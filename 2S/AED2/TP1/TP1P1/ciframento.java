// Aluno: Rodrigo Padilha
// Matricula: 628826

public class ciframento
{
// funcao para cifrar a palavra
// recebe string para cifrar e retorna a string cifrada
   public static String cifrar ( String s )
   {
      int tamanho = s.length( );
      String cifrada = "";
      for ( int i = 0; i < tamanho; i++ ) // percorrer string trocando as letras
      {
         cifrada = cifrada + (char) (s.charAt(i)+3);
      }
      return ( cifrada );
   }
   public static void main ( String [] args )
   {
      String linha = MyIO.readLine ( );
      // continuar executando enquanto a palavra lida nao for FIM
      while ( ! ( linha.length( ) == 3 && linha.charAt(0) == 'F' && linha.charAt(1) == 'I' && linha.charAt(2) == 'M' ) )
      {
         MyIO.println ( cifrar ( linha ) );
         linha = MyIO.readLine( );
      }
   }
}
