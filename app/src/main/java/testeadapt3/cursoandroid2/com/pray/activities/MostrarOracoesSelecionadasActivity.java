package testeadapt3.cursoandroid2.com.pray.activities;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import testeadapt3.cursoandroid2.com.pray.R;
import testeadapt3.cursoandroid2.com.pray.adapter.Filho;
import testeadapt3.cursoandroid2.com.pray.fragments.OracoesDiariasFragment;
import testeadapt3.cursoandroid2.com.pray.fragments.SantoTercoFragment;

public class MostrarOracoesSelecionadasActivity extends AppCompatActivity {

    Filho filho;
    private TextView textViewMostrarOracoes;
    private AnimatedVectorDrawable mMenuDrawable;
    private AnimatedVectorDrawable mBackDrawable;
    private boolean mMenuFlag;
    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.mostrar_oracoes_selecionadas );
        toolbar = findViewById( R.id.tollbarmostrarOracoesSelecionadas );
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayOptions( ActionBar.DISPLAY_HOME_AS_UP);

        //animacao das setas e menus
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_vector);
//        mMenuDrawable = (AnimatedVectorDrawable) getDrawable(R.drawable.ic_menu_animatable);
//        mBackDrawable = (AnimatedVectorDrawable) getDrawable(R.drawable.ic_back_animatable);

        textViewMostrarOracoes = findViewById( R.id.textViewMostarOracoes );
        Intent i = getIntent();
        filho = i.getExtras().getParcelable( "filho" );
        textViewMostrarOracoes.setText(this.getString(filho.getNameID()));
        textViewMostrarOracoes.setTextIsSelectable( true ); // selecionar copiar e compartilhar texto...

        textViewMostrarOracoes.setOnLongClickListener( new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText( getApplicationContext(),"clicado e segurado",Toast.LENGTH_SHORT ).show();

                return false;
            }
        } );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            Toast.makeText( this, "clicado na seta",Toast.LENGTH_SHORT ).show();
//            menuClick();
            return true;
        }

        return super.onOptionsItemSelected( item );
    }

    private void menuClick() {
        if (mMenuFlag) {
            getSupportActionBar().setHomeAsUpIndicator(mBackDrawable);
            mBackDrawable.start();
        } else {
            getSupportActionBar().setHomeAsUpIndicator(mMenuDrawable);
            mMenuDrawable.start();
        }
        mMenuFlag = !mMenuFlag;
    }
}
