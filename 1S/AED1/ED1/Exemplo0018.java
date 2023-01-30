// 628826-RODRIGO_PADILHA_FONSECA
/**
* Exemplo0018
*
* @author
* @version 18
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0018
{
// ---------------------------------------------- definicao de metodos
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
public static void main ( String [ ] args )
{
IO.println ( "EXEMPLO0018 - Programa em Java" );
IO.println ( "Autor:Rodrigo Padilha Fonseca" );
String x,y; // é possível definir mais de um dado do mesmo tipo
String z; // para guardar o resultado da concatenacao
          // rever as dicas dos exercicios 05 (Exemplo0010) e 06 (Exemplo0011)
x=IO.readString("Entrar com uma cadeia de caracteres: ");
y=IO.readString("Entrar com uma cadeia de caracteres: ");
IO.println(x+"|"+y);
IO.pause ( "Apertar ENTER para terminar." );
} // fim main( )
} // fim class Exemplo0018
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
