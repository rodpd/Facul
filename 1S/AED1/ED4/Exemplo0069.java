/**
* Exemplo0069
*
* Matricula: 628826
* Aluno: Rodrigo Padilha Fonseca
* Versao 09 
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0069
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static int contar_minusculas ( String cadeia )
   {
   // definir dado
      int resposta = 0;
      int posicao = cadeia.length( )-1; // ultima
   // testar simbolos na cadeia de caracteres
      while ( posicao >= 0 )
      {
      // testar se letra minuscula
         if ( minuscula (cadeia.charAt(posicao)) )
         { resposta = resposta + 1; }
      // passar 'a proxima
         posicao = posicao - 1;
      } // fim repetir
   // retornar resultado
      return ( resposta );
   } // fim contar_minusculas ( )
   public static boolean minuscula ( char simbolo )
   {
   // definir dado
      boolean resposta = false;
   // testar se letra minuscula
      if ( simbolo >= 'a' &&
      simbolo <= 'z' )
      {
         resposta = true;
      } // fim se
   // retornar resultado
      return ( resposta );
   } // fim minuscula ( )
   public static void metodo09 ( )
   {
   // definir dados
      String x;
      int tamanho;
      int posicao;
      int contador=0;
      String minusculas;
   // identificar o metodo
      IO.println ( "Metodo 09" );
   // ler cadeia de caracteres do teclado
      x = IO.readString ( "Entrar com uma cadeia de caracteres: " );
      IO.println ( "Valor lido = " + x );
      // obter tamanho da cadeia
      tamanho=x.length();
      // mostrar o tamanho da cadeia
      IO.println("tamanho de "+x+"="+tamanho);
   // contar e separar letras minusculas
      minusculas="";
      contador = contar_minusculas ( x );
      contador=0;
      posicao = 0;
      while ( posicao<tamanho )
      {
         if ( minuscula ( x.charAt(posicao) ) )
         {
            IO.println ( "posicao = " + posicao
               + " contem " + x.charAt(posicao) );
            contador = contador+1;
            minusculas=minusculas+x.charAt(posicao);
         } // fim se
         posicao = posicao + 1;
      } // fim repetir
      // mostrar a quantidade de letras minusculas
      IO.println("letras minusculas= " + contador+
                 " = "+minusculas);
   } // fim metodo09( )
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0069 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo09 ( ); // tratar caracteres
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0069