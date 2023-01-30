// Rodrigo Padilha Fonseca
// Matricula: 628826
// TP03 - EX01 - Árvore Binária
// Classe No
class No
{
// atributos
   public int chave;
   No esq;
   No dir;
   arvoreSegunda arvore;
// construtor vazio
   No ( )
   {
      this.arvore = new arvoreSegunda( );
   }
// construtor com chave
   No ( int x )
   {
      this.chave = x;
      this.arvore = new arvoreSegunda( );
   }
}
class NoSegunda
{
// atributos
   public int codigo;
   public String nome;
   public String sigla;
   public int codigoMantenedora;
   public String mantenedora;
   public int categoria;
   public int organizacao;
   public int codigoMunicipio;
   public String municipio;
   public String uf;
   public String regiao;
   public int tecnico;
   public int periodico;
   public int livro;
   public double receita;
   public double transferencia;
   public double outraReceita;
   public double despesaDocente;
   public double despesaTecnico;
   public double despesaEncargo;
   public double despesaCusteio;
   public double despesaInvestimento;
   public double despesaPesquisa;
   public double despesaOutras;
   NoSegunda esq;
   NoSegunda dir;
// construtor vazio
   NoSegunda ( )
   {
      this.codigo = 0;
      this.nome = "";
      this.sigla = "";
      this.codigoMantenedora = 0;
      this.mantenedora = "";
      this.categoria = 0;
      this.organizacao = 0;
      this.codigoMunicipio = 0;
      this.municipio = "";
      this.uf = "";
      this.regiao = "";
      this.tecnico = 0;
      this.periodico = 0;
      this.livro = 0;
      this.receita = 0.0;
      this.transferencia = 0.0;
      this.outraReceita = 0.0;;
      this.despesaDocente = 0.0;
      this.despesaTecnico = 0.0;
      this.despesaEncargo = 0.0;
      this.despesaCusteio = 0.0;
      this.despesaInvestimento = 0.0;
      this.despesaPesquisa = 0.0;
      this.despesaOutras = 0.0;
      this.esq = null;
      this.dir = null;
   }
// getters e setters
   public int getCodigo ( )
   {
      return ( this.codigo );
   }
   public void setCodigo ( int codigo )
   {
      this.codigo = codigo;
   }
   public String getNome ( )
   {
      return ( this.nome );
   }
   public void setNome ( String nome )
   {
      this.nome = nome;
   }
   public String getSigla ( )
   {
      return ( this.sigla );
   }
   public void setSigla ( String sigla )
   {
      this.sigla = sigla;
   }
   public int getCodigoMantenedora ( )
   {
      return ( this.codigoMantenedora );
   }
   public void setCodigoMantenedora ( int cod )
   {
      this.codigoMantenedora = cod;
   }
   public String getMantenedora ( )
   {
      return ( this.mantenedora );
   }
   public void setMantenedora ( String mantenedora )
   {
      this.mantenedora = mantenedora;
   }
   public int getCategoria ( )
   {
      return ( this.categoria );
   }
   public void setCategoria ( int categoria )
   {
      this.categoria = categoria;
   }
   public int getOrganizacao ( )
   {
      return ( this.organizacao );
   }
   public void setOrganizacao ( int organizacao )
   {
      this.organizacao = organizacao;
   }
   public int getCodigoMunicipio ( )
   {
      return ( this.codigoMunicipio );
   }
   public void setCodigoMunicipio ( int cod )
   {
      this.codigoMunicipio = cod;
   }
   public String getMunicipio ( )
   {
      return ( this.municipio );
   }
   public void setMunicipio ( String municipio )
   {
      this.municipio = municipio;
   }
   public String getUf ( )
   {
      return ( this.uf );
   }
   public void setUf ( String uf )
   {
      this.uf = uf;
   }
   public String getRegiao ( )
   {
      return ( this.regiao );
   }
   public void setRegiao ( String regiao )
   {
      this.regiao = regiao;
   }
   public int getTecnico ( )
   {
      return ( this.tecnico );
   }
   public void setTecnico ( int tecnico )
   {
      this.tecnico = tecnico;
   }
   public int getPeriodico ( )
   {
      return ( this.periodico );
   }
   public void setPeriodico ( int periodico )
   {
      this.periodico = periodico;
   }
   public int getLivro ( )
   {
      return ( this.livro );
   }
   public void setLivro ( int livro )
   {
      this.livro = livro;
   }
   public double getReceita ( )
   {
      return ( this.receita );
   }
   public void setReceita ( double receita )
   {
      this.receita = receita;
   }
   public double getTransferencia ( )
   {
      return ( this.transferencia );
   }
   public void setTransferencia ( double transf )
   {
      this.transferencia = transf;
   }
   public double getOutraReceita ( )
   {
      return ( this.outraReceita );
   }
   public void setOutraReceita ( double rec )
   {
      this.outraReceita = rec;
   }
   public double getDespesaDocente ( )
   {
      return ( this.despesaDocente );
   }
   public void setDespesaDocente ( double despesa )
   {
      this.despesaDocente = despesa;
   }
   public double getDespesaTecnico ( )
   {
      return ( this.despesaTecnico );
   }
   public void setDespesaTecnico ( double despesa )
   {
      this.despesaTecnico = despesa;
   }
   public double getDespesaEncargo ( )
   {
      return ( this.despesaEncargo );
   }
   public void setDespesaEncargo ( double despesa )
   {
      this.despesaEncargo = despesa;
   }
   public double getDespesaCusteio ( )
   {
      return ( this.despesaCusteio );
   }
   public void setDespesaCusteio ( double despesa )
   {
      this.despesaCusteio = despesa;
   }
   public double getDespesaInvestimento ( )
   {
      return ( this.despesaInvestimento );
   }
   public void setDespesaInvestimento ( double despesa )
   {
      this.despesaInvestimento = despesa;
   }
   public double getDespesaPesquisa ( )
   {
      return ( this.despesaPesquisa );
   }
   public void setDespesaPesqusia ( double despesa )
   {
      this.despesaPesquisa = despesa;
   }
   public double getDespesaOutras ( )
   {
      return ( this.despesaOutras );
   }
   public void setDespesaOutras ( double despesa )
   {
      this.despesaOutras = despesa;
   }
   // metodo p/ imprimir dados do objeto
   void imprimir ( )
   {
      MyIO.println ( this.codigo + " " + this.nome + " " + this.sigla + " " + this.codigoMantenedora + " " + this.mantenedora 
         + " " + this.categoria + " " + this.organizacao + " " + this.codigoMunicipio + " " + this.municipio + " " + this.uf 
         + " " + this.regiao + " " + this.tecnico + " " + this.periodico + " " + this.livro + " " + this.receita + " " 
         + this.transferencia + " " + this.outraReceita + " " + this.despesaDocente + " " + this.despesaTecnico + " " 
         + this.despesaEncargo + " " + this.despesaCusteio + " " + this.despesaInvestimento + " " + this.despesaPesquisa 
         + " " + this.despesaOutras );
   }
// metodo p/ ler e gravar dados do censo.dat - recebe numero da linha que sera lida
   void ler ( int numLinha )
   {
   //abrir arquivo e continuar lendo linha ate chegar na desejada
      Arq.openRead ( "censo.dat", "ISO-8859-1" );
      for ( int i = 0; i < numLinha; i++ )
      {
         Arq.readLine( );
      }
      String linha = Arq.readLine( );
   // split com \t porque estavam separados por tabulacao
      String s[] = linha.split("\t");
   // mudar atributos pegando das partes separadas pelo split
      this.codigo = Integer.parseInt(s[0]);
      this.nome = s[1];
      this.sigla = s[2];
      this.codigoMantenedora = Integer.parseInt(s[3]);
      this.mantenedora = s[4];
      this.categoria = Integer.parseInt(s[5]);
      this.organizacao = Integer.parseInt(s[6]);
      this.codigoMunicipio = Integer.parseInt(s[7]);
      this.municipio = s[8];
      this.uf = s[9];
      this.regiao = s[10];
      this.tecnico = Integer.parseInt(s[11]);
      this.periodico = Integer.parseInt(s[12]);
      this.livro = Integer.parseInt(s[13]);
      this.receita = Double.parseDouble(s[14]);
      this.transferencia = Double.parseDouble(s[15]);
      this.outraReceita = Double.parseDouble(s[16]);
      this.despesaDocente = Double.parseDouble(s[17]);
      this.despesaTecnico = Double.parseDouble(s[18]);
      this.despesaEncargo = Double.parseDouble(s[19]);
      this.despesaCusteio = Double.parseDouble(s[20]);
      this.despesaInvestimento = Double.parseDouble(s[21]);
      this.despesaPesquisa = Double.parseDouble(s[22]);
      this.despesaOutras = Double.parseDouble(s[23]);
      Arq.close( );	
   }
// metodo p/ criar clone do objeto - retorna o clone
   public NoSegunda clone ( )
   {
      NoSegunda Instituicao = new NoSegunda ( );
      Instituicao.codigo = getCodigo( );
      Instituicao.nome = getNome( );
      Instituicao.sigla = getSigla( );
      Instituicao.codigoMantenedora = getCodigoMantenedora( );
      Instituicao.mantenedora = getMantenedora( );
      Instituicao.categoria = getCategoria( );
      Instituicao.organizacao = getOrganizacao( );
      Instituicao.codigoMunicipio = getCodigoMunicipio( );
      Instituicao.municipio = getMunicipio( );
      Instituicao.uf = getUf( );
      Instituicao.regiao = getRegiao( );
      Instituicao.tecnico = getTecnico( );
      Instituicao.periodico = getPeriodico( );
      Instituicao.livro = getLivro( );
      Instituicao.receita = getReceita( );
      Instituicao.transferencia = getTransferencia( );
      Instituicao.outraReceita = getOutraReceita( );
      Instituicao.despesaDocente = getDespesaDocente( );
      Instituicao.despesaTecnico = getDespesaTecnico( );
      Instituicao.despesaEncargo = getDespesaEncargo( );
      Instituicao.despesaCusteio = getDespesaCusteio( );
      Instituicao.despesaInvestimento = getDespesaInvestimento( );
      Instituicao.despesaPesquisa = getDespesaPesquisa( );
      Instituicao.despesaOutras = getDespesaOutras( );
      return ( Instituicao );
   }
}
class arvoreSegunda
{
// atributos
   NoSegunda raiz;
// construtor vazio
   arvoreSegunda ( )
   {
      this.raiz = null;
   }
   // metodos p inserir na segunda arvore
   public void inserirSegunda ( NoSegunda no )
   {
      this.raiz = inserirSegunda ( this.raiz, no );
   }
   public NoSegunda inserirSegunda ( NoSegunda no, NoSegunda inserir )
   {
   // inserir caso o no seja nulo
      if ( no == null )
      {
         no = new NoSegunda ( );
         no = inserir.clone( );
      }
      // caso contrario, procurar posicao para isnerir
      else if ( inserir.getCodigo( ) < no.getCodigo( ) )
      {
         no.esq = inserirSegunda ( no.esq, inserir );
      }
      else if ( inserir.getCodigo( ) > no.getCodigo( ) )
      {
         no.dir = inserirSegunda ( no.dir, inserir );
      }
      return ( no );
   }
   // metodos p pesquisar na segunda arvore
   public boolean pesquisarSegunda ( int pesquisar )
   {
      return ( pesquisarSegunda ( this.raiz, pesquisar ) );
   }
   public boolean pesquisarSegunda ( NoSegunda no, int pesquisar )
   {
      boolean resp = false;
      // mudar resp caso seja encontrado
      if ( no.codigo == pesquisar )
      {
         resp = true;
      }
      // se resp for falsa, printar esq
      if ( resp == false )
      {
         MyIO.print ( "esq " );
         // se esq for nulo, pesquisar a partir dele
         if ( no.esq != null )
         {
            resp = pesquisarSegunda ( no.esq, pesquisar );
         }
         // mesmo procedimento p/ lado direito
         if ( resp == false )
         {
            MyIO.print ( "dir " );
            if ( no.dir != null )
            {
               resp = pesquisarSegunda ( no.dir, pesquisar );
            }
         }
      }
      return ( resp );
   }
}
// classe arvoreDeArvore
public class arvoreDeArvore
{
   // atributos
   No raiz;
   // construtor vazio
   arvoreDeArvore ( )
   {
      this.raiz = null;
   }
   // metodos p inserir na primeira arvore
   public void inserirInicio ( int inserir )
   {
      this.raiz = inserirInicio ( this.raiz, inserir );
   }
   public No inserirInicio ( No no, int inserir )
   {
   // inserir caso no seja nulo
      if ( no == null )
      {
         no = new No( inserir );
         no.chave = inserir;
      }
      // caso contrario, procurar posicao
      else if ( inserir < no.chave )
      {
         no.esq = inserirInicio ( no.esq, inserir );
      }
      else if ( inserir > no.chave )
      {
         no.dir = inserirInicio ( no.dir, inserir );
      }
      return ( no );
   }
   // metodos p inserir na segunda arvore
   public void inserir ( NoSegunda no )
   {
      inserir ( this.raiz, no );
   }
   public boolean inserir ( No no, NoSegunda inserir )
   {
      boolean inserido = false;
      // se o codigo mod 15 for igual a chave, chamar outro metodo para inserir na segunda
      if ( no.chave == inserir.getCodigo( ) % 15 )
      {
         no.arvore.inserirSegunda ( inserir );
         inserido = true;
      }
      else
      {
      // caso contrario, continuar procurando o no em que sera inserido
         if ( no.esq != null )
         {
            inserido = inserir ( no.esq, inserir );
         }
         if ( no.dir != null )
         {
            inserido = inserir ( no.dir, inserir );
         }
      }
      return ( inserido );
   }
   // metodo p pesquisar
   public boolean pesquisar ( No no, int pesquisar )
   {
      boolean resp = false;
      MyIO.print ( "esq " );
      // caso esq nao seja nulo e resp ainda seja falsa, pesquisar a partir do no esq
      if ( no.esq != null && resp == false )
      {
         resp = pesquisar ( no.esq, pesquisar );
      }
      // caso resp ainda seja falsa, pesquisar na arvore secundaria do no atual
      if ( resp == false )
      {
         MyIO.print ( "raiz " );
         resp = no.arvore.pesquisarSegunda ( pesquisar );
         // caso resp continue falsa, pesquisar no No a direita
         if ( resp == false )
         {
            MyIO.print ( "dir " );
            if ( no.dir != null )
            {
               resp = pesquisar ( no.dir, pesquisar );
            }
         }
      }
      return ( resp );
   }
   public static void main ( String [] args )
   {
   // insercao dos nos da primeira arvore
      arvoreDeArvore inst = new arvoreDeArvore ( );
      inst.inserirInicio ( 7 );
      inst.inserirInicio ( 3 );
      inst.inserirInicio ( 11 );
      inst.inserirInicio ( 1 );
      inst.inserirInicio ( 5 );
      inst.inserirInicio ( 9 );
      inst.inserirInicio ( 12 );
      inst.inserirInicio ( 0 );
      inst.inserirInicio ( 2 );
      inst.inserirInicio ( 4 );
      inst.inserirInicio ( 6 );
      inst.inserirInicio ( 8 );
      inst.inserirInicio ( 10 );
      inst.inserirInicio ( 13 );
      inst.inserirInicio ( 14 );
      NoSegunda temp = new NoSegunda ( );
      // continuar lendo enquanto nao encontrar 0
      for ( int num = MyIO.readInt( ); num > 0; num = MyIO.readInt( ) )
      {
         temp.ler ( num );
         inst.inserir ( temp );
         temp = new NoSegunda ( );
      }
      // ler comandos da entrada padrao enquanto string for diferente de FIM
      for ( int num = MyIO.readInt( ); num != 0; num = MyIO.readInt( ) )
      {
         // pesquisar, imprimir caminho e resp
         MyIO.print ( num + " raiz " );
         if ( inst.pesquisar ( inst.raiz, num ) )
         {
            MyIO.println ( "SIM" );
         }
         else
         {
            MyIO.println ( "NÃO" );
         }
      }
   }
}