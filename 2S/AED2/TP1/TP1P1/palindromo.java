// Aluno: Rodrigo Padilha
// Matricula: 628826

public class palindromo
{
// funcao para checar se e palindromo
// recebe a string que ira checar e retorna boolean
   public static boolean checar ( String s )
   {
      int tamanho = s.length();
      int j = tamanho;
      boolean resp = true;
      for ( int i = 0; i<(tamanho/2)+1; i++ ) // repetir ate chegar no meio da palavra
      {
         if ( s.charAt(i) != s.charAt(j-1) ) // comparar caracteres
         {
            resp = false;
         }
         j -= 1;
      }
      return ( resp );
   }
   public static void main ( String [] args )
   {
      String linha = MyIO.readLine( );
      // continuar executando enquanto a palavra lida nao for FIM
      while ( !( linha.length( ) == 3 && linha.charAt(0) == 'F' && linha.charAt(1) == 'I' && linha.charAt(2) == 'M' ) )
      {
         if ( checar ( linha ) )
         {
            MyIO.println ( "SIM" );
         }
         else
         {
            MyIO.println ( "NAO" );
         }
         linha = MyIO.readLine ( );
      }
   }
}
