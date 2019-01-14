package testeadapt3.cursoandroid2.com.pray.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.facebook.AccessToken;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import testeadapt3.cursoandroid2.com.pray.R;
import testeadapt3.cursoandroid2.com.pray.logins.LoginFacebook;
import testeadapt3.cursoandroid2.com.pray.logins.LoginGoogle;

public class AlertDialogCustomActivity extends Dialog implements
        android.view.View.OnClickListener {

    public Activity c;
    public Dialog d;
    public ImageButton yes, no;
    private LoginFacebook loginFacebook;
    private LoginGoogle loginGoogle;
    private FirebaseAuth mAuth;

    public AlertDialogCustomActivity(Activity a) {
        super( a );
        // TODO Auto-generated constructor stub
        this.c = a;
        loginFacebook = new LoginFacebook( a );
        loginGoogle = new LoginGoogle( a );
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        setContentView( R.layout.activity_alert_dialog_custom );

        yes = (ImageButton) findViewById( R.id.btn_yes );
        no = (ImageButton) findViewById( R.id.btn_no );
        yes.setOnClickListener( this );
        no.setOnClickListener( this );

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_yes:
                Intent intent = new Intent( c, LoginActivity.class );
                c.startActivity( intent );
                verificationsttatus();
                break;
            case R.id.btn_no:
                dismiss();
                break;
            default:
                break;
        }

        dismiss();
    }

    public void verificationsttatus() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        boolean isLoggedInFace = accessToken != null && !accessToken.isExpired();
        boolean isLoggedGoogle = currentUser != null;
        if (isLoggedInFace) {
            loginFacebook.sairFacebook();
        }
        if (isLoggedGoogle) {
            loginGoogle.deslogarGoogle();
        }
    }
}