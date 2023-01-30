/**
* Exemplo0194
*
* Aluno: Rodrigo Padilha Fonseca
* Matricula: 628826
* Versao 14
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
} // fim da classe Arranjo
// ---------------------------------------------- definicao da classe principal
public class Exemplo0194
{
// ---------------------------------------------- definicao de metodo auxiliar
/**
* Testar definições de arranjo usando classe.
*/
   public static int toFile ( int [] arranjo )
   {
      FILE arquivo = new FILE ( FILE.OUTPUT, nome );
      int tamanho = arranjo.length;
      if ( arranjo == null )
      {
         IO.println ( "Erro: Arranjo nulo" );
      }
      else
      {
         if ( tamanho <= 0 )
         {
            IO.println( "Erro: Tamanho invalido" );
         }
         else
         {
            for ( int i = 0; i < tamanho; i = i+1 )
            {
               arquivo.println(""+arranjo[i]);
            }
         }
      }
      return ( arranjo );
   }
   public static void metodo01 ( )
   {
      FILE arquivo = new FILE ( FILE.INPUT, "Exemplo0194.txt" );
      String linha = arquivo.readln();
      if ( linha == null )
      {
         IO.println( "Erro: Arranjo nulo" );
      }
      else
      {
         int tamanho = IO.getint(linha);
         if ( tamanho <= 0 )
         {
            IO.println ("Erro: Tamanho invalido" );
         }
         else
         {
            for ( int i = 0; i < tamanho; i = i+1 )
            {
               linha = arquivo.readln();
               arranjo[i] = IO.getint(linha);
            }
         }
      }
   }
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0194 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padiha Fonseca" );
   // executar o metodo auxiliar
      metodo01 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0194