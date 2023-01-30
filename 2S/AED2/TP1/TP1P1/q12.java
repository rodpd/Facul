// Aluno: Rodrigo Padilha
// Matricula: 628826
// 12. RECURSIVO - Palindromo

public class q12
{
// funcao para checar se e palindromo
// recebe a string que ira checar e variavel i para descobrir posicao dos chars
   public static boolean checar ( String s, int i )
   {
      boolean resp = true;
      int tamanho = s.length( );
      if ( i <= tamanho/2 )
      {
      // mudar resposta e igualar i ao tamanho para parar se chars forem diferentes
         if ( s.charAt(i) != s.charAt(tamanho-i-1) )
         {
            resp = false;
            i = tamanho;
         }
         // chamar funcao para checar com os outros chars e mudar resposta
         resp = resp && checar ( s, i+1 );
      }
      return ( resp );
   }
   public static void main ( String [] args )
   {
      String linha = MyIO.readLine( );
      // continuar executando enquanto a palavra lida nao for FIM
      while ( !( linha.length( ) == 3 && linha.charAt(0) == 'F' && linha.charAt(1) == 'I' && linha.charAt(2) == 'M' ) )
      {
         if ( checar ( linha, 0 ) )
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
