// Aluno: Rodrigo Padilha
// Matricula: 628826
// 6. Is

public class q06
{
// funcao para checar se a string e composta somente por vogais
// recebe string que sera checada e retorna boolean com a resposta
   public static boolean vogais ( String s )
   {
      boolean res = true;
      int tamanho = s.length( );
      // continuar checando ate o fim ou encontrar char que nao seja vogal
      for ( int i = 0; i < tamanho && res == true; i++ )
      {
         if ( !( s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' 
         || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' 
         || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U' ) )
         {
         
            res = false;
         }
      }
      return ( res );
   }
// funcao para checar se a string e composta somente por consoantes
// recebe string que sera checada e retorna boolean com a resposta
   public static boolean consoantes ( String s )
   {
      boolean res = true;
      int tamanho = s.length( );
      // continuar checando ate o fim ou encontrar char que nao seja consoante
      for ( int i = 0; i < tamanho && res == true; i++ )
      {
         if ( ! ( ( s.charAt(i) >= 'b' && s.charAt(i) <= 'z' ) || ( s.charAt(i) >='B' && s.charAt(i) <= 'Z' ) )
         || ( s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' 
         || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U' ) )
         {
            res = false;
         }
      }
      return ( res );
   }
// funcao para checar se a string e composta somente por inteiros
// recebe string que sera checada e retorna boolean com a resposta
   public static boolean inteiro ( String s )
   {
      boolean res = true;
      int tamanho = s.length( );
      // continuar checando ate o fim ou encontrar char que nao seja inteiro
      for ( int i = 0; i < tamanho && res == true; i++ )
      {
         if ( ! ( s.charAt(i) >= '0' && s.charAt(i) <= '9' ) )
         {
            res = false;
         }
      }
      return ( res );
   }
// funcao para checar se a string e composta somente por reais
// recebe string que sera checada e retorna boolean com a resposta
   public static boolean real ( String s )
   {
      boolean res = true;
      int tamanho =  s.length( );
      int separadores = 0;
      // continuar checando ate o fim ou encontrar char que nao seja real
      for ( int i = 0; i < tamanho && res == true; i++ )
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
      }
      return ( res );
   }
   public static void main ( String [] args )
   {
      String linha = MyIO.readLine( );
      // continuar executando enquanto a palavra lida nao for FIM
      while ( ! ( linha.length( ) == 3 && linha.charAt(0) == 'F' && linha.charAt(1) == 'I' && linha.charAt(2) == 'M' ) )
      {
         if ( vogais ( linha ) )
         {
            MyIO.print ( "SIM " );
         }
         else
         {
            MyIO.print ( "NAO " );
         }
         if ( consoantes ( linha ) )
         {
            MyIO.print ( "SIM " );
         }
         else
         {
            MyIO.print ( "NAO " );
         } 
         if ( inteiro ( linha ) )
         {
            MyIO.print ( "SIM " );
         }
         else
         {
            MyIO.print ( "NAO " );
         }
         if ( real ( linha ) )
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
