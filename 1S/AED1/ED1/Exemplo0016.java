// 628826-RODRIGO_PADILHA_FONSECA
/**
* Exemplo0016
*
* @author
* @version 16
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0016
{
// ---------------------------------------------- definicao de metodos
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
public static void main ( String [ ] args )
{
IO.println ( "EXEMPLO0016 - Programa em Java" );
IO.println ( "Autor:Rodrigo Padilha Fonseca" );
char x,y; // é possível definir mais de um dado do mesmo tipo
x=IO.readchar("Entrar com um caractere: ");
y=IO.readchar("Entrar com um caractere: ");
IO.println("x="+x+" y="+y);
IO.println(""+x+""+y);
IO.pause ( "Apertar ENTER para terminar." );
} // fim main( )
} // fim class Exemplo0016
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
