/**
* Exemplo0078
*
* Matricula: 628826
* Aluno: Rodrigo Padilha Fonseca
* Versao 18 
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0078
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static int contar_pares ( String cadeia )
   {
   // definir dados
      int posicao=0;
      int resposta=0;
      int tamanho=cadeia.length();
      while (posicao<tamanho)
      {
      // testar se e' numero par
         if ( cadeia.charAt(posicao)>='0'
         &&cadeia.charAt(posicao)<='9'
         &&cadeia.charAt(posicao)%2==0)
         {
            resposta = resposta + 1;
         } // fim se
         // passar a' proxima posicao
         posicao=posicao+1;
      } // fim repetir
      //retornar resultado
      return(resposta);
   } // fim contar_pares
   public static void metodo18()
   {
   // definir dados
      String x;
      int pares=0;
      int y=0;
      int posicao=0;
      // ler cadeida de caracteres do teclado
      x=IO.readString("Entrar com uma cadeia de caracteres: ");
      // contar numeros pares
      pares = contar_pares(x);
      // mostrar quantidade de numeros pares
      IO.println("Quantidade de numeros pares: "+pares);
   
   } // fim metodo18
// ---------------------------------------------- definicao do metodo principal
/**
* main() metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0078 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo18 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0078
/* Versao 18 - Teste
   EXEMPLO0078 - Programa em Java
   Autor: Rodrigo Padilha Fonseca
   Entrar com uma cadeia de caracteres: 1aA2bB3cC456789
   Quantidade de numeros pares: 4
   Apertar ENTER para terminar.
*/