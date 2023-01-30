/**
* Exemplo0201
*
* Matricula: 628826  
* Aluno: Rodrigo Padilha
* Versao 01
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao de classe auxiliar
/**
* Classe para tratar matriz de objetos.
*/
class Matriz
{
/**
* armazenador generico dos dados
*/
   public Object [ ][ ] tabela;
/**
* construtor padrao
*/
   public Matriz ( )
   {
      tabela = null;
   } // fim construtor padrao
} // fim da classe Matriz// ---------------------------------------------- definicao da classe principal
public class Exemplo0201
{
// ---------------------------------------------- definicao de metodo auxiliar
/**
* Testar definições de matriz usando classe.
*/
   public static void metodo01 ( )
   {
   // 1. definir dados
      Matriz a1 = null;
   // nao existe objeto
      Matriz a2 = new Matriz ( );
   // existe objeto (sem dados, no momento)
   // 2. identificar
      IO.println ( "Definicoes de matriz" );
   // 3. testar as definicoes de matriz
      if ( a1 == null )
      {
         IO.println ( "Matriz a1 nula (inexistente)" );
      }
      else
      {
         IO.println ( "Matriz a1 nao nula (existente)" );
      } // fim se
      if ( a2 == null )
      {
         IO.println ( " Matriz a2 nula (inexistente)" );
      }
      else
      {
         IO.println ( " Matriz a2 nao nula (existente)" );
      } // fim se
   // 5. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo01( )
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0201 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo01 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0201