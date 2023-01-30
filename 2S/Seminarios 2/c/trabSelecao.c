#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
void selecao ( int num[], int tam )
{
   int menor, temp;
   for ( int i = 0; i < tam-1; i++ )
   {
      menor = i;
      for ( int j = i+1; j < tam; j++ )
      {
         if ( num[menor] > num[j] )
         {
            menor = j;
         }
      }
      temp = num[menor];
      num[menor] = num[i];
      num[i] = temp;
   }
}
int main()
{
   FILE* file = fopen ("in10k.txt", "r");
   int numeros [1000000];
   int tam;
   clock_t inicio, fim, total;
   for ( tam = 0; feof(file) == 0; tam++ )
   {
      fscanf (file, "%d", &numeros[tam] );
   }
   tam--;
   fclose ( file );
   // teste inicio
   file = fopen ( "selecaoInicio.out", "w" );
   for ( int i = 0; i < tam; i++ )
   {
      fprintf ( file, "numeros[%d]: %d\n", i, numeros[i] );
   }
   fclose ( file );
   inicio = clock( );
   selecao ( numeros, tam );
   fim = clock( );
   total = ( fim - inicio )*1000/CLOCKS_PER_SEC;
   printf ( "tempo do sort: %ld ms", total );
   // teste final
   file = fopen ( "selecaoFinal.out", "w" );
   for ( int i = 0; i < tam; i++ )
   {
      fprintf ( file, "numeros[%d]: %d\n", i, numeros[i] );
   }
   fclose ( file );
}
