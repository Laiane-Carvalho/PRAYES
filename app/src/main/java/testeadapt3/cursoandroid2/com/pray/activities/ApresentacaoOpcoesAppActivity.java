package testeadapt3.cursoandroid2.com.pray.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.OnClick;
import testeadapt3.cursoandroid2.com.pray.R;

public class ApresentacaoOpcoesAppActivity extends SupportActivity implements View.OnClickListener {

    @BindView(R.id.oracoes)
    Button oracoes;

    @BindView(R.id.AjudaDoutrinaria)
    Button ajudaDoutrinaria;

    @BindView(R.id.catecismo)
    Button catecismo;

    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayoutFundo;

    @BindView(R.id.botaoExitApp)
    ImageButton botaoExitApp;

    AlertDialogCustomActivity alertDialogCustomActivity;

    Animation dowToUp, downToUpAjudaDoutrinaria, downToUpCatecismo, backtela;

    @Override
    int layoutID() {
        return R.layout.activity_apresentacao_opcoes_app;
    }

    @Override
    void inicializar(Bundle savedInstanceState) {
        animacoes();
        clicks();

    }

    private void clicks() {
        oracoes.setOnClickListener( this );
        ajudaDoutrinaria.setOnClickListener( this );
        catecismo.setOnClickListener( this );
        botaoExitApp.setOnClickListener( this );
        alertDialogCustomActivity = new AlertDialogCustomActivity( this );
    }

    private void animacoes() {
        backtela = AnimationUtils.loadAnimation( this, R.anim.telaback );
        relativeLayoutFundo.setAnimation( backtela );

        dowToUp = AnimationUtils.loadAnimation( this, R.anim.downtoup );
        oracoes.setAnimation( dowToUp );

        downToUpAjudaDoutrinaria = AnimationUtils.loadAnimation( this, R.anim.downtouajudadoutrinaria );
        ajudaDoutrinaria.setAnimation( downToUpAjudaDoutrinaria );

        downToUpCatecismo = AnimationUtils.loadAnimation( this, R.anim.downtoupcatecismo );
        catecismo.setAnimation( downToUpCatecismo );
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
            case R.id.botaoExitApp:
                exitApp();
                break;
        }
    }

    private void exitApp() {
        alertDialogCustomActivity.verificationsttatus();
    }

    private void irAjudadedoutrina() {
        Intent intent = new Intent( this, ResumoAjudaDoutrinariaActivity.class );
        startActivity( intent );
    }

    private void irResumoOracoes() {
        Intent intent = new Intent( this, ResumoOracoesActivity.class );
        startActivity( intent );
    }

    private void irResumoCatecismo() {
        Intent intent = new Intent( this, ResumoOracoesActivity.class );
        startActivity( intent );
    }
    @OnClick(R.id.botaoExitApp)
    public void botaoExitApp(){

    }
}
