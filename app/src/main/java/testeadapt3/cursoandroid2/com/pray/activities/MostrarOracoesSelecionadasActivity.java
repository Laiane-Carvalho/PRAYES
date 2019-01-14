package testeadapt3.cursoandroid2.com.pray.activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import testeadapt3.cursoandroid2.com.pray.R;
import testeadapt3.cursoandroid2.com.pray.adapter.Filho;

public class MostrarOracoesSelecionadasActivity extends SupportActivity {

    @BindView( R.id.textViewMostarOracoes )
     TextView textViewMostarOracoes;

    @BindView( R.id.btnReturnOracoes )
    ImageButton btnReturnOracoes;

    Filho filho;

    @Override
    int layoutID() {
        return R.layout.activity_mostrar_oracoes_selecionadas;
    }

    @Override
    void inicializar(Bundle savedInstanceState) {
        mostrarOracaoSelecionada();
    }

    private void mostrarOracaoSelecionada() {
        Intent i = getIntent();
        filho = i.getExtras().getParcelable( "filho" );
        textViewMostarOracoes.setText( this.getString( filho.getNameID() ) );
        textViewMostarOracoes.setTextIsSelectable( true ); // selecionar copiar e compartilhar texto...
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Toast.makeText( this, "clicado na seta", Toast.LENGTH_SHORT ).show();
//            menuClick();
            return true;
        }

        return super.onOptionsItemSelected( item );
    }

    @OnClick(R.id.btnReturnOracoes)
    public void btnReturnOracoes() {
        finish();
    }

}
