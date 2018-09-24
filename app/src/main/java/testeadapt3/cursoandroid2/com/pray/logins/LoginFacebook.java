package testeadapt3.cursoandroid2.com.pray.logins;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

import testeadapt3.cursoandroid2.com.pray.activities.LoginActivity;
import testeadapt3.cursoandroid2.com.pray.activities.ApresentacaoOpcoesAppActivity;

/**
 * Created by laianeoliveira on 28/08/18.
 */

public class LoginFacebook {

    Activity activity;
    private static final String TAG = "accessTokenfacebook";
    CallbackManager callbackManager;
    private FirebaseAuth auth;


    public LoginFacebook(Activity activity) {
        this.activity=activity;

    }
    public void loginFacebook() {

        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().logInWithReadPermissions( activity, Arrays.asList( "public_profile" ) );
        LoginManager.getInstance().registerCallback( callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Toast.makeText( activity, "sucesso ao logar no facebook", Toast.LENGTH_LONG ).show();
                        facebookAccessToken( loginResult.getAccessToken() );
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText( activity, "cancelamento ao logar no facebook", Toast.LENGTH_LONG ).show();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Toast.makeText( activity, "Erro ao logar no facebook" + exception, Toast.LENGTH_LONG ).show();
                    }
                } );
    }

    private void facebookAccessToken(AccessToken token) {
        Log.d( TAG, "handleFacebookAccessToken:" + token );

        AuthCredential credential = FacebookAuthProvider.getCredential( token.getToken() );
        auth.signInWithCredential( credential )
                .addOnCompleteListener( activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d( TAG, "signInWithCredential:success" );
                            FirebaseUser user = auth.getCurrentUser();
                            Toast.makeText( activity,"sucesso ao logar no facebook",Toast.LENGTH_LONG ).show();
                            irParaPrincipal();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w( TAG, "signInWithCredential:failure", task.getException() );
                            Toast.makeText( activity, "Authentication failed.",
                                    Toast.LENGTH_SHORT ).show();
                        }
                    }
                } );
    }

    private void irParaPrincipal() {
        Intent intent = new Intent( activity, ApresentacaoOpcoesAppActivity.class );
        activity.startActivity( intent );
        activity.finish();
        Toast.makeText( activity,"deu certo logar facebook",Toast.LENGTH_LONG ).show();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult( requestCode, resultCode, data );

    }

    protected void verificationsttatus() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();
        if (isLoggedIn) {
            irParaPrincipal();
        } else {
            Toast.makeText( activity, "deslogado do facebook", Toast.LENGTH_LONG ).show();
        }
    }
    public void sairFacebook(){
        auth.signOut();
        LoginManager.getInstance().logOut();
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity( intent );
        activity.finish();
        Toast.makeText( activity,"Deslogando do facebook",Toast.LENGTH_LONG ).show();
    }
}
