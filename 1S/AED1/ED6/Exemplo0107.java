/**
 * Exemplo0107
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca
 * Versao 07
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0107
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo01 ( int x )
   {
   // testar se valor positivo
      if ( x > 0 )
      {
      // mostrar valor
         IO.println ( "Valor lido = " + x );
      // tentar fazer de novo com valor menor
         metodo01 ( x-1 );
      } // fim se
   } // fim metodo01( )
   public static void metodo02 ( int x )
   {
   // testar se valor positivo
      if ( x > 0 )
      {
      // tentar fazer de novo com valor menor
         metodo02 ( x-1 );
      // mostrar valor ( acao pendente )
         IO.println ( "Valor = " + x );
      } // fim se
   } // fim metodo02( ) 
   public static void metodo03 ( int x )
   {
   // testar se contador valido
      if ( x > 1 )
      {
      // mostrar valor relativo
         IO.print ( " " + x );
      // tentar fazer de novo com valor menor
         metodo03 ( x-1 ); // motor da recursividade
      }
      else
      {
      // mostrar ultimo
         IO.println ( " " + x ); // base da recursividade
      } // fim se
   } // fim metodo03( )
   public static void metodo04 ( int x )
   {
   // testar se contador valido
      if ( x > 1 )
      {
      // mostrar valor relativo
         IO.print ( " " + 2*(x-1) );
      // tentar fazer de novo com valor menor
         metodo04 ( x-1 );
      }
      else
      {
      // mostrar ultimo
         IO.println ( " 1" );
      } // fim se
   } // fim metodo04( )
   public static void metodo05 ( int x )
   {
   // testar se contador valido
      if ( x > 1 )
      {
      // tentar fazer de novo com valor menor
         metodo05 ( x-1 );
      // mostrar valor relativo
         IO.print ( " + " + (2*(x-1)) + "/" + (2*x-1) );
      }
      else
      {
      // mostrar ultimo valor (primeiro na sequencia)
         IO.print ( " 1" );
      } // fim se
   } // fim metodo05( )
   public static int funcao01 ( int x )
   {
   // definir dado
      int resposta = 0;
   // testar se contador valido
      if ( x > 1 )
      {
      // tentar fazer de novo com valor menor
         resposta = x + funcao01 ( x-1 );
      // mostrar valor relativo
         IO.print ( " + " + x );
      }
      else
      {
      // mostrar ultimo
         IO.print ( " 1" );
      // ultima resposta
         resposta = 1;
      } // fim se
   // retornar resposta
      return ( resposta );
   } // fim funcao01( )
   public static double funcao02 ( int x )
   {
   // definir dado
      double resposta = 0.0;
   // testar se contador valido
      if ( x > 1 )
      {
      // calcular termo e tentar fazer de novo com valor menor
         resposta = (2.0*(x-1) / (2.0*x-1)) + funcao02 ( x-1 );
      // mostrar valor relativo
         IO.print ( " + " + 2*(x-1) + "/" + (2*x-1) );
      }
      else
      {
      // ultima resposta
         resposta = 1.0;
      // mostrar ultimo
         IO.print ( " 1" );
      } // fim se
   // retornar resposta
      return ( resposta );
   } // fim funcao02( )

// ---------------------------------------------- definicao do metodo principal
 /**
 * main() ? metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0107 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      IO.println ( " = " + funcao02 ( 5 ) );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0107
/*
   Versao      Teste    
   01           1       metodo01 ( 5 );
                        Valor lido = 5
                        Valor lido = 4
                        Valor lido = 3
                        Valor lido = 2
                        Valor lido = 1
   02           1       metodo02 ( 5 );
                        Valor = 1
                        Valor = 2
                        Valor = 3
                        Valor = 4
                        Valor = 5
   03           1       metodo03 ( 5 );
                         5 4 3 2 1
   04           1       metodo04 ( 5 );
                         8 6 4 2 1
   05           1       metodo05 ( 5 );
                         1 + 2/3 + 4/5 + 6/7 + 8/9
   06           1       Valor previsto: 5
                        1 + 2 + 3 + 4 + 5 = 15
   07           1       Valor previsto: 5
                        1 + 2/3 + 4/5 + 6/7 + 8/9 = 4.212698412698413

*/ 
