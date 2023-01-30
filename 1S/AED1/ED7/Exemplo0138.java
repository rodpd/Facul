/**
 * Exemplo0138
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca
 * Versao 18
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0138
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static int fibonacci ( int x )
   {
      int resposta = 0;
      if ( x == 1 || x == 2 )
      {
         resposta = 1;
      }
      else
      {
         if ( x > 1 )
         {
            resposta = fibonacci ( x-1 ) + fibonacci ( x-2 );
         }
      } 
      return ( resposta );
   }
   public static void metodo18 ( )
   {
      FILE arquivo;
      int x=IO.readint("Quantidade: ")*3;
      int z=1;
      arquivo = new FILE ( FILE.OUTPUT, "Exemplo0138.TXT" );
      while (x>=z)
      {
         arquivo.println(""+fibonacci(z));
         z=z+1;
      }
      fibonacci(x);
      arquivo.println("Fibonacci = "+ fibonacci(x));   
      arquivo.close( );
   } 
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0138 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo18 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0138
/*
   Teste          Versao
   1              18       Quantidade: 5
                           Exemplo0138.TXT
                           1
                           1
                           2
                           3
                           5
                           8
                           13
                           21
                           34
                           55
                           89
                           144
                           233
                           377
                           610
   2                       Fibonacci = 610
                           Quantidade: 3
                           Exemplo0138.TXT:
                           1
                           1
                           2
                           3
                           5
                           8
                           13
                           21
                           34
                           Fibonacci = 34
*/