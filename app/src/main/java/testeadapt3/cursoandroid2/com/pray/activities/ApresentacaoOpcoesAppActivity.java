package testeadapt3.cursoandroid2.com.pray.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import testeadapt3.cursoandroid2.com.pray.R;

public class ApresentacaoOpcoesAppActivity extends AppCompatActivity implements View.OnClickListener {

    private Button oracoes;
    private Button ajudaDoutrinaria;
    private Button catecismo;
//    private Button questionamentos;
    private Toolbar toolbar;
    Animation dowToUp, downToUpAjudaDoutrinaria, downToUpCatecismo, downToUpQuestionamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_apresentacao_opcoes_app );
        toolbar = findViewById( R.id.toolbarPrayers );
        setSupportActionBar( toolbar );
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        oracoes = findViewById( R.id.oracoes );
        ajudaDoutrinaria = findViewById( R.id.AjudaDoutrinaria );
        catecismo = findViewById( R.id.catecismo );
//        questionamentos = findViewById( R.id.questionamentos );

        animacoes();

        oracoes.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irResumoOracoes();
            }
        } );
        ajudaDoutrinaria.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irAjudadedoutrina();
            }
        } );
    }

    private void animacoes() {

        dowToUp = AnimationUtils.loadAnimation( this, R.anim.downtoup );
        oracoes.setAnimation( dowToUp );

        downToUpAjudaDoutrinaria = AnimationUtils.loadAnimation( this, R.anim.downtouajudadoutrinaria );
        ajudaDoutrinaria.setAnimation( downToUpAjudaDoutrinaria );

        downToUpCatecismo = AnimationUtils.loadAnimation( this, R.anim.downtoupcatecismo );
        catecismo.setAnimation( downToUpCatecismo );
//
//        downToUpQuestionamentos = AnimationUtils.loadAnimation( this, R.anim.downtoumquestionamentos );
//        questionamentos.setAnimation( downToUpQuestionamentos );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu_apresentacao_opcao_app, menu );

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.outprayers) {
            AlertDialogCustomActivity cdd = new AlertDialogCustomActivity( ApresentacaoOpcoesAppActivity.this );
            cdd.setCanceledOnTouchOutside( false );
            cdd.show();

            return true;
        }

        return super.onOptionsItemSelected( item );
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.oracoes:
                irResumoOracoes();
                break;
            case R.id.AjudaDoutrinaria:
                irAjudadedoutrina();
                break;
            case R.id.catecismo:
                irResumoCatecismo();
                break;
//            case R.id.questionamentos:
//                irResumoQuestionamentos();
//                break;
        }
    }

    private void irAjudadedoutrina() {
        Toast.makeText( this, "vc clicou em ajuda doutrinaria", Toast.LENGTH_SHORT ).show();

        Intent intent = new Intent( ApresentacaoOpcoesAppActivity.this, ResumoAjudaDoutrinariaActivity.class );
        startActivity( intent );
    }

    private void irResumoOracoes() {
        Toast.makeText( this, "vc clicou em oracoes", Toast.LENGTH_SHORT ).show();
        Intent intent = new Intent( this, ResumoOracoesActivity.class );
        startActivity( intent );
    }

    private void irResumoQuestionamentos() {
    }

    private void irResumoCatecismo() {
    }


}
