/**
* Exemplo0067
*
* Matricula: 628826
* Aluno: Rodrigo Padilha Fonseca
* Versao 07 
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0067
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
   public static void metodo07 ( )
   {
   // definir dados
      String x;
      int tamanho;
      int posicao;
      int contador=0;
   // identificar o metodo
      IO.println ( "Metodo 07" );
   // ler cadeia de caracteres do teclado
      x = IO.readString ( "Entrar com uma cadeia de caracteres: " );
      IO.println ( "Valor lido = " + x );
      // obter tamanho da cadeia
      tamanho=x.length();
      // mostrar o tamanho da cadeia
      IO.println("tamanho de "+x+"="+tamanho);
   // contar letras minusculas
      contador=0;
      posicao = 0;
      while ( posicao<tamanho )
      {
         if ( minuscula ( x.charAt(posicao) ) )
         {
            IO.println ( "posicao = " + posicao
               + " contem " + x.charAt(posicao) );
            contador = contador+1;
         } // fim se
         posicao = posicao + 1;
      } // fim repetir
      // mostrar a quantidade de letras minusculas
      IO.println("letras minusculas= " + contador);
   } // fim metodo07( )
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0067 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo07 ( ); // tratar caracteres
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0067