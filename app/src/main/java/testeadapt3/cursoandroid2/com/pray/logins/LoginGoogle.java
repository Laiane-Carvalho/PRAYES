package testeadapt3.cursoandroid2.com.pray.logins;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import testeadapt3.cursoandroid2.com.pray.R;
import testeadapt3.cursoandroid2.com.pray.activities.ApresentacaoOpcoesAppActivity;
import testeadapt3.cursoandroid2.com.pray.activities.LoginActivity;

/**
 * Created by laianeoliveira on 18/12/18.
 */

public class LoginGoogle {

    Activity activity;
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    private static final String TAG = "GoogleActivity";
    private static final int RC_SIGN_IN = 9001;


    public LoginGoogle(Activity activity) {
        this.activity = activity;
        mAuth = FirebaseAuth.getInstance();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder( GoogleSignInOptions.DEFAULT_SIGN_IN )
                .requestIdToken( activity.getString( R.string.default_web_client_id ) )
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient( activity, gso );
    }

    public void logandoGoogle() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        activity.startActivityForResult( signInIntent, RC_SIGN_IN );
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task <GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent( data );
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult( ApiException.class );
                firebaseAuthWithGoogle( account );
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w( TAG, "Google sign in failed", e );
                // ...
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d( TAG, "firebaseAuthWithGoogle:" + acct.getId() );

        AuthCredential credential = GoogleAuthProvider.getCredential( acct.getIdToken(), null );
        mAuth.signInWithCredential( credential )
                .addOnCompleteListener( activity, new OnCompleteListener <AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task <AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d( TAG, "signInWithCredential:success" );
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText( activity, "Sucesso em:" + user, Toast.LENGTH_LONG ).show();
                            irParaPrincipal();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w( TAG, "signInWithCredential:failure", task.getException() );
                            Toast.makeText( activity, "Authentication failed.",
                                    Toast.LENGTH_SHORT ).show();
                            Toast.makeText( activity, "falha na credencial", Toast.LENGTH_LONG ).show();
                        }

                    }
                } );
    }
    private void irParaPrincipal() {
        Intent intent = new Intent( activity, ApresentacaoOpcoesAppActivity.class );
        activity.startActivity( intent );
        activity.finish();
        Toast.makeText( activity,"deu certo logar no Google",Toast.LENGTH_LONG ).show();
    }

    public void deslogarGoogle() {
        // Firebase sign out
        mAuth.signOut();

        // Google sign out
        mGoogleSignInClient.signOut().addOnCompleteListener( activity,
                new OnCompleteListener <Void>() {
                    @Override
                    public void onComplete(@NonNull Task <Void> task) {
                        Toast.makeText( activity, "Deslogando do google", Toast.LENGTH_LONG ).show();

                    }
                } );
        Intent intent = new Intent( activity,LoginActivity.class );
        activity.startActivity( intent );

    }
}
