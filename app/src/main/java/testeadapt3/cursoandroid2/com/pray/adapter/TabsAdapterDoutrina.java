package testeadapt3.cursoandroid2.com.pray.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import testeadapt3.cursoandroid2.com.pray.fragments.IgrejaFragment;
import testeadapt3.cursoandroid2.com.pray.fragments.OracoesDiariasFragment;
import testeadapt3.cursoandroid2.com.pray.fragments.SacramentosFragment;
import testeadapt3.cursoandroid2.com.pray.fragments.SantoTercoFragment;
import testeadapt3.cursoandroid2.com.pray.fragments.SantosFragment;

/**
 * Created by laianeoliveira on 14/09/18.
 */

public class TabsAdapterDoutrina  extends FragmentStatePagerAdapter {

    private Context context;
    private String[] abas = new String[]{"IGREJA","SANTOS","SACRAMENTOS"};

    public TabsAdapterDoutrina(FragmentManager fm, Context c) {
        super( fm );
        this.context = c;
    }

    @Override
    public Fragment getItem(int position) {


        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new IgrejaFragment();
                break;
            case 1:
                fragment = new SantosFragment();
                break;
            case 2:
                fragment = new SacramentosFragment();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return abas[position];
    }

    @Override
    public int getCount() {
        return abas.length;
    }
}
