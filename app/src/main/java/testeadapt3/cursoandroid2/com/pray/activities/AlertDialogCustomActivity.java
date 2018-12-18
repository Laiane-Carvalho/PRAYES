package testeadapt3.cursoandroid2.com.pray.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.facebook.AccessToken;

import testeadapt3.cursoandroid2.com.pray.R;
import testeadapt3.cursoandroid2.com.pray.logins.LoginFacebook;

public class AlertDialogCustomActivity extends Dialog implements
        android.view.View.OnClickListener {

    public Activity c;
    public Dialog d;
    public ImageButton yes, no;
    private LoginFacebook loginFacebook;

    public AlertDialogCustomActivity(Activity a) {
        super( a );
        // TODO Auto-generated constructor stub
        this.c = a;
        loginFacebook = new LoginFacebook( a );

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
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();
        if (isLoggedIn) {
            loginFacebook.sairFacebook();
        }
    }
}