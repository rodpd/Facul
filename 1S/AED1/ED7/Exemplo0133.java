/**
 * Exemplo0133
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca
 * Versao 13
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0133
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo13 ( )
   {
      FILE arquivo;
      int x;
      int y;
      y = IO.readint ( "Quantidade: " );
      arquivo = new FILE ( FILE.OUTPUT, "Exemplo0133.TXT" );
      for ( x=0; x<y; x=x+1 )
      {
         if (x==0)
         {
            arquivo.println("1");
         }
         else
         {
            arquivo.println(""+(5*x));
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
      IO.println ( "EXEMPLO0133 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo13 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0133
/*
   Teste          Versao
   1              13       Quantidade: 5
                           Exemplo0133.TXT:
                           1
                           5 
                           10
                           15
                           20
*/