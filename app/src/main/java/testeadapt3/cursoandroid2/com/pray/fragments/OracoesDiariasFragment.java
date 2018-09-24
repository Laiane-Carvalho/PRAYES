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
public class OracoesDiariasFragment extends ListFragment {

    private List <String> listGroup;
    private HashMap <String, List <Filho>> listData;

    public OracoesDiariasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_oracoes_diarias, container, false );

        ExpandableListView expandableListView = (ExpandableListView) view.findViewById( R.id.expandableListView );
        criarLista();

        expandableListView.setAdapter( new ExpandableAdapter( getContext(), listGroup, listData ) );
        // expandableListView.setAdapter( new ExpandableAdapterFragmentOracoes( getContext(), listGroup, listData ) );

        //listner do clique no filho
        expandableListView.setOnChildClickListener( new ExpandableListView.OnChildClickListener() {
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

    //listas prontas, falta configurar e rever todo texto
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

        //formar filhos dos grupos (1)
        auxList = new ArrayList <>(); //necessario instanciar o objeto todas as vezes, senao ele ira chamar as primeiras posicoes do grupo 0
        auxList.add( new Filho( "CONSAGRAÇÃO A NOSSA SENHORA", R.string.consagracaonossasenhora ) );
        auxList.add( new Filho( "CONSAGRAÇÃ MARIA RAINHA DO CÉU", R.string.consagracaomariarainhadoceu ) );
        auxList.add( new Filho( "CONSAGRAÇÃO AO IMACULADO CORAÇÃO DE MARIA", R.string.consagracaoaoimaculadocoracaodemaria ) );
        auxList.add( new Filho( "CONSAGRAÇÃO AO PRECIOSÍSSIMO SANGUE DE JESUS", R.string.consagracaoaopreciosissimosanguedejesus ) );
        auxList.add( new Filho( "CONSAGRAÇÃ AO ESPIRITO SANTO", R.string.consagracaoespiritosanto ) );
        auxList.add( new Filho( "CONSAGRAÇÃO A SÃO JOSÉ", R.string.consagracaoasaojose ) );
        listData.put( listGroup.get( 1 ), auxList );

        //formar filhos dos grupos (2)
        auxList = new ArrayList <>();
        auxList.add( new Filho( "CURA FÍSICA E ESPIRITUAL", R.string.curafisicaeespiritual ) );
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

        //lista3
        auxList = new ArrayList <>();
        auxList.add( new Filho( "INTERCESSOR", R.string.oracaodointercessor ) );
        auxList.add( new Filho( "INTERCESSÃO PELA CONVERSÃO DE ALGUÉM", R.string.intercessaoconversaodealguem ) );
        auxList.add( new Filho( "INTERCESSÃO PELA CURA INTERIOR DE ALGUÉM", R.string.intercessaopelacurainteriordealguem ) );
        auxList.add( new Filho( "INTERCESSÃO BÊNÇÃO PARA ALGUÉM", R.string.intercessaobencaodealguem ) );
        auxList.add( new Filho( "INTERCESSÃO PELA NAÇÃO", R.string.intercessaopelanacao ) );
        listData.put( listGroup.get( 3 ), auxList );

        //lista 4
        auxList = new ArrayList <>();
        auxList.add( new Filho( "ORAÇÃO ARMADURA DO CRISTÃO", R.string.armaduradocristao ) );
        auxList.add( new Filho( "ORAÇÃO SÃO MIGUEL ARCANJO", R.string.saomiguelarcanjo ) );
        auxList.add( new Filho( "O MAGNIFICAT LC 1,46-56", R.string.magnificat ) );
        auxList.add( new Filho( "ORAÇÃO DE ABANDONO EM DEUS", R.string.abandonoemdeus ) );
        auxList.add( new Filho( "ORAÇÃO AUGUSTA RAINHA DOS CÉUS", R.string.augustarainhadapaz ) );
        auxList.add( new Filho( "SALMOS 91", R.string.salmo91 ) );
        listData.put( listGroup.get( 4 ), auxList );

        //lista 5
        auxList = new ArrayList <>();
        auxList.add( new Filho( "ORAÇÃO DE LIBERTAÇÃO", R.string.oracaodelibertacao ) );
        auxList.add( new Filho( "ORAÇÃO LIBERTAÇÃO DA RESISTÊNCIA", R.string.libertacaodaresistencia ) );
        auxList.add( new Filho( "ORAÇÃO COMBATE ESPIRITUAL", R.string.oracaocombateespiritual ) );
        auxList.add( new Filho( "LOUVOR ÁS CHAGAS E AO SANGUE DO CORDEIRO", R.string.louvoraschagaseaosanguedocordeiro ) );
        auxList.add( new Filho( "ORAÇÃO DE CONFISSÃO E RENUNCIA", R.string.oracaodeconficaoerenuncia ) );
        auxList.add( new Filho( "ORAÇÃO DE QUEBRA DE MALDIÇÃO", R.string.oracaodequebrademaldicao ) );
        listData.put( listGroup.get( 5 ), auxList );

        //lista 6
        auxList = new ArrayList <>();
        auxList.add( new Filho( "SÃO MIGUEL ARCANJO", R.string.saomiguelarcanjo ) );
        auxList.add( new Filho( "SÃO GABRIEL ARCANJO", R.string.oracaosaogabrielarcanjo ) );
        auxList.add( new Filho( "SÃO RAFAEL ARCANJO", R.string.oracaosaorafaelarcanjo ) );
        auxList.add( new Filho( "SÃO PADRE PIO DE PIETRELCINA", R.string.saopadrepio ) );
        auxList.add( new Filho( "ŠÃO JOSÉ", R.string.oracaoasaojose ) );
        auxList.add( new Filho( "SANTA TEREZA D'AVILA", R.string.oracaosantaterezadavila ) );
        auxList.add( new Filho( "SÃO BENTO", R.string.oracaoasaobento ) );
        auxList.add( new Filho( "SANTA TEREZINHA DO MENINO JESUS", R.string.oracaosantaterezinhadomeninojesis ) );
        auxList.add( new Filho( "SANTO AGOSTINHO", R.string.oracaoasantoagostinho ) );
        listData.put( listGroup.get( 6 ), auxList );

        //lista 7
        auxList = new ArrayList <>();
        auxList.add( new Filho( "ORAÇÃO REPARADORA SO SANTÍSSIMO SACRAMENTO", R.string.oracaoreparadoraaosantissimosacramento ) );
        auxList.add( new Filho( "ORAÇÃO PARA PEDIR FÉ", R.string.oracaoparapedirfe ) );
        auxList.add( new Filho( "ORAÇÃO NOSSA SENHORA DESATADORA DOS NÓS", R.string.nossasenhoradesatadoradosnos ) );
        auxList.add( new Filho( "ORAÇÃO DE BÊNÇÃO DE LUGARES TUMULTUADOS", R.string.bencaodelugarestumultuados ) );
        auxList.add( new Filho( "ORAÇÃO A NOSSA SENHORA DO EQUILÍBRIO", R.string.oracaoanossasenhoradoequilibrio ) );
        listData.put( listGroup.get( 7 ), auxList );

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
