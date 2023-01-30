/**
 * Exemplo0115
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca
 * Versao 15
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0115
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static String metodo10 ( String cadeia, int x )
   {
      String resposta="";
      if ( x >= 0 && x<cadeia.length())
      {
         IO.println(cadeia.charAt(x));
         resposta = resposta + metodo10 ( cadeia, x+1 );
      }
      return ( resposta );
   }
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0115 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      String x;
      x=IO.readString("Entrar com uma cadeia de caracteres: ");
      metodo10(x,0);
      IO.println("");
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0115
/*
   Versao      Teste    
   20          1      Entrar com uma cadeia de caracteres: abc123ABC
                      a
                      b
                      c
                      1
                      2
                      3
                      A
                      B
                      C       
*/ 
