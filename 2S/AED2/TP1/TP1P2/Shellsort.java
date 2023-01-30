// Rodrigo Padilha Fonseca
// Matricula: 628826
// TP01P02 - EX11 - Shellsort
public class Shellsort implements Cloneable
{
	// atributos
	public static int ultimo;
	public static Shellsort [] inst;
	public static Shellsort [] retornada;
	static int movimentacoes;
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
	void Shellsort ( )
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
	void Shellsort ( int codigo, String nome, String sigla, int codigoMantenedora, String mantenedora, int categoria, int organizacao, int codigoMunicipio, String municipio, String uf, String regiao, int tecnico, int periodico, int livro, double receita, double transferencia, double outraReceita, double despesaDocente, double despesaTecnico, double despesaEncargo, double despesaCusteio, double despesaInvestimento, double despesaPesquisa, double despesaOutras )
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
	public Shellsort clone ( )
	{
		Shellsort Instituicao = new Shellsort ( );
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
	// metodo para ordenar por insercao
	public static void ordenarInsercao ( )
	{
		Shellsort temp = new Shellsort ( );
		// primeiro loop para definir o numero a ser comparado
		for ( int i = 1; i <= ultimo; i++ )
		{
			if ( inst[i].codigoMantenedora < inst[i-1].codigoMantenedora )
			{
				temp = inst[i].clone( );
				movimentacoes += 1;
				// segundo loop para comparar com os outros
				for ( int j = i-1; j>= 0; j-- )
				{
					// mover para a direita caso seja maior que o numero que esta sendo comparado
					if ( inst[j].codigoMantenedora > temp.codigoMantenedora )
					{
						inst[j+1] = inst[j].clone( );
						movimentacoes += 1;
					}
					else 
					{
						// colocar o numero que esta sendo comparado na posicao j e parar o loop caso seja menor
						if ( inst[j].codigoMantenedora < temp.codigoMantenedora )
						{
							inst[j+1] = temp.clone( );
							movimentacoes += 1;
							j = -1;
						}
						else 
						{
							// comparar usando sigla se o codigo da mantenedora for igual
							if ( inst[j].sigla.compareTo ( temp.sigla ) < 0 )
							{
								inst[j+1] = temp.clone( );
								j = -1;
								movimentacoes += 1;
							}
							else
							{
								inst[j+1] = inst[j].clone( );
								movimentacoes += 1;
							}
							comparacoes += 1;
						}
						comparacoes += 1;
					}
					comparacoes += 1;
				}
			}
			// caso o ultimo numero seja igual ao primeiro com o qual sera comparado
			else 
			{
				if ( inst[i].codigoMantenedora == inst[i-1].codigoMantenedora )
				{
					// comparar usando sigla e trocar caso seja menor
					if ( inst[i].sigla.compareTo ( inst[i-1].sigla ) < 0 )
					{
						temp = inst[i].clone( );
						inst[i] = inst[i-1].clone( );
						inst[i-1] = temp.clone( );
						movimentacoes += 3;
					}
					comparacoes += 1;
				}
				comparacoes += 1;
			}
			comparacoes += 1;
		}
	}
	public static void shellsort ( )
	{
		Shellsort temp = new Shellsort ( );
		// loop tamanhos diferentes
		for ( int i = 4; i>=1; i/=2 )
		{
			// loop percorrer com todas cores
			for ( int h = i; h < i*2; h++ )
			{
				// insercao mudar cor
				for ( int j = h; j <= ultimo; j+=i )
				{
					temp = inst[j].clone( );
               movimentacoes++;
					// insercao cor atual
					for ( int k = j-i; k >= 0; k-=i )
					{
						if ( temp.uf.compareTo ( inst[k].getUf( ) ) < 0 )
						{
							inst[k+i] = inst[k].clone( );
                     movimentacoes++;
							// caso seja a menor
							if ( k < i )
							{
								inst[k] = temp.clone( );
                        movimentacoes++;
							}
						}
						else
						{
							if ( temp.uf.compareTo ( inst[k].getUf( ) ) > 0 )
							{
								inst[k+i] = temp.clone( );
								k = -1;
                        movimentacoes++;
							}
							else
							{
								if ( temp.sigla.compareTo ( inst[k].getSigla( ) ) < 0 )
								{
									inst[k+i] = inst[k].clone( );
                           movimentacoes++;
									if ( k < i )
									{
										inst[k] = temp.clone( );
                              movimentacoes++;
									}
								}
								else
								{
									inst[k+i] = temp.clone( );
                           movimentacoes++;
									k = -1;
								}
                        comparacoes++;
							}
                     comparacoes++;
						}
                  comparacoes++;
					}
				}
			}
		}
	}
	public static void main ( String [] args )
	{
		long inicio = System.currentTimeMillis( );
		comparacoes = 0;
		movimentacoes = 0;
		inst = new Shellsort[200];
		ultimo = -1;
		int num = MyIO.readInt( );
		// continuar lendo enquanto nao encontrar 0 p/ povoar array de objetos
		while ( num > 0 )
		{
			inst[ultimo+1] = new Shellsort ( );
			inst[ultimo+1].ler(num);
			ultimo += 1;
			num = MyIO.readInt( );
		}
		// ordenar por shellsort
		shellsort( );
		// imprimir dados do array
		for ( int i = 0; i <= ultimo; i++ )
		{
			inst[i].imprimir( );
			//MyIO.println ( inst[i].getUf( ) + " " + inst[i].getSigla( ) );
		}
		// calcular tempo final
		long tempo = System.currentTimeMillis( ) - inicio;
		// abrir arquivo e escrever matricula, tempo em milisegundos e numero de comparacoes
		Arq.openWrite ( "matrícula_shellsort.txt" );
		Arq.println ( "628826\t" + comparacoes + "\t" + movimentacoes + "\t" + tempo );
		Arq.close( );
	}
}
