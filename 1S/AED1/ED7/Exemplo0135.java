/**
 * Exemplo0135
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca
 * Versao 15
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0135
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo15 ( )
   {
      FILE arquivo;
      String y;
      y = IO.readString ( "Entrar com uma cadeia de caracteres: " );
      int x=y.length( )-1;
      arquivo = new FILE ( FILE.OUTPUT, "Exemplo0135.TXT" );

      while ( x >= 0 && x<y.length())
      {
         arquivo.println(y.substring(x,x+1));
         x=x-1;
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
      IO.println ( "EXEMPLO0135 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo15 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0135
/*
   Teste          Versao
   1              15       Entrar com uma cadeia de caracteres: abc123ABC
                           Exemplo135.TXT:
                           C
                           B
                           A
                           3
                           2
                           1
                           c
                           b
                           a
*/