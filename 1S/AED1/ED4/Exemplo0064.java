/**
* Exemplo0064
*
* Matricula: 628826
* Aluno: Rodrigo Padilha Fonseca
* Versao 04 
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0064
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo04 ( )
   {
   // definir dados
      String x;
      int tamanho;
      int posicao;
   // identificar o metodo
      IO.println ( "Metodo 04" );
   // ler cadeia de caracteres do teclado
      x = IO.readString ( "Entrar com uma cadeia de caracteres: " );
      IO.println ( "Valor lido = " + x );
      // obter tamanho da cadeia
      tamanho=x.length();
      // mostrar o tamanho da cadeia
      IO.println("tamanho de "+x+"="+tamanho);
      // mostrar cada simbolo separadamente
      // em ordem inversa
      for ( posicao=tamanho-1; posicao>=0; posicao=posicao-1 )
      {
         IO.println("posicao= "+posicao
                 + " contem " +x.charAt(posicao));
      } // fim repetir
   } // fim metodo04( )
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0064 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo04 ( ); // tratar caracteres
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0064