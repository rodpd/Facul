// Aluno: Rodrigo Padilha
// Matricula: 628826
// 13. RECURSIVO - Ciframento de Cesar

public class q13
{
// metodo para cifrar frase lida
// recebe a frase e posicao do char
   public static String cifrar ( String s, int i )
   {
      int tamanho = s.length( );
      String cifrada = "";
      if ( i < tamanho )
      {
      // popular nova string com char atual e chamar funcao novamente para adicionar os proximos chars
         cifrada = cifrada + (char) (s.charAt(i)+3) + cifrar ( s, i+1 );
      }
      return ( cifrada );
   }
   public static void main ( String [] args )
   {
      String linha = MyIO.readLine ( );
   // continuar executando enquanto a palavra lida nao for FIM
      while ( ! ( linha.length( ) == 3 && linha.charAt(0) == 'F' && linha.charAt(1) == 'I' && linha.charAt(2) == 'M' ) )
      {
         MyIO.println ( cifrar ( linha, 0 ) );
         linha = MyIO.readLine( );
      }
   }
}
