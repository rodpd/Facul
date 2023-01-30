/**
 * Exemplo0233
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca   
 * Versao 13
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
               if ( !(foneInicial.charAt(i) >= '0' ) && !(foneInicial.charAt(i) <= '9' ) && foneInicial.charAt(4) != '-' )
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
   public void testFone ( )
   {
      boolean resultado = false;
      if ( getFone( ) == null )
      {
         IO.println ( "Erro: Telefone nulo " );
      }
      else
      {
         int tamanho = getFone().length( );
         if ( tamanho != 9 )
         {
            IO.println ( "Erro: Tamanho invalido " );
         }
         else
         {
            resultado = true;
            for ( int i = 0; i < tamanho; i++ )
            {
               if ( i != 4 )
               {
                  char c = getFone().charAt(i);
                  if ( c <= '0' || c >= '9' )
                  {
                     resultado = false;
                  }
               }
            }
            if ( getFone().charAt(4) != '-' )
            {
               resultado = false;
            }
         }
      }
      if ( resultado )
      {
         IO.println ( "Valor de telefone valido" );
      }
      else
      {
         IO.println ( "Valor de telefone invalido" );
      }
   }
} // fim da classe Contato
// ---------------------------------------------- definicao da classe principal
public class Exemplo0233
{
// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * Testar definições da classe Contato.
 */
   public void metodo13 ( )
   {
   // 1. definir dados
      Contato a1 = new Contato ( );
      a1.readFone( "Fone: " );
      a1.testFone( );
      // encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo13 ( )
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0233 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // criar e executar o metodo auxiliar
      Exemplo0233 m1 = new Exemplo0233 ( );
      m1.metodo13 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0233
/*
   Versao   Teste
   13       01
                     Fone: 1234-5678
                     Valor de telefone valido
            02
                     Fone: 123-45678
                     Valor de telefone invalido
            03
                     Fone: abcd-efgh
                     Valor de telefone invalido
*/