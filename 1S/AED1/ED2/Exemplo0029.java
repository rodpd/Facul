/**
* Exemplo0029
*
* Aluno: Rodrigo Padilha Fonseca
* Matricula: 628826
* @version 01
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0029
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
      IO.println ( "EXEMPLO0029 - Programa em Java" );
      IO.println ( "Autor: 628826-Rodrigo_P" );
   // ler valor inteiro do teclado
      x=IO.readint("Entrar com a quantidade: ");
      for(y=x;y>=1;y=y-1)
      {
         z = IO.readint ( "Entrar com um valor inteiro: " );
         if(z%2==0)
         {
            IO.println("par: "+z);
         } // fim se
      } // fim repetir
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0029
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
//                      com -14: Moustrou que -14 é par
//                      com -7: Não mostrou nada
//                      com 0: Mostrou que 0 é par
//                      com 4: Mostrou que 4 é par
//                      com 9: Não mostrou nada
