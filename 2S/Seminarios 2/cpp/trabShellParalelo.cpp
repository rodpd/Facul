#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <omp.h>
void shell( int num[], int tam )
{
   int espaco = 1;
   do 
   {
      espaco = (espaco * 3) + 1;
   } while (espaco < tam);
   do 
   {
      espaco /= 3;
      #pragma omp parallel for
      for( int bloco = 0; bloco < espaco; bloco++ )
      {
         {
            for (int i = ( espaco + bloco ); i < tam; i += espaco )
            {
               int tmp = num[i];
               int j = i - espaco;
               while ( ( j >= 0 ) && ( num[j] > tmp ) )
               {
                  num[j + espaco] = num[j];
                  j -= espaco;
               }
               num[j + espaco] = tmp;
            }
         }
      }
   } while (espaco != 1);
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
   file = fopen ( "shellParaleloInicio.out", "w" );
   for ( int i = 0; i < tam; i++ )
   {
      fprintf ( file, "numeros[%d]: %d\n", i, numeros[i] );
   }
   fclose ( file );
   inicio = omp_get_wtime( );
   shell ( numeros, tam );
   fim = omp_get_wtime( );
   total = ( fim - inicio );
   printf ( "tempo do sort: %.3f s", total );
   // teste final
   file = fopen ( "shellParaleloFinal.out", "w" );
   for ( int i = 0; i < tam; i++ )
   {
      fprintf ( file, "numeros[%d]: %d\n", i, numeros[i] );
   }
   fclose ( file );
}
