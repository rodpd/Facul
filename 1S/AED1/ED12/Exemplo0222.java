/**
 * Exemplo0222
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca   
 * Versao 02
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao de classe auxiliar
/**
 * Classe para tratar contatos.
 */
class Contato
{
 /**
 * atributos.
 */
   public String nome;
   public String fone;
 /**
 * construtor padrao.
 */
   public Contato ( )
   {
   // atribuir valores iniciais nulos
      nome = null;
      fone = null;
   } // fim construtor padrao
    /**
 * construtor alternativo.
 */
   public Contato (String nomeInicial, String foneInicial )
   {
   // testar e inserir valores iniciais
      nome = nomeInicial;
      fone = foneInicial;
   } // fim construtor alternativo
} // fim da classe Contato
// ---------------------------------------------- definicao da classe principal
public class Exemplo0222
{
// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * Testar definições da classe Contato.
 */
   public void metodo02 ( )
   {
   // 1. definir dados
      Contato a1 = null;
      Contato a2 = new Contato ( );
      Contato a3 = new Contato ( "nome1", "1111-1111" );
   // 2. identificar
      IO.println ( "Definicoes da Contato" );
   // 3. testar as definicoes da Contato
      if ( a1 == null )
      {
         IO.println ( "Contato a1 nulo" );
      }
      else
      {
         IO.println ( "Contato a1 nao nulo" );
      } // fim se
      if ( a2 == null )
      {
         IO.println ( "Contato a2 nulo" );
      }
      else
      {
         IO.println ( "Contato a2 nao nulo" );
      } // fim se
      if ( a3 == null )
      {
         IO.println ( "Contato a3 nulo" );
      }
      else
      {
         IO.println ( "Contato a3 nao nulo com "+a3.nome+" e " + a3.fone );
      } // fim se
   // encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo02 ( )
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0222 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // criar e executar o metodo auxiliar
      Exemplo0222 m1 = new Exemplo0222 ( );
      m1.metodo02 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0222
/*
   Versao   Teste
   02       01
                     Definicoes da Contato
                     Contato a1 nulo
                     Contato a2 nao nulo
                     Contato a3 nao nulo com nome1 e 1111-1111
*/