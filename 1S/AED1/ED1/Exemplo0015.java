// 628826-RODRIGO_PADILHA_FONSECA
/**
* Exemplo0015
*
* @author
* @version 15
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0015
{
// ---------------------------------------------- definicao de metodos
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
public static void main ( String [ ] args )
{
IO.println ( "EXEMPLO0015 - Programa em Java" );
IO.println ( "Autor:Rodrigo Padilha Fonseca" );
double x,y; // é possível definir mais de uma dado do mesmo tipo
x=IO.readdouble("Entrar com um valor real: ");
y=IO.readdouble("Entrar com um valor real: ");
IO.println("x="+x+" y="+y);
IO.println("x+y="+(x+y));
IO.pause ( "Apertar ENTER para terminar." );
} // fim main( )
} // fim class Exemplo0015
// ---------------------------------------------- documentacao complementar
//
// ------------------------------------------ historico
//
// Versao      Data        Modificacao
// 0.1         15/02       esboco
// 0.2         15/02       mudança de versão
//
// ---------------------------------------------- testes
//
// Versao      Teste
// 0.1         01. ( OK ) identificacao de programa
// 0;2         01. ( OK ) identificacao de programa
//             02. ( OK ) introdução de dado inteiro
//             03. ( OK ) introdução de dado inteiro com valor inicial
//             04. ( OK ) introdução de dado inteiro com valor inicial com operação
//
