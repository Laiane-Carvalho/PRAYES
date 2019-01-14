package testeadapt3.cursoandroid2.com.pray;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by laianeoliveira on 08/01/19.
 */

public class Content extends WebView implements
        View.OnSystemUiVisibilityChangeListener, View.OnClickListener,
        ActionBar.OnMenuVisibilityListener {
    Activity mActivity;
    TextView mTitleView;
    Button mPlayButton;
    WebView mWebView;
   LinearLayout customBar;
    boolean mAddedMenuListener;
    boolean mMenusOpen;
    boolean mPaused;
    boolean mNavVisible;
    int mLastSystemUiVis;

    Runnable mNavHider = new Runnable() {
        @Override public void run() {
            setNavVisibility(false);
        }
    };

    public Content(Context context) {
        super(context);
        setOnSystemUiVisibilityChangeListener(this);
        setOnClickListener(this);
    }

    public void init(Activity activity, WebView webView, LinearLayout customBarLinear) {
        // Isso é chamado pela atividade de contenção para suprir a vizinhança
        // estado do player de vídeo com o qual ele irá interagir.
        mActivity = activity;
        mWebView =webView;
        customBar = customBarLinear;
        //customBar =customBarLinear;
       // mPlayButton.setOnClickListener(this);
        setPlayPaused(true);
    }

    @Override protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mActivity != null) {
            mAddedMenuListener = true;
            mActivity.getActionBar().addOnMenuVisibilityListener( (android.app.ActionBar.OnMenuVisibilityListener) this );

        }
    }

    @Override protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mAddedMenuListener) {
           mActivity.getActionBar().removeOnMenuVisibilityListener( (android.app.ActionBar.OnMenuVisibilityListener) this );
        }
    }

    @Override public void onSystemUiVisibilityChange(int visibility) {
        // Detectar quando sairmos do modo nav-hidden, para limpar nosso estado
        // volta a ter o chrome completo da interface do usuário. Só faça isso quando
        // o estado está mudando e o nav não está mais oculto.
        int diff = mLastSystemUiVis ^ visibility;
        mLastSystemUiVis = visibility;
        if ((diff&SYSTEM_UI_FLAG_HIDE_NAVIGATION) != 0
                && (visibility&SYSTEM_UI_FLAG_HIDE_NAVIGATION) == 0) {
            setNavVisibility(true);
        }
    }

    @Override protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);

        // Quando nos tornamos visíveis ou invisíveis, o jogo é pausado.
        setPlayPaused(true);
    }

    @Override public void onClick(View v) {
        if (v == mPlayButton) {
            // Clicar no botão play / pause (jogar / pausar) alterna seu estado.
            setPlayPaused(!mPaused);
        } else {
            // Clicar em outro lugar torna a navegação visível.
            setNavVisibility(true);
        }
    }

    @Override public void onMenuVisibilityChanged(boolean isVisible) {
        mMenusOpen = isVisible;
        setNavVisibility(true);
    }

    void setPlayPaused(boolean paused) {
        mPaused = paused;
       // mPlayButton.setText(paused ? R.string.play : R.string.pause);
        setKeepScreenOn(!paused);
        setNavVisibility(true);
    }

    void setNavVisibility(boolean visible) {
        int newVis = SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | SYSTEM_UI_FLAG_LAYOUT_STABLE;
        if (!visible) {
            newVis |= SYSTEM_UI_FLAG_LOW_PROFILE | SYSTEM_UI_FLAG_FULLSCREEN
                    | SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }

        // Se agora estivermos visíveis, agende um temporizador para que fiquemos invisíveis.
        if (visible) {
            Handler h = getHandler();
            if (h != null) {
                h.removeCallbacks(mNavHider);
                if (!mMenusOpen && !mPaused) {
                    // Se os menus estiverem abertos ou o play estiver pausado, não nos esconderemos automaticamente.
                    h.postDelayed(mNavHider, 3000);
                }
            }
        }

        // Defina a nova visibilidade desejada.
        setSystemUiVisibility(newVis);
       // customBar.setVisibility(visible ? VISIBLE : INVISIBLE);
     //   mTitleView.setVisibility(visible ? VISIBLE : INVISIBLE);
       // mPlayButton.setVisibility(visible ? VISIBLE : INVISIBLE);
        //mSeekView.setVisibility(visible ? VISIBLE : INVISIBLE);
    }
}