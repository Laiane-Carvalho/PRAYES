package testeadapt3.cursoandroid2.com.pray.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import testeadapt3.cursoandroid2.com.pray.R;
import testeadapt3.cursoandroid2.com.pray.adapter.TabsAdapterDoutrina;
import testeadapt3.cursoandroid2.com.pray.util.SlidingTabLayout;

public class ResumoAjudaDoutrinariaActivity extends AppCompatActivity {

    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.resumo_ajuda_doutrinaria );
        //configurar tollbarCustom
        toolbar=findViewById( R.id.tollbardoutrina );
        setSupportActionBar( toolbar );
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        slidingTabLayout = findViewById( R.id.slidingTabLayout );
        viewPager = findViewById( R.id.viewPager );

        //configurar adapter
        TabsAdapterDoutrina tabsAdapter = new TabsAdapterDoutrina(getSupportFragmentManager() ,this );
        viewPager.setAdapter( tabsAdapter );
        slidingTabLayout.setCustomTabView( R.layout.tabs_view, R.id.item_tab_text );
        slidingTabLayout.setDistributeEvenly( true );
        slidingTabLayout.setViewPager( viewPager );
    }
}
