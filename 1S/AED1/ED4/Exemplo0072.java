/**
* Exemplo0072
*
* Matricula: 628826
* Aluno: Rodrigo Padilha Fonseca
* Versao 12 
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0072
{
// ---------------------------------------------- definicao de metodo auxiliar
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
   public static String separar_minusculas ( String cadeia )
   {
   // definir dado
      String resposta = "";
      int posicao = cadeia.length( )-1; // ultima
   // testar simbolos na cadeia de caracteres
      while ( posicao >= 0 )
      {
      // testar se letra minuscula
         if ( minuscula (cadeia.charAt(posicao)) )
         {
            resposta = resposta + cadeia.charAt(posicao);
         } // fim se
      // passar 'a proxima
         posicao = posicao - 1;
      } // fim repetir
   // retornar resultado
      return ( resposta );
   } // fim separar_minusculas ( )
   public static void metodo10 ( )
   {
   // definir dados
      String x;
      int tamanho;
      int posicao;
      int contador;
      String minusculas;
   // identificar o metodo
      IO.println ( "Metodo 10" );
   // ler cadeia de caracteres do teclado
      x = IO.readString ( "Entrar com uma cadeia de caracteres: " );
      IO.println ( "Valor lido = " + x );
   // obter o tamanho da cadeia
      tamanho = x.length( );
   // mostrar o tamanho da cadeia
      IO.println ( "tamanho de " + x + " = " + tamanho );
   // contar e separar letras minusculas
      minusculas = separar_minusculas ( x );
      contador = contar_minusculas ( x );
   // mostrar a quantidade de letras minusculas
      IO.println ( "letras minusculas = " + contador +
         " = " + minusculas );
   } // fim metodo10( )
   public static void metodo12()
   {
      String x;
      int tamanho;
      int posicao;
      int z;
      x = IO.readString ( "Entrar com uma cadeia de caracteres: " );
      tamanho=x.length();
      z=0;
      posicao = 0;
      while ( posicao<tamanho )
      {
         if ( x.charAt(posicao) >= 'a' &&
         x.charAt(posicao) <= 'z' )
         {
            z=z+1;
         } 
         posicao = posicao + 1;
      } 
      IO.println("numero de minusculas= "+z);
   }
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0072 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo12 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0072
// Versao 12 - Teste
// Entrar com uma cadeia de caracteres: abcd123ABCefg4hD
// numero de minusculas= 8