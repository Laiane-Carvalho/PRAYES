package testeadapt3.cursoandroid2.com.pray.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import testeadapt3.cursoandroid2.com.pray.Content;
import testeadapt3.cursoandroid2.com.pray.R;
import testeadapt3.cursoandroid2.com.pray.adapter.Filho;

public class ActivityMostrarAjudaSelecionada extends SupportActivity{
    
    @BindView(R.id.webView)
    WebView view;

    @BindView(R.id.btnBackVideos)
    ImageButton btnBackVideos;

    @BindView(R.id.customBarLinearVideos)
    LinearLayout customBarLinearVideos;

    Filho filho;
    Content content;

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView( name, context, attrs );

    }

    @Override
    int layoutID() {
        return R.layout.activity_mostrar_ajuda_doutrinaria_selecionada;
    }

    @Override
    void inicializar(Bundle savedInstanceState) {
        chamarWebView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //menuClick();
                break;
        }
        return super.onOptionsItemSelected( item );
    }

    private class MyBrowser extends WebViewClient {
        public boolean overrideUrlLoading(WebView view, String url) {
            view.loadUrl( url );
            return true;
        }
    }

    private void chamarWebView() {
        view.setWebViewClient( new MyBrowser() );
        view.getSettings().setJavaScriptEnabled( true );
        Intent i = getIntent();

        filho = i.getExtras().getParcelable( "filho" );
        view.loadUrl( this.getString( filho.getNameID() ) );
        view.setWebChromeClient( new WebChromeClient() );
    }
    @OnClick(R.id.btnBackVideos)
    public void btnBackVideos(){
        finish();
    }
}
