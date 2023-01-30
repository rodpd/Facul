// 628826-RODRIGO_PADILHA_FONSECA
/**
* Exemplo0020
*
* @author
* @version 20
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0020
{
// ---------------------------------------------- definicao de metodos
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
public static void main ( String [ ] args )
{
IO.println ( "EXEMPLO0020 - Programa em Java" );
IO.println ( "Autor:Rodrigo Padilha Fonseca" );
int a,b;
double x,y;
String z,c,d,e; // para guardar o resultado da concatenacao
          // rever as dicas do ex 05(ex10) e 06 (ex11)
          // e mostrar apenas seu valor ano final
x=IO.readdouble("Entrar com um valor real: ");
a=IO.readint("Entrar com um valor inteiro: ");
z=IO.readString("Entrar com um valor real: ");
y=IO.getdouble(z); // para tentar converter de literal para valor real
c=IO.readString("Entrar com um valor inteiro: ");
b=IO.getint(c);
d="("+x+","+a+")";
e=d+"("+y+","+b+")";
IO.println(e);
IO.pause ( "Apertar ENTER para terminar." );
} // fim main( )
} // fim class Exemplo0020
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
