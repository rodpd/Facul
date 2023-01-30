// Aluno: Rodrigo Padilha
// Matricula: 628826
// 7. Palindromo em C

#include <stdio.h>
#include <string.h>

int palindromo ( char str[] );

int main ( )
{
   char str[500];
   fgets ( str, 500, stdin );
   // continuar executando enquanto a palavra lida nao for FIM
   while ( ! ( strlen (str)-1 == 3 && str[0] == 'F' && str[1] == 'I' && str[2] == 'M' ) )
   {
      if ( palindromo ( str ) == 1 )
      {
         printf ( "SIM\n" );
      }
      else
      {
         printf ( "NAO\n" );
      }
      // ler proxima string
      fgets ( str, 500, stdin );
   }
   return ( 0 );
}

// funcao para checar se a frase e' palindromo
// recebe array de chars e retorna 1 se sim ou 0 se nao
int palindromo ( char str[] )
{
   int resp = 1;
   int tamanho = strlen (str)-1;
   //continuar checando enquanto nao chegar no meio da palavra
   for ( int i = 0; i < tamanho/2; i++ )
   {
   // mudar resposta para 0 se os chars forem diferentes
   // e igualar i ao tamanho para parar o loop
      if ( str[i] != str [tamanho-i-1] )
      {
         resp = 0;
         i = tamanho;
      }
   }
   return ( resp );
}
