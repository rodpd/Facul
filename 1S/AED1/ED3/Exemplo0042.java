/**
* Exemplo0042
*
* Matricula: 628826
* Aluno: Rodrigo Padilha Fonseca
* Version 02
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0042
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo02 ( )
   {
   // definir dados
      int x;
   // definir dado para guardar o resultado
      int quantidade = 0;
   // identificar o metodo
      IO.println ( "Metodo 02" );
   // ler valor inteiro do teclado
      quantidade = IO.readint ( "Entrar com a quantidade: " );
      while ( quantidade > 0 )
      {
      // ler valor inteiro do teclado
         x = IO.readint ( "Entrar com um valor inteiro: " );
         IO.println ( "Valor lido = " + x );
      // diminuir a quantidade
         quantidade = quantidade - 1;
      } // fim repetir
   } // fim metodo02( )
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0042 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo01 ( ); // ler e mostrar valor inteiro
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0042// ---------------------------------------------- documentacao complementar
//
// ---------------------------------------------- historico
//
// Versao      Data     Modificacao
// 0.1         01/03    esboco
// 0,2         01/03    
// ---------------------------------------------- testes
//
// Versao      Teste
// 0.1         01. (ok)    identificacao de programa e leitura
//                         Valores previstos: -5, 0, 5
// 0.2         01. (ok)    Ler quantidade e mostrar valores inteiros
//                         Valores testados: -5, 0, 5