// 628826-RODRIGO_PADILHA_FONSECA
/**
* Exemplo0009
*
* @author
* @version 09
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0009
{
// ---------------------------------------------- definicao de metodos
// ---------------------------------------------- definicao do metodo principal
/**
* main() � metodo principal
*/
public static void main ( String [ ] args )
{
IO.println ( "EXEMPLO0009 - Programa em Java" );
IO.println ( "Autor:Rodrigo Padilha Fonseca" );
String x;
x="43.21"; // uma sequ�ncia de literais (caracteres) deve sempre vir entre aspas
IO.println("x="+x); // exibir valor inicial do dado
x=IO.readString("Entrar com uma cadeia de caracteres: ");
IO.println("x="+x); // exibir valor lido
IO.pause ( "Apertar ENTER para terminar." );
} // fim main( )
} // fim class Exemplo0009
// ---------------------------------------------- documentacao complementar
//
// ---------------------------------------------- historico
//
// Versao      Data        Modificacao
// 0.1         15/02       esboco
// 0.2         15/02       mudan�a de vers�o
//
// ---------------------------------------------- testes
//
// Versao      Teste
// 0.1         01. ( OK ) identificacao de programa
// 0;2         01. ( OK ) identificacao de programa
//             02. ( OK ) introdu��o de dado inteiro
//             03. ( OK ) introdu��o de dado inteiro com valor inicial
//             04. ( OK ) introdu��o de dado inteiro com valor inicial com opera��o
//
