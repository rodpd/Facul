/**
 * Exemplo0232
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca   
 * Versao 12
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
 * estabelecer novo nome.
 */
   public void setNome ( String novoNome )
   {
      nome = novoNome;
   } // end setNome ( )
 /**
 * estabelecer novo telefone.
 */
   public void setFone ( String novoFone )
   {
      fone = novoFone;
   } // end setFone ( )
    /**
 * obter os conteudos do objeto.
 *
 * @return dados contidos no objeto.
 */
   public String toString ( )
   {
      return ( ""+nome+" - "+fone );
   } // end toString ( )
 /**
 * clonar os conteudos do objeto.
 *
 * @return copia dos dados contidos no objeto.
 */
   public Contato clone ( )
   {
      Contato copia = new Contato ( );
      if ( copia == null || hasErro( ) )
      {
         setErro ( 3 ); // ERRO: Problema ao copiar.
      }
      else
      {
         if ( copia != null )
         {
            copia.setNome ( getNome( ) );
            copia.setFone ( getFone( ) );
         } // fim se
      } // fim se
      return ( copia );
   } // end clone ( )
    /**
 * construtor alternativo.
 */
   public Contato (String nomeInicial, String foneInicial )
   {
   // testar e inserir valores iniciais
      setErro ( 0 ); // ainda nao há erro
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
               setNome ( nomeInicial );
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
               setFone ( foneInicial );
            }
         }
      }
   } // fim construtor alternativo
   public void readNome ( String s )
   {
      String novo = IO.readString ( s );
      setNome ( novo );
   }
   public void readFone ( String s )
   {
      String novo = IO.readString ( s );
      setFone ( novo );
   }
} // fim da classe Contato
// ---------------------------------------------- definicao da classe principal
public class Exemplo0232
{
// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * Testar definições da classe Contato.
 */
   public void metodo12 ( )
   {
   // 1. definir dados
      Contato a1 = new Contato ( );
      a1.readFone( "Fone: " );
      IO.println ( "Fone de a1: " + a1.getFone( ) );
   // encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo12 ( )
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0232 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // criar e executar o metodo auxiliar
      Exemplo0232 m1 = new Exemplo0232 ( );
      m1.metodo12 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0232
/*
   Versao   Teste
   12       01
                     Fone: 7777-7777
                     Fone de a1: 7777-7777
*/