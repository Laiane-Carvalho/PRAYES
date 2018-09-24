package testeadapt3.cursoandroid2.com.pray.activities;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import testeadapt3.cursoandroid2.com.pray.R;
import testeadapt3.cursoandroid2.com.pray.adapter.TabsAdapter;
import testeadapt3.cursoandroid2.com.pray.util.SlidingTabLayout;

public class ResumoOracoesActivity extends AppCompatActivity
        implements SearchView.OnQueryTextListener{

    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.resumo_oracoes );

        //configurar tollbarCustom
        toolbar=findViewById( R.id.tollbarresumo );
        setSupportActionBar( toolbar );
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //configurar abas
        slidingTabLayout = findViewById( R.id.slidingTabLayout );
        viewPager = findViewById( R.id.viewPager );

        //configurar adapter
        TabsAdapter tabsAdapter = new TabsAdapter(getSupportFragmentManager() ,this );
        viewPager.setAdapter( tabsAdapter );
        slidingTabLayout.setCustomTabView( R.layout.tabs_view, R.id.item_tab_text );
        slidingTabLayout.setDistributeEvenly( true );
        slidingTabLayout.setViewPager( viewPager );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu_resumo_oracoes, menu );

        //menuu pesquisa...
        MenuItem searchItem = menu.findItem(R.id.pesquisa);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.out:
                AlertDialogCustomActivity cdd=new AlertDialogCustomActivity(ResumoOracoesActivity.this);
                cdd.setCanceledOnTouchOutside(false);
                cdd.show();
                return true;
            case R.id.retornar:
                startActivity( new Intent( getApplicationContext(),ApresentacaoOpcoesAppActivity.class ) );
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
