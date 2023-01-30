// Aluno: Rodrigo Padilha
// Matricula: 628826
// 8. Leitura de Pagina HTTP

import java.net.*;
import java.io.*;

public class q08
{
// metodo para ler da pagina e imprimir quantidades de chars
	public static void leitura ( String nome )
	{
		URL url;
      // variaveis dos chars para contar quantidades
		int a=0, á=0, à=0, ã=0, â=0, e=0, é=0, è=0, ê=0, i=0, í=0, ì=0, î=0, o=0, ó=0, ò=0, õ=0, ô=0, u=0, ú=0, ù=0, û=0, consoantes=0, br=0, table=0;
		try
		{
         // ler nome da pagina do input
			String endereco = MyIO.readLine( );
			url = new URL ( endereco );
			URLConnection conn = url.openConnection( );
			BufferedReader in = new BufferedReader ( new InputStreamReader ( conn.getInputStream( ) ) );
			String inputLine;
         // continuar lendo da pagina enquanto a linha nao for vazia
			while ( ( inputLine = in.readLine ( ) ) != null )
			{
				int tamanho = inputLine.length( );
            // contar quantidade dos chars
				for ( int n = 0; n < tamanho; n++ )
				{
					if ( inputLine.charAt(n) == 'a' )
					{
						a += 1;
					}
					else if ( inputLine.charAt(n) == 'e' )
					{
						e += 1;
					}
					else if ( inputLine.charAt(n) == 'i' )
					{
						i += 1;
					}
					else if ( inputLine.charAt(n) == 'o' )
					{
						o += 1;
					}
					else if ( inputLine.charAt(n) == 'u' )
					{
						u += 1;
					}
					else if ( inputLine.charAt(n) == 'á' )
					{
						á += 1;
					}
					else if ( inputLine.charAt(n) == 'é' )
					{
						é += 1;
					}
					else if ( inputLine.charAt(n) == 'í' )
					{
						í += 1;
					}
					else if ( inputLine.charAt(n) == 'ó' )
					{
						ó += 1;
					}
					else if ( inputLine.charAt(n) == 'ú' )
					{
						ú += 1;
					}
					else if ( inputLine.charAt(n) == 'à' )
					{
						à += 1;
					}
					else if ( inputLine.charAt(n) == 'è' )
					{
						è += 1;
					}
					else if ( inputLine.charAt(n) == 'ì' )
					{
						ì += 1;
					}
					else if ( inputLine.charAt(n) == 'ò' )
					{
						ò += 1;
					}
					else if ( inputLine.charAt(n) == 'ù' )
					{
						ù += 1;
					}
					else if ( inputLine.charAt(n) == 'ã' )
					{
						ã += 1;
					}
					else if ( inputLine.charAt(n) == 'õ' )
					{
						õ += 1;
					}
					else if ( inputLine.charAt(n) == 'â' )
					{
						â += 1;
					}
					else if ( inputLine.charAt(n) == 'ê' )
					{
						ê += 1;
					}
					else if ( inputLine.charAt(n) == 'î' )
					{
						î += 1;
					}
					else if ( inputLine.charAt(n) == 'ô' )
					{
						ô += 1;
					}
					else if ( inputLine.charAt(n) == 'û' )
					{
						û += 1;
					}
					else if ( ( inputLine.charAt(n) >= 'b' && inputLine.charAt(n) <='z' ) )
					{
						consoantes += 1;
					}
               // se comecar com < checar se e' <br> ou <table>
               // se sim aumentar quantidade de br ou table e diminuir 
               // numero de consoantes e vogais lidas
					else if ( inputLine.charAt(n) == '<' )
					{
						if ( inputLine.charAt(n+1) == 'b' )
						{
							if ( inputLine.charAt(n+2) == 'r' )
							{
								if ( inputLine.charAt(n+3) == '>' )
								{
								br += 1;
								consoantes -= 2;
								}
							}
						}
							if ( inputLine.charAt(n+1) == 't' )
						{
							if ( inputLine.charAt(n+2) == 'a' )
							{
								if ( inputLine.charAt(n+3) == 'b' )
								{
									if ( inputLine.charAt(n+4) == 'l' )
									{
										if (inputLine.charAt(n+5) == 'e' )
										{
											if ( inputLine.charAt(n+6) == '>' )
											{
												table += 1;
												consoantes -= 3;
												a -= 1;
												e -= 1;
											}
										}
									}
								}
							}
						}
					}
			}
			}
         // fechar arquivo
			in.close ( );
		}
		catch ( MalformedURLException k )
		{
			k.printStackTrace( );
		}
		catch ( IOException k ) 
		{
			k.printStackTrace( );
		}
      // imprimir quantidades e nome da pagina
			MyIO.println ( "a(" + a + ") " + "e(" + e + ") " +"i(" + i + ") " +"o(" + o + ") " +"u(" + u + ") " +"á(" + á + ") " +"é(" + é + ") " +"í(" + í + ") " + "ó(" + ó + ") " +"ú(" + ú + ") " +"à(" + à + ") " +"è(" + è + ") " +"ì(" + ì + ") " +"ò(" + ò + ") " + "ù(" + ù + ") " +"ã(" + ã + ") " +"õ(" + õ + ") " +"â(" + â + ") " +"ê(" + ê + ") " +"î(" + î + ") " + "ô(" + ô + ") " +"û(" + û + ") " +"consoante(" + consoantes + ") " +"<br>(" + br + ") " +"<table>(" + table + ") " + nome );
	}
	public static void main ( String [] args )
	{
      // mudar charset para utf-8
		MyIO.setCharset("UTF-8");
		String linha = MyIO.readLine( );
      // continuar executando enquanto a palavra lida nao for FIM
		while ( ! ( linha.length( ) == 3 && linha.charAt(0) == 'F' && linha.charAt(1) == 'I' && linha.charAt(2) == 'M' ) )
		{
			leitura( linha );
			linha = MyIO.readLine( );
		}
	}
}
