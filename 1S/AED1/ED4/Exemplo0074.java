/**
* Exemplo0074
*
* Matricula: 628826
* Aluno: Rodrigo Padilha Fonseca
* Versao 14 
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0074
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static String separar_minusculas ( String cadeia )
   {
   // definir dados
      int posicao=0;
      int tamanho=cadeia.length();
      String resposta="";
      while (posicao<tamanho)
      {
      // testar se e' minuscula
         if (cadeia.charAt(posicao)>='a'&&cadeia.charAt(posicao)<='z')
         {
            resposta = resposta+cadeia.charAt(posicao);
         }
         // passar 'a proxima posicao
         posicao=posicao+1;
      }
      // retornar resultado
      return(resposta);
   }
   public static void metodo14()
   {
   // definir dados
      String x;
      String minusculas="";
      // ler cadeida de caracteres do teclado
      x=IO.readString("Entrar com uma cadeia de caracteres: ");
      // separar minusculas
      minusculas=separar_minusculas(x);
      //mostrar minusculas
      IO.println("minusculas: "+minusculas);
   }
// ---------------------------------------------- definicao do metodo principal
/**
* main() metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0074 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo14 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0074
/* Versao 14 - Teste
   Entrar com uma cadeia de caracteres: 1aA2bB3cCdef
   minusculas: abcdef
*/