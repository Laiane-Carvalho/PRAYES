package testeadapt3.cursoandroid2.com.pray.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import testeadapt3.cursoandroid2.com.pray.R;
import testeadapt3.cursoandroid2.com.pray.adapter.Filho;

public class MostrarAjudaDoutrinariaSelecionadaActivity extends AppCompatActivity{
//        implements NavigationView.OnNavigationItemSelectedListener {

    Filho filho;
    WebView view;
    Button botaoProximo;
    android.support.v7.widget.Toolbar toolbar;
    private AnimatedVectorDrawable mMenuDrawable;
    private AnimatedVectorDrawable mBackDrawable;
    private boolean mMenuFlag;
    //private ImageSwitcher imageView;

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView( name, context, attrs );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.mostrar_ajuda_doutrinaria_selecionada );
        toolbar = findViewById( R.id.tollbarvideos );
        setSupportActionBar( toolbar );
        contruirActioneAnimacao();

        botaoProximo = findViewById( R.id.botaoProximoVideo );
        botaoProximo.setText( "PROXIMO VIDEO" );
        view = (WebView) findViewById( R.id.webView );

        chamarWebView();
       // construirDrawer();
    }

    private void contruirActioneAnimacao() {
        getSupportActionBar().setDisplayShowTitleEnabled( false );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );

        //animacao de menu na actionbar https://medium.com/android-dev-br/criando-%C3%ADcones-animados-no-android-14b2d5feb877
        getSupportActionBar().setDisplayOptions( ActionBar.DISPLAY_HOME_AS_UP );
        //animacao setas e menus
//        getSupportActionBar().setHomeAsUpIndicator( R.drawable.ic_menu_vector );
//        mMenuDrawable = (AnimatedVectorDrawable) getDrawable( R.drawable.ic_menu_animatable );
//        mBackDrawable = (AnimatedVectorDrawable) getDrawable( R.drawable.ic_back_animatable );

    }

//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
//        if (drawer.isDrawerOpen( GravityCompat.START )) {
//            drawer.closeDrawer( GravityCompat.START );
//        } else {
//            super.onBackPressed();
//        }
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //menuClick();
                break;
        }

        return super.onOptionsItemSelected( item );
    }

    //itens de navegacao menu drawer
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
//        drawer.closeDrawer( GravityCompat.START );
//        return true;
//    }

    //metodod da animacao icone menu action
    private void menuClick() {
        if (mMenuFlag) {
            getSupportActionBar().setHomeAsUpIndicator( mBackDrawable );
            Toast.makeText( this,"vc clicou fechar",Toast.LENGTH_SHORT ).show();
            mBackDrawable.start();
        } else {
            getSupportActionBar().setHomeAsUpIndicator( mMenuDrawable );
            Toast.makeText( this,"vc clicou menu",Toast.LENGTH_SHORT ).show();
            mMenuDrawable.start();
        }
        mMenuFlag = !mMenuFlag;
    }

    //class in webView
    private class MyBrowser extends WebViewClient {
        public boolean overrideUrlLoading(WebView view, String url) {
            view.loadUrl( url );
            return true;
        }
    }

//    private void construirDrawer() {
//        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
//        drawer.addDrawerListener( toggle );
//        toggle.syncState();
//        NavigationView navigationView = (NavigationView) findViewById( R.id.nav_view );
//        navigationView.setNavigationItemSelectedListener( this );
//    }
    private void chamarWebView() {
        view.setWebViewClient( new MyBrowser() );
        view.getSettings().setJavaScriptEnabled( true );
        Intent i = getIntent();
        filho = i.getExtras().getParcelable( "filho" );
        view.loadUrl( this.getString( filho.getNameID() ) );
        view.setWebChromeClient( new WebChromeClient() );
    }
}
