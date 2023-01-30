// Aluno: Rodrigo Padilha
// Matricula: 628826
// 11. RECURSIVO - Aquecimento

public class q11
{
// funcao para contar quantidade de maiusculas
// recebe string que sera percorrida e ate qual char ira testar
   public static int maiusculas ( String s, int n )
   {
      int quantidade = 0;
      // parar se tamanho for menor que 0
      if ( n >= 0 )
      {	
         if ( s.charAt(n) >= 'A' && s.charAt(n) <= 'Z' )
         {
            quantidade += 1;
         }
      // chamar funcao novamente para checar char anterior
         quantidade += maiusculas ( s, n-1 );
      }
      return ( quantidade );
   }
   public static void main ( String [] args )
   {
      String linha = MyIO.readLine ( );
      int tamanho;
      // continuar executando enquanto a palavra lida nao for FIM
      while ( ! ( linha.length( ) == 3 && linha.charAt(0) == 'F' && linha.charAt(1) == 'I' && linha.charAt(2) == 'M' ) )
      {
         tamanho = linha.length( );
         MyIO.println ( maiusculas ( linha, tamanho-1 ) );
         linha = MyIO.readLine ( );	
      }
   }
}
