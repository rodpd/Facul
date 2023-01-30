/**
* Exemplo0077
*
* Matricula: 628826
* Aluno: Rodrigo Padilha Fonseca
* Versao 17 
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0077
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo17()
   {
   // definir dados
      String x;
      String numeros="";
      int y=0;
      int posicao=0;
      // ler cadeida de caracteres do teclado
      x=IO.readString("Entrar com uma cadeia de caracteres: ");
      int tamanho=x.length();
      while (posicao<tamanho)
      {
         if (x.charAt(posicao)>='0'&&x.charAt(posicao)<='9')
         {
            numeros=numeros+x.charAt(posicao);
         }
         posicao=posicao+1;
      }
      
      IO.println("Numeros: "+numeros);
   
   }
// ---------------------------------------------- definicao do metodo principal
/**
* main() metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0077 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo17 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0077
/* Versao 17 - Teste
   EXEMPLO0077 - Programa em Java
   Autor: Rodrigo Padilha Fonseca
  Entrar com uma cadeia de caracteres: 1aA2bB3cC456
  Numeros: 123456
  Apertar ENTER para terminar.
*/