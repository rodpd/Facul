public class dd
{
	public static boolean checar ( String s )
	{
		int tamanho = s.length();
		int j = tamanho;
		boolean resp = true;
		for ( int i = 0; i<(tamanho/2)+1; i++ )
		{
			if ( s.charAt(i) != s.charAt(j-1) )
			{
				resp = false;
			}
			j -= 1;
		}
		if ( resp == false )
		{
			return ( true );
		}
		else
		{
			return ( false );
		}
	}
	public static void main ( String [] args )
	{
		String linha = MyIO.readLine( );
		int i = 1;
      /*MyIO.println ( linha.length( ) );
      MyIO.println ( linha.charAt(0) );
      MyIO.println ( linha.charAt(1) );
      MyIO.println ( linha.charAt(2) );
      MyIO.println ( linha.length( ) != 3 && linha.charAt(0) != 'F' && linha.charAt(1) != 'I' && linha.charAt(2) != 'M' ); */
      while ( linha.length( ) != 3 || linha.charAt(0) != 'F' && linha.charAt(1) != 'I' && linha.charAt(2) != 'M' )
		{
      MyIO.print ( i + ": " );
		if ( checar ( linha ) )
		{
			MyIO.println ( "SIM" );
		}
		else
		{
			MyIO.println ( "NAO" );
		}
      i += 1;
		linha = MyIO.readLine ( );
		}
	}
}
