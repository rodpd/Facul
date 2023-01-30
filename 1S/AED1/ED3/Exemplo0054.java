/**
* Exemplo0054
*
* Matricula: 628826
* Aluno: Rodrigo Padilha Fonseca
* Version 14
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0054
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo01 ( )
   {
   // definir dados
      int x;
   // identificar o metodo
      IO.println ( "Metodo 01" );
   // ler valor inteiro do teclado
      x = IO.readint ( "Entrar com um valor inteiro: " );
      IO.println ( "Valor lido = " + x );
   } // fim metodo01( )
   public static void metodo02 ( )
   {
   // definir dados
      int x;
   // definir dado para guardar o resultado
      int quantidade = 0;
   // identificar o metodo
      IO.println ( "Metodo 02" );
   // ler valor inteiro do teclado
      quantidade = IO.readint ( "Entrar com a quantidade: " );
      while ( quantidade > 0 )
      {
      // ler valor inteiro do teclado
         x = IO.readint ( "Entrar com um valor inteiro: " );
         IO.println ( "Valor lido = " + x );
      // diminuir a quantidade
         quantidade = quantidade - 1;
      } // fim repetir
   } // fim metodo02( )
   public static void metodo03 ( )
   {
   // definir dados
      int x;
   // definir dado para guardar o resultado
      int quantidade = 0;
   // definir contador
      int contador;
   // identificar o metodo
      IO.println ( "Metodo 03" );
   // ler a quantidade do teclado
      quantidade = IO.readint ( "Entrar com a quantidade: " );
      contador = quantidade;
      while ( contador > 0 )
      {
      // ler valor inteiro do teclado
         x = IO.readint ( "Entrar com um valor inteiro: " );
         IO.println ( "Valor lido = " + x );
      // contar mais um valor lido
         contador = contador - 1;
      } // fim repetir
   } // fim metodo03( )
   public static void metodo04 ( )
   {
   // definir dados
      int x;
   // definir dado para guardar o resultado
      int quantidade = 0;
   // definir contador
      int contador;
   // identificar o metodo
      IO.println ( "Metodo 04" );
   // ler a quantidade do teclado
      quantidade = IO.readint ( "Entrar com a quantidade: " );
      contador = 1;
      while ( contador <= quantidade )
      {
      // ler valor inteiro do teclado
         x = IO.readint ( "Entrar com um valor inteiro: " );
         IO.println ( "Valor lido = " + x );
      // contar mais um valor lido
         contador = contador + 1;
      } // fim repetir
   } // fim metodo04( )

   public static void metodo05 ( )
   {
   // definir dados
      int x;
   // definir dado para guardar o resultado
      int quantidade = 0;
   // definir contador
      int contador;
   // identificar o metodo
      IO.println ( "Metodo 05" );
   // ler a quantidade do teclado
      quantidade = IO.readint ( "Entrar com a quantidade: " );
      contador = 0;
      while ( contador < quantidade )
      {
      // ler valor inteiro do teclado
         x = IO.readint ( "Entrar com um valor inteiro: " );
         IO.println ( "Valor lido = " + x );
      // contar mais um valor lido
         contador = contador + 1;
      } // fim repetir
   } // fim metodo05( )
   public static void metodo06()
   {
      int x;
      int quantidade=0;
      int contador;
      IO.println("Metodo 06");
      quantidade=IO.readint("Entrar com a quantidade: ");
      contador=0;
      while(contador<quantidade)
      {
         x=IO.readint("Entrar com um valor inteiro: ");
         contador=contador+1;
      
         if (x<100)
         {
            IO.println("Valor lido = "+x);
         }
      }
   }
   public static void metodo07 ( )
   {
   // definir dados
      int x;
   // definir dado para guardar o resultado
      int quantidade = 0;
   // definir contador
      int contador;
   // identificar o metodo
      IO.println ( "Metodo 07" );
   // ler a quantidade do teclado
      quantidade = IO.readint ( "Entrar com a quantidade: " );
      contador = 0;
      while ( contador < quantidade )
      {
      // ler valor inteiro do teclado
         x = IO.readint ( "Entrar com um valor inteiro: " );
         if(x%2!=0&&x<100)
            IO.println ( "Valor lido = " + x );
      // contar mais um valor lido
         contador = contador + 1;
      } // fim repetir
   } // fim metodo07( )
   public static void metodo08 ( )
   {
   // definir dados
      double x;
   // definir dado para guardar o resultado
      int quantidade = 0;
   // definir contador
      int contador;
   // identificar o metodo
      IO.println ( "Metodo 08" );
   // ler a quantidade do teclado
      quantidade = IO.readint ( "Entrar com a quantidade: " );
      contador = 0;
      while ( contador < quantidade )
      {
      // ler valor inteiro do teclado
         x = IO.readdouble ( "Entrar com um valor real: " );
         if(x%2.0!=0.0&&x<=225.00&&x>=15.00)
            IO.println ( "Valor lido = " + x );
      // contar mais um valor lido
         contador = contador + 1;
      } // fim repetir
   } // fim metodo08( )
   public static void metodo09 ( )
   {
   // definir dados
      double x;
   // definir dado para guardar o resultado
      int quantidade = 0;
   // definir contador
      int contador;
   // identificar o metodo
      IO.println ( "Metodo 09" );
   // ler a quantidade do teclado
      quantidade = IO.readint ( "Entrar com a quantidade: " );
      contador = 0;
      while ( contador < quantidade )
      {
      // ler valor inteiro do teclado
         x = IO.readdouble ( "Entrar com um valor real: " );
         if(x<100&&x>=0)
         IO.println ( "Valor lido = "+ (int)x );
      // contar mais um valor lido
         contador = contador + 1;
      } // fim repetir
   } // fim metodo09( )
// ---------------------------------------------- definicao do metodo principal
/**
* main() metodo principal
*/
   public static void main ( String [ ] args )
   {
   // definir dado
      int opcao;
      int contador = IO.readint("Quantas vezer quer executar o programa?");
      do
      {
      // identificar
         IO.println ( "EXEMPLO0054 - Programa em Java" );
         IO.println ( "Autor: Rodrigo Padilha Fonseca" );
      // mostrar opcoes
         IO.println ( "Opcoes:" );
         IO.println ( "0 - Parar");
         IO.println ( "1 - Metodo 01" );
         IO.println ( "2 - Metodo 02" );
         IO.println ( "3 - Metodo 03" );
         IO.println ( "4 - Metodo 04" );
         IO.println ( "5 - Metodo 05" );
         IO.println("6 - Metodo 06");
         IO.println("7 - Metodo 07");
         IO.println("8 - Metodo 08");
         IO.println("9 - Metodo 09");
      // ler a opcao do teclado
         opcao = IO.readint ( "Qual a sua opcao? " );
      // escolher qual metodo executar
         switch ( opcao )
         {
            case 0: // nao faz nada
               break;
            case 1: metodo01 ( );
               break;
            case 2: metodo02 ( );
               break;
            case 3: metodo03 ( );
               break;
            case 4: metodo04 ( );
               break;
            case 5: metodo05 ( );
               break;
            case 6: metodo06();
               break;
            case 7: metodo07 ( );
               break;
            case 8: metodo08();
               break;
            case 9: metodo09();
               break;
            default:
               IO.println("ERRO:Opcao Invalida.");
         } // fim escolher
      }
      while (opcao!=0);
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0054
// -------------------------------------- documentacao complementar
//
// ---------------------------------------------- historico
//
// Versao      Data     Modificacao
// 0.1         01/03    esboco
// 0.2         01/03    
// 0.3         01/03    
// 0.4         01/03
// ---------------------------------------------- testes
//
// Versao      Teste
// 0.1         01. (ok)    identificacao de programa e leitura
//                         Valores previstos: -5, 0, 5
// 0.2         01. (ok)    Ler quantidade e mostrar valores inteiros
//                         Valores testados: -5, 0, 5
// 0.3         01. (ok)
