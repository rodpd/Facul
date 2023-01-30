// Aluno: Rodrigo Padilha
// Matricula: 628826
// 14. RECURSIVO - Alteracao Aleatoria

import java.util.Random;
public class q14
{
// funcao para mudar a frase
// recebe a frase a ser alterada, o char que sera trocado, por qual char trocar e posicao
// retorna a string ja alterada
   public static String mudar ( String s, char l1, char l2, int i )
   {
      int tamanho = s.length( );
      String alterada = "";
      if ( i < tamanho )
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
         // chamar funcao com uma posicao maior
         alterada += mudar ( s, l1, l2, i+1 );
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
         MyIO.println ( mudar ( linha, l1, l2, 0 ) );
         linha = MyIO.readLine( );
      }
   }
}
