/**
* Exemplo0192
*
* Aluno: Rodrigo Padilha Fonseca
* Matricula: 628826
* Versao 12
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
public class Exemplo0192
{
// ---------------------------------------------- definicao de metodo auxiliar
/**
* Testar definições de arranjo usando classe.
*/
   public static void printIntArray ( int [] arranjo, int inicio, int quantidade )
   {
      int tamanho = arranjo.length;
      if ( arranjo == null )
      {
         IO.println( "Erro: Arranjo nulo" );
      }
      else
      {
         if ( tamanho <= 0 )
         {
            IO.println ("Erro: Tamanho invalido" );
         }
         else
         {
            if ( inicio <=0 || quantidade <=0 )
            {
               IO.println( "Erro: Inicio e quantidade devem ser maiores que 0 " );
            }
            else
            {
               for ( int i = inicio; i < inicio + quantidade; i = i+1 )
               {
                  IO.println (arranjo[i]);
               }
            }
         }
      }
   }
   public static void metodo01 ( )
   {
      int [] arranjo = {1,2,3,4,5,6,7,8};
      int inicio = IO.readint("Inicio: ");
      int quantidade = IO.readint( "Quantidade: ");
      printIntArray ( arranjo, inicio, quantidade );
   }
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0192 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padiha Fonseca" );
   // executar o metodo auxiliar
      metodo01 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0161