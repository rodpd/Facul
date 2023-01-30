/**
* Exemplo0202
*
* Matricula: 628826  
* Aluno: Rodrigo Padilha
* Versao 02
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
      /**
* construtor alternativo.
*/
   public Matriz ( int linhas, int colunas )
   {
      if ( linhas <= 0 || colunas <= 0 )
      {
         IO.println ( "ERRO: quantidade invalida." );
      }
      else
      {
         tabela = new Object [ linhas ][ colunas ];
      } // fim se
   } // fim construtor alternativo
/**
* informar a quantidade de posicoes reservadas (linhas).
*/
   public int lines ( )
   {
      int linhas = 0;
      if ( tabela != null )
      {
         linhas = tabela.length;
      }
      return ( linhas );
   } // fim lines ( )
/**
* informar a quantidade de posicoes reservadas (colunas).
*/
   public int columns ( )
   {
      int colunas = 0;
      if ( tabela != null )
      {
         colunas = tabela[0].length;
      }
      return ( colunas );
   } // fim columns ( )

} // fim da classe Matriz
//---------------------------------------------- definicao da classe principal
public class Exemplo0202
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
      IO.println ( "EXEMPLO0202 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
   // 1. definir dados
      Matriz a1 = null;
      Matriz a2 = new Matriz ( );
      Matriz a3 = new Matriz ( 3, 3 );
   // 3. testar as definicoes de matriz
      if ( a3 == null )
      {
         IO.println ( " Matriz a3 nula" );
      }
      else
      {
         IO.println ( " Matriz a3 nao nula com "+a3.lines( )+"x"+a3.columns( )+" posicoes." );
      } // fim se
      
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0202