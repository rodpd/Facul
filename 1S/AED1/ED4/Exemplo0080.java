/**
* Exemplo0080
*
* Matricula: 628826
* Aluno: Rodrigo Padilha Fonseca
* Versao 20 
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0080
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
   public static int contar_maiusculas(String cadeia)
   {
   //definir dados
      int posicao=0;
      int tamanho=cadeia.length();
      int resposta=0;
      while(posicao<tamanho)
      {
      //testar se e' maiuscula
         if (cadeia.charAt(posicao)>='A'&&cadeia.charAt(posicao)<='Z')
         {
            resposta=resposta+1;
         }
      // passar 'a proxima posicao
         posicao=posicao+1;
      }
      return(resposta);
   }
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
   public static int contar_numeros ( String cadeia )
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
         {
            resposta = resposta + 1;
         } // fim se
         // passar a' proxima posicao
         posicao=posicao+1;
      } // fim repetir
      //retornar resultado
      return(resposta);
   } // fim contar_numeros

   public static void metodo20()
   {
   // definir dados
      String x;
      String pares="";
      int y=0;
      int posicao=0;
      // ler cadeida de caracteres do teclado
      x=IO.readString("Entrar com uma cadeia de caracteres: ");
      // contar numeros pares
      pares = separar_pares(x);
      // mostrar quantidade de numeros pares
      IO.println("Numeros pares: "+pares);
   
   } // fim metodo18
// ---------------------------------------------- definicao do metodo principal
/**
* main() metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO080 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo19 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0080
/* Versao 19 - Teste
  EXEMPLO0079 - Programa em Java
Autor: Rodrigo Padilha Fonseca
Entrar com uma cadeia de caracteres: 1aA2bB3cC456789
Numeros pares: 2 4 6 8 
Apertar ENTER para terminar.
*/