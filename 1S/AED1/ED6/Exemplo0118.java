/**
 * Exemplo0118
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca
 * Versao 18
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0118
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static int metodo13 ( int x )
   {
   // definir dado
      int resposta = 0;
   // testar se contador valido
      if ( x == 1 || x == 2 )
      {
      // primeiros dois valores iguais a 1
         resposta = 1; // bases
      }
      else
      {
         if ( x > 1 )
         {
         // fazer de novo com valor absoluto
            resposta = metodo13 ( x-1 ) + metodo13 ( x-2 );
         } // fim se
      } // fim se
   // retornar resposta
      return ( resposta );
   }
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0118 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      int x;
      x=IO.readint("Quantidade: ");
      x=3*x;
      metodo13(x);
      IO.print("Fibonacci = "+metodo13(x));
      IO.println("");
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0118
/*
   Versao      Teste    
   18          1      Quantidade: 5
                      Fibonacci = 610
                      Quantidade: 7
                      Fibonacci = 10946
*/ 
