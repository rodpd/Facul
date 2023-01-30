/**
* Exemplo0022
*
* Aluno: Rodrigo Padilha Fonseca
* Matricula: 628826
* @version 01
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0022
{
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
   public static void main ( String [ ] args )
   {
   // definir dados
      int x;
   // identificar
      IO.println ( "EXEMPLO0022 - Programa em Java" );
      IO.println ( "Autor: 628826-Rodrigo_P" );
   // ler valor inteiro do teclado
      x = IO.readint ( "Entrar com um valor inteiro: " );
      while(x>0)
      {
         IO.println ( "Valor lido = " + x );
         x=x-1;
      } // fim repetir
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0022
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
//