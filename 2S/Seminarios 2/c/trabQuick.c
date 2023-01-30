#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
void quick ( int num[], int esq, int dir )
{
   int i = esq, j = dir, pivo = num[(esq+dir)/2], temp;
   while ( i <= j )
   {
      while ( num[i] < pivo )
      {
         i++;
      }
      while ( num[j] > pivo )
      {
         j--;
      }
      if ( i <= j )
      {
         temp = num[i];
         num[i] = num[j];
         num[j] = temp;
         i++;
         j--;
      }
   }
   if ( esq < dir )
   {
      quick ( num, esq, j );
      quick ( num, i, dir );
   }
}
int main( )
{
   FILE* file = fopen ( "in1milhao.txt", "r");
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
   file = fopen ( "quickInicio.out", "w" );
   for ( int i = 0; i < tam; i++ )
   {
      fprintf ( file, "numeros[%d]: %d\n", i, numeros[i] );
   }
   fclose ( file );
   inicio = clock( );
   quick ( numeros, 0, tam-1 );
   fim = clock( );
   total = ( fim - inicio )*1000/CLOCKS_PER_SEC;
   printf ( "tempo do sort: %ld ms", total );
   // teste final
   file = fopen ( "quickFinal.out", "w" );
   for ( int i = 0; i < tam; i++ )
   {
      fprintf ( file, "numeros[%d]: %d\n", i, numeros[i] );
   }
   fclose ( file );
}
