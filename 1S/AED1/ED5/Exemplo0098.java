/**
* Exemplo0098
*
* Matricula: 628826
* Aluno: Rodrigo Padilha Fonseca
* Versao 18
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0098
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo01 ( int x )
   {
   // repetir enquanto valor maior que zero
      while ( x > 0 )
      {
      // mostrar valor
         IO.println ( "Valor = " + x );
      // passar ao próximo
         x = x - 1;
      } // fim se
   } // fim metodo01( )
   public static void metodo02 ( int x )
   {
   // definir dado local
      int y = x;
   // repetir enquanto valor maior que zero
      while ( y > 0 )
      {
      // mostrar valor
         IO.println ( "Valor = " + y );
      // passar ao próximo
         y = y - 1;
      } // fim se
   } // fim metodo02( )
   public static void metodo03 ( int x )
   {
   // definir dado local
      int y;
   // repetir enquanto valor maior que zero
      for ( y = x; y > 0; y = y - 1 )
      {
      // mostrar valor
         IO.println ( "Valor = " + y );
      } // fim se
   } // fim metodo03( )
   public static void metodo04 ( int x )
   {
   // definir dado local
      int y;
   // repetir enquanto valor maior que zero
      for ( y = 1; y <= x; y = y + 1 )
      {
      // mostrar valor
         IO.println ( "Valor = " + y );
      } // fim se
   } // fim metodo04( )
   public static void metodo05 ( int x )
   {
   // definir dado local
      int y;
      int z = 1;
   // repetir enquanto valor maior que zero
      for ( y = 1; y <= x; y = y + 1 )
      {
      // mostrar valor
         IO.println ( "Valor = " + z );
      // passar ao proximo
         z = z + 2;
      } // fim se
   } // fim metodo05( )
   public static void metodo06 ( int x )
   {
   // definir dado local
      int y;
      int z = 1;
   // repetir enquanto valor maior que zero
      IO.println ( "Valor = " + z );
      z = 2;
      for ( y = 1; y < x; y = y + 1 )
      {
      // mostrar valor
         IO.println ( "Valor = " + z );
      // passar ao proximo
         z = z + 2;
      } // fim se
   } // fim metodo06( )
   public static void metodo07 ( int x )
   {
   // definir dado local
      int y;
      int z;
   // repetir enquanto valor maior que zero
      IO.println ( "Valor = 1/1" );
      z = 3;
      for ( y = 2; y <= x; y = y + 1 )
      {
      // mostrar valor
         IO.println ( "Valor = " + (z-1) + "/" + z );
      // passar ao proximo
         z = z + 2;
      } // fim se
   } // fim metodo07( )
   public static void metodo08 ( int x )
   {
   // definir dado local
      int y;
      int z;
      double soma = 1.0;
   // repetir enquanto valor maior que zero
      IO.println ( "Valor = 1/1" );
      z = 3;
      for ( y = 2; y <= x; y = y + 1 )
      {
      // mostrar valor
         IO.println ( "Valor = " + (z-1) + "/" + z );
      // somar uma parcela
         soma = soma + 1.0 * (z-1) / z;
      // passar ao proximo
         z = z + 2;
      } // fim se
   // mostrar o resultado
      IO.println ( "Soma = " + soma );
   } // fim metodo08( )
   public static double metodo09 ( int x )
   {
   // definir dado local
      int y;
      int z;
      double soma = 1.0;
   // repetir enquanto valor maior que zero
      IO.println ( "Valor = 1/1" );
      z = 3;
      for ( y = 1; y < x; y = y + 1 )
      {
      // mostrar valor
         IO.println ( "Valor = " + (z-1) + "/" + z );
      // somar uma parcela
         soma = soma + 1.0 * (z-1) / z;
      // passar ao proximo
         z = z + 2;
      } // fim se
   // retornar a resposta
      return ( soma );
   } // fim metodo09( )
   public static double metodo10 ( int x )
   {
   // definir dado local
      int y;
      int numerador = 1;
      int denominador = 1;
      double soma = (double) numerador / denominador;
   // repetir enquanto valor maior que zero
      IO.println ( ""+soma );
      for ( y = 1; y < x; y = y + 1 )
      {
      // passar ao proximo numerador
         numerador = y * 2;
      // passar ao proximo denominador
         denominador = denominador + 2;
      // mostrar valor
         IO.println ( "+ " + numerador + "/" + denominador );
      // somar uma parcela
         soma = soma + 1.0 * numerador / denominador;
      } // fim se
   // retornar a resposta
      return ( soma );
   } // fim metodo10( )
   public static void metodo11 ()
   {
      int x;
      int y;
      int z=0;
      IO.println("Inserir quantidade: ");
      x=IO.readint();
      for (y=0;y<x;y=y+1)
      {
         z=z+3;
         IO.println("Valor = "+z);
      }
   }
   public static void metodo12 ()
   {
      int x;
      int y;
      int z=0;
      IO.println("Inserir quantidade: ");
      x=IO.readint();
      for (y=0;y<x;y=y+1)
      {
         z=z+6;
         IO.println("Valor = "+z);
      }
   }
   public static void metodo13 ()
   {
      int x;
      int y;
      IO.println("Inserir quantidade: ");
      x=IO.readint();
      int z=6*x;
      for (y=x;y>0;y=y-1)
      {
         z=z-3;
         if (z%2==0)
         {
            z=z-3;
         }
         IO.println("Valor = "+z);
      }
   }
   public static void metodo14 ()
   {
      int x;
      int y;
      int numerador=1;
      int denominador=0;
      IO.println("Inserir quantidade: ");
      x=IO.readint();
      for (y=0;y<x;y=y+1)
      {
         denominador=denominador+5;
         IO.println("Valor = "+numerador+"/"+denominador);
      }
   }
   public static void metodo15 ()
   {
      int x;
      int y;
      int numerador=1;
      int denominador=1;
      IO.println("Inserir quantidade: ");
      x=IO.readint();
      for (y=0;y<x;y=y+1)
      {
         denominador=denominador*3;
         IO.println("Valor = "+numerador+"/"+denominador);
      }
   }
   public static void metodo16 ()
   {
      int w=0;
      int x;
      int y;
      IO.println("Inserir quantidade: ");
      x=IO.readint();
      int z=0;
      for (y=x;y>0;y=y-1)
      {
         w=w+2;
         if (w%3==0)
         {
            w=w+2;
         }
         IO.println("Valor = "+w);
         z=z+w;
      }
      IO.println("Soma = "+z);
   }
   public static void metodo17 ()
   {
      int x;
      int y;
      int numerador=1;
      int denominador=0;
      double soma=0;
      IO.println("Inserir quantidade: ");
      x=IO.readint();
      for (y=0;y<x;y=y+1)
      {
         denominador=denominador+2;
         if (denominador%3==0)
         {
            denominador=denominador+2;
         }
         IO.println("Valor = "+numerador+"/"+denominador);
         soma=soma+(0.0+numerador)/denominador;
      }
      IO.println("Soma = "+soma);
   }
   public static void metodo18 ()
   {
      int w=0;
      int x;
      int y;
      IO.println("Inserir quantidade: ");
      x=IO.readint();
      int soma=0;
      for (y=x;y>0;y=y-1)
      {
         w=w+1;
         IO.println("Valor = "+w);
         soma=soma+w;
      }
      IO.println("Soma = "+soma);
   }
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0098 - Programa em Java" );
      IO.println ( "Autor: Rodrigo Padilha Fonseca" );
      IO.println ( );
   // receber o resultado
      metodo18();
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0098
/* ---------------------------------- testes
// Versao          Teste
// 11              01.  EXEMPLO0091 - Programa em Java
                        Autor: Rodrigo Padilha Fonseca 
                        Inserir quantidade: 
                        5
                        Valor = 3
                        Valor = 6
                        Valor = 9
                        Valor = 12
                        Valor = 15
                        Apertar ENTER para terminar
  12             01.    Inserir quantidade: 
                        5
                        Valor = 6
                        Valor = 12
                        Valor = 18
                        Valor = 24
                        Valor = 30
                        Apertar ENTER para terminar.
  13             01.    Inserir quantidade: 
                        5
                        Valor = 27
                        Valor = 21
                        Valor = 15
                        Valor = 9
                        Valor = 3
                        Apertar ENTER para terminar.
  14             01.    Inserir quantidade: 
                        5
                        Valor = 1/5
                        Valor = 1/10
                        Valor = 1/15
                        Valor = 1/20
                        Valor = 1/25
  15             01.    Inserir quantidade: 
                        5
                        Valor = 1/3
                        Valor = 1/9
                        Valor = 1/27
                        Valor = 1/81
                        Valor = 1/243
 16              01.    Inserir quantidade: 
                       3
                       Valor = 2
                      Valor = 4
                      Valor = 8
                      Soma = 14
                 02.    Inserir quantidade: 
                        5
                      Valor = 2
                      Valor = 4
                      Valor = 8
                      Valor = 10
                      Valor = 14
                      Soma = 38
 17              01.    Inserir quantidade: 
                       3
                      Valor = 1/2
                      Valor = 1/4
                      Valor = 1/8
                      Soma = 0.875 
               02.    Inserir quantidade: 
                        5
                       Valor = 1/2
                       Valor = 1/4
                      Valor = 1/8
                      Valor = 1/10
                      Valor = 1/14
                       Soma = 1.0464285714285715
 18              01.   Inserir quantidade: 
                       5
                     Valor = 1
                     Valor = 2
                     Valor = 3
                     Valor = 4
                     Valor = 5
                     Soma = 15
               02.   Inserir quantidade: 
                       6
                      Valor = 1
                     Valor = 2
                      Valor = 3
                      Valor = 4
                      Valor = 5
                     Valor = 6
                      Soma = 21
*/