/**
* Exemplo0193
*
* Aluno: Rodrigo Padilha Fonseca
* Matricula: 628826
* Versao 13
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
public class Exemplo0193
{
// ---------------------------------------------- definicao de metodo auxiliar
/**
* Testar definições de arranjo usando classe.
*/
   public static int fromFile ( String nome )
   {
      FILE arquivo = new FILE ( FILE.INPUT, nome );
      String linha = arquivo.readln();
      if ( linha == null )
      {
         IO.println ( "Erro: Arranjo nulo" );
      }
      else
      {
         int tamanho = IO.getint(linha);
         if ( tamanho <= 0 )
         {
            IO.println( "Erro: Tamanho invalido" );
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
      return ( arranjo );
   }
   public static void metodo01 ( )
   {
      int [] arranjo;
      arranjo = fromFile("Exemplo0193.txt");
      int tamanho = arranjo.length;
      if ( arranjo == null )
      {
         IO.println ("Erro: Arranjo nulo");
      }
      else
      {
         if ( tamanho <= 0 )
         {
            IO.println ( "Erro: Tamanho invalido ");
         }
         else
         {
            for ( int i = 0; i < tamanho; i = i+1 )
            {
               IO.println(arranjo[i]);
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
      IO.println ( "EXEMPLO0193 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padiha Fonseca" );
   // executar o metodo auxiliar
      metodo01 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0193