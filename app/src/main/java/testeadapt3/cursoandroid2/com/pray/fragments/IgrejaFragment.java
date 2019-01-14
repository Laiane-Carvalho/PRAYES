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
import testeadapt3.cursoandroid2.com.pray.activities.ActivityMostrarAjudaSelecionada;
import testeadapt3.cursoandroid2.com.pray.adapter.ExpandableAdapter;
import testeadapt3.cursoandroid2.com.pray.adapter.Filho;

public class IgrejaFragment extends ListFragment {

    private List <String> listGroup;
    private HashMap <String, List <Filho>> listData;

    public IgrejaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_igreja, container, false );

        ExpandableListView expandableListView = (ExpandableListView) view.findViewById( R.id.expandableListView ); //instanncia a classe expanable
        criarLista();//chama a lista criada

        expandableListView.setAdapter( new ExpandableAdapter( getContext(), listGroup, listData ) );//passa os parametros da lisra do grupo e dos itens
        expandableListView.setOnChildClickListener( new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //  Toast.makeText( getContext(), "Group: " + groupPosition + " | Child: " + childPosition, Toast.LENGTH_SHORT ).show();

                String grupo = listGroup.get( groupPosition );
                Filho filho = listData.get( grupo ).get( childPosition );

                Intent intent = new Intent( getActivity(), ActivityMostrarAjudaSelecionada.class );
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
        listGroup.add( "HISTÓRIA E FATOS DA IGREJA" ); //grupo 0
        listGroup.add( "EUCARISTIA" );//GRUPO 1
        listGroup.add( "CATÓLICOS X PROTESTANTES" );//GRUPO 2
        listGroup.add( "ORIENTAÇÕES DA IGREJA" );//GRUPO 3

        //formar filhos dos grupos (0) ///HISTÓRIA E FATOS DA IGREJA
        List <Filho> auxList = new ArrayList <>();
        auxList.add( new Filho( "PORQUE SOU CATÓICO", R.string.PORQUESOUCATOLICO ) );
        auxList.add( new Filho( "COMO CRER NA SANTIDADE DA IGREJA", R.string.ComoacrersantidadeIgreja ) );
        auxList.add( new Filho( "TEOLOGIA DA LIBERTAÇÃ E SUA INFLUÊNCIA NA IGREJA", R.string.TEOLOGIADALIBERTACAOESUAINFLUENCIA ) );
        auxList.add( new Filho( "IGREJA APÓS O CONCÍLIO VATICANO II", R.string.IGREJAAPOSCONCILIOVATICANOII ) );
        auxList.add( new Filho( "INDULGÊNCIAS", R.string.INDULGENCIAS ) );
        auxList.add( new Filho( "PEDRO E O PRIMADO PAPAL", R.string.PEDROEOPRIMADOPAPAL ) );
        auxList.add( new Filho( "O CAPITALISMO", R.string.CAPITALISMO ) );
        auxList.add( new Filho( "O QUE FOI A ORDEM DOS TEMPLÁRIOS", R.string.ORDEMDOSTEMPLARIOS ) );
        auxList.add( new Filho( "FIDELIDADE AO PAPA", R.string.FIDELIDADEAOPAPA ) );
        auxList.add( new Filho( "PORQUE A MISSA DO SÉTIMO DIA", R.string.PORQUEAMISSADOSETIMODIA ) );
        auxList.add( new Filho( "PORQUE COBRIR AS IMAGENS SACRAS NA QUARESMA", R.string.PORQUECOBRIRASIMAGENSSACRASNAQUARESMA ) );
        auxList.add( new Filho( "PORQUE NÃO COMER CARNE NA SEXTA-FEIRA SANTA", R.string.PORQUENAOCOMERCARNESEXTA ) );
        auxList.add( new Filho( "COMO INTERPRETAR AS SAGRADA ESCRITURA", R.string.COMOINTERPRETARASAGRADAESCRITURA ) );
        auxList.add( new Filho( "TODAS AS RELIGIÕES SÃO IGUALMENTE BOAS?", R.string.TODASASRELIGIOES ) );
        auxList.add( new Filho( "PRESBÍTEROS E O REINO DE DEUS", R.string.PRESBITEROSEOREINO ) );
        auxList.add( new Filho( "QUAL A MISSÃO DE UM PAPA", R.string.QUALAMISSAODEUMPAPA ) );
        auxList.add( new Filho( "O PURGATÓIO", R.string.OPURGATÓIO ) );
        auxList.add( new Filho( "TRÍDUO PASCAL", R.string.TRIDUOPASCAL ) );
        listData.put( listGroup.get( 0 ), auxList );

        //formar filhos dos grupos (0) ///EUCARISTIA
        auxList = new ArrayList <>();
        auxList.add( new Filho( "SANTÍSSIMA EUCARISTIA", R.string.SANTISSIMAEUCARISTIA ) );
        auxList.add( new Filho( "MILAGRE EUCARÍSTICO", R.string.MILAGREEUCARISTICO ) );
        auxList.add( new Filho( "PRESENÇA REAL DE JESUS NA EUCARISTIA", R.string.PRESENCAREALDEJESUSNAEUCARISTIA ) );
        auxList.add( new Filho( "POR QUE DEVEMOS COMUNGAR AO MENOS UMA VEZ POR ANO?", R.string.PORQUEDEVEMOSCOMUNGARAOMENOSUMAVEZPORANO ) );
        auxList.add( new Filho( "IMPORTÂNCIA DE COMUNGAR BEM", R.string.IMPORTANCIADECOMUNGARBEM ) );
        auxList.add( new Filho( "COMUNHÃO EM PECADO GRAVE", R.string.COMUNHAOEMPECADOGRAVE ) );
        auxList.add( new Filho( "COMUNHÃO EUCARÍSTICA: TRÊS ALVURAS DA FÉ CATÓLICA", R.string.COMUNHAOEUCARISTICAALVURAS ) );
        auxList.add( new Filho( "QUINTA-FEIRA SANTA EUCARISTIA, SACRIFÍIO E PRESENÇA DE AMOR", R.string.QUINTAFEIRAEUCARISTICASACRIFICIO ) );
        auxList.add( new Filho( "DEVO COMUNGAR COM AS MÃOS?", R.string.DEVOCOMUNGARCOMASMAOS ) );
        auxList.add( new Filho( "PORQUE É NECESSÁRIO AÇÃO DE GRAÇAS APÓS COMUNHÃO?", R.string.PORQUEACAODEGRACAOAPOSCOMUNHAO ) );
        auxList.add( new Filho( "É NECESSÁRIO CURSO DE CATEQUESE PARA PRIMEIRA COMUNHÃO?", R.string.NECESSARIOCURSODECATEQUESEPARAPRIMEIRACOMUNHAO) );
        auxList.add( new Filho( "COMUNHÃO SOB DUAS ESPÉCIES", R.string.COMUNHAOSOBDUASESPECIES ) );
        listData.put( listGroup.get( 1 ), auxList );

        //formar filhos dos grupos (0) ///IGREJA CATÓLICA X PROTESTANTISMO
        auxList = new ArrayList <>();
        auxList.add( new Filho( "O PROTESTANTISMO", R.string.OPROTESTANTISMO ) );
        auxList.add( new Filho( "CHAVE PARA ENTENDER O PROTESTANTISMO", R.string.CHAVEPARAENTENDEROPROTESTANTISMO) );
        auxList.add( new Filho( "O NEOPROTESTANTISMO DENTRO DA IGREJA CATÓLICA", R.string.NEOPROTESTANTISMODENTRODAIGREJACATOLICA) );
        auxList.add( new Filho( "A BÍBLIA CATÓICA X PROTESTANTE", R.string.DIFERENCAENTREBIBLIACATOLICAEAPROTESTANTE ) );
        auxList.add( new Filho( "VIRGEM MARIA (PROTESTANTES) MARIA ÉUMA MULHER QUALQUER?", R.string.MARIAEUMAMULHERQUALQUER ) );
        auxList.add( new Filho( "PORQUE OS CATÓLICOS PEDEM A MARIA E NÃO DIRETAMENTE A JESUS? ", R.string.PORQUECATOLICOSPEDEMAMARIAENAOAJESUS ) );
        auxList.add( new Filho( "PORQUE OS PROTESTANTES NÃ ACREDITAM NA SANTIDADE", R.string.PORQUEOSPROTESTANTESNAOACREDITAMNASANTIDADE ) );
        auxList.add( new Filho( "TESTEMUNHO EX PASTOR PROTESTANTE SCOTT HAHN", R.string.TESTEMUNHOSCOTTHAHN ) );
        auxList.add( new Filho( "CASAMENTO EM IGREJA PROTESTANTE É VÁLIDO?", R.string.CASAMENTOEMIGREJAPROTESTANTEEVALIDO ) );
        auxList.add( new Filho( "PORQUE TANTOS CATOLICOS DEIXAM A IGREJA", R.string.PORQUETANTOSCATOLICOSDEIXAMAIGREJA ) );
        listData.put( listGroup.get( 2 ), auxList );

        //formar filhos dos grupos (0) ///ORIENTACOES DA IGREJA
        auxList = new ArrayList <>();
        auxList.add( new Filho( "COMO SABER O TAMANHO DO AMOR DE CRISTO POR NÓS", R.string.COMOSABEROTAMANHODOAMORDECRISTOPORNOS ) );
        auxList.add( new Filho( "COMO ENSINAR SEU FILHO QUAL É A VERDADEIRA IGREJA DE CRISTO?", R.string.COMOENSINARSEUFILHOQUALAVERDADEIRAIGREJADECRISTO ) );
        auxList.add( new Filho( "COMO EDUCAR OS FILHOS EM UM MUNDO DOMINADO PELO RELATIVISMO MORAL", R.string.COMOEDUCARSEUFILHOEMUMMUNDODOMINADOPELORELATIVISMOMORAL ) );
        auxList.add( new Filho( "COMO EDUCAR OS FILHOS QUANDO OS PAIS TRABALHAM FORA", R.string.COMOEDUCARSEUFILHOSQUANDOOSPAISTRABALHAMFORAL ) );
        auxList.add( new Filho( "COMO CONTROLAR A PRÓRIA IRRITAÇÃO", R.string.COMOCONTROLARAPROPRIAIRRITACAO ) );
        auxList.add( new Filho( "COMO RENUNCIAR A SÍ MESMO", R.string.COMORENUNCIARASIMESMO ) );
        auxList.add( new Filho( "COMO O CRISTÃO DE HOJE DEVE SE MORTIFICAR", R.string.COMOOCRISTAODEHOJEDEVESEMORTIFICAR ) );
        auxList.add( new Filho( "COMO CONCENTRAR NA ORAÇÃO", R.string.COMOCONCENTRARNAORACAO ) );
        auxList.add( new Filho( "COMO FAZER UMA BOA CONFIÇÃO", R.string.COMOFAZERUMABOACONFICAO ) );
        auxList.add( new Filho( "COMO ME RELACIONAR COM MEU ANJO DA GUARDA", R.string.COMOMERELACIONARCOMMEUANJODAGUARDA ) );
        auxList.add( new Filho( "APRENDER A REZAR O SANTO TERÇO", R.string.COMOAPRENDERAREZAROTERCO ) );
        auxList.add( new Filho( "COMO DESCOBRIR MINHA VOCAÇÃO", R.string.COMODESCOBRIRMINHAVOCACAO ) );
        auxList.add( new Filho( "COMO DEVEMOS NOS PREPARAR PARA MORTE", R.string.COMODEVEMOSNOSPREPARARPARAMORTE ) );
        auxList.add( new Filho( "COMO INTERPRETAR AS SAGRADAS ESCRITURAS", R.string.COMOINTERPRETARASAGRADAESCRITURA ) );
        auxList.add( new Filho( "COMO FALAR DE SEXO COM SEUS FILHOS", R.string.COMOFALARDESEXOCOMMEUSFILHOS ) );
        auxList.add( new Filho( "COMO COMBATER AS DISTRAÇÕES DURANTE AS ORAÇÕES", R.string.COMOSELIVRARDASDISTRACOES ) );
        auxList.add( new Filho( "COMO LIDAR COM O CIÚME DOENTIO", R.string.COMOSELIVRARDOCIUMEDOENTIO ) );
        auxList.add( new Filho( "COMO SE LIVRAR DO VÍCIO DA MASTURBAÇÃO", R.string.COMOSELIVRARDOVICIODAMASTURBACAO ) );
        auxList.add( new Filho( "COMO LEVAR MEUS PAIS PARA IGREJA", R.string.COMOLEVARMEUSPAISPARAIGREJA ) );
        auxList.add( new Filho( "COMO COMBATER A PREGUIÇA ESPIRITUAL", R.string.COMOCOMBATERAPREGUICAESPIRITUAL ) );
        auxList.add( new Filho( "COMO AUMENTAR MINHA FE", R.string.COMOAUMENTARMINHAFE ) );
        auxList.add( new Filho( "MODÉSTIA- COMO AS MULHERES DEVEM SE PORTAR PARTE-1", R.string.MODESTIACOMOAMULHERDEVESEPORTAR ) );
        auxList.add( new Filho( "MODÉSTIA- COMO AS MULHERES DEVEM SE PORTAR PARTE-2", R.string.MULHERMODESTIAPARTE2 ) );
        auxList.add( new Filho( "COMO CONVIVER E CUIDAR DOS IDOSOS", R.string.COMOCONVIVERECUIDARDOSIDOSOS ) );
        auxList.add( new Filho( "COMO LIDAR COM CONFLITO MÃE E ESPOSA", R.string.COMOLIDARCOMCONFLITOMAEEESPOSA ) );
        auxList.add( new Filho( "COMO O FACEBOOK PODE SER UMA ARMADILHA PARA CASTIDADE", R.string.COMOOFACEBOOKPODESERUMAARMADILHA ) );
        listData.put( listGroup.get( 3 ), auxList );
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
