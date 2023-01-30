// Aluno: Rodrigo Padilha
// Matricula: 628826
// 5.  

import java.util.Random;
public class q05
{
   public static char resolver ( String linha )
   {
      String s, str;
      linha = mudarForma ( linha );
      MyIO.println ( "nova forma: " + linha );
      int tamanho = linha.length( );
      MyIO.println ( tamanho );
      while ( tamanho > 3 )
      {
         s = "(";
         for ( int i = 0; i < tamanho; i++ )
         {
            MyIO.println ( "i: " + i );
            MyIO.println ( "s: " + s );
            if ( linha.charAt(i) == '(' )
            {
               if ( linha.charAt(i+1) == '(' )
               {
                  s += '(';
               }
               if ( i > 0 )
               {
                  if ( linha.charAt(i-1) == '!' )
                  {
                     if ( linha.charAt(i+2) == ')' )
                     {
                        if ( linha.charAt(i+1) == 't' )
                        {
                           s += 'f';
                        }
                        else
                        {
                           s += 't';
                        }
                     }
                     else
                     {
                        s += '!';
                     }
                  }
                  else 
                  {
                  }
                  if ( linha.charAt(i+2) == '&' )
                  {
                     if ( linha.charAt(i+3) == 't' || linha.charAt(i+3) == 'f' )
                     {
                        str = "";
                        for ( int j = i+1; linha.charAt(j) != ')'; j++ )
                        {
                           str += linha.charAt(j);
                        }
                        MyIO.println ( and ( str ) );
                        s += and ( str );
                     }
                  }
                  if ( linha.charAt(i+2) == '|' )
                  {
                     str = "";
                     for ( int j = i+1; linha.charAt(j) != ')'; j++ )
                     {
                        str += linha.charAt(j);
                     }
                     s += or ( str );
                  }
               }
               else if ( i == 0 )
               {
                  if ( linha.charAt(i+2) == '&' )
                  {
                     if ( linha.charAt(i+3) == 't' || linha.charAt(i+3) == 'f' )
                     {
                        str = "";
                        for ( int j = i+1; linha.charAt(j) != ')'; j++ )
                        {
                           str += linha.charAt(j);
                        }
                        MyIO.println ( and ( str ) );
                        s += and ( str );
                     }
                  }
                  else if ( linha.charAt(i+2) == '|' )
                  {
                     str = "";
                     for ( int j = i+1; linha.charAt(j) != ')'; j++ )
                     {
                        str += linha.charAt(j);
                     }
                     s += or ( str );
                  }
               }
            }
            else 
            {
               if ( linha.charAt(i) == '&' )
               {
                  if ( ! ( ( linha.charAt(i-1) == 't' || linha.charAt(i-1) == 'f' ) && ( linha.charAt(i+1) == 't' || linha.charAt(i+1) == 'f' ) ) )
                  {
                     s += '&';
                  }
               }
               else if ( linha.charAt(i) == '|' )
               {
                  if ( ! ( ( linha.charAt(i-1) == 't' || linha.charAt(i-1) == 'f' ) && ( linha.charAt(i+1) == 't' || linha.charAt(i+1) == 'f' ) ) )
                  {
                     s += '|';
                  }
               }
               else if ( linha.charAt(i) == '!' )
               {
                  if ( linha.charAt(i+1) != '(' && ( linha.charAt(i+1) != 'f' && linha.charAt(i+1) != 't'  ) )
                  {
                     s += '!';
                     MyIO.println(s);
                  }
               }
               else if ( linha.charAt(i) == ')' )
               {
                  if ( linha.charAt(i-1) == ')' )
                  {
                     s += ')';
                  }
               }
               if ( i > 2 && i < tamanho-3 )
               {
                  if ( linha.charAt(i) == 't' )
                  {
                     if ( ! ( linha.charAt(i+2) == 't' || linha.charAt(i-2) == 't' || linha.charAt(i+2) == 'f' || linha.charAt(i-2) == 'f' ) )
                     {
                        s += 't';
                     }
                  }
                  else if ( linha.charAt(i) == 'f' )
                  {
                     if ( ! ( linha.charAt(i+2) == 'f' || linha.charAt(i-2) == 'f' || linha.charAt(i+2) == 't' || linha.charAt(i-2) == 't' ) )
                     {
                        s += 'f';
                     }
                  }
               }
               else if ( i < 2 )
               {
                  if ( linha.charAt(i) == 't' )
                  {
                     if ( ! ( linha.charAt(i+2) == 't' || linha.charAt(i+2) == 'f') )
                     {
                        s += 't';
                     }
                  }
                  else if ( linha.charAt(i) == 'f' )
                  {
                     if ( ! ( linha.charAt(i+2) == 'f' || linha.charAt(i+2) == 't') )
                     {
                        s += 'f';
                     }
                  }
               }
               else if ( i > tamanho-3 )
               {
                  if ( linha.charAt(i) == 't' )
                  {
                     if ( ! ( linha.charAt(i-2) == 't' || linha.charAt(i-2) == 'f') )
                     {
                        s += 't';
                     }
                  }
                  else if ( linha.charAt(i) == 'f' )
                  {
                     if ( ! ( linha.charAt(i-2) == 'f' || linha.charAt(i-2) == 't') )
                     {
                        s += 'f';
                     }
                  }
               }
            }
         }           
        // s += ')';
         linha = s;
         tamanho = linha.length( );
         MyIO.println ( "linha: " + linha );
      }
      return ( linha.charAt(1) );
   }
   public static char and (String s )
   {
      char res = 't';
      int tamanho = s.length( );
      for ( int i = 0; i < tamanho; i+=2 )
      {
         if ( s.charAt(i) == 'f' )
         {
            res = 'f';
            i = tamanho;
         }
      }
      return ( res );
   }
   public static char or ( String s )
   {
      char res = 'f';
      int tamanho = s.length( );
      for ( int i = 0; i < tamanho; i+=2 )
      {
         if ( s.charAt(i) == 't' )
         {
            res = 't';
            i = tamanho;
         }
      }
      return ( res );
   }
   public static String mudarForma ( String s )
   {
      int tamanho = s.length( );
      String nova = "";
      int qnt = s.charAt(0)-48;
      int [] bools = new int [qnt];
      for ( int i = 0; i < qnt; i++ )
      {
         bools[i] = s.charAt( (i+1)*2 ) -48 ;
      }
      for ( int i = 2*qnt+2; i < tamanho; i++ )
      {
         if ( s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' )
         {
            if ( bools[(int) (s.charAt(i)-65)] == 0 )
            {
               s = mudarNaPosicao ( s, i, 'f' );
            }
            else
            {
               s = mudarNaPosicao ( s, i, 't');
            }
         }
         if ( s.charAt(i) == '(' )
         {
            if ( s.charAt(i-1) == 't' )
            {
               s = mudarNaPosicao ( s, i-1, '!' );
            }
            else
            {
               int abertos = 1;
               int fechados = 0;
               for ( int j = i+1; abertos != fechados; j++ )
               {
                  if ( s.charAt(j) == '(' )
                  {	
                     abertos += 1;
                  }
                  else if ( s.charAt(j) == ')' )
                  {
                     fechados += 1;
                  }
                  else if ( s.charAt(j) == ',' || s.charAt(j) == '&' || s.charAt(j) == '|' )
                  {
                     if ( s.charAt(i-1) == 'r' )
                     {
                        s = mudarNaPosicao ( s, j, '|' );
                     }
                     else if ( s.charAt(i-1) == 'd' )
                     {
                        s = mudarNaPosicao ( s, j, '&' );
                     }
                  }
               }
            }
         }
      }
      for ( int i = qnt*2+2; i < tamanho; i++ )
      {
         if ( s.charAt(i) == '(' )
         {
            nova += "(";
         }
         else if ( s.charAt(i) == ')' )
         {
            nova += ")";
         }
         else if ( s.charAt(i) == '!' )
         {
            nova += "!";
         }
         else if ( s.charAt(i) == '&' )
         {
            nova += "&";
         }
         else if ( s.charAt(i) == '|' )
         {
            nova += "|";
         }
         else if ( s.charAt(i) == 't' )
         {
            nova += "t";
         }
         else if ( s.charAt(i) == 'f' )
         {
            nova += "f";
         }
      }
      return ( nova );
   }
   public static String mudarNaPosicao ( String s, int posicao, char c )
   {
      int tamanho = s.length( );
      String nova = "";
      for ( int i = 0; i < tamanho; i++ )
      {
         if ( i == posicao )
         {
            nova += c;
         }
         else
         {
            nova += s.charAt(i);
         }
      }
      return ( nova );
   }
   public static void main ( String [] args )
   {
      String linha = MyIO.readLine ( );
      while ( ! ( linha.length( ) == 1 && linha.charAt(0) == '0' ) )
      {
      //MyIO.println ( linha );
      //MyIO.println ( mudarForma ( linha ) );
         if ( resolver ( linha ) == 't' )
         {
            MyIO.println ( "1" );
         }
         else
         {
            MyIO.println ( "0" );
         }
         linha = MyIO.readLine( );
      } 
      linha = MyIO.readLine( );
   }
}