package testeadapt3.cursoandroid2.com.pray.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import testeadapt3.cursoandroid2.com.pray.activities.MostrarOracoesSelecionadasActivity;
import testeadapt3.cursoandroid2.com.pray.adapter.ExpandableAdapter;
import testeadapt3.cursoandroid2.com.pray.adapter.Filho;

/**
 * A simple {@link Fragment} subclass.
 */
public class SantoTercoFragment extends ListFragment {

    private List <String> listGroup;
    private HashMap <String, List <Filho>> listData;

    public SantoTercoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_santo_terco, container, false );


        ExpandableListView expandableListView = (ExpandableListView) view.findViewById( R.id.expandableListView ); //instanncia a classe expanable
        criarLista();//chama a lista criada

        expandableListView.setAdapter( new ExpandableAdapter( getContext(),listGroup,listData ));//passa os parametros da lisra do grupo e dos itens
        expandableListView.setOnChildClickListener( new ExpandableListView.OnChildClickListener() { //inplementa os metodos de cliques das listas
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //  Toast.makeText( getContext(), "Group: " + groupPosition + " | Child: " + childPosition, Toast.LENGTH_SHORT ).show();
                String grupo = listGroup.get( groupPosition );
                Filho filho = listData.get( grupo ).get( childPosition );

                Intent intent = new Intent( getActivity(), MostrarOracoesSelecionadasActivity.class );
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
        listGroup.add( "ROSÁRIOS" ); //grupo 0
        listGroup.add( "TERÇOS" );//GRUPO 1
        listGroup.add( "LADAINHAS" );//GRUPO 2
        listGroup.add( "" );//GRUPO 3
        listGroup.add( "" );//GRUPO 4
        listGroup.add( "" );//GRUPO 5
        listGroup.add( "" );//GRUPO 6
        listGroup.add( "" );//GRUPO 7


        //formar filhos dos grupos (0) ///ROSARIOS
        List <Filho> auxList = new ArrayList <>();
        auxList.add( new Filho( "LADAINHA AO SAGRADO CORAÇÃO DE MARIA", R.string.oracaodamanhapassagem ) );
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

        //formar filhos dos grupos (1) //TERCOS
        auxList = new ArrayList <>(); //necessario instanciar o objeto todas as vezes, senao ele ira chamar as primeiras posicoes do grupo 0
        auxList.add( new Filho( "CONSAGRAÇÃO A NOSSA SENHORA", R.string.consagracaonossasenhora ) );
        auxList.add( new Filho( "CONSAGRAÇÃ MARIA RAINHA DO CÉU", R.string.consagracaomariarainhadoceu ) );
        auxList.add( new Filho( "CONSAGRAÇÃO AO IMACULADO CORAÇÃO DE MARIA", R.string.consagracaoaoimaculadocoracaodemaria ) );
        auxList.add( new Filho( "CONSAGRAÇÃO AO PRECIOSÍSSIMO SANGUE DE JESUS", R.string.consagracaoaopreciosissimosanguedejesus ) );
        auxList.add( new Filho( "CONSAGRAÇÃ AO ESPIRITO SANTO", R.string.consagracaoespiritosanto ) );
        auxList.add( new Filho( "CONSAGRAÇÃO A SÃO JOSÉ", R.string.consagracaoasaojose ) );
        listData.put( listGroup.get( 1 ), auxList );

        //formar filhos dos grupos (2) //LADAINHAS
        auxList = new ArrayList <>();
        auxList.add( new Filho( "LADAINHA AO SAGRADO CORAÇÃO DE MARIA", R.string.curafisicaeespiritual ) );
        auxList.add( new Filho( "CURA INTERIOR", R.string.curainterior ) );
        auxList.add( new Filho( "CURA DOS TRAUMAS", R.string.curadostarumas ) );
        auxList.add( new Filho( "CURA DA ÁRVORE GENEALÓGICA", R.string.curadaarvoregenealogica ) );
        auxList.add( new Filho( "CURA NO CASAMENTO", R.string.curanocasamento ) );
        auxList.add( new Filho( "CURA DAS CRIANÇAS", R.string.curadascriancas ) );
        auxList.add( new Filho( "CURA SEXUAL", R.string.curasexual ) );
        auxList.add( new Filho( "CURA DOS MEDOS", R.string.curadosmedos ) );
        auxList.add( new Filho( "CURA MENTAL", R.string.curamental ) );
        auxList.add( new Filho( "CURA DA LÍGUA", R.string.curadalingua ) );
        auxList.add( new Filho( "CURA DA DEPRESSÃO", R.string.curadadepressao ) );
        auxList.add( new Filho( "CURA ATRAVÉS DA HUMILDADE", R.string.curaatravesdahumildade ) );
        auxList.add( new Filho( "CURA PARA UMA MORTE FELIZ", R.string.curaparaumamortefeliz ) );
        listData.put( listGroup.get( 2 ), auxList );

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
