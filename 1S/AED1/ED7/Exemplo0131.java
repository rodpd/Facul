/**
 * Exemplo0131
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca
 * Versao 11
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0131
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo11 ( )
   {
      FILE arquivo;
      int x;
      x = IO.readint ( "Quantidade: " );
      arquivo = new FILE ( FILE.OUTPUT, "Exemplo0131.TXT" );
      int y=x;
      for ( x=x; x>0; x=x-1 )
      {
         arquivo.println(""+(3+2*y));
         y=y-1;
      }
      arquivo.close( );
   }
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0131 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo11 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0131
/*
   Teste          Versao
   1              11       Quantidade: 10
                           Exemplo0131.TXT
                           23
                           21
                           19
                           17
                           15
                           13
                           11
                           9
                           7
                           5

*/