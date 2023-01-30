#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <omp.h>
void selecao ( int num[], int tam )
{
   int menor, temp;
   for ( int i = 0; i < tam-1; i++ )
   {
      menor = i;
      //schedule ( static, ( (tam-i)/omp_get_num_threads( ) ) ) reduction ( min:num[menor] )
      #pragma omp parallel for 
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
   FILE* file = fopen ( "in1milhao.txt", "r");
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
   file = fopen ( "selecaoParalelaInicio.out", "w" );
   for ( int i = 0; i < tam; i++ )
   {
      fprintf ( file, "numeros[%d]: %d\n", i, numeros[i] );
   }
   fclose ( file );
   inicio = omp_get_wtime( );
   selecao ( numeros, tam );
   fim = omp_get_wtime( );
   total = ( fim - inicio );
   printf ( "tempo do sort: %.3f s", total );
   // teste final
   file = fopen ( "selecaoParalelaFinal.out", "w" );
   for ( int i = 0; i < tam; i++ )
   {
      fprintf ( file, "numeros[%d]: %d\n", i, numeros[i] );
   }
   fclose ( file );
}
