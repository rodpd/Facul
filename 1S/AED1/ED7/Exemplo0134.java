/**
 * Exemplo0134
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca
 * Versao 14
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0134
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo14 ( )
   {
      FILE arquivo;
      int x;
      int y;
      y = IO.readint ( "Quantidade: " );
      arquivo = new FILE ( FILE.OUTPUT, "Exemplo0134.TXT" );
      for ( x=y-1; x>=0; x=x-1 )
      {
         if (x==0)
         {
            arquivo.println("1");
         }
         else
         {
            arquivo.println("1/"+(Math.pow(5,x)));
         }
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
      IO.println ( "EXEMPLO0134 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo14 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0134
/*
   Teste          Versao
   1              14       Quantidade: 7
                           Exemplo0134.TXT:
                           1/15625.0
                           1/3125.0
                           1/625.0
                           1/125.0
                           1/25.0
                           1/5.0
                           1
*/