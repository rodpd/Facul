#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <omp.h>
void merge ( int numeros[], int inicio, int fim, int a )
{
   int i, j, k, meio, *temp;
   if( inicio != fim )
   {
      meio = ( inicio + fim ) / 2;
      if ( fim - inicio < a )
      {
         merge ( numeros, inicio, meio, a );
         merge ( numeros, meio + 1, fim, a );
      }
      else
      {
      #pragma omp parallel sections
         {
         #pragma omp section
            merge ( numeros, inicio, meio, a );
         #pragma omp section
            merge ( numeros, meio + 1, fim, a );
         }
      }
      i = inicio;
      j = meio + 1;
      k = 0;
      temp = ( int* ) malloc ( sizeof(int) * ( fim - inicio + 1 ) );
      while ( i < meio + 1 || j < fim + 1 )
      {
         if (i == meio + 1 )
         { 
            temp[k] = numeros[j];
            j++;
            k++;
         }
         else
         {
            if (j == fim + 1)
            {
               temp[k] = numeros[i];
               i++;
               k++;
            }
            else
            {
               if ( numeros[i] < numeros[j])
               {
                  temp[k] = numeros[i];
                  i++;
                  k++;
               }
               else
               {
                  temp[k] = numeros[j];
                  j++;
                  k++;
               }
            }
         }
      }
      for( i = inicio; i <= fim; i++ )
      {
         numeros[i] = temp[i-inicio];
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
   file = fopen ( "mergeParaleloInicio.out", "w" );
   for ( int i = 0; i < tam; i++ )
   {
      fprintf ( file, "numeros[%d]: %d\n", i, numeros[i] );
   }
   fclose ( file );
   int a = tam/4;
   omp_set_nested(1);
   omp_set_num_threads(2);
   inicio = omp_get_wtime( );
   merge ( numeros, 0, tam-1, a );
   fim = omp_get_wtime( );
   total = ( fim - inicio );
   printf ( "tempo do sort: %.3f s", total );
   // teste final
   file = fopen ( "mergeParaleloFinal.out", "w" );
   for ( int i = 0; i < tam; i++ )
   {
      fprintf ( file, "numeros[%d]: %d\n", i, numeros[i] );
   }
   fclose ( file );
}
