/**
 * Exemplo0137
 *
 * Matricula: 628826
 * Aluno: Rodrigo Padilha Fonseca
 * Versao 17
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0137
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo17 ( )
   {
      FILE arquivo;
      int z=IO.readint("Quantidade: ");
      double denominador=3.0;
      double soma=0.0;
      arquivo = new FILE ( FILE.OUTPUT, "Exemplo0137.TXT" );
      for ( int x=1; x<=z; x=x+1 )
      {
         arquivo.println("1/"+denominador);
         soma=soma+1/denominador;
         denominador=denominador+2;
      }
      arquivo.println("Soma = "+soma);
      arquivo.close( );
   } 
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0137 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
   // executar o metodo auxiliar
      metodo17 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0137
/*
   Teste          Versao
   1              17       Quantidade: 5
                           Exemplo0137.TXT
                           1/3.0
                           1/5.0
                           1/7.0
                           1/9.0
                           1/11.0
                           Soma = 0.8782106782106783
                           Quantidade: 3
                           Exemplo0137.TXT:
                           1/3.0
                           1/5.0
                           1/7.0
                           Soma = 0.6761904761904762

*/