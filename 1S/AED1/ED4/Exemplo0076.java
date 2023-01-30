/**
* Exemplo0076
*
* Matricula: 628826
* Aluno: Rodrigo Padilha Fonseca
* Versao 16 
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0076
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
   public static String separar_maiusculas(String cadeia)
   {
   //definir dados
      int posicao=0;
      int tamanho=cadeia.length();
      String resposta="";
      while(posicao<tamanho)
      {
      //testar se e' maiuscula
         if (cadeia.charAt(posicao)>='A'&&cadeia.charAt(posicao)<='Z')
         {
            resposta=resposta+cadeia.charAt(posicao);
         }
      // passar 'a proxima posicao
         posicao=posicao+1;
      }
      return(resposta);
   }
   public static void metodo16()
   {
   // definir dados
      String x;
      String minusculas="";
      String maiusculas="";
      // ler cadeida de caracteres do teclado
      x=IO.readString("Entrar com uma cadeia de caracteres: ");
      // separar minusculas e maiusculas
      minusculas=separar_minusculas(x);
      maiusculas=separar_maiusculas(x);
      //mostrar minusculas
      IO.println("minusculas: "+minusculas);
      IO.println("maiusculas: "+maiusculas);
   }
// ---------------------------------------------- definicao do metodo principal
/**
* main() metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0076 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo16 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0076
/* Versao 16 - Teste
   EXEMPLO0076 - Programa em Java
   Autor: Rodrigo Padilha Fonseca
   Entrar com uma cadeia de caracteres: 1aA2bB3cCdefDE
   minusculas: abcdef
   maiusculas: ABCDE
   Apertar ENTER para terminar.

*/