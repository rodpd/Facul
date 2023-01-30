/**
 * Exemplo0124
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca
 * Versao 04
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0124
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
   /**
 * recuperar dados em arquivo,
 * dada a quantidade deles na primeira linha.
 */
   public static void metodo03 ( )
   {
   // 1. definir dados
      int n, k;
      String linha;
      FILE arquivo;
   // 2. identificar
      IO.println ( "Consultar dados em arquivos" );
   // 3. abrir arquivo para a leitura
      arquivo = new FILE ( FILE.INPUT, "DADOS1.TXT" );
   // 4. ler quantidade de dados do arquivo
   // 4.1 ler uma linha do arquivo
      linha = arquivo.readln ( );
   // 4.2 converter conteudo para valor inteiro
      n = IO.getint ( linha );
   // 5. testar a quantidade
      if ( n <= 0 )
      {
         IO.println ( "ERRO: Quantidade invalida." );
      }
      else
      {
      // mostrar a quantidade de dados
         IO.println ( "Quantidade de dados = " + n );
      // ler os outros dados do arquivo
         for ( k = 1; k <= n; k = k + 1 )
         {
         // ler uma linha do arquivo
            linha = arquivo.readln ( );
         // mostrar dado na tela
            IO.println ( "" + linha );
         } // fim repetir
      // fechar o arquivo (RECOMENDAVEL para a leitura)
         arquivo.close ( );
      } // fim se
   // 6. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo03 ( )
   /**
 * guardar dados inteiros em arquivo,
 * dada a quantidade deles.
 */
   public static void metodo04 ( )
   {
   // 1. definir dados
      int n, k, dado;
      FILE arquivo;
   // 2. identificar
      IO.println ( "Guardar dados inteiros em arquivos" );
   // 3. ler dado do teclado
      n = IO.readint ( "Fornecer a quantidade de valores: " );
   // 4. testar a quantidade
      if ( n <= 0 )
      {
         IO.println ( "ERRO: Quantidade invalida." );
      }
      else
      {
      // criar arquivo para gravar dados
         arquivo = new FILE ( FILE.OUTPUT, "DADOS2.TXT" );
      // guardar a quantidade de dados
         arquivo.println ( ""+n );
      // ler os outros dados do teclado
         for ( k = 1; k <= n; k = k + 1 )
         {
         // ler um dado do teclado
            dado = IO.readint ( "Dado = " );
         // guardar dado em arquivo
            arquivo.println ( ""+dado );
         } // fim repetir
      // fechar o arquivo (INDISPENSAVEL para a gravacao)
         arquivo.close ( );
      } // fim se
   // 5. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo04 ( )
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() � metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0124 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo04 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0124
/*
   Teste          Versao
   1              4        EXEMPLO0124 - Programa em Java
                         Autor: Rodrigo Padilha Fonseca
                        Guardar dados inteiros em arquivos
                         Fornecer a quantidade de valores: 5
                        Dado = 123
                        Dado = 159
                        Dado = 145
                        Dado = 165
                        Dado = 215
*/