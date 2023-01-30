/**
 * Exemplo0116
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca
 * Versao 16
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0116
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static int metodo11 (  int x )
   {
      int soma = 0;
      if ( x > 0 )
      {
         soma = soma + (1+x*2) + metodo11 ( x-1 );
      }
      return ( soma );
   }
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0116 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      int x;
      x=IO.readint("Quantidade: ");
      IO.print("Soma = "+metodo11(x));
      IO.println("");
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0116
/*
   Versao      Teste    
   16          1       Quantidade: 3
                       Soma = 15
               2       Quantidade: 5
                       Soma = 35 
*/ 
