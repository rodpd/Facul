// Rodrigo Padilha Fonseca
// Matricula: 628826
// TP03 - EX05 - Tabela Hash Direta com Reserva
// Classe Instituicao
class Instituicao
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
   // construtor vazio
   void instituicao ( )
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
   public String getInstituicaome ( )
   {
      return ( this.nome );
   }
   public void setInstituicaome ( String nome )
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
      Arq.openRead ( "/tmp/censo.dat", "ISO-8859-1" );
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
   public Instituicao clone ( )
   {
      Instituicao instituicao = new Instituicao ( );
      instituicao.codigo = getCodigo( );
      instituicao.nome = getInstituicaome( );
      instituicao.sigla = getSigla( );
      instituicao.codigoMantenedora = getCodigoMantenedora( );
      instituicao.mantenedora = getMantenedora( );
      instituicao.categoria = getCategoria( );
      instituicao.organizacao = getOrganizacao( );
      instituicao.codigoMunicipio = getCodigoMunicipio( );
      instituicao.municipio = getMunicipio( );
      instituicao.uf = getUf( );
      instituicao.regiao = getRegiao( );
      instituicao.tecnico = getTecnico( );
      instituicao.periodico = getPeriodico( );
      instituicao.livro = getLivro( );
      instituicao.receita = getReceita( );
      instituicao.transferencia = getTransferencia( );
      instituicao.outraReceita = getOutraReceita( );
      instituicao.despesaDocente = getDespesaDocente( );
      instituicao.despesaTecnico = getDespesaTecnico( );
      instituicao.despesaEncargo = getDespesaEncargo( );
      instituicao.despesaCusteio = getDespesaCusteio( );
      instituicao.despesaInvestimento = getDespesaInvestimento( );
      instituicao.despesaPesquisa = getDespesaPesquisa( );
      instituicao.despesaOutras = getDespesaOutras( );
      return ( instituicao );
   }
}
// classe hashDiretaReserva
public class hashDiretaReserva
{
   // atributos
   Instituicao[ ] tabela;
   // construtor com tamanho da tabela
   hashDiretaReserva ( )
   {
      this( 30 );
   }
   hashDiretaReserva ( int x )
   {
      this.tabela = new Instituicao[x];
      for ( int i = 0; i < x; i++ )
      {
         tabela[i] = null;
      }
   }
   public void inserir ( Instituicao inst )
   {  
      // encontrar posicao
      int div = inst.codigoMantenedora % 21;
      // se for nula, colocar instituicao na posicao
      if ( tabela[div] == null )
      {
         tabela[div] = new Instituicao ( );
         tabela[div] = inst.clone( );
      }
      // caso contrario percorrer area reserva procurando espaco vazio
      else
      {
         for ( int i = 21; i < 30; i++ )
         {
            if ( tabela[i] == null )
            {
               tabela[i] = new Instituicao ( );
               tabela[i] = inst.clone( );
               i = 30;
            }
         }
      }
   }
   public void pesquisar ( String pesquisar )
   {
      boolean resp = false;
      // percorrer tabela procurando a string passada como parametro
      for ( int i = 0; i < 30; i++ )
      {
         if ( tabela[i] != null )
         {
            if ( tabela[i].sigla.compareTo ( pesquisar ) == 0 )
            {
               MyIO.println ( "(" + i + ") " + "SIM" );
               resp = true;
               i = 30;
            }
         }
      }
      if ( resp == false )
      {
         MyIO.println ( "N??O" );
      }
   }
   public static void main ( String [] args )
   {
      hashDiretaReserva inst = new hashDiretaReserva ( );
      Instituicao temp = new Instituicao ( );
      // continuar lendo enquanto nao encontrar 0
      for ( int num = MyIO.readInt( ); num != 0; num = MyIO.readInt( ) )
      {
         temp.ler ( num );
         inst.inserir ( temp );
         temp = new Instituicao ( );
      }
      // ler comandos da entrada padrao enquanto string for diferente de FIM
      for ( String s = MyIO.readString( ); s.compareTo( "FIM" ) != 0; s = MyIO.readString( ) )
      {
         MyIO.print ( s + " " );
      // pesquisar e imprimir resp
         inst.pesquisar ( s );
      }
   }
}
