Construcao dos metodos de autenticacoes 
Login Facebook
Login Google
Utilizacao Firebase


Tabs Default

Da documentação do design do material do google

As guias facilitam a exploração e alternam entre diferentes visualizações.

As guias permitem a organização do conteúdo em um nível alto, como alternar entre visualizações, conjuntos de dados ou aspectos funcionais de um aplicativo.

Como adicionar? ¶
I. Na sua build.gradleadição mais recente design e appcompatbibliotecas.


dependências {
    compile 'com.android.support:appcompat-v7:XXX'
    Compile 'com.android.support:design:XXX'
    compile 'com.android.support:support-v13:XXX'
    // onde a versão XXX
}
II. Faça sua atividade se estender android.support.v7.app.AppCompatActivity.


 classe  pública MainActivity  estende  AppCompatActivity  {
 ...
}
III Declare TabLayoute ViewPagerno seu layout.xmlarquivo.


<LinearLayout  xmlns: android = "http://schemas.android.com/apk/res/android"
    android: layout_width = "match_parent"
    android: layout_height = "match_parent"
    android: orientação = "vertical" >

    <android.support.design.widget.TabLayout
        android: id = "@ id / tabLayout"
        android: layout_width = "match_parent"
        android: layout_height = "wrap_content"
        android: fundo = "? attr / colorPrimary" />

    <android.support.v4.view.ViewPager
        android: id = "@ id / viewPager"
        android: layout_width = "match_parent"
        android: layout_height = "match_parent" />

</ LinearLayout>
IV. Configure o seu TabLayoutcom ViewPager.


ViewPager  viewPager  =  ( ViewPager )  findViewById ( R . ID . ViewPager );

// configure o adaptador para seu ViewPager
viewPager . setAdapter ( novo  FragmentPagerAdapter ( getFragmentManager ()));

TabLayout  tabLayout  =  ( TabLayout )  findViewById ( R . ID . TabLayout );
tabLayout . setupWithViewPager ( viewPager );
V. Substitua o getPageTitlemétodo no adaptador do ViewPager para retornar o título da guia.


@Override
public  CharSequence  getPageTitle ( posição int  ) { switch ( position ) { case ITEM_ONE : retorna "Item Um" ; ... } }






Como estilizar? ¶
Guias estilizadas

I. Declare o estilo personalizado no seu styles.xmlarquivo.


<style  name = "TabLayoutStyle"  pai = "Widget.Design.TabLayout" >
    <item  name = "tabMaxWidth" > @dimen / tab_max_width </ item>
    <item  name = "tabIndicatorColor" > @ cor / rosa </ item>
    < item  name = "tabIndicatorHeight" > 2dp </ item>
    <item  name = "tabPaddingStart" > 8dp </ item>
    <item  name = "tabPaddingEnd" > 8dp </ item>
    < nome do item = "tabBackground" >? attr / selectableItemBackground </ item>
    <item  name = "tabTextAppearance" > @ estilo / TabTextAppearance </ item>
    <item  name = "tabSelectedTextColor" > @android: cor / branco </ item>
</ style>

<  nome do estilo = "TabTextAppearance"  parent = "TextAppearance.Design.Tab" >
    <item  name = "android: tamanho_do_texto" > 14sp </ item>
    <item  name = "android: color_text" > @ color / color_white_semitransparent </ item>
    <item  name = "textAllCaps" > verdadeiro </ item>
</ style>
II. Aplique este estilo ao seu atributo TabLayoutvia style.


<android.support.design.widget.TabLayout
        style = "@ style / TabLayoutStyle"
        android: id = "@ id / tabLayout"
        android: layout_width = "match_parent"
        android: layout_height = "wrap_content" / & gt;
Guias com ícones e texto ¶
Guias estilizadas com ícones e texto

I. Substitua o getPageTitlemétodo no adaptador do ViewPager para retornar o título da guia.


@Override
public  CharSequence  getPageTitle ( posição int  ) { switch ( position ) { case ITEM_ONE : retorna "Item Um" ; ... } }






II. Crie seletores para cada ícone de guia.


<seletor  xmlns: android = "http://schemas.android.com/apk/res/android" >

    <item
        android: estado_selecionado = "verdadeiro"
        android: drawable = "@ drawable / ic_call_selected"  />

    <item
        android: estado_selecionado = "falso"
        android: drawable = "@ drawable / ic_call_unselected"  />

</ selector>
III Para alterar o TabLayout.Tab#setIconmétodo de uso do ícone da guia . Você pode obter o TabLayout.Tabobjeto via TabLayout#getTabAtmétodo, que aceita o índice de tabulação como parâmetro.


...
// depois da inicialização TabLayout e ViewPager
TabLayout . Tab  tabCall  =  tabLayout . getTabAt ( ITEM_CALL );
tabCall . setIcon ( R . amovível . selector_call );

// repita este código para todas as suas guias
...
Guias com ícones apenas ¶
Apenas ícones de guias

I. Criar seletores para cada ícone de guia.


<seletor  xmlns: android = "http://schemas.android.com/apk/res/android" >

    <item
        android: estado_selecionado = "verdadeiro"
        android: drawable = "@ drawable / ic_call_selected"  />

    <item
        android: estado_selecionado = "falso"
        android: drawable = "@ drawable / ic_call_unselected"  />

</ selector>
II. Para alterar o TabLayout.Tab#setIconmétodo de uso do ícone da guia . Você pode obter o TabLayout.Tabobjeto via TabLayout#getTabAtmétodo, que aceita o índice de tabulação como parâmetro.


...
// depois da inicialização TabLayout e ViewPager
TabLayout . Tab  tabCall  =  tabLayout . getTabAt ( ITEM_CALL );
tabCall . setIcon ( R . amovível . selector_call );

// repita este código para todas as suas guias
...
Guias Roláveis ¶
Guias roláveis

Para tornar seu atributo de TabLayoutrolagem adicionar custom:tabModee definir seu valor para scrollable.


<android.support.design.widget.TabLayout
        xmlns: custom = "http://schemas.android.com/apk/res-auto"
        android: id = "@ id / tabLayout"
        android: layout_width = "match_parent"
        android : layout_height = "wrap_content"
        custom: tabMode = "rolável" />
Entradas com registro ¶
Guias centralizadas

Para criar guias centralizadas, adicione o custom:tabGravityatributo e defina seu valor como center.


<android.support.design.widget.TabLayout
        xmlns: custom = "http://schemas.android.com/apk/res-auto"
        android: id = "@ id / tabLayout"
        android: layout_width = "match_parent"
        android : layout_height = "wrap_content"
        personalizado: tabGravity = "center" />