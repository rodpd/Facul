// Rodrigo Padilha Fonseca
// Matricula: 628826
// TP01P02 - EX03 - Pilha com Alocacao Sequencial
public class InstituicaoPilha implements Cloneable
{
   // atributos
   public static int ultimo;
   public static InstituicaoPilha [] inst;
   public static InstituicaoPilha [] retornada;
   private int codigo;
   private String nome;
   private String sigla;
   private int codigoMantenedora;
   private String mantenedora;
   private int categoria;
   private int organizacao;
   private int codigoMunicipio;
   private String municipio;
   private String uf;
   private String regiao;
   private int tecnico;
   private int periodico;
   private int livro;
   private double receita;
   private double transferencia;
   private double outraReceita;
   private double despesaDocente;
   private double despesaTecnico;
   private double despesaEncargo;
   private double despesaCusteio;
   private double despesaInvestimento;
   private double despesaPesquisa;
   private double despesaOutras;
      static InstituicaoPilha prox;
   static InstituicaoPilha primeiro;
   static InstituicaoPilha ultimo;
   // construtor vazio
   void InstituicaoPilha ( )
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
         this.prox = null;
      this.primeiro = null;
      this.ultimo = null;
   }
   // construtor que muda tudo
   void InstituicaoPilha ( int codigo, String nome, String sigla, int codigoMantenedora, String mantenedora, int categoria, int organizacao, int codigoMunicipio, String municipio, String uf, String regiao, int tecnico, int periodico, int livro, double receita, double transferencia, double outraReceita, double despesaDocente, double despesaTecnico, double despesaEncargo, double despesaCusteio, double despesaInvestimento, double despesaPesquisa, double despesaOutras )
   {
      this.codigo = codigo;
      this.nome = nome;
      this.sigla = sigla;
      this.codigoMantenedora = codigoMantenedora;
      this.mantenedora = mantenedora;
      this.categoria = categoria;
      this.organizacao = organizacao;
      this.codigoMunicipio = codigoMunicipio;
      this.municipio = municipio;
      this.uf = uf;
      this.regiao = regiao;
      this.tecnico = tecnico;
      this.periodico = periodico;
      this.livro = livro;
      this.receita = receita;
      this.transferencia = transferencia;
      this.outraReceita = outraReceita;
      this.despesaDocente = despesaDocente;
      this.despesaTecnico = despesaTecnico;
      this.despesaEncargo = despesaEncargo;
      this.despesaCusteio = despesaCusteio;
      this.despesaInvestimento = despesaInvestimento;
      this.despesaPesquisa = despesaPesquisa;
      this.despesaOutras = despesaOutras;
      // getters e setters
   }
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
   public InstituicaoPilha clone ( )
   {
      InstituicaoPilha Instituicao = new InstituicaoPilha ( );
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
   // metodo p inserir
   public static void inserir ( InstituicaoPilha Instituicao )
   {
      ultimo.prox = temp;
      temp.prox = null;
      ultimo = temp;
      temp = null;
   }
   // metodo p remover
   public static InstituicaoPilha remover ( )
   {
         //clonar objeto que sera deletado
      InstituicaoPilha Instituicao = ultimo.clone( );
      InstituicaoPilha temp = primeiro;
      if ( primeiro != ultimo )
      {
         while ( temp.prox != ultimo )
         {
            temp = temp.prox;
         }
         ultimo = temp;
         temp = temp.prox = null;
      }
      return ( Instituicao );
   }
   public static void main ( String [] args )
   {
      InstituicaoPilha inst = new InstituicaoPilha ( );
      InstituicaoPilha retornada = new InstituicaoPilha ( );
      inst.primeiro = inst;
      inst.ultimo = inst;
      retornada.primeiro = retornada;
      retornada.ultimo = retornada;
      InstituicaoPilha temp = inst.primeiro;
      int num = MyIO.readInt( );
      // continuar lendo enquanto nao encontrar 0
      while ( num > 0 )
      {
         temp.prox = new InstituicaoPilha ( );
         temp = temp.prox;
         temp.ler(num);
         temp.ultimo = temp;
         num = MyIO.readInt( );
      }
      String linha;
      String s[];
      retornada = new InstituicaoPilha ( );
      retornada.primeiro = retornada;
      retornada.ultimo = retornada;
      // ler i comandos da entrada padrao
      for ( int i = MyIO.readInt( ); i > 0; i-- )
      {
         linha = MyIO.readLine( );
         s = linha.split(" ");
         if ( s[0].equals("I") )
         {
            inst.ler( Integer.parseInt(s[1]) );
            inst.inserirFim ( temp );
         }
         else if ( s[0].equals("R") )
         {         
            retornada.ultimo.prox = inst.removerFim ( );
            retornada.ultimo = retornada.ultimo.prox;
            retornada.ultimo.prox = null;
            MyIO.println ( "(R) " + retornada.ultimo.getNome( ) );
         }
      }
      // print do array
      for ( InstituicaoPilha i = inst.primeiro; i != null; i = i.prox )
      {
         i.imprimir( );
      }
   }
}
