/**
 * Exemplo0101
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca
 * Versao 01
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0101
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo01 ( int x )
   {
   // testar se valor positivo
      if ( x > 0 )
      {
      // mostrar valor
         IO.println ( "Valor lido = " + x );
      // tentar fazer de novo com valor menor
         metodo01 ( x-1 );
      } // fim se
   } // fim metodo01( )
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0101 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo01 ( 5 );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0101
/*
   Versao      Teste    
   1           1        metodo01 ( 5 );
                        Valor lido = 5
                        Valor lido = 4
                        Valor lido = 3
                        Valor lido = 2
                        Valor lido = 1
*/ 
