/**
* Exemplo0081
*
* Matricula: 628826
* Aluno: Rodrigo Padilha Fonseca
* Versao 01
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0081
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo01 ( int x )
   {
   // repetir enquanto valor maior que zero
      while ( x > 0 )
      {
      // mostrar valor
         IO.println ( "Valor = " + x );
      // passar ao próximo
         x = x - 1;
      } // fim se
   } // fim metodo01( )
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0081 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
      IO.println ( );
   // executar o metodo auxiliar
      metodo01 ( 5 );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0081