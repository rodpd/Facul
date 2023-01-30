/**
* Exemplo0073
*
* Matricula: 628826
* Aluno: Rodrigo Padilha Fonseca
* Versao 13 
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0073
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static int contar_minusculas ( String cadeia )
   {
   // definir dados
      int posicao=0;
      int tamanho=cadeia.length();
      int resposta=0;
      while (posicao<tamanho)
      {
      // testar se e' minuscula
         if (cadeia.charAt(posicao)>='a'&&cadeia.charAt(posicao)<='z')
         {
            resposta = resposta+1;
         }
         // passar 'a proxima posicao
         posicao=posicao+1;
      }
      // retornar resultado
      return(resposta);
   }
   public static void metodo13()
   {
   // definir dados
      String x;
      int minusculas=0;
      // ler cadeida de caracteres do teclado
      x=IO.readString("Entrar com uma cadeia de caracteres: ");
      // contar minusculas
      minusculas=contar_minusculas(x);
      //mostrar minusculas
      IO.println("quantidade de minusculas: "+minusculas);
   }
// ---------------------------------------------- definicao do metodo principal
/**
* main() metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0073 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo13 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0073
// Versao 13 - Teste
// Entrar com uma cadeia de caracteres: 1aA2bB3cCdef
// quantidade de minusculas: 6
