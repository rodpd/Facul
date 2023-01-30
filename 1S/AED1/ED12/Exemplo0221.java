/**
 * Exemplo0221
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca   
 * Versao 01
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
} // fim da classe Contato
// ---------------------------------------------- definicao da classe principal
public class Exemplo0221
{
// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * Testar definições da classe Contato.
 */
   public void metodo01 ( )
   {
   // 1. definir dados
      Contato a1 = null;
      Contato a2 = new Contato ( );
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
   // encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo01 ( )
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0201 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // criar e executar o metodo auxiliar
      Exemplo0221 m1 = new Exemplo0221 ( );
      m1.metodo01 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0221
/*
   Versao   Teste
   01       01
                     Definicoes da Contato
                     Contato a1 nulo
                     Contato a2 nao nulo
*/