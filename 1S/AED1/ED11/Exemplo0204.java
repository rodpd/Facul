/**
* Exemplo0204
*
* Matricula: 628826  
* Aluno: Rodrigo Padilha
* Versao 04
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
/**
* exibir dados em matriz.
*/
   public void printMatrix ( )
   {
   // definir dados
      int x, y,
         linhas, colunas;
   // identificar
      IO.println ( );
   // testar se a matriz foi montada
      if ( tabela == null )
      {
         IO.println ( "ERRO: Matriz vazia." );
      }
      else
      {
      // obter dimensoes da matriz
         linhas = lines( );
         colunas = columns( );
      // mostrar matriz
         IO.println ( "Matriz com "+linhas+"x"+colunas+" posicoes:" );
      // repetir para cada posicao na matriz
         for ( x = 0; x < linhas; x = x + 1 )
         {
            for ( y = 0; y < colunas; y = y + 1 )
            {
            // mostrar o valor armazenado
               IO.print ( "\t"+matriz [ x ][ y ] );
            } // fim repetir
            IO.println ( );
         } // fim repetir
      } // fim se
   } // fim printMatrix ( )
   /**
* ler valores do teclado e guardar em uma matriz.
* @param message - com texto a ser mostrado na tela
*/
   public void readMatrix ( String message )
   {
   // definir dados
      int x, y,
         linhas = lines( ),
         colunas = columns( );
      String linha;
   // testar se quantidade valida
      if ( linhas <= 0 || colunas <= 0 )
      {
         IO.println ( "ERRO: Tamanho invalido." );
      }
      else
      {
      // mostrar mensagem antes de ler dados
         IO.println ( message );
      // obter o tamanho da matriz
         linhas = this.lines ( );
         colunas = this.columns ( );
      // repetir para cada posicao na matriz
         for ( x = 0; x < linhas; x = x + 1 )
         {
            for ( y = 0; y < colunas; y = y + 1 )
            {
            // ler linha do teclado
               linha = IO.readln ( );
            // armazenar em um posicao da matriz
            // como objeto em String
               tabela [ x ][ y ] = linha;
            } // fim repetir
         } // fim repetir
      } // fim se
   } // fim readMatrix ( )
} // fim da classe Matriz
//---------------------------------------------- definicao da classe principal
public class Exemplo0204
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
   /**
* Testar entrada e saida de dados em matriz usando classe.
*/
   public static void metodo03 ( )
   {
   // 1. definir dados
      Matriz a3 = new Matriz ( 3, 3 );
   // 2. identificar
      IO.println ( );
      IO.println ( "Entrada e saida em matriz" );
      IO.println ( );
   // 3. testar entrada e saida em matriz
      if ( a3 == null )
      {
         IO.println ( "Matriz a3 nula" );
      }
      else
      {
      // mostrar informacoes sobre matriz
         IO.println ( "Matriz a3 nao nula com "+a3.lines( )+"x"+a3.columns( )+" posicoes." );
      // mostrar dados no matriz
         IO.println ( "Mostrar dados lidos e armazenados:" );
         a3.printMatrix ( );
      } // fim se
   // 4. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo03( )
   /**
* Testar entrada e saida de dados em matriz usando classe.
*/
   public static void metodo04 ( )
   {
   // 1. definir dados
      Matriz a3 = new Matriz ( 3, 3 );
   // 2. identificar
      IO.println ( );
      IO.println ( "Entrada e saida em matriz" );
      IO.println ( );
   // 3. testar entrada e saida em matriz
      if ( a3 == null )
      {
         IO.println ( "Matriz a3 nula" );
      }
      else
      {
      // mostrar informacoes sobre matriz
         IO.println ( "Matriz a3 nao nula com "+a3.lines( )+"x"+a3.columns( )+" posicoes." );
      // ler dados e guardar no matriz
         a3.readMatrix ( "Entrar com dados na matriz:" );
      // mostrar dados na matriz
         IO.println ( "Mostrar dados lidos e armazenados:" );
         a3.printMatrix ( );
      } // fim se
   // 4. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo04( )
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0204 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo04();
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
   
} // fim class Exemplo0204