package testeadapt3.cursoandroid2.com.pray.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import butterknife.BindView;
import testeadapt3.cursoandroid2.com.pray.R;
import testeadapt3.cursoandroid2.com.pray.adapter.TabsAdapter;

public class ResumoOracoesActivity extends SupportActivity
        implements SearchView.OnQueryTextListener {

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.tollbarresumo)
    Toolbar toolbar;

    @Override
    int layoutID() {
        return R.layout.resumo_oracoes;
    }

    @Override
    void inicializar(Bundle savedInstanceState) {
        setSupportActionBar( toolbar );
        getSupportActionBar().setDisplayShowTitleEnabled( false );

        //configurar adapter
        TabsAdapter tabsAdapter = new TabsAdapter( getSupportFragmentManager(), this );
        viewPager.setAdapter( tabsAdapter );

        //chamar Tab (Abas)
        TabLayout tabLayout = findViewById( R.id.tabLayout );
//        tabLayout.setTabIndicatorFullWidth( true );
        tabLayout.setupWithViewPager( viewPager );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu_resumo_oracoes, menu );
        //menuu pesquisa...
        MenuItem searchItem = menu.findItem( R.id.pesquisa );
        SearchView searchView = (SearchView) MenuItemCompat.getActionView( searchItem );
        searchView.setOnQueryTextListener( this );

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.out:
                AlertDialogCustomActivity cdd = new AlertDialogCustomActivity( ResumoOracoesActivity.this );
                cdd.setCanceledOnTouchOutside( false );
                cdd.show();
                return true;
            case R.id.retornar:
                startActivity( new Intent( getApplicationContext(), ApresentacaoOpcoesAppActivity.class ) );
                return true;
        }
        return super.onOptionsItemSelected( item );
    }

    //é acionado quando o botão de busca é pressionado.
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    //é chamado quando o usuário digitar cada caractere no campo de texto;
    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
