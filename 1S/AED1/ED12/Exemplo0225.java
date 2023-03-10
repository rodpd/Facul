/**
 * Exemplo0225
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca   
 * Versao 05
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
 * tratamento de erro.
 Codigos de erro:
 1. Nome invalido.
 2. Fone invalido.
 */
   private int erro;
    /**
 * indicar a existencia de erro.
 */
   public boolean hasErro ( )
   {
      return ( getErro( ) != 0 );
   } // end hasErro ( )
 /**
 * obter o codigo de erro.
 */
   public int getErro ( )
   {
      return ( erro );
   } // end getErro ( )
 /**
 * estabelecer novo codigo de erro.
 */
   private void setErro ( int codigo )
   {
      erro = codigo;
   } // end setErro ( )
 /**
 * atributos.
 */
   private String nome;
   private String fone;
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
 * obter o nome.
 */
   public String getNome ( )
   {
      return ( nome );
   } // end getNome ( )
 /**
 * obter o telefone.
 */
   public String getFone ( )
   {
      return ( fone );
   } // end getFone ( )
    /**
 * construtor alternativo.
 */
   public Contato (String nomeInicial, String foneInicial )
   {
   // testar e inserir valores iniciais
      setErro ( 0 ); // ainda nao h? erro
      if ( nomeInicial == null )
      {
         IO.println ( "Erro: Nome nulo " );
         setErro ( 1 );
      }
      else
      {
         int tamanho = nomeInicial.length();
         if ( tamanho <= 0 )
         {
            IO.println ( "Erro: Nome vazio " );
            setErro ( 1 );
         }
         else
         {
            for ( int i = 0; i < tamanho; i++ )
            {
               if ( !(nomeInicial.charAt(i) >= 'a') && !(nomeInicial.charAt(i) <= 'z') 
               || !(nomeInicial.charAt(i) >= 'A' ) && !(nomeInicial.charAt(i) >= 'Z') )
               {
                  IO.println ( "Erro: nome pode conter apenas letras " );
                  setErro ( 1 );
               }
            }
            if ( getErro ( ) != 1 )
            {
               nome = nomeInicial;
            }
         }
      }
      if ( foneInicial == null )
      {
         IO.println ( "Erro: numero nulo" );
         setErro ( 2 );
      }
      else
      {
         int tamanho2 = foneInicial.length();
         if ( tamanho2 != 9 )
         {
            IO.println ( "Erro: Tamanho de numero invalido" );
            setErro ( 2 );
         }
         else
         {
            for ( int i = 0; i < tamanho2; i++ )
            {
               if ( !(foneInicial.charAt(i) >= '0' ) && !(foneInicial.charAt(i) <= '9' ) || foneInicial.charAt(4) != '-' )
               {
                  IO.println ( "Erro: numero deve conter 8 digitos e ser dividido ao meio por um traco " );
                  setErro( 2 );
               }
            }
            if ( getErro ( ) != 2 )
            {
               fone = foneInicial;
            }
         }
      }
   } // fim construtor alternativo
} // fim da classe Contato
// ---------------------------------------------- definicao da classe principal
public class Exemplo0225
{
// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * Testar defini??es da classe Contato.
 */
   public void metodo05 ( )
   {
   // 1. definir dados
      Contato a1 = new Contato ( "", "1111-1111" );
      Contato a2 = new Contato ( "nome1", null );
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
         if ( a1.hasErro ( ) )
         {
            IO.println ( "Contato a1 com erro " + a1.getErro ( ) );
         }
         else
         {
            IO.println ( "Contato a1 nao nulo com "+a1.getNome( )+" e " + a1.getFone( ) );
         } // fim se
      } // fim se
      if ( a2 == null )
      {
         IO.println ( "Contato a2 nulo" );
      }
      else
      {
         if ( a1.hasErro ( ) )
         {
            IO.println ( "Contato a2 com erro " + a2.getErro ( ) );
         }
         else
         {
            IO.println ( "Contato a2 nao nulo com "+a2.getNome( )+" e " + a3.getFone( ) );
         } // fim se
      } // fim se
      if ( a3 == null )
      {
         IO.println ( "Contato a3 nulo" );
      }
      else
      {
         if ( a3.hasErro ( ) )
         {
            IO.println ( "Contato a3 com erro " + a3.getErro ( ) );
         }
         else
         {
            IO.println ( "Contato a3 nao nulo com "+a3.getNome( )+" e " + a3.getFone( ) );
         } // fim se
      } // fim se
   
   // encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo05 ( )
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() ? metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0225 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // criar e executar o metodo auxiliar
      Exemplo0225 m1 = new Exemplo0225 ( );
      m1.metodo05 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0225
/*
   Versao   Teste
   05       01
                     Erro: Nome vazio 
                     Erro: nome pode conter apenas letras 
                     Erro: numero nulo
                     Erro: nome pode conter apenas letras 
                     Definicoes da Contato
                     Contato a1 com erro 1
                     Contato a2 com erro 2
                     Contato a3 com erro 1
*/