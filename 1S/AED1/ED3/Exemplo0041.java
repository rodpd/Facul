/**
* Exemplo0041
* 
* Matricula: 628826
* Aluno: Rodrigo Padilha Fonseca
* Versao 01
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0041
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
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
public static void main ( String [ ] args )
{
// identificar
IO.println ( "EXEMPLO0041 - Programa em Java" );
IO.println ( "Autor: Rodrigo Padilha Fonseca" );
// executar o metodo auxiliar
metodo01 ( ); // ler e mostrar valor inteiro
// encerrar
IO.pause ( "Apertar ENTER para terminar." );
} // fim main( )
} // fim class Exemplo0041// ---------------------------------------------- documentacao complementar
//
// ---------------------------------------------- historico
//
// Versao      Data     Modificacao
// 0.1         01/03    esboco
//
// ---------------------------------------------- testes
//
// Versao      Teste
// 0.1         01. (ok)    identificacao de programa e leitura
//                         Valores previstos: 5, 0, -5
// 