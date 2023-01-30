// Aluno: Rodrigo Padilha
// Matricula: 628826
// 17. RECURSIVO - Palindromo em C

#include <stdio.h>
#include <string.h>

int palindromo ( char str[], int resp, int tamanho, int i );

int main ( )
{
   char str[500];
   fgets ( str, 500, stdin );
   int tamanho = strlen (str)-1;
   // continuar executando enquanto a palavra lida nao for FIM
   while ( ! ( strlen (str)-1 == 3 && str[0] == 'F' && str[1] == 'I' && str[2] == 'M' ) )
   {
      if ( palindromo ( str, 1, tamanho, 0 ) == 1 )
      {
         printf ( "SIM\n" );
      }
      else
      {
         printf ( "NAO\n" );
      }
      fgets ( str, 500, stdin );
      tamanho = strlen (str)-1;
   }
   return ( 0 );
}

int palindromo ( char str[], int resp, int tamanho, int i )
{
   // repetir ate chegar no meio da palavra e enquanto a resposta for 1
   if ( resp == 1 && i < ( tamanho ) / 2 )
   {
      // mudar resp se forem diferentes
      if ( str[i] != str [tamanho-i-1] )
      {
         resp = 0;
      }
      // chamar metodo novamente se os chars forem iguais
      else
      {
         resp = palindromo ( str, resp, tamanho, i+1 );
      }
   }
   return ( resp );
}
