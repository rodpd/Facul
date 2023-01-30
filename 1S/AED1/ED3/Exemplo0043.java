/**
* Exemplo0043
*
* Matricula: 628826
* Aluno: Rodrigo Padilha Fonseca
* Version 03
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0043
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo03 ( )
   {
   // definir dados
      int x;
   // definir dado para guardar o resultado
      int quantidade = 0;
   // definir contador
      int contador;
   // identificar o metodo
      IO.println ( "Metodo 03" );
   // ler a quantidade do teclado
      quantidade = IO.readint ( "Entrar com a quantidade: " );
      contador = quantidade;
      while ( contador > 0 )
      {
      // ler valor inteiro do teclado
         x = IO.readint ( "Entrar com um valor inteiro: " );
         IO.println ( "Valor lido = " + x );
      // contar mais um valor lido
         contador = contador - 1;
      } // fim repetir
   } // fim metodo03( )
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0043 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo01 ( ); // ler e mostrar valor inteiro
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0043// -------------------------------------- documentacao complementar
//
// ---------------------------------------------- historico
//
// Versao      Data     Modificacao
// 0.1         01/03    esboco
// 0.2         01/03    
// 0.3         01/03    
// ---------------------------------------------- testes
//
// Versao      Teste
// 0.1         01. (ok)    identificacao de programa e leitura
//                         Valores previstos: -5, 0, 5
// 0.2         01. (ok)    Ler quantidade e mostrar valores inteiros
//                         Valores testados: -5, 0, 5
// 0.3         01. (ok)    