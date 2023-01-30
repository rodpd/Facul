// 628826-RODRIGO_PADILHA_FONSECA
/**
* Exemplo0017
*
* @author
* @version 17
*/
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0017
{
// ---------------------------------------------- definicao de metodos
// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
public static void main ( String [ ] args )
{
IO.println ( "EXEMPLO0017 - Programa em Java" );
IO.println ( "Autor:Rodrigo Padilha Fonseca" );
char x,y; // é possível definir mais de um dado do mesmo tipo
String z; // para guardar o resultado
          // rever as dicas dos exercicios 05 (Exemplo0010) e 06 (Exemplo0011)
x=IO.readchar("Entrar com um caractere: ");
z=IO.readString("Entrar com uma cadeia de caracteres: "); // para ler uma palavra
y=IO.getchar(z); // para extrair o primeiro caractere do que foi lido (z)
IO.println(""+(x+z));
IO.pause ( "Apertar ENTER para terminar." );
} // fim main( )
} // fim class Exemplo0017
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
