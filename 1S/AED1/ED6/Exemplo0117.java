/**
 * Exemplo0117
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca
 * Versao 17
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0117
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static double metodo12 (  int x )
   {
      double numerador = 1.0;
      double denominador = 1.0+2*x;
      double soma = 0;
      if ( x > 0 )
      {
         soma = numerador/denominador + metodo12 ( x-1 );
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
      IO.println ( "EXEMPLO0117 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      int x;
      x=IO.readint("Quantidade: ");
      metodo12(x);
      IO.print("Soma = "+metodo12(x));
      IO.println("");
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0117
/*
   Versao      Teste    
   17          1      Quantidade: 3
                      Soma = 0.6761904761904762
                      Quantidade: 5
                      Soma = 0.8782106782106783
*/ 
