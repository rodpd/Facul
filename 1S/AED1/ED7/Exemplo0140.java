/**
 * Exemplo0140
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca
 * Versao 20
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0140
{
   public static void metodo19 ( )
   {
      FILE arquivo;
      String cadeia = IO.readString("Entrar com uma cadeia de caracteres: ");
      int digitos = 0;
      arquivo = new FILE ( FILE.OUTPUT, "Exemplo0140.TXT" );
      for ( int x=0; x<cadeia.length( ); x=x+1 )
      {
         if (cadeia.charAt(x)>='0' && cadeia.charAt(x)<='9')
         {
            arquivo.print (cadeia.charAt(x)+" ");
            digitos = digitos + 1;
         }
         else
         {
         }
      }
      arquivo.println("" );
      arquivo.println("Quantidade de digitos: " + digitos );
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
      IO.println ( "EXEMPLO0140 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo19 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0140
/*
   Teste          Versao
   1              20      Entrar com uma cadeia de caracteres: g4fsd56gfdsGFG123
                          Exemplo0140.TXT:
                          4 5 6 1 2 3 
                          Quantidade de digitos: 6
   2                      Entrar com uma cadeia de caracteres: gfds4564137GG9h5
                          Exemplo140.TXT:
                          4 5 6 4 1 3 7 9 5 
                          Quantidade de digitos: 9

*/