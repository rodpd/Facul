// Aluno: Rodrigo Padilha
// Matricula: 628826
// 16. RECURSIVO - Is

public class q16
{
// funcao para checar se a string e composta somente por vogais
// recebe string que sera checada e posicao e retorna boolean com a resposta
   public static boolean vogais ( String s, int i )
   {
      boolean res = true;
      int tamanho = s.length( );
      // continuar checando ate o fim da string
      if ( i < tamanho )
      {
         if ( !( s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' 
         || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' 
         || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U' ) )
         {
            res = false;
         }
         // chamar metodo novamente com posicao maior se resposta ainda for true
         if ( res == true )
         {
            res = res && vogais ( s, i+1 );
         }
      }
      return ( res );
   }
// funcao para checar se a string e composta somente por consoantes
// recebe string que sera checada e posicao e retorna boolean com a resposta
   public static boolean consoantes ( String s, int i )
   {
      boolean res = true;
      int tamanho = s.length( );
      // continuar checando ate o fim da string
      if ( i < tamanho )
      {
         if ( ! ( ( s.charAt(i) >= 'b' && s.charAt(i) <= 'z' ) || ( s.charAt(i) >='B' && s.charAt(i) <= 'Z' ) )
         || ( s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' 
         || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U' ) )
         {
            res = false;
         }
         // chamar metodo novamente com posicao maior se resposta ainda for true
         if ( res == true )
         {
            res = res && consoantes ( s, i+1 );
         }
      }
      return ( res );
   }
// funcao para checar se composta somente por inteiros
   public static boolean inteiro ( String s, int i )
   {
      boolean res = true;
      int tamanho = s.length( );
      if ( i < tamanho )
      {
         if ( ! ( s.charAt(i) >= '0' && s.charAt(i) <= '9' ) )
         {
            res = false;
         }
         if ( res == true )
         {
            res = res && inteiro ( s, i+1 );
         }
      }
      return ( res );
   }
// funcao para checar se composta somente por reais
// recebe string, posicao e quantidade de pontos ou virgulas
   public static boolean real ( String s, int i, int separadores )
   {
      boolean res = true;
      int tamanho =  s.length( );
      if ( i < tamanho )
      {
         if ( ! ( s.charAt(i) >= '0' && s.charAt(i) <= '9' ) )
         {
            // checar se se a quantidade de pontos ou virgulas e maior que 1 
            if ( s.charAt(i) == '.' || s.charAt(i) == ',' )
            {
               if ( separadores == 1 )
               {
                  res = false;
               }
               else
               {
                  separadores += 1;
               }
            }
            else
            {
               res = false;
            }
         }
         if ( res == true )
         {
            res = res && real ( s, i+1, separadores );
         }
      }
      return ( res );
   }
   public static void main ( String [] args )
   {
      String linha = MyIO.readLine( );
      // continuar executando enquanto a palavra lida nao for FIM
      while ( ! ( linha.length( ) == 3 && linha.charAt(0) == 'F' && linha.charAt(1) == 'I' && linha.charAt(2) == 'M' ) )
      {
         if ( vogais ( linha, 0 ) )
         {
            MyIO.print ( "SIM " );
         }
         else
         {
            MyIO.print ( "NAO " );
         }
         if ( consoantes ( linha, 0 ) )
         {
            MyIO.print ( "SIM " );
         }
         else
         {
            MyIO.print ( "NAO " );
         } 
         if ( inteiro ( linha, 0 ) )
         {
            MyIO.print ( "SIM " );
         }
         else
         {
            MyIO.print ( "NAO " );
         }
         if ( real ( linha, 0, 0 ) )
         {
            MyIO.println ( "SIM" );
         }
         else
         {
            MyIO.println ( "NAO" );
         }
         linha = MyIO.readLine( );
      }
   }
}
