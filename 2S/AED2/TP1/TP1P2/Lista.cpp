// Rodrigo Padilha Fonseca
// Matricula: 628826
// TP01P02 - EX05 - Lista com Alocacao Sequencial em C
int main ( )
{
	inst = new Lista[200];
	retornada = new Lista[20];
	Lista Instituicao = new Lista ( );
	ultimo = -1;
	int num = MyIO.readInt( );
	// continuar lendo enquanto nao encontrar 0 p/ povoar array de objetos
	while ( num > 0 )
	{
		inst[ultimo+1] = new Lista ( );
		inst[ultimo+1].ler(num);
		ultimo += 1;
		num = MyIO.readInt( );
	}
	String linha;
	String s[];
	int retornadas = 0;
	// ler i comandos da entrada padrao
	for ( int i = MyIO.readInt( ); i > 0; i-- )
	{
		linha = MyIO.readLine( );
		s = linha.split(" ");
		if ( s[0].equals("II") )
		{
			//instanciar objeto antes de executar metodo
			Instituicao.ler( Integer.parseInt(s[1]) );
			inserirInicio ( Instituicao );
		}
		else if ( s[0].equals("IF") )
		{
			Instituicao.ler( Integer.parseInt(s[1]) );
			inserirFim ( Instituicao );
		}
		else if ( s[0].equals("I*") )
		{
			Instituicao.ler( Integer.parseInt(s[2]) );
			inserir ( Instituicao, Integer.parseInt(s[1]));
		}  
		else if ( s[0].equals("RI") )
		{
			// objetos retornados sao guardados em um outro array
			// e imprimidos ao serem retornados
			retornada[retornadas] = new Lista ( );
			retornada[retornadas] = removerInicio ( );
			MyIO.println ( "(R) " + retornada[retornadas].getNome( ) );
			retornadas += 1;
		}
		else if ( s[0].equals("RF") )
		{         
			retornada[retornadas] = new Lista ( );
			retornada[retornadas] = removerFim ( );
			MyIO.println ( "(R) " + retornada[retornadas].getNome( ) );
			retornadas += 1;
		}
		else if ( s[0].equals("R*") )
		{
			retornada[retornadas] = new Lista ( );
			retornada[retornadas] = remover ( Integer.parseInt(s[1]) );
			MyIO.println ( "(R) " + retornada[retornadas].getNome( ) );
			retornadas += 1;
		}
	}
	// print do array
	for ( int i = 0; i <= ultimo; i++ )
	{
		inst[i].imprimir( );
	}
}
}
return 0;
}
typedef struct Instituicao
{
	// atributos
	public static int ultimo;
	public static Lista [] inst;
	public static Lista [] retornada;
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
	// metodo p/ imprimir dados do objeto
	void imprimir ( )
	{
		printf ( this.codigo + " " + this.nome + " " + this.sigla + " " + this.codigoMantenedora + " " + this.mantenedora 
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
	public Lista clone ( )
	{
		Lista Instituicao = new Lista ( );
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
	// metodo p inserir no inicio - recebe objeto Instituicao
	public static void inserirInicio ( Lista Instituicao )
	{
		// aumento na variavel ultimo para contagem, uso no for e instanciar array de 
		// instituicoes na proxima posicao caso ainda nao tenha sido iniciado
		ultimo += 1;
		inst[ultimo] = new Lista ( ); 
		int i;
		// mover os elementos para uma posicao a mais
		for ( i = ultimo; i > 0; i-- )
		{
			inst[i] = inst[i-1].clone( );
		}
		// colocar parametro na primeira posicao
		inst[i] = Instituicao.clone( );
	}
	// metodo p inserir no fim - recebe objeto Instituicao
	public static void inserirFim ( Lista Instituicao )
	{
		ultimo += 1;
		inst[ultimo] = Instituicao.clone( );
	}
	// metodo p inserir em certa posicao
	public static void inserir ( Lista Instituicao, int posicao )
	{
		ultimo += 1;
		inst[ultimo] = new Lista ( );
		int i;
		// mover elementos a partir de posicao para a direita
		for ( i= ultimo; i > posicao; i-- )
		{
			inst[i] = inst[i-1].clone( );
		}
		// colocar elemento na posicao escolhida
		inst[i] = Instituicao.clone( );
	}
	// metodo para remover objeto do inicio do array - retorna o objeto
	public static Lista removerInicio ( )
	{
		//diminuir contagem de objetos
		ultimo -= 1;
		Lista Instituicao = new Lista ( );
		// igualar objeto que sera retornado a atual posicao 0 ja que sera sobrescrita
		Instituicao = inst[0].clone( );
		// mover objetos p esquerda
		for ( int i = 0; i <=ultimo; i++ )
		{
			inst[i] = inst[i+1].clone( );
		}
		// deletar objeto na posicao que ficou fora da contagem
		inst[ultimo+1] = null;
		return ( Instituicao );
	}
	// metodo p remover ultimo objeto
	public static Lista removerFim ( )
	{
		ultimo -= 1;
		Lista Instituicao = new Lista ( );
		//clonar objeto que sera deletado para dar return depois
		Instituicao = inst[ultimo+1].clone( );
		inst[ultimo+1] = null;
		return ( Instituicao );
	}
	// metodo p remover certa posicao
	public static Lista remover ( int posicao )
	{
		ultimo -= 1;
		Lista Instituicao = new Lista ( );
		Instituicao = inst[posicao].clone( );
		// mover elementos a partir da posicao escolhida para a esquerda
		for ( int i = posicao; i <=ultimo; i++ )
		{
			inst[i] = inst[i+1].clone( );
		}
		inst[ultimo+1] = null;
		return ( Instituicao );
	}
	public static void main ( String [] args )
	{
		inst = new Lista[200];
		retornada = new Lista[20];
		Lista Instituicao = new Lista ( );
		ultimo = -1;
		int num = MyIO.readInt( );
		// continuar lendo enquanto nao encontrar 0 p/ povoar array de objetos
		while ( num > 0 )
		{
			inst[ultimo+1] = new Lista ( );
			inst[ultimo+1].ler(num);
			ultimo += 1;
			num = MyIO.readInt( );
		}
		String linha;
		String s[];
		int retornadas = 0;
		// ler i comandos da entrada padrao
		for ( int i = MyIO.readInt( ); i > 0; i-- )
		{
			linha = MyIO.readLine( );
			s = linha.split(" ");
			if ( s[0].equals("II") )
			{
				//instanciar objeto antes de executar metodo
				Instituicao.ler( Integer.parseInt(s[1]) );
				inserirInicio ( Instituicao );
			}
			else if ( s[0].equals("IF") )
			{
				Instituicao.ler( Integer.parseInt(s[1]) );
				inserirFim ( Instituicao );
			}
			else if ( s[0].equals("I*") )
			{
				Instituicao.ler( Integer.parseInt(s[2]) );
				inserir ( Instituicao, Integer.parseInt(s[1]));
			}  
			else if ( s[0].equals("RI") )
			{
				// objetos retornados sao guardados em um outro array
				// e imprimidos ao serem retornados
				retornada[retornadas] = new Lista ( );
				retornada[retornadas] = removerInicio ( );
				MyIO.println ( "(R) " + retornada[retornadas].getNome( ) );
				retornadas += 1;
			}
			else if ( s[0].equals("RF") )
			{         
				retornada[retornadas] = new Lista ( );
				retornada[retornadas] = removerFim ( );
				MyIO.println ( "(R) " + retornada[retornadas].getNome( ) );
				retornadas += 1;
			}
			else if ( s[0].equals("R*") )
			{
				retornada[retornadas] = new Lista ( );
				retornada[retornadas] = remover ( Integer.parseInt(s[1]) );
				MyIO.println ( "(R) " + retornada[retornadas].getNome( ) );
				retornadas += 1;
			}
		}
		// print do array
		for ( int i = 0; i <= ultimo; i++ )
		{
			inst[i].imprimir( );
		}
	}
}
