/**
* Exemplo0089
*
* Matricula: 628826
* Aluno: Rodrigo Padilha Fonseca
* Versao 09
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0089
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
   public static void metodo02 ( int x )
   {
   // definir dado local
      int y = x;
   // repetir enquanto valor maior que zero
      while ( y > 0 )
      {
      // mostrar valor
         IO.println ( "Valor = " + y );
      // passar ao próximo
         y = y - 1;
      } // fim se
   } // fim metodo02( )
   public static void metodo03 ( int x )
   {
   // definir dado local
      int y;
   // repetir enquanto valor maior que zero
      for ( y = x; y > 0; y = y - 1 )
      {
      // mostrar valor
         IO.println ( "Valor = " + y );
      } // fim se
   } // fim metodo03( )
   public static void metodo04 ( int x )
   {
   // definir dado local
      int y;
   // repetir enquanto valor maior que zero
      for ( y = 1; y <= x; y = y + 1 )
      {
      // mostrar valor
         IO.println ( "Valor = " + y );
      } // fim se
   } // fim metodo04( )
   public static void metodo05 ( int x )
   {
   // definir dado local
      int y;
      int z = 1;
   // repetir enquanto valor maior que zero
      for ( y = 1; y <= x; y = y + 1 )
      {
      // mostrar valor
         IO.println ( "Valor = " + z );
      // passar ao proximo
         z = z + 2;
      } // fim se
   } // fim metodo05( )
   public static void metodo06 ( int x )
   {
   // definir dado local
      int y;
      int z = 1;
   // repetir enquanto valor maior que zero
      IO.println ( "Valor = " + z );
      z = 2;
      for ( y = 1; y < x; y = y + 1 )
      {
      // mostrar valor
         IO.println ( "Valor = " + z );
      // passar ao proximo
         z = z + 2;
      } // fim se
   } // fim metodo06( )
   public static void metodo07 ( int x )
   {
   // definir dado local
      int y;
      int z;
   // repetir enquanto valor maior que zero
      IO.println ( "Valor = 1/1" );
      z = 3;
      for ( y = 2; y <= x; y = y + 1 )
      {
      // mostrar valor
         IO.println ( "Valor = " + (z-1) + "/" + z );
      // passar ao proximo
         z = z + 2;
      } // fim se
   } // fim metodo07( )
   public static void metodo08 ( int x )
   {
   // definir dado local
      int y;
      int z;
      double soma = 1.0;
   // repetir enquanto valor maior que zero
      IO.println ( "Valor = 1/1" );
      z = 3;
      for ( y = 2; y <= x; y = y + 1 )
      {
      // mostrar valor
         IO.println ( "Valor = " + (z-1) + "/" + z );
      // somar uma parcela
         soma = soma + 1.0 * (z-1) / z;
      // passar ao proximo
         z = z + 2;
      } // fim se
   // mostrar o resultado
      IO.println ( "Soma = " + soma );
   } // fim metodo08( )
   public static double metodo09 ( int x )
   {
   // definir dado local
      int y;
      int z;
      double soma = 1.0;
   // repetir enquanto valor maior que zero
      IO.println ( "Valor = 1/1" );
      z = 3;
      for ( y = 1; y < x; y = y + 1 )
      {
      // mostrar valor
         IO.println ( "Valor = " + (z-1) + "/" + z );
      // somar uma parcela
         soma = soma + 1.0 * (z-1) / z;
      // passar ao proximo
         z = z + 2;
      } // fim se
   // retornar a resposta
      return ( soma );
   } // fim metodo09( )
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0089 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
      IO.println ( );
   // executar o metodo auxiliar
      metodo09 ( 5 );
      // mostrar o resultado
      IO.println ( "Soma = " + metodo09 ( 5 ) );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0089