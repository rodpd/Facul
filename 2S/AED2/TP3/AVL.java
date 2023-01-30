// Rodrigo Padilha Fonseca
// Matricula: 628826
// TP03 - EX01 - Árvore Binária
// Classe No
class No
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
   public int fator;
   No esq;
   No dir;
   // construtor vazio
   void No ( )
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
      this.fator = 0;
   }
   // construtor com apontadores esq e dir
   void No ( No esq, No dir )
   {
      this.esq = esq;
      this.dir = dir;
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
   public void setFator ( )
   {
      this.fator++;
   }
   // calcular fator
   public int getFator ( No no )
   {
      int fator = getFator ( no, 0, 0, 0 );
      MyIO.println ( "fator: " + fator );
      return ( fator );
   }
   public int getFator ( No no, int fator, int fatorEsq, int fatorDir )
   {
      if ( no != null )
      {
         if ( this.esq != null )
         {
            fatorEsq = this.esq.getAltura ( this.esq );
         }
         if ( this.dir != null )
         {
            fatorDir = this.dir.getAltura ( this.dir );
         }
      }
      return ( fatorDir - fatorEsq );
   }
   // percorrer e encontrar altura
   public int getAltura ( No no )
   {
      int altura = getAltura ( no, 0, 0, 0 );
      return ( altura );
   }
   public int getAltura ( No no, int altura, int alturaEsq, int alturaDir )
   {
      if ( no != null )
      {
            alturaEsq = getAltura ( no.esq, altura, alturaEsq+1, alturaDir );
            alturaDir = getAltura ( no.dir, altura, alturaEsq, alturaDir+1 );
      }
      if ( alturaDir > alturaEsq )
      {
         altura = alturaDir;
      }
      else
      {
         altura = alturaEsq;
      }
      return ( altura );
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
   public No clone ( )
   {
      No Instituicao = new No ( );
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
// classe AVL
public class AVL
{
   // atributos
   No raiz;
   // construtor vazio
   void AVL ( )
   {
      this.raiz = null;
   }

   public void inserir ( No no )
   {
      this.raiz = inserir ( this.raiz, no );
   }
   public No inserir ( No no, No inserir )
   {
      if ( no == null )
      {
         no = new No ( );
         no = inserir.clone( );
         no.fator = no.getFator( no );
      }
      else if ( inserir.sigla.compareTo ( no.getSigla( ) ) < 0 )
      {
         no.esq = inserir ( no.esq, inserir );
      }
      else if ( inserir.sigla.compareTo ( no.getSigla( ) ) > 0 )
      {
         no.dir = inserir ( no.dir, inserir );
      }
      else
      {
         MyIO.println ( " deu erro aq mano " );
      }
       MyIO.println ( "antes d balancear " );
       MyIO.println ( "sigla: " + no.sigla );
       MyIO.println ( "fator: " + no.fator );
      no = balancear ( no );
       MyIO.println ( "dps d balancear " );
       MyIO.println ( "sigla: " + no.sigla );
       MyIO.println ( "fator: " + no.fator );
      mostrar( no );
      // MyIO.println ( "sigla: " + no.sigla );
      // MyIO.println ( "fator: " + no.fator );
      return ( no );
   }
   public No balancear ( No no )
   {
      if ( no != null )
      {
         int fator = no.getFator( no );
         if ( fator >= -1 && fator <= 1 )
         {
            no.fator = fator;
         }
         // Se estiver desbalanceada p/ direita
         else if ( fator == 2 )
         {
            int dir = no.getFator ( no.dir );
         // Se o filho tambem estiver desbalanceado
            if ( dir == -1 )
            {
               no.dir = rotacionarDir ( no.dir );
            }
            no = rotacionarEsq ( no );
         }
         // Se desbalanceada p/ esquerda
         else if ( fator == -2 )
         {
            int esq = no.esq.getFator( no.esq );
            if ( esq == 1 )
            {
               no.esq = rotacionarEsq ( no.esq );
            }
            no = rotacionarDir ( no );
         }
         else
         {
            MyIO.println ( " deu erro no balanceamento man " );
         }
      }
      return ( no );
   }
   public No rotacionarDir ( No no )
   {
      No noEsq = no.esq;
      No noEsqDir = noEsq.dir;
      noEsq.dir = no;
      no.esq = noEsqDir;
      no.fator = no.getFator( no );
      noEsq.fator = noEsq.getFator( noEsq);
      return ( noEsq );
   }
   public No rotacionarEsq ( No no )
   {
      No noDir = no.dir;
      No noDirEsq = noDir.esq;
      noDir.esq = no;
      no.dir = noDirEsq;
      no.fator = no.getFator( no );
      noDir.fator = noDir.getFator( noDir );
      return ( noDir );
   }
   /*public No balancear( No no )
   {
      if ( no != null )
      {
         int fator = no.getFator( );
         // Se balanceada
         if ( Math.abs(fator) <= 1 )
         {
            no.setFator ( );
         }
         // Se desbalanceada para a direita
         else if ( fator == 2 )
         {
            MyIO.println ( "desbalanceada, fator = 2" );
            MyIO.println ( "com fator 2: " + no.sigla );
            int fatorFilhoDir = no.dir.getFator ( );
            // MyIO.println ( "filho dir: " + no.dir.sigla );
            // MyIO.println ( "fator: " + no.fator );
            // MyIO.println ( "filho esq dir: " + no.dir.esq.sigla );
            //Se o filho a direita tambem estiver desbalanceado
            if ( fatorFilhoDir == -1 )
            {
               no.dir = rotacionarDir ( no.dir );
            }
            no = rotacionarEsq ( no );
         //Se desbalanceada para a esquerda
         }
         else if ( fator == -2 )
         {
            int fatorFilhoEsq = no.esq.getFator ( );
            //Se o filho a esquerda tambem estiver desbalanceado
            if ( fatorFilhoEsq == 1 )
            {
               no.esq = rotacionarEsq ( no.esq );
            }
            no = rotacionarDir ( no );
         }
         else
         {
            MyIO.println ( " deu erro la no balanceamento man " );
         }
      }
      return no;
   }
   public No rotacionarDir ( No no )
   {
      No noEsq = no.esq;
      No noEsqDir = noEsq.dir;
      noEsq.dir = no;
      no.esq = noEsqDir;
      no.setFator ( );
      noEsq.setFator ( );
      return ( noEsq );
   }
   public No rotacionarEsq ( No no )
   {
      No noDir = no.dir;
      No noDirEsq = noDir.esq;
      noDir.esq = no;
      no.dir = noDirEsq;
      no.setFator ( );
      noDir.setFator ( );
      return ( noDir );
   }*/

   public boolean pesquisar ( No no, String pesquisar )
   {
      boolean resp = true;
      if ( no == null )
      {
         resp = false;
      }
      else if ( pesquisar.compareTo ( no.getSigla( ) ) == 0 )
      {
         resp = true;
      }
      else if ( pesquisar.compareTo ( no.getSigla( ) ) < 0 )
      {
         MyIO.print ( "esq " );
         resp = pesquisar ( no.esq, pesquisar );
      }
      else if ( pesquisar.compareTo ( no.getSigla( ) ) > 0 )
      {
         MyIO.print ( "dir " );
         resp = pesquisar ( no.dir, pesquisar );
      }
      return ( resp );
   }
   public void mostrar ( No no )
   {
      MyIO.println ( no.sigla );
      MyIO.println ( no.fator );
      if ( no.esq != null )
      {
         mostrar ( no.esq );
      }
      if ( no.dir != null )
      {
         mostrar ( no.dir );
      }
   }
   public static void main ( String [] args )
   {
      AVL inst = new AVL ( );
      No temp = new No ( );
      // continuar lendo enquanto nao encontrar 0
      for ( int num = MyIO.readInt( ); num != 0; num = MyIO.readInt( ) )
      {
         temp.ler ( num );
         inst.inserir ( temp );
         temp = new No ( );
      }
      inst.mostrar ( inst.raiz );
      // inst.mostrar ( inst.raiz );
      // ler comandos da entrada padrao enquanto string for diferente de FIM
      for ( String s = MyIO.readString( ); s.compareTo( "FIM" ) != 0; s = MyIO.readString( ) )
      {
         temp = new No ( );
      // pesquisar, imprimir caminho e resp
         MyIO.print ( s + " raiz " );
         if ( inst.pesquisar ( inst.raiz, s ) )
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
