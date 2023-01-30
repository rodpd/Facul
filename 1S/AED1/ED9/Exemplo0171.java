/**
* Exemplo0171
*
* Aluno: Rodrigo Padilha Fonseca
* Matricula: 628826
* Versao 11
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0171
{
// ---------------------------------------------- definicao de metodo auxiliar
/**
* ler valores inteiros de arquivo e guardar em uma matriz.
* @return tabela com os valores lidos de arquivo
* @param nome do arquivo com os dados
*/
   public static int [ ] [ ] funcao01 ( String x, String y )
   {
      if ( x == null || y == null )
      {
         IO.println ( "Erro: Matriz vazia " );
      }
      else
      {
         int linha = IO.getint( x );
         int coluna = IO.getint ( y );
         if ( linha <= 0 || coluna <= 0 )
         {
            IO.println ( "Erro: Tamanho invalido ");
         }
         else
         {
            int [ ] [ ] matriz = new int [linha] [coluna];
            for ( int j = 0; j < coluna; j = j+1 )
            { 
               for ( int i = 0; i < linha; i = i+1 )
               {
                  int z = IO.readint ( "Digite um valor real: ");
                  if ( z <= 0 )
                  {
                     IO.println ( "O valor deve ser maior que 0" );
                  }
                  else
                  {
                     matriz [i] [j] = z;
                  }
               }
            }
            return ( matriz );
         }
      }
   }
   public static void metodo01 ( )
   {
      String x = IO.readString ( "Qual a quantidade de linhas? " );
      String y = IO.readString ( "Qual a quantidade de colunas? " );
      if ( x == null || y == null )
      {
      IO.println ( "Erro: Matriz vazia" );
      }
      else
      {
      int linha = IO.getint ( x );
      int coluna = IO.getint ( y );
      
      int [ ] [ ] matriz = funcao01( x, y);
      for ( int j = 0; j <
      IO.println ( matriz );
   }
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0141 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca " );
   // executar o metodo auxiliar
      metodo01 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0141
/*
Versao      Teste    
11          01
*/