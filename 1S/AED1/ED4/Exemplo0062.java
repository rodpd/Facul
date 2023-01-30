/**
* Exemplo0062
*
* Matricula: 628826
* Aluno: Rodrigo Padilha Fonseca
* Versao 02
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0062
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo02 ( )
   {
   // definir dados
      String x;
      int tamanho;
   // identificar o metodo
      IO.println ( "Metodo 02" );
   // ler cadeia de caracteres do teclado
      x = IO.readString ( "Entrar com uma cadeia de caracteres: " );
      IO.println ( "Valor lido = " + x );
      // obter tamanho da cadeia
      tamanho=x.length();
      // mostrar o tamanho da cadeia
      IO.println("tamanho de "+x+"="+tamanho);
   } // fim metodo02( )
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0062 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo02 ( ); // tratar caracteres
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0062