/**
* Exemplo0079
*
* Matricula: 628826
* Aluno: Rodrigo Padilha Fonseca
* Versao 19 
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0079
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static String separar_pares ( String cadeia )
   {
   // definir dados
      int posicao=0;
      String resposta="";
      int tamanho=cadeia.length();
      while (posicao<tamanho)
      {
      // testar se e' numero par
         if ( cadeia.charAt(posicao)>='0'
         &&cadeia.charAt(posicao)<='9'
         &&cadeia.charAt(posicao)%2==0)
         {
            resposta = resposta + cadeia.charAt(posicao)+" ";
         } // fim se
         // passar a' proxima posicao
         posicao=posicao+1;
      } // fim repetir
      //retornar resultado
      return(resposta);
   } // fim separar_pares
   public static void metodo19()
   {
   // definir dados
      String x;
      String pares="";
      int y=0;
      int posicao=0;
      // ler cadeida de caracteres do teclado
      x=IO.readString("Entrar com uma cadeia de caracteres: ");
      // separar numeros pares
      pares = separar_pares(x);
      // mostrar numeros pares
      IO.println("Numeros pares: "+pares);
   
   } // fim metodo19
// ---------------------------------------------- definicao do metodo principal
/**
* main() metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0079 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo19 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0079
/* Versao 19 - Teste
  EXEMPLO0079 - Programa em Java
Autor: Rodrigo Padilha Fonseca
Entrar com uma cadeia de caracteres: 1aA2bB3cC456789
Numeros pares: 2 4 6 8 
Apertar ENTER para terminar.
*/