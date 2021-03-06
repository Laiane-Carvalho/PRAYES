package testeadapt3.cursoandroid2.com.pray.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.squareup.picasso.Picasso;

import testeadapt3.cursoandroid2.com.pray.R;
import testeadapt3.cursoandroid2.com.pray.logins.LoginFacebook;
import testeadapt3.cursoandroid2.com.pray.logins.LoginGoogle;

public class LoginActivity extends SupportActivity {

    LoginFacebook loginFacebook;
    LoginGoogle loginGoogle;
    String arrayNames[] = {
            "Facebook",
            "Twitter",
            "Google",
            "Novo"};

    @Override
    protected void onStart() {
        super.onStart();
        loginFacebook.verificationsttatus();
    }

    @Override
    int layoutID() {
        return R.layout.activity_loguin;
    }

    @Override
    void inicializar(Bundle savedInstanceState) {
        Picasso.with( getApplication() ).load( R.drawable.praylay ).resize( 256, 256 ).centerCrop();

        loginFacebook = new LoginFacebook( this );
        loginGoogle = new LoginGoogle( this );

        CircleMenu circleMenu = (CircleMenu) findViewById( R.id.circule_menu );
        circleMenu.setMainMenu( Color.parseColor( "#CDCDCD" ), R.drawable.icadd, R.drawable.icremove )
                .addSubMenu( Color.parseColor( "#274f9e" ), R.drawable.icfacebook )
                .addSubMenu( Color.parseColor( "#4eb8c9" ), R.drawable.ictwitter )
                .addSubMenu( Color.parseColor( "#ff0000" ), R.drawable.icgoogle )
                .addSubMenu( Color.parseColor( "#FFF4F7F7" ), R.drawable.add_user )
                .setOnMenuSelectedListener( new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {

                        Toast.makeText( getApplicationContext(), "voce selecionou " + arrayNames[index], Toast.LENGTH_LONG ).show();

                        switch (arrayNames[index]) {
                            case "Facebook":
                                logarFacebook();
                                break;
                            case "Google":
                                logarGoogle();
                                break;
                            case "Twitter":
                                logarTwitter();
                                break;
                            case "Novo":
                                criarConta();
                                break;

                        }
                    }
                } );
    }

    private void criarConta() {
        irPrayers();
    }

    private void logarTwitter() {
        irPrayers();
    }

    private void logarGoogle() {
        loginGoogle.logandoGoogle();
    }

    private void logarFacebook() {
        loginFacebook.loginFacebook();
    }

    private void irPrayers() {
        Intent intent = new Intent( LoginActivity.this, ApresentacaoOpcoesAppActivity.class );
        startActivity( intent );
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
//        loginFacebook.onActivityResult( requestCode, resultCode, data );
        loginGoogle.onActivityResult( requestCode,resultCode,data);
    }
}
