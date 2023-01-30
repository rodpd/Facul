#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <omp.h>
void quick ( int num[], int esq, int dir, int a )
{
   if ( esq < dir )
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
      if ( dir - esq < a )
      {
         quick ( num, esq, j, a );
         quick ( num, i, dir, a );
      }
      else
      {
      #pragma omp parallel sections
         {
         #pragma omp section
            quick ( num, esq, j, a );
         #pragma omp section
            quick ( num, i, dir, a );
         }
      }
   }
}
int main( )
{
   FILE* file = fopen ("in1milhao.txt", "r");
   int numeros [1000000];
   int tam;
   double inicio, fim, total;
   for ( tam = 0; feof(file) == 0; tam++ )
   {
      fscanf (file, "%d", &numeros[tam] );
   }
   tam--;
   fclose ( file );
   // teste inicio
   file = fopen ( "quickParaleloInicio.out", "w" );
   for ( int i = 0; i < tam; i++ )
   {
      fprintf ( file, "numeros[%d]: %d\n", i, numeros[i] );
   }
   fclose ( file );
   int a = tam/2;
   omp_set_nested(1);
   omp_set_num_threads(2);
   inicio = omp_get_wtime( );
   quick ( numeros, 0, tam-1, a );
   fim = omp_get_wtime( );
   total = ( fim - inicio );
   printf ( "tempo do sort: %.3f s", total );
   // teste final
   file = fopen ( "quickParaleloFinal.out", "w" );
   for ( int i = 0; i < tam; i++ )
   {
      fprintf ( file, "numeros[%d]: %d\n", i, numeros[i] );
   }
   fclose ( file );
}