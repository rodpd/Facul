/**
 * Exemplo0120
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca
 * Versao 20
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0120
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static int metodo15 ( String cadeia, int x )
   {
      int digitos = 0;
      if ( x >= 0 && x<cadeia.length())
      {
         if ( cadeia.charAt(x)>='0' && cadeia.charAt(x)<='9' )
         {
            digitos = 1;
         }
         digitos = digitos + metodo15 ( cadeia, x+1 );
      }
      return ( digitos );
   }
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0120 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      String x;
      x=IO.readString("Entrar com uma cadeia de caracteres: ");
      IO.print("Quantidade de digitos = "+metodo15(x,0));
      IO.println("");
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0120
/*
   Versao      Teste    
   20          1      Entrar com uma cadeia de caracteres: abcd12A
                      Quantidade de digitos = 2
               2      Entrar com uma cadeia de caracteres: 12345ab
                      Quantidade de digitos = 5       
*/ 
