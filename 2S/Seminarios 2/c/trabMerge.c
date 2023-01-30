#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
void merge ( int numeros[], int inicio, int fim )
{
   int i, j, k, meio, *temp;
   if( inicio == fim )
      return;
   meio = ( inicio + fim ) / 2;
   merge ( numeros, inicio, meio );
   merge ( numeros, meio + 1, fim );
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
int main( )
{
   FILE* file = fopen ("in1milhao.txt", "r");
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
   file = fopen ( "mergeInicio.out", "w" );
   for ( int i = 0; i < tam; i++ )
   {
      fprintf ( file, "numeros[%d]: %d\n", i, numeros[i] );
   }
   fclose ( file );
   inicio = clock( );
   merge ( numeros, 0, tam-1 );
   fim = clock( );
   total = ( fim - inicio )*1000/CLOCKS_PER_SEC;
   printf ( "tempo do sort: %ld ms", total );
   // teste final
   file = fopen ( "mergeFinal.out", "w" );
   for ( int i = 0; i < tam; i++ )
   {
      fprintf ( file, "numeros[%d]: %d\n", i, numeros[i] );
   }
   fclose ( file );
}
