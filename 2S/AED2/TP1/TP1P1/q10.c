// Aluno: Rodrigo Padilha
// Matricula: 628826
// 10. Arquivo em C

#include <stdio.h>

int main ( )
{
   // ler do input e gravar no arquivo
   FILE *arq;
   arq = fopen ( "q10.out", "wb" );
   int qnt;
   scanf ( "%d", &qnt );
   double num;
   for ( int i = 0; i < qnt; i++ )
   {
      scanf ( "%lf", &num );
      fwrite ( &num, sizeof(double), 1, arq );
   }
   fclose(arq);
   arq = fopen ( "q10.out", "rb" );
   for ( int i = 1; i <= qnt; i++ )
   {
      // leitura do arquivo comecando no fim e diminuindo em funcao de i
      fseek ( arq, -sizeof(double)*i, 2 );
      fread ( &num, sizeof(double), 1, arq );
      // imprimir com no maximo 6 casas
      printf ("%.6g\n", num );
   }
   fclose(arq);
}