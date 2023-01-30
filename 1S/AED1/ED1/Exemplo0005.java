// 628826-RODRIGO_PADILHA_FONSECA
/**
* Exemplo0005
*
* @author
* @version 05
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0005
{
// ---------------------------------------------- definicao de metodos
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
public static void main ( String [ ] args )
{
// definir dado
int x=2+3; // forma alternativa para definir valor inicial por expressao aritmetica
IO.println ( "EXEMPLO0005 - Programa em Java" );
IO.println ( "Autor:Rodrigo Padilha Fonseca" );
IO.println("x="+x); // exibir valor inicial do dado
x=IO.readint("Entrar com um valor inteiro: ");
//x=5; // atribuir valor ao dado
IO.println("x="+x); // exibir valor lido
IO.pause ( "Apertar ENTER para terminar." );
} // fim main( )
} // fim class Exemplo0005
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
