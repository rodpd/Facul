/**
* Exemplo0065
*
* Matricula: 628826
* Aluno: Rodrigo Padilha Fonseca
* Versao 05 
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0065
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo05 ( )
   {
   // definir dados
      String x;
      int tamanho;
      int posicao;
   // identificar o metodo
      IO.println ( "Metodo 05" );
   // ler cadeia de caracteres do teclado
      x = IO.readString ( "Entrar com uma cadeia de caracteres: " );
      IO.println ( "Valor lido = " + x );
      // obter tamanho da cadeia
      tamanho=x.length();
      // mostrar o tamanho da cadeia
      IO.println("tamanho de "+x+"="+tamanho);
   // mostrar cada letra minuscula separadamente
      posicao = 0;
      while ( posicao<tamanho )
      {
         if ( x.charAt(posicao) >= 'a' &&
         x.charAt(posicao) <= 'z' )
         {
            IO.println ( "posicao = " + posicao
               + " contem " + x.charAt(posicao) );
         } // fim se
         posicao = posicao + 1;
      } // fim repetir
   } // fim metodo05( )
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0065 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo05 ( ); // tratar caracteres
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0065