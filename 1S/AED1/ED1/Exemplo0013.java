// 628826-RODRIGO_PADILHA_FONSECA
/**
* Exemplo0013
*
* @author
* @version 13
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0013
{
// ---------------------------------------------- definicao de metodos
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
public static void main ( String [ ] args )
{
String x;
int y=5;
double z=0.4;
boolean w;
x=""+(y>z); // guardar em (x) uma sequência de literais vazia ( “” ) concatenada
            // ao resultado do teste (por isso o parênteses) entre valores inteiro e real
IO.println ( "EXEMPLO0013 - Programa em Java" );
IO.println ( "Autor:Rodrigo Padilha Fonseca" );
IO.println("x=y>z");
IO.println("x="+x); // exibir valor inicial do dado
IO.println("y="+y); // exibir valor lido
IO.println("z="+z);
IO.pause ( "Apertar ENTER para terminar." );
} // fim main( )
} // fim class Exemplo0013
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

