package testeadapt3.cursoandroid2.com.pray.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import testeadapt3.cursoandroid2.com.pray.R;
import testeadapt3.cursoandroid2.com.pray.activities.MostrarAjudaDoutrinariaSelecionadaActivity;
import testeadapt3.cursoandroid2.com.pray.adapter.ExpandableAdapter;
import testeadapt3.cursoandroid2.com.pray.adapter.Filho;

public class SacramentosFragment extends ListFragment {
    private List <String> listGroup;
    private HashMap <String, List <Filho>> listData;

    public SacramentosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_sacramentos, container, false );

        ExpandableListView expandableListView = (ExpandableListView) view.findViewById( R.id.expandableListView ); //instanncia a classe expanable
        criarLista();//chama a lista criada

        expandableListView.setAdapter( new ExpandableAdapter( getContext(), listGroup, listData ) );//passa os parametros da lisra do grupo e dos itens
        expandableListView.setOnChildClickListener( new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //  Toast.makeText( getContext(), "Group: " + groupPosition + " | Child: " + childPosition, Toast.LENGTH_SHORT ).show();

                String grupo = listGroup.get( groupPosition );
                Filho filho = listData.get( grupo ).get( childPosition );

                Intent intent = new Intent( getActivity(), MostrarAjudaDoutrinariaSelecionadaActivity.class );
                intent.putExtra( "filho", filho );
                startActivity( intent );

                return false;
            }

        } );
        expandableListView.setOnGroupExpandListener( new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText( getContext(), "Group:(Expand) " + groupPosition, Toast.LENGTH_SHORT ).show();
            }
        } );
        expandableListView.setOnGroupCollapseListener( new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText( getContext(), "Group:(Collapse) " + groupPosition, Toast.LENGTH_SHORT ).show();
            }
        } );
        expandableListView.setGroupIndicator( getResources().getDrawable( R.drawable.icon_group ) );
        return view;
    }

    public void criarLista() {
        listGroup = new ArrayList <String>();
        listData = new HashMap <>();

        //formar grupos
        listGroup.add( "ORACOES DIÁRIAS" ); //grupo 0
        listGroup.add( "ORACOES DE CONSAGRAÇÃO" );//GRUPO 1
        listGroup.add( "ORACOES DE CURA" );//GRUPO 2
        listGroup.add( "ORACOES DE INTERCESSÃO" );//GRUPO 3
        listGroup.add( "ORACOES DE PROTEÇÃO E REVESTIMENTO" );//GRUPO 4
        listGroup.add( "ORACOES LIBERTAÇÃO" );//GRUPO 5
        listGroup.add( "ORACOES DOS SANTOS" );//GRUPO 6
        listGroup.add( "OUTRAS ORAÇÕES" );//GRUPO 7

        //formar filhos dos grupos (0) ///oracaoes diarias
        List <Filho> auxList = new ArrayList <>();
        auxList.add( new Filho( "ORAÇÃO DA MANHÃ", R.string.oracaodamanhapassagem ) );
        auxList.add( new Filho( "ORAÇÃO DA NOITE", R.string.oracaodanoitepassagem ) );
        auxList.add( new Filho( "AVE MARIA", R.string.avemaria ) );
        auxList.add( new Filho( "CORDEIRO DE DEUS", R.string.cordeirodedeus ) );
        auxList.add( new Filho( "CREDO", R.string.creioemdeuspai ) );
        auxList.add( new Filho( "GLORIA AO PAI", R.string.gloriaaopai ) );
        auxList.add( new Filho( "GLORIA A DEUS NAS ALTURAS", R.string.gloriaadeusnasalturas ) );
        auxList.add( new Filho( "PAI NOSSO", R.string.painosso ) );
        auxList.add( new Filho( "SALVE RAINHA", R.string.salverainha ) );
        auxList.add( new Filho( "SINAL DA CRUZ", R.string.sinaldacruz ) );
        auxList.add( new Filho( "VINDE ESPIRITO SANTO", R.string.vindeespiritosanto ) );
        listData.put( listGroup.get( 0 ), auxList );
    }

    @Override
    public void onStart() {
        super.onStart();

        getListView().setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                Toast.makeText( getActivity(), listGroup.get( position ), Toast.LENGTH_SHORT ).show();
            }
        } );
    }
}
