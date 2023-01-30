/**
 * Exemplo0122
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca
 * Versao 02
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0122
{
// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * guardar dados em arquivo,
 * dada a quantidade deles.
 */
   public static void metodo01 ( )
   {
   // 1. definir dados
      int n;
      int k;
      String dado;
      FILE arquivo;
   // 2. identificar
      IO.println ( "Guardar dados em arquivos" );
   // 3. ler dado do teclado
      n = IO.readint ( "Quantos nomes? " );
   // 4. testar a quantidade
      if ( n <= 0 )
      {
         IO.println ( "ERRO: Quantidade invalida." );
      }
      else
      {
      // criar arquivo para gravar dados
         arquivo = new FILE ( FILE.OUTPUT, "DADOS1.TXT" );
      // guardar a quantidade de dados em arquivo
         arquivo.println ( ""+ n );
      // ler os outros dados do teclado
         for ( k = 1; k <= n; k = k + 1 )
         {
         // ler um dado do teclado
            dado = IO.readString ( "Nome = " );
         // guardar dado em arquivo
            arquivo.println ( ""+dado );
         } // fim repetir
      // fechar o arquivo (INDISPENSAVEL para a gravacao)
         arquivo.close ( );
      } // fim se
   // 5. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo01( )
   /**
 * consultar dados em arquivo.
 */
   public static void metodo02 ( )
   {
   // 1. definir dados
      String linha;
      FILE arquivo;
   // 2. identificar
      IO.println ( "Consultar dados em arquivos" );
   // 3. abrir arquivo para a leitura
      arquivo = new FILE ( FILE.INPUT, "DADOS1.TXT" );
   // 4. ler linhas do arquivo
   // tentar ler uma linha do arquivo
      linha = arquivo.readln ( );
   // repetir enquanto houver dado
      while ( ! arquivo.eof ( ) )
      {
      // mostrar dado na tela
         IO.println ( "" + linha );
      // tentar ler outra linha do arquivo
         linha = arquivo.readln ( );
      } // fim repetir
   // fechar o arquivo (RECOMENDAVEL para a leitura)
      arquivo.close ( );
   // 5. encerrar
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
      IO.println ( "EXEMPLO0122 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo02 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0122
/*
   Teste          Versao
   1              2       EXEMPLO0122 - Programa em Java
                         Autor: Rodrigo Padilha Fonseca
                       Consultar dados em arquivos
                       3
                       rodrigo
                       thiago
                       diego

*/