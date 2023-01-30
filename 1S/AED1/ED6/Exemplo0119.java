/**
 * Exemplo0119
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca
 * Versao 19
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0119
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static int metodo14 ( String cadeia, int x )
   {
      int maiusculas = 0;
      if ( x >= 0 && x<cadeia.length())
      {
         if ( cadeia.charAt(x)>='A' && cadeia.charAt(x)<='Z' )
         {
            maiusculas = 1;
         }
         maiusculas = maiusculas + metodo14 ( cadeia, x+1 );
      }
      return ( maiusculas );
   }
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0119 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      String x;
      x=IO.readString("Entrar com uma cadeia de caracteres: ");
      IO.print("Maiusculas = "+metodo14(x,0));
      IO.println("");
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0119
/*
   Versao      Teste    
   19          1      Entrar com uma cadeia de caracteres: abAb
                      Maiusculas = 2
               2      Entrar com uma cadeia de caracteres: ABCDE123fg
                      Maiusculas = 5
*/ 
