#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
void shell( int num[], int tam )
{
   int h = 1;
   do 
   {
      h = (h * 3) + 1;
   } while (h < tam);
   do 
   {
      h /= 3;
      for( int espaco = 0; espaco < h; espaco++ )
      {
         {
            for (int i = ( h + espaco ); i < tam; i += h )
            {
               int tmp = num[i];
               int j = i - h;
               while ( ( j >= 0 ) && ( num[j] > tmp ) )
               {
                  num[j + h] = num[j];
                  j -= h;
               }
               num[j + h] = tmp;
            }
         }
      }
   } while (h != 1);
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
   file = fopen ( "shellInicio.out", "w" );
   for ( int i = 0; i < tam; i++ )
   {
      fprintf ( file, "numeros[%d]: %d\n", i, numeros[i] );
   }
   fclose ( file );
   inicio = clock( );
   shell ( numeros, tam );
   fim = clock( );
   total = ( fim - inicio )*1000/CLOCKS_PER_SEC;
   printf ( "tempo do sort: %ld ms", total );
   // teste final
   file = fopen ( "shellFinal.out", "w" );
   for ( int i = 0; i < tam; i++ )
   {
      fprintf ( file, "numeros[%d]: %d\n", i, numeros[i] );
   }
   fclose ( file );
   return 0;
}
