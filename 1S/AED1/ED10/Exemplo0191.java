/**
* Exemplo0191
*
* Aluno: Rodrigo Padilha Fonseca
* Matricula: 628826
* Versao 11
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao de classe auxiliar
/**
* Classe para tratar arranjo de inteiros.
*/
class Arranjo
{
/**
* armazenador generico dos dados
*/
   public Object [ ] tabela;
/**
* construtor padrao
*/
   public Arranjo ( )
   {
      tabela = null;
   } // fim construtor padrao
} // fim da classe Arranjo// ---------------------------------------------- definicao da classe principal
public class Exemplo0191
{
// ---------------------------------------------- definicao de metodo auxiliar
/**
* Testar definições de arranjo usando classe.
*/
   public static int [] readIntArray ( int [] arranjo, int inicio, int quantidade )
   {
      int tamanho = arranjo.length;
      int [] newarray;
      if ( tamanho < (inicio + quantidade) )
      {
         newarray = new int [inicio + quantidade];
      }
      else
      {
         newarray = new int [tamanho];
      }
      for ( int i = 0; i < tamanho; i = i+1 )
      {
         newarray[i] = arranjo[i];
      }
      for ( int i = inicio; i <= inicio + quantidade ; i = i+1 )
      {
         arranjo[i] = IO.readint("Entrar com um inteiro: ");
      }
      return( arranjo );
   }
   public static void metodo01 ( )
   {
      int [] arranjo = {1,2,3,4,5,6,7,8};
      int inicio = IO.readint("Inicio: ");
      int quantidade = IO.readint( "Quantidade: ");
      arranjo = readIntArray ( arranjo, inicio, quantidade );
      int tamanho = arranjo.length;
      for ( int i = 0; i < tamanho; i = i+1 )
      {
         IO.println(arranjo[i]);
      }
   }
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0191 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padiha Fonseca" );
   // executar o metodo auxiliar
      metodo01 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0161