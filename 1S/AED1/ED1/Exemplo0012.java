// 628826-RODRIGO_PADILHA_FONSECA
/**
* Exemplo0012
*
* @author
* @version 12
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0012
{
// ---------------------------------------------- definicao de metodos
// ---------------------------------------------- definicao do metodo principal
/**
* main() � metodo principal
*/
public static void main ( String [ ] args )
{
IO.println ( "EXEMPLO0012 - Programa em Java" );
IO.println ( "Autor:Rodrigo Padilha Fonseca" );
String x;
int y=5;
double z=0.4;
boolean w;
w=(y>z); // opera��o relacional para se avaliar uma condi��o
x=""+w;  // guardar em (x) uma sequ�ncia de literais vazia ( �� )
         // concatenada � convers�o de valor l�gico
IO.println("x=y>z");
IO.println("y="+y);
IO.println("z="+z);
IO.println("x="+x); // exibir valor inicial do dado
IO.pause ( "Apertar ENTER para terminar." );
} // fim main( )
} // fim class Exemplo0012
// ---------------------------------------------- documentacao complementar
//
// ------------------------------------------ historico
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
