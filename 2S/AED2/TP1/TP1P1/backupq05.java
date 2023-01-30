import java.util.Random;
public class q05
{
	public static boolean resolver ( String s )
	{
		boolean resposta;
		int qnt = s.charAt(0);
		int tamanho = s.length( );
		String fim = "";
		int t = s.charAt(0)-48;	
		int [] bools = new int [t];
		for ( int i = 0; i < t; i++ )
		{
			bools[i] = s.charAt( (i+1)*2 ) -48 ;
		}
		for ( int i = 2*qnt+2; i < tamanho; i++ )
		{
			if ( s.charAt(i) == 'a' )
			{
				fim += "&&";
			}
			else if ( s.charAt(i) == 'o' && s.charAt(i+1) == 'r' )
			{
				fim += "||";
			}
			else if ( s.charAt(i) == 'n' )
			{
				fim += "!";
			}
			else if ( s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' )
			{
				if ( bools[(char) ( (int) s.charAt(i)-17 )] == '0' )
				{
					fim += "false";
				}
				else
				{
					fim += "true";
				}
			}
			else if ( s.charAt(i) == '(' )
			{
				fim += "(";
			}
			else if ( s.charAt(i) == ')' )
			{
				fim += ")";
			}
		}
		resposta = Boolean.getBoolean ( fim );
		return ( resposta );
	}
	public static String mudarNaPosicao ( String s, int posicao, char c )
	{
		int tamanho = s.length( );
		String nova = "";
		for ( int i = 0; i < tamanho; i++ )
			
	public static void main ( String [] args )
	{
		String linha = MyIO.readLine ( );
		while ( ! ( linha.length( ) == 1 && linha.charAt(0) == '0' ) )
		{
			if ( resolver ( linha ) )
			{
				MyIO.println ( "1" );
			}
			else
			{
				MyIO.println ( "0" );
			}
			linha = MyIO.readLine( );
		}
	}
}
