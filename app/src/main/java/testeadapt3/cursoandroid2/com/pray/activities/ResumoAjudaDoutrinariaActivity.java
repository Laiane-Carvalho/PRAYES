package testeadapt3.cursoandroid2.com.pray.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import testeadapt3.cursoandroid2.com.pray.R;
import testeadapt3.cursoandroid2.com.pray.adapter.TabsAdapterDoutrina;

public class ResumoAjudaDoutrinariaActivity extends SupportActivity  {

    @BindView( R.id.viewPager )
     ViewPager viewPager;

    @BindView( R.id.tollbardoutrina )
     Toolbar toolbar;

    @Override
    int layoutID() {
        return R.layout.resumo_ajuda_doutrinaria;
    }

    @Override
    void inicializar(Bundle savedInstanceState) {
        setSupportActionBar( toolbar );
        getSupportActionBar().setDisplayShowTitleEnabled( false );

        //configurar adapter
        TabsAdapterDoutrina tabsAdapter = new TabsAdapterDoutrina( getSupportFragmentManager(), this );
        viewPager.setAdapter( tabsAdapter );

        //chamar Tab (Abas)
        TabLayout tabLayout  =  ( TabLayout )  findViewById ( R.id.tabLayout );
        tabLayout.setupWithViewPager(viewPager);

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate( R.menu.activity_ajudadoutrinariaselecionadas, menu );
//
//        //menuu pesquisa...
//        MenuItem searchItem = menu.findItem( R.id.pesquisa );
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView( searchItem );
//        searchView.setOnQueryTextListener( (SearchView.OnQueryTextListener) this );
//
//        return true;
//    }
}
