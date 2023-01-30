/**
 * Exemplo0126
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca
 * Versao 06
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0126
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
   /**
 * recuperar dados inteiros em arquivo,
 * dada a quantidade deles na primeira linha.
 */
   public static void metodo05 ( )
   {
   // 1. definir dados
      int n, k, dado;
      String linha;
      FILE arquivo;
   // 2. identificar
      IO.println ( );
      IO.println ( "Consultar dados em arquivos" );
      IO.println ( );
   // 3. abrir arquivo para a leitura
      arquivo = new FILE ( FILE.INPUT, "DADOS2.TXT" );
   
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
         // converter conteudo para valor inteiro
            dado = IO.getint ( linha );
         // mostrar dado na tela
            IO.println ( "" + dado );
         } // fim repetir
      // fechar o arquivo (RECOMENDAVEL para a leitura)
         arquivo.close ( );
      } // fim se
   // 6. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo05 ( )
/**
 * guardar dados reais em arquivo,
 * dada a quantidade deles.
 */
   public static void metodo06 ( )
   {
   // 1. definir dados
      int n, k;
      double dado;
      FILE arquivo;
   // 2. identificar
      IO.println ( "Guardar dados reais em arquivos" );
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
         arquivo = new FILE ( FILE.OUTPUT, "DADOS3.TXT" );
      // guardar a quantidade de dados
         arquivo.println ( ""+n );
      // ler os outros dados do teclado
         for ( k = 1; k <= n; k = k + 1 )
         {
         // ler um dado do teclado
            dado = IO.readdouble ( "Dado = " );
         // guardar dado em arquivo
            arquivo.println ( ""+dado );
         } // fim repetir
      // fechar o arquivo (INDISPENSAVEL para a gravacao)
         arquivo.close ( );
      } // fim se
   // 5. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo06 ( )
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0126 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo06 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0126
/*
   Teste          Versao
   1              6        Guardar dados reais em arquivos
                          Fornecer a quantidade de valores: 5
                          Dado = 12.4
                         Dado = 5.23
                         Dado = 6.2
                         Dado = 1.566
                         Dado = 7576.1
*/