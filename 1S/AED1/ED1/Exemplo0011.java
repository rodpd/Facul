// 628826-RODRIGO_PADILHA_FONSECA
/**
* Exemplo0011
*
* @author
* @version 11
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0011
{
// ---------------------------------------------- definicao de metodos
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
public static void main ( String [ ] args )
{
IO.println ( "EXEMPLO0011 - Programa em Java" );
IO.println ( "Autor:Rodrigo Padilha Fonseca" );
String x;
int y=5;
double z=0.4;
x=""+(y+z); // guardar em (x) uma sequência de literais vazia ( “” )
        // concatenada à soma (por isso os parênteses) convertida para valor real
IO.println("x=y+z");
IO.println("z="+z);
IO.println("y="+y);
IO.println("x="+x); // exibir valor inicial do dado
IO.pause ( "Apertar ENTER para terminar." );
} // fim main( )
} // fim class Exemplo0011
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
