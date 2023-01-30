/**
 * Exemplo0136
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca
 * Versao 16
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0136
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo16 ( )
   {
      FILE arquivo;
      int z=IO.readint("Quantidade: ");
      int y=3;
      int soma=0;
      arquivo = new FILE ( FILE.OUTPUT, "Exemplo0136.TXT" );
      for ( int x=1; x<=z; x=x+1 )
      {
         arquivo.println(""+y);
         soma=soma+y;
         y=y+2;
      }
      arquivo.println("Soma = "+soma);
      arquivo.close( );
   } 
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0136 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo16 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0136
/*
   Teste          Versao
   1              16       Quantidade: 5
                           Exemplo0136.TXT
                           3
                           5
                           7
                           9
                           11
                           Soma = 35
   2                       Quantidade: 3
                           Exemplo0136.TXT:
                           3
                           5
                           7
                           Soma = 15
*/