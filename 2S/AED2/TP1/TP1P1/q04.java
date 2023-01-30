// Aluno: Rodrigo Padilha
// Matricula: 628826
// 4. Alteracao aleatoria

import java.util.Random;
public class q04
{
// funcao para mudar a frase
// recebe a frase a ser alterada, o char que sera trocado e por qual ira trocar
// retorna a string ja alterada
   public static String mudar ( String s, char l1, char l2 )
   {
      int tamanho = s.length( );
      String alterada = "";
      for ( int i = 0; i < tamanho; i++ )
      {
         // alterar char para l2 se for igual a l1
         if ( s.charAt(i) == l1 )
         {
            alterada = alterada + l2;
         }
         else
         {
            alterada = alterada + s.charAt(i);
         }
      }
      return ( alterada );
   }
   public static void main ( String [] args )
   {
      String linha = MyIO.readLine( );
      char l1, l2;
      Random gerador = new Random (4);
      // continuar executando enquanto a palavra lida nao for FIM
      while ( !(linha.length( ) == 3 && linha.charAt(0) == 'F' && linha.charAt(1) == 'I' && linha.charAt(2) == 'M' ) )
      {
      // mudar quais chars serao trocados
         l1 = (char) ('a' + ( Math.abs ( gerador.nextInt( ) ) % 26 ) );
         l2 = (char) ('a' + ( Math.abs ( gerador.nextInt( ) ) % 26 ) );
         MyIO.println ( mudar ( linha, l1, l2) );
         linha = MyIO.readLine( );
      }
   }
}
