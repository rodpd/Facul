/**
* Exemplo0033
*
* Aluno: Rodrigo Padilha Fonseca
* Matricula: 628826
* @version 01
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0033
{
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
   public static void main ( String [ ] args )
   {
   // definir dados
      int x, y, z;
   // identificar
      IO.println ( "EXEMPLO0033 - Programa em Java" );
      IO.println ( "Autor: 628826-Rodrigo_P" );
   // ler valor inteiro do teclado
      x=IO.readint("Entrar com a quantidade: ");
      for(y=x;y>=1;y=y-1)
      {
         z = IO.readint ( "Entrar com um valor inteiro menor -15 ou maior que 35: " );
         if (-15>z||z>35)
         {
            IO.println("z= "+z);
         } // fim se
      } // fim repetir
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0033
// ---------------------------------------------- documentacao complementar
//
// ---------------------------------------------- historico
//
// Versao   Data     Modificacao
// 0.1      25/02    esboco
// 0.2      25/02    mudança de versão
//
// ---------------------------------------------- testes
//
// Versao   Teste
// 0.1      01. ( OK )  identificacao de programa e leitura
//                      Valores previstos: 5, 0, -5
// 0.2      01. ( OK )  mostrar todos os valores inteiros menores ou iguais a x e maiores que 0
//                      Valores previstos:
//                      com 5: Leu os valores 5, 4, 3, 2 e 1 em ordem decrescente
//                      com 0: Não leu nada
//                      com -5: Não leu nada
// 0.3      01. ( OK )  mostrar todos os valores inteiros maiores que zero e menores ou iguais a ele, em ordem crescente
//                      Valores previstos:
//                      com 5: mostrou os valores de 1 a 5 em ordem crescente
//                      com 0: Não mostrou nada
//                      com -5: Não mostrou nada
// 0.4      01. ( OK )  mesma funcao que o programa anterior, porem de forma mais compacta
//                      Valores previstos:
//                      com 5: mostrou os valores de 1 a 5 em ordem crescente
//                      com 0: Não mostrou nada
//                      com -5: Não mostrou nada
// 0.5      01. ( OK )  mostrar todos os valores inteiros maiores que zero e menores ou iguais a ele, em ordem decrescente
//                      Valores previstos:
//                      com 5: mostrou os valores de 1 a 5 em ordem decrescente
//                      com 0: Não mostrou nada
//                      com -5: Não mostrou nada
// 0.6      01. ( OK )  ler e testar o valor, mostrar se for maior que zero
//                      Valores previstos:
//                      com 5: mostrou o valor 5
//                      com 0: Não mostrou nada
//                      com -5: Não mostrou nada
// 0.7      01. ( OK )  mostrar os valores lidos que forem maiores que 0 e menores que 10
//                      Valores previstos:
//                      com 12: Não mostrou nada
//                      com 5: mostrou o valor 5
//                      com 0: Não mostrou nada
//                      com -5: Não mostrou nada
// 0.8      01. ( OK )  mostrar os valores lidos que forem menores ou iguais a 0 ou maiores ou iguais a 10
//                      Valores previstos:
//                      com 12: Mostrou o valor 12
//                      com 10: Mostrou o valor 10
//                      com 5: Não mostrou nada
//                      com 0: Mostrou o valor 0
//                      com -5: Mostrou o valor -5
// 0.9      01. ( OK )  mostrar os valores lidos que forem pares
//                      Valores testados:
//                      com -14: Mosstrou que -14 e' par
//                      com -7: Não mostrou nada
//                      com 0: Mostrou que 0 e' par
//                      com 4: Mostrou que 4 e' par
//                      com 9: Não mostrou nada
// 1.0      01. ( OK )  separar dentre os valores lidos quais sao impares e quais sao pares
//                      Valores testados:
//                      com -14: Moustrou que -14 e' par
//                      com -7: Mostrou que -7 e' impar
//                      com 0: Mostrou que 0 e' par
//                      com 4: Mostrou que 4 e' par
//                      com 9: Mostrou que 9 e' impar
// 1.1      01. ( OK )  identificar quais valores lidos sao positivos e quais sao negativos
//                      Valores testados: -5, 0 e 5
//                      com -5: Identificou que e' negativo
//                      com 0: Pediu que inserisse apenas numeros diferentes de 0
//                      com 5: Identificou que e' positivo
/*
   1.2      01. ( OK )  ler valores inseridos e mostrar apenas os que estao entre -15 e 35
                        Valores testados: -15, -14, 0, 34 e 35
                        com -15: Nada
                        -14:     z= -14
                        0:       z= 0
                        34:      z= 34
                        35:      Nada
   1.3      01. ( OK )  ler valores e mostrar apenas os que nao estao entre -15 e 35
                        valores testados: -20, -15, 0, 35 e 40
                        -20: z= -20
                        -15: Nada
                        0:   Nada
                        35:  Nada
                        40:  z= 40
*/
