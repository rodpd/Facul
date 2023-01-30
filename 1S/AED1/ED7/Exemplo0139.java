/**
 * Exemplo0139
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca
 * Versao 19
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0139
{
   public static void metodo19 ( )
   {
      FILE arquivo;
      String cadeia = IO.readString("Entrar com uma cadeia de caracteres: ");
      int maiusculas = 0;
      arquivo = new FILE ( FILE.OUTPUT, "Exemplo0139.TXT" );
      for ( int x=0; x<cadeia.length( ); x=x+1 )
      {
         if (cadeia.charAt(x)>='A' && cadeia.charAt(x)<='Z')
         {
            arquivo.print (cadeia.charAt(x)+" ");
            maiusculas = maiusculas + 1;
         }
         else
         {
         }
      }
      arquivo.println("" );
      arquivo.println("Quantidade de maiusculas: " + maiusculas );
      arquivo.close( );
   }
// ---------------------------------------------- definicao de metodo auxiliar
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0139 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo19 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0139
/*
   Teste          Versao
   1              19      Entrar com uma cadeia de caracteres: sdf654FDSGB456gB
                          Exemplo0139.TXT:
                          F D S G B B 
                          Quantidade de maiusculas: 6
   2                      Entrar com uma cadeia de caracteres: gf4sd56
                          Exemplo0139.TXT:
                          
                          Quantidade de maiusculas: 0
*/