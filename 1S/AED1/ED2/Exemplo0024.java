/**
* Exemplo0024
*
* Aluno: Rodrigo Padilha Fonseca
* Matricula: 628826
* @version 01
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0024
{
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
   public static void main ( String [ ] args )
   {
   // definir dados
      int x;
      int y;
   // identificar
      IO.println ( "EXEMPLO0024 - Programa em Java" );
      IO.println ( "Autor: 628826-Rodrigo_P" );
   // ler valor inteiro do teclado
      x = IO.readint ( "Entrar com um valor inteiro: " );
      for(y=1;y<=x;y=y+1)
      {
         IO.println(""+y);
      } // fim repetir
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0024
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
//