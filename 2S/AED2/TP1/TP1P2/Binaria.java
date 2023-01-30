// Rodrigo Padilha Fonseca
// Matricula: 628826
// // TP01P02 - EX07 - Pesquisa Binaria
public class Binaria implements Cloneable
{
	// atributos
	public static int ultimo;
	public static Binaria [] inst;
	public static Binaria [] retornada;
	static int comparacoes;
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
	// construtor vazio
	void Binaria ( )
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
	// construtor que muda tudo
	void Binaria ( int codigo, String nome, String sigla, int codigoMantenedora, String mantenedora, int categoria, int organizacao, int codigoMunicipio, String municipio, String uf, String regiao, int tecnico, int periodico, int livro, double receita, double transferencia, double outraReceita, double despesaDocente, double despesaTecnico, double despesaEncargo, double despesaCusteio, double despesaInvestimento, double despesaPesquisa, double despesaOutras )
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
		this.despesaDocente = (double)Double.parseDouble(s[17]);
		this.despesaTecnico = Double.parseDouble(s[18]);
		this.despesaEncargo = Double.parseDouble(s[19]);
		this.despesaCusteio = Double.parseDouble(s[20]);
		this.despesaInvestimento = Double.parseDouble(s[21]);
		this.despesaPesquisa = Double.parseDouble(s[22]);
		this.despesaOutras = Double.parseDouble(s[23]);
		Arq.close( );	
	}
	// metodo p/ criar clone do objeto - retorna o clone
	public Binaria clone ( )
	{
		Binaria Instituicao = new Binaria ( );
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
	// metodo p inserir no fim - recebe objeto Instituicao
	public static void inserir ( Binaria Instituicao )
	{
		ultimo += 1;
		inst[ultimo] = Instituicao.clone( );
	}
	// metodo para ordenar por quicksort
	public static void ordenarQuicksort ( int esq, int dir)
	{
		// declarar variaveis
		int i = esq, j = dir;	
		Binaria pivo = new Binaria ( );
		Binaria temp = new Binaria ( );
		// definir pivo
		pivo = inst[(esq+dir)/2].clone( );
		while ( i <= j )
		{
			// mover i para a direita ate encontrar um nome maior ou igual ao do pivo
			while ( inst[i].sigla.compareTo ( pivo.sigla ) < 0 )
			{
				i++;
			}
			// mover j para a esquerda ate encontrar um nome menor ou igual ao do pivo
			while ( inst[j].sigla.compareTo ( pivo.sigla ) > 0 )
			{
				j--;
			}
			// trocar os dois se i nao for maior que j
			if ( i <= j )
			{
				temp = inst[i].clone( );
				inst[i] = inst[j].clone( );
				inst[j] = temp.clone( );
				i++;
				j--;
			}
		}
		if ( j > esq )
		{
			ordenarQuicksort ( esq, j );
		}
		if ( i < dir )
		{
			ordenarQuicksort ( i, dir );
		}
	}
	public static boolean pesquisaBinaria ( String linha ) 
	{
		int esq = 0;
		int dir = ultimo;
		int meio;
		boolean resp = false;
		// continuar pesquisa binaria enquanto esq nao passar de dir
		while ( esq <= dir )
		{
			meio = (esq+dir)/2;
			// se encontrar a sigla mudar resposta e parar loop
			if ( linha.equals( inst[meio].getSigla( ) ) )
			{
				resp = true;
				esq = ultimo+1;
			}
			// se sigla for maior que o meio procurar apenas a partir do meio
			else
			{
				if ( linha.compareTo( inst[meio].getSigla( ) ) > 0 )
				{
					esq = meio + 1;
				}
				// caso contrario procurar antes do meio
				else
				{
					dir = meio - 1;
				}
				comparacoes += 1;
			}
			comparacoes += 1;
		}
		return ( resp );
	}
	public static void main ( String [] args )
	{
		long inicio = System.currentTimeMillis( );
		comparacoes = 0;
		inst = new Binaria[200];
		Binaria Instituicao = new Binaria ( );
		ultimo = -1;
		int num = MyIO.readInt( );
		// continuar lendo enquanto nao encontrar 0 p/ povoar array de objetos
		while ( num > 0 )
		{
			comparacoes += 1;
			inst[ultimo+1] = new Binaria ( );
			inst[ultimo+1].ler(num);
			ultimo += 1;
			num = MyIO.readInt( );
		}
		// ordenar com quicksort
		ordenarQuicksort( 0, ultimo );
		String linha = MyIO.readLine( );
		boolean resp;
		while ( ! (linha.equals ( "FIM" )) )
		{
			// resetar resposta da pesquisa binaria
			resp = false;
			resp = pesquisaBinaria( linha );
			if  ( resp == false )
			{
				MyIO.println ( "NÃO" );
			}
			else
			{
				MyIO.println ( "SIM" );
			}
			linha = MyIO.readLine( );
		}
		// calcular tempo final
		long tempo = System.currentTimeMillis( ) - inicio;
		// abrir arquivo e escrever matricula, tempo em milisegundos e numero de comparacoes
		Arq.openWrite ( "matrícula_binaria.txt" );
		Arq.println ( "628826\t" + tempo + "\t" + comparacoes );
		MyIO.println ( "" );
		Arq.close( );
	}
}
