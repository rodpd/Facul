// 628826-RODRIGO_PADILHA_FONSECA
/**
* Exemplo0010
*
* @author
* @version 10
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0010
{
// ---------------------------------------------- definicao de metodos
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
public static void main ( String [ ] args )
{
IO.println ( "EXEMPLO0010 - Programa em Java" );
IO.println ( "Autor:Rodrigo Padilha Fonseca" );
String x;
int y=5;
x=""+y; // guardar em (x) uma sequência de literais vazia ( “” )
        // concatenada à conversão de valor inteiro (y) para caracteres
IO.println("x="+x); // exibir valor inicial do dado
IO.println("y="+y); // exibir valor lido
IO.pause ( "Apertar ENTER para terminar." );
} // fim main( )
} // fim class Exemplo0010
// ---------------------------------------------- documentacao complementar
//
// ---------------------------------------------- historico
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
