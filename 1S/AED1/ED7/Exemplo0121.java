/**
 * Exemplo0121
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca
 * Versao 01
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0121
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
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0121 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo01 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0121
/*
   Teste          Versao
   1              1        EXEMPLO0121 - Programa em Java
                         Autor: Rodrigo Padilha Fonseca
                          Guardar dados em arquivos
                          Quantos nomes? 3
                        Nome = rodrigo
                        Nome = thiago
                        Nome = diego
*/