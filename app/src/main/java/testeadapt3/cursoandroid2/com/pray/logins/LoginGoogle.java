package testeadapt3.cursoandroid2.com.pray.logins;

import android.app.Activity;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import testeadapt3.cursoandroid2.com.pray.R;

/**
 * Created by laianeoliveira on 18/12/18.
 */

public class LoginGoogle {

    Activity activity;
    private FirebaseAuth mAuth;



    public LoginGoogle(Activity activity) {
        this.activity=activity;
        mAuth = FirebaseAuth.getInstance();


    }

    public void logandoGoogle(){
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(activity.getString( R.string.default_web_client_id))
                .requestEmail()
                .build();
        //mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


    }

}
