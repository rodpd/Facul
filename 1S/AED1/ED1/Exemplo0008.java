// 628826-RODRIGO_PADILHA_FONSECA
/**
* Exemplo0008
*
* @author
* @version 08
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0008
{
// ---------------------------------------------- definicao de metodos
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
public static void main ( String [ ] args )
{
IO.println ( "EXEMPLO0008 - Programa em Java" );
IO.println ( "Autor:Rodrigo Padilha Fonseca" );
boolean x;
x=true; // ou falso
IO.println("x="+x); // exibir valor inicial do dado
x=IO.readboolean("Entrar com um valor logico: ");
IO.println("x="+x); // exibir valor lido
IO.pause ( "Apertar ENTER para terminar." );
} // fim main( )
} // fim class Exemplo0008
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
