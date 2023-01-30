/**
 * Exemplo0132
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca
 * Versao 12
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0132
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo12 ( )
   {
      FILE arquivo;
      int x;
      int y;
      y = IO.readint ( "Quantidade: " );
      arquivo = new FILE ( FILE.OUTPUT, "Exemplo0132.TXT" );
      for ( x=1; x<=y; x=x+1 )
      {
         arquivo.println(""+(5*x));
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
      IO.println ( "EXEMPLO0132 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo12 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0132
/*
   Teste          Versao
   1              12       Quantidade: 6
                           Exemplo0132.TXT:
                           5
                           10
                           15
                           20
                           25
                           30

*/