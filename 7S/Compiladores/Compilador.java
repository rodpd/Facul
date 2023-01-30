/*
Disciplina: Compiladores
GRUPO 19
Rodrigo Padilha Fonseca
*/

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;


public class Compilador {

    // declaracao de variaveis globais
    static int line_count = 1, i = 0;
    static char c = 0;
    static boolean devolve = false;
    static InputStream is = System.in;
    static Registro reg;
    static tabelaSimbolos t = new tabelaSimbolos();
    static int memoriaDados = 0x10000;
    static FileWriter myWriter;
    static int rotulo = 0;
    static int temporario = 0;


    static void analisadorLexico() {

        // reinicia automato mudando o estado para 0 
        // e reinicia registro global que contem as informacoes do token lido
        reg = new Registro();
        int state = 0;

        // continua executando o automato enquanto nao chegar ao estado final ou encontrar um erro
        while ( state != -1 ) {

            // ler proximo char se o ultimo nao tiver sido devolvido
            try {
                if ( devolve == false ) {
                    i = is.read();
                    c = (char)i;
                }
                else 
                    devolve = false;


                // fim de arquivo
                if ( i == -1 ) {
                    // erro -> ler fim de arquivo durante comentario ( estados 13 e 14 )
                    if ( state == 13 || state == 14 ) {
                        System.out.println(line_count);
                        System.out.println("fim de arquivo nao esperado.");
                        myWriter.close();
                        System.exit(0);
                    }
                    state = -1;
                    reg.lexema = "eof";
                    reg.token = "eof";
                }
                /* se nao for fim de arquivo, percorrer automato
                /* byte lido em ascii permitidos pela linguagem:
                letras, dígitos, espaço, sublinhado, ponto, vírgula, ponto-e-vírgula, dois-pontos, 
                parênteses, colchetes, chaves, mais, menos, aspas, apóstrofo, barra, barra em pé, 
                barra invertida, e-comercial, porcentagem, exclamação, interrogação, maior, 
                menor e igual, quebra de linha
                */
                else if ( i == 10 || i == 13 || (i >= 32 && i <= 34) || (i >= 37 && i <= 63) || (i >= 65 && i <= 93 ) || i == 95 || (i >= 97 && i <= 125)) {

                    c = (char)i;

                    switch (state) {
                        // estado 0
                        case 0: 
                            // ignorar espacos em branco e quebra de linha
                            // se encontrar quebra de linha adiciona a quantidade total de linhas
                            if ( c == ' ' || c == '\r' ) {
                                ;
                            }
                            else if ( c == '\n' ) { 
                                line_count++;
                            }
                            // os tokens ( ) , = + * ; { } [ ] - levam direto ao estado final
                            else if ( c == '(' ) {
                                state = -1;
                                reg.lexema += '(';
                                reg.token = "(";
                            }
                            else if ( c == ')' ) {
                                state = -1;
                                reg.lexema += ')';
                                reg.token = ")";
                            }
                            else if ( c == ',' ) {
                                state = -1;
                                reg.lexema += ',';
                                reg.token = ",";
                            }
                            else if ( c == '=' ) {
                                state = -1;
                                reg.lexema += '=';
                                reg.token = "=";
                            }
                            else if ( c == '+' ) {
                                state = -1;
                                reg.lexema += '+';
                                reg.token = "+";
                            }
                            else if ( c == '*' ) {
                                state = -1;
                                reg.lexema += '*';
                                reg.token = "*";
                            }
                            else if ( c == ';' ) {
                                state = -1;
                                reg.lexema += ';';
                                reg.token = ";";
                            }
                            else if ( c == '{' ) {
                                state = -1;
                                reg.lexema += '{';
                                reg.token = "{";
                            }
                            else if ( c == '}' ) {
                                state = -1;
                                reg.lexema += '}';
                                reg.token = "}";
                            }
                            else if ( c == '[' ) {
                                state = -1;
                                reg.lexema += '[';
                                reg.token = "[";
                            }
                            else if ( c == ']' ) {
                                state = -1;
                                reg.lexema += ']';
                                reg.token = "]";
                            }
                            else if ( c == '-' ) {
                                state = -1;
                                reg.lexema += '-';
                                reg.token = "-";
                            }
                            // se encontrar um | vai para o estado 7
                            else if ( c == '|' ) {
                                reg.lexema += '|';
                                state = 7;
                            }
                            // se encontrar um ! vai para o estado 8
                            else if ( c == '!' ) {
                                reg.lexema += '!';
                                state = 8;
                            }
                            // se encontrar um < vai para o estado 9
                            else if ( c == '<' ) {
                                reg.lexema += '<';
                                state = 9;
                            }
                            // se encontrar um > vai para o estado 10
                            else if ( c == '>' ) {
                                reg.lexema += '>';
                                state = 10;
                            }
                            // se encontrar um & vai para o estado 11
                            else if ( c == '&' ) {
                                reg.lexema += '&';
                                state = 11;
                            }
                            // identificador: leva ao estado 1, comeca com letra ou _
                            else if ( (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == '_' ) {
                                state = 1;
                                reg.lexema += c;
                            }
                            // caractere: leva ao estado 2, comeca com '
                            else if ( c == '\'' ) {
                                reg.lexema += "'";
                                state = 2;
                            }
                            // digito 0 leva ao estado 4, pode ser um numero ou inicio de caractere hexadecimal
                            else if ( c == '0' ) {
                                reg.lexema += '0';
                                state = 4;
                            }
                            // string: leva ao estado 21, comea com "
                            else if ( c == '"' ) {
                                state = 21;
                                reg.lexema += "\"";
                            }
                            // se encontrar um / leva ao estado 12. Pode ser uma divisao real ou inicio de um comentario
                            else if ( c == '/' ) {
                                state = 12;
                            }
                            // numeros inteiros: estado 16
                            else if ( c >= '1' && c <= '9') {
                                state = 16;
                                reg.lexema += c;
                            }
                            // numero real iniciado em . : estado 15
                            else if ( c == '.' ) {
                                state = 15;
                                reg.lexema += ".";
                            }
                            else { 
                                // se nao se encaixar em nenhuma das alternativas anteriores, se trata de um erro de lexema
                                reg.lexema += c;
                                erroLexema();
                            }
                            break;
                        case 1: 
                            /* 
                            identificador
                            le caracteres ate encontrar um que nao pode fazer parte do identificador
                            se for um caractere valido, adiciona ao identificador e le o proximo
                            senao, para o loop, vai para o estado final e devolve o que foi lido
                            */
                            if ( (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9' ) || c == '.' || c == '_' ) {
                                reg.lexema += c;
                            }
                            else {
                                state = -1;
                                devolve = true;
                                registroTabela registro = t.pesquisar(reg.lexema);
                                /*
                                identificar se o que foi lido e' um id ou palavra reservada
                                se ja estiver na tabela de simbolos e for um id o token sera igual a id,
                                e os tokens das palavras reservadas igual ao lexema.
                                caso nao esteja na tabela tambem se trata de um id
                                */
                                    if ( registro != null ) {
                                        reg.token = registro.token;
                                    }
                                    else {
                                        reg.token = "id";
                                    }
                            }
                            break;
                        case 2: 
                        /*
                        lexema: '
                        ler caractere alfanumerico, varia entre 0 e 255. 
                        Depois disso, vai para o estado 3 para ler o fim do caractere (')
                        */
                            if ( i >= 0 && i <= 255 ) {
                                reg.lexema += c;
                                state = 3;
                            }
                            // se o que foi lido for diferente, indica erro de lexema
                            else {
                                erroLexema();
                            }
                            break;
                        case 3: 
                        /*
                        lexema: 'c'
                        fim de caractere, se encontrar ' vai para o estado final, senao detecta erro
                        */
                            if ( c == '\'' ) {
                                reg.token = "valor";
                                reg.tipo = "caractere";
                                reg.lexema += "'";
                                state = -1;
                            }
                            else {
                                erroLexema();
                            }
                            break;
                        /* lexema: 0
                        se encontrar um x, vai para o estado do primeiro digito do hexadecimal (estado 5)
                        senao, caso encontre um . vai para o estado de inicio de numeros decimais (estado 15)
                        senao, se econtrar um digito vai para o estado dos inteiros (estado 16)
                        senao, identifica que era o numero 0 e devolve o que foi lido
                        */
                        case 4: 
                            if ( c == 'x' ) {
                                reg.lexema += c;
                                state = 5;
                            }
                            else if ( c == '.' ) {
                                state = 15;
                                reg.lexema += '.';
                            }
                            else if ( c >= '0' && c <= '9') {
                                state = 16;
                                reg.lexema += c;
                            }
                            else { 
                                state = -1;
                                devolve = true;
                                reg.token = "valor";
                                reg.tipo = "inteiro";
                            }
                            break;
                        case 5: 
                        /* lexema: 0x
                        primeiro digito hexadecimal
                        se encontrar algo diferente de 0-9 ou A-F detecta erro
                        senao, vai para o estado 6 para ler o proximo digito
                        */
                            if ( (c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') ) {
                                reg.lexema += c;
                                state = 6;
                            }
                            else {
                                erroLexema();
                            }
                            break;        
                        case 6: 
                        /* 
                        lexema: 0xHEX
                        caso seja lido o segundo digito hexadecimal vai para o fim do automato
                        senao, caso encontrar algo diferente detecta erro
                        */
                            if ( (c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') ) {
                                reg.lexema += c;
                                state = -1;
                                reg.token = "valor";
                                reg.tipo = "caractere";
                            }
                            else {
                                erroLexema();
                            }
                            break;
                        case 7: 
                        /* 
                        lexema: |
                        caso tenha lido | identifica a operacao or (||), senao detecta erro
                        */
                            if ( c == '|' ) {
                                state = -1;
                                reg.lexema += '|';
                                reg.token = "||";
                            }
                            else {
                                erroLexema();
                            }
                            break;
                        case 8: 
                        /*
                        lexema: !
                        se encontrar um = , identifica que se trata da operacao de diferenca (!=)
                        senao, identifica que e' o operador not (!) e devolve o que foi lido
                        */
                            if ( c == '=' ) {
                                state = -1;
                                reg.lexema += '=';
                                reg.token = "!=";
                            }
                            else {
                                reg.lexema = "!";
                                reg.token = "!";
                                devolve = true;
                                state = -1;
                            }
                            break;
                        case 9: 
                        /*
                        lexema: <
                        se o que foi lido for um = , identifica a operacao de menor ou igual (<=)
                        senao, caso seja um - se trata do operador de definicao (<-)
                        senao, identifica que e operador menor (<) e devolve o que foi lido
                        */
                            if ( c == '=' ) {
                                state = -1;
                                reg.lexema += '=';
                                reg.token = "<=";
                            }
                            else if ( c == '-' ) {
                                state = -1;
                                reg.lexema += '-';
                                reg.token = "<-";
                            }
                            else {
                                reg.lexema = "<";
                                reg.token = "<";
                                state = -1;
                                devolve = true;
                            }
                            break;
                        case 10: 
                        /*
                        lexema: >
                        se o que foi lido for um = , se  trata do operador de maior ou igual (>=)
                        senao, identifica o operador de maior (>) e devolve o que foi lido
                        */
                            if ( c == '=' ) {
                                state = -1;
                                reg.lexema += '=';
                                reg.token = ">=";
                            }
                            else {
                                reg.lexema = ">";
                                reg.token = ">";
                                state = -1;
                                devolve = true;
                            }
                            break;
                        case 11: 
                        /*
                        lexema: &
                        se encontrar outro &, se trata do operador and (&&) senao detecta erro
                        */
                            if ( c == '&' ) {
                                state = -1;
                                reg.lexema += '&';
                                reg.token = "&&";
                            }
                            else {
                                erroLexema();
                            }
                            break;
                        /*
                        lexema: /
                        se encontrar um * vai para o estado de comentario, 
                        senao era o token de divisao, entao identifica o reg.token e devolve o que foi lido
                        */
                        case 12: 
                            if ( c == '*' ) {
                                state = 13;
                            }
                            else {
                                devolve = true;
                                state = -1;
                                reg.lexema += '/';
                                reg.token = "/";
                            }
                            break;
                        /*
                        comentario
                        aumenta quantidade de linhas do programa se encontrar \n,
                        vai para o estado 14 se encontrar um * (inicio do  * /  para terminar o comentario),
                        continua no mesmo estado para os outros caracteres
                        */
                        case 13: 
                            if ( c == '\n' ) {
                                line_count++;
                            }
                            else if ( c == '*' ) {
                                state = 14;
                            }
                            break;
                        /*
                        comentario
                        volta para o estado anterior se encontrar qualquer coisa diferente de *,
                        aumenta a quantidade de linhas se o que encontrou for \n
                        continua no mesmo estado enquanto encontrar *
                        */
                        case 14: 
                            if ( c == '/' ) {
                                state = 0;
                            }
                            else if ( c != '*' )
                                state = 13;
                                if ( c == '\n' )
                                    line_count++;
                            break;
                        /*
                        lexema: . ou num.
                        caso o que foi lido seja um digito, vai para o estado de numeros reais(18)
                        senao envia um erro, ja que os floats devem ter ao menos um numero nas casas decimais
                        */
                        case 15:
                            if ( c >= '0' && c <= '9' ) {
                                state = 18;
                            }
                            else {
                                erroLexema();
                            }
                        /*
                        numeros inteiros 
                        continua nesse estado enquanto estiver lendo digitos
                        se encontrar um . vai para o estado de inicio de numeros reais (15)
                        caso nao encontre um digito ou . identifica o token como int e devolve o que foi lido
                        */
                        case 16: 
                            if ( c == '.' ) {
                                state = 15;
                                reg.lexema += '.';
                            }
                            else if ( c >= '0' && c <= '9' ) {
                                reg.lexema += c;
                            }
                            else {
                                reg.token = "valor";
                                reg.tipo = "inteiro";
                                devolve = true;
                                state = -1;
                            }
                            break;
                        /*
                        numeros inteiros
                        continua lendo digitos
                        se encontrar algo diferente de um digito identifica como int e devolve o que foi lido
                        */
                        case 17: 
                            if ( c >= '0' && c <= '9' ) {
                                    reg.lexema += c;
                            }
                            else {
                                reg.token = "valor";
                                reg.tipo = "real";
                                devolve = true;
                                state = -1;
                            }
                            break;
                        /*
                        numeros reais
                        lexema : .num ou num.num
                        continua lendo os digitos enquanto a quantidade for menor que 6
                        devolve se encontrar algo diferente de um digito
                        */
                        case 18: 
                            if ( c >= '0' && c <= '9' ) {
                                reg.lexema += c;
                            }
                            else {
                                reg.token = "valor";
                                reg.tipo = "real";
                                devolve = true;
                                state = -1;
                            }
                            break;
                        /*
                        string
                        se encontrar ", termina a string
                        senao, le caracteres se a quantidade encontrada for menor que 254
                        detecta erro ao ler quebras de linha na string
                        */
                        case 21: 
                            if ( c == '"' ) {
                                state = -1;
                                reg.token = "valor";
                                reg.tipo = "string";
                                reg.lexema += "\"";
                            }
                            else if ( c != '\n' && c != '\r') {
                                reg.lexema += c;
                            }
                            else {
                                erroLexema();
                            }
                            break;
                    }
                }
                // detecta caractere invalido caso nao pertenca aos que sao permitidos no arquivo fonte
                else {
                    System.out.println(line_count);
                    System.out.println("caractere invalido.");
                    System.exit(0);
                    state = -1;
                    i = -1;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    static void erroLexema( ) {
        System.out.println(line_count);
        System.out.println("lexema nao identificado [" + reg.lexema + "].");
        try {
            myWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }


    // Analisador Sintatico

    /*
    procedimento casa token
    se o tipo for igual ao esperado, continua seguindo a gramatica
    caso contrario, se tiver encontrado o fim de arquivo indica erro de fim nao esperado
    senao, indica erro de token nao esperado com o lexema lido
    */
    static void casa_token ( String tipoEsperado ) {
        if ( tipoEsperado == reg.token ) {
            analisadorLexico();
        }
        else if ( reg.token == "eof" ) {
            System.out.println(line_count);
            System.out.println("fim de arquivo nao esperado.");
            System.exit(0);
        }
        else {
            System.out.println(line_count);
            System.out.println("token nao esperado [" + reg.lexema + "].");
            System.exit(0);
        }
    }



    /*
    Erros na analise sintatica
    nn -> numero de linhas
    fecha o arquivo que esta sendo escrito e depois para a execucao do programa
    */

    /*
    primeiro tipo de erro na parte de analise sintatica:
    nn
    identificador nao declarado [lex].
    */
    static void erro1() {
        System.out.println(line_count);
        System.out.println("identificador nao declarado [" + reg.lexema + "].");
        try {
            myWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
    
    /* 
    segundo tipo de erro:
    nn
    identificador ja declarado [lex].
    */
    static void erro2() {
        System.out.println(line_count);
        System.out.println("identificador ja declarado [" + reg.lexema + "].");
        try {
            myWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /* 
    Terceiro tipo de erro:
    nn
    tipos incompativeis.
    */
    static void erro3() {
        System.out.println(line_count);
        System.out.println("tipos incompativeis.");
        try {
            myWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /*
    Quarto tipo de erro:
    nn
    classe de identificador incompativel [lex].
    */
    static void erro4() {
        System.out.println(line_count);
        System.out.println("classe de identificador incompativel [" + reg.lexema + "].");
        try {
            myWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }


    /* 
    Funcao toHex
    recebe um endereco como parametro
    retorna o endereco no formato do assembly convertendo o parametro para hexadecimal e adicionando h ao fim
    ex: endereco 65536 retorna 10000h
    */
    static String toHex ( int num ) {
        String s = String.format("%xh", num);
        // adiciona um 0 antes do endereco caso o primeiro caractere nao seja menor ou igual a 9 (a,b,c,d,e,f), 
        // ja que caso o endereco comecasse com a,b,c,d,e ou f (ex: ah) estava dando erro no NASM
        if ( !(s.charAt(0) >= '0' && s.charAt(0) <= '9') ) {
            s = "0" + s;
        }
        return s;
    }

    /*
    Funcao novoTemp
    retorna o endereco atual da area de temporarios e incrementa para o proximo uso de acordo com o tipo
    */
    static int novoTemp ( String tipo) {
        int endereco = temporario;
        if ( tipo == "inteiro" || tipo == "real" || tipo == "logica") {
            temporario += 4;
        }
        else { // caractere
            temporario += 1;
        }
        return endereco;
    }

    /*
    Funcao novoRot
    retorna o numero atual disponivel para uso no rotulo e incrementa ele em 1 para o proximo uso
    */
    static String novoRot ( ) {
        String rot = "Rot" + rotulo;
        rotulo++;
        return rot;
    }



    // S -> {(Declaracao|Bloco_de_comandos)} EOF
    static void S () {
        while ( reg.token == "int" || reg.token == "float" || reg.token == "string" 
        || reg.token == "char" || reg.token == "const" || reg.token == "{" || reg.token == "id" 
        || reg.token == "while" || reg.token == "if" || reg.token == ";" || reg.token == "readln" 
        || reg.token == "write" || reg.token == "writeln" ) {
            if ( reg.token == "int" || reg.token == "float" || reg.token == "string"
            || reg.token == "char" || reg.token == "const" ) {
                Declaracao();
            }
            else {
                Bloco_de_comandos();
            }
        }
        casa_token("eof");
    }


    /* Declaracao -> (int|float) id [<-[-]valor] {,id[<-[-]valor]} ;
        | (string|char) id [<-valor]{,id[<-valor]} ;
        | const id = [-] valor ;
    */
    static void Declaracao () {
        try {
            myWriter.write("section .data\t; sessao de dados\n");
            // declaracao das variaveis que serao utilizadas nas acoes sintaticas
            String tipo = "";
            Boolean definido = false;
            String valor = "";
            Boolean negativo = false;
            if ( reg.token == "int" ) {
                tipo = "inteiro";
            }
            else if ( reg.token == "float") {
                tipo = "real";
            }
            else if ( reg.token == "char" ) {
                tipo = "caractere";
            }
            else if ( reg.token == "string") {
                tipo = "string";
            }
            // declaracao de inteiro ou real
            if ( reg.token == "int" || reg.token == "float" ) {
                casa_token(reg.token);
                // pesquisar registro na tabela para verificar se ja foi declarado
                // caso tenha sido, indica erro de identificador ja declarado
                // senao, insere na tabela
                registroTabela registro = t.pesquisar(reg.lexema);
                if ( registro != null ) {
                    erro2();
                }
                else {
                    registro = new registroTabela(reg.token, "classe-var", tipo, memoriaDados);
                    t.inserir(reg.lexema, registro);
                }
                casa_token("id");
                // ler valor caso o token lido seja <-
                if ( reg.token == "<-" ) {
                    definido = true;
                    negativo = false;
                    casa_token("<-");
                    if ( reg.token == "-" ) {
                        negativo = true;
                        casa_token("-");
                    }
                    // erro de tipos incompativeis se o tipo do identificador for diferente do tipo do valor
                    if ( tipo != reg.tipo ) {
                        erro3();
                    }
                    valor = reg.lexema;
                    casa_token("valor");
                }
                // geracao de codigo da declaracao de inteiro ou real
                    if ( definido ) {
                        myWriter.write("dd ");
                        if ( negativo ) {
                            myWriter.write("-");
                        }
                        if ( registro.tipo == "inteiro" ) {
                            myWriter.write(valor + "\t;Int em " + toHex(memoriaDados) + "\t; declaracao de inteiro\n");
                        }
                        else {
                            myWriter.write(valor + "\t;Float em " + toHex(memoriaDados) + "\t; declaracao de real\n");
                        }
                    }
                    else {
                        if ( registro.tipo == "inteiro" ) {
                            myWriter.write(";declaracao de inteiro\n");
                            myWriter.write("resd 1\t;Int em " + toHex(memoriaDados) + "\n");
                        }
                        else {
                            myWriter.write(";declaracao de real\n");
                            myWriter.write("resd 1\t;Float em " + toHex(memoriaDados) + "\n");
                        }
                    }
                    memoriaDados += 4;
                // continuar lendo declaracoes caso o token lido seja ,
                while ( reg.token == "," ) {
                    casa_token(",");
                    definido = false;
                    registro = t.pesquisar(reg.lexema);
                    if ( registro != null ) {
                        erro2();
                    }
                    else {
                        registro = new registroTabela(reg.token, "classe-var", tipo, memoriaDados);
                        t.inserir(reg.lexema, registro);
                    }
                    casa_token("id");
                    if ( reg.token == "<-" ) {
                        negativo = false;
                        definido = true;
                        casa_token("<-");
                        if ( reg.token == "-" ) {
                            negativo = true;
                            casa_token("-");
                        }
                        // tipos incompativeis se tipo do identificador for diferente do tipo do valor
                        if ( tipo != reg.tipo ) {
                            erro3();
                        }
                        valor = reg.lexema;
                        casa_token("valor");
                    }
                    // geracao de codigo
                        if ( definido ) {
                            myWriter.write("dd ");
                            if ( negativo ) {
                                myWriter.write("-");
                            }
                            if ( registro.tipo == "inteiro" ) {
                                myWriter.write(valor + "\t;Int em " + toHex(memoriaDados) + "\t; declaracao de inteiro\n");
                            }
                            else {
                                myWriter.write(valor + "\t;Float em " + toHex(memoriaDados) + "\t; declaracao de real\n");
                            }
                        }
                        else {
                            if ( registro.tipo == "inteiro" ) {
                                myWriter.write(";declaracao de inteiro\n");
                                myWriter.write("resd 1\t;Int em " + toHex(memoriaDados) + "\n");
                            }
                            else {
                                myWriter.write(";declaracao de real\n");
                                myWriter.write("resd 1\t;Float em " + toHex(memoriaDados) + "\n");
                            }
                        }
                        memoriaDados += 4;
                }
                casa_token(";");
            }
            // declaracao de caractere ou string
            else if ( reg.token == "char" || reg.token == "string" ) {
                casa_token(reg.token);
                registroTabela registro = t.pesquisar(reg.lexema);
                // pesquisar registro na tabela para verificar se ja foi declarado
                // caso tenha sido, indica erro de identificador ja declarado
                // senao, insere na tabela
                if ( registro != null ) {
                    erro2();
                }
                else {
                    registro = new registroTabela(reg.token, "classe-var", tipo, memoriaDados);
                    t.inserir(reg.lexema, registro);
                }
                definido = false;
                casa_token("id");
                if ( reg.token == "<-" ) {
                    definido = true;
                    casa_token("<-");
                    // tipos incompativeis se tipo do id for diferente do tipo do valor
                    if ( tipo != reg.tipo )
                        erro3();
                    valor = reg.lexema;
                    // guarda o tamanho se for uma string
                    if ( tipo == "string" ) {
                        registro.tamanho = reg.lexema.length()-1;
                    }
                    casa_token("valor");
                }
                // geracao de codigo
                    if ( definido ) {
                        if ( registro.tipo == "caractere" ) {
                            myWriter.write(";declaracao de caractere\n");
                            myWriter.write("db " + valor + "\t;Caractere em " + toHex(memoriaDados) + "\n");
                            memoriaDados += 1;
                        }
                        else {
                            myWriter.write(";declaracao de string\n");
                            myWriter.write("db " + valor + ",0\t;String em " + toHex(memoriaDados) + "\n");
                            memoriaDados += valor.length()-1;
                        }
                    }
                    else {
                        if ( registro.tipo == "caractere" ) {
                            myWriter.write(";declaracao de caractere\n");
                            myWriter.write("resb 1\t;Caractere em " + toHex(memoriaDados) + "\n");
                            memoriaDados += 1;
                        }
                        else {
                            myWriter.write(";declaracao de string\n");
                            myWriter.write("resb 100h\t;String em " + toHex(memoriaDados) + "\n");
                            memoriaDados += 256;
                        }
                    }
                // continuar lendo declaracoes caso o token lido seja ,
                while ( reg.token == "," ) {
                    definido = false;
                    casa_token(",");
                    registro = t.pesquisar(reg.lexema);
                    if ( registro != null ) {
                        erro2();
                    }
                    else {
                        registro = new registroTabela(reg.token, "classe-var", tipo, memoriaDados);
                        t.inserir(reg.lexema, registro);
                    }
                    casa_token("id");
                    if ( reg.token == "<-" ) {
                        definido = true;
                        casa_token("<-");
                        // tipos incompativeis se tipo do id for diferente do tipo do identificador
                        if ( tipo != reg.tipo ) {
                            erro3();
                        }
                        valor = reg.lexema;
                        // guarda o tamanho se for uma string
                        if ( tipo == "string" ) {
                            registro.tamanho = reg.lexema.length()-1;
                        }
                        casa_token("valor");
                    }
                    // geracao de codigo
                        if ( definido ) {
                            if ( registro.tipo == "caractere" ) {
                                myWriter.write(";declaracao de caractere\n");
                                myWriter.write("db " + valor + "\t;Caractere em " + toHex(memoriaDados) + "\n");
                                memoriaDados += 1;
                            }
                            else {
                                myWriter.write(";declaracao de string\n");
                                myWriter.write("db " + valor + ",0\t;String em " + toHex(memoriaDados) + "\n");
                                memoriaDados += valor.length()-1;
                            }
                        }
                        else {
                            if ( registro.tipo == "inteiro" ) {
                                myWriter.write(";declaracao de caractere\n");
                                myWriter.write("resb 1\t;Caractere em " + toHex(memoriaDados) + "\n");
                                memoriaDados += 1;
                            }
                            else {
                                myWriter.write(";declaracao de string\n");
                                myWriter.write("resb 100h\t;String em " + toHex(memoriaDados) + "\n");
                                memoriaDados += 256;
                            }
                        }
                }
                casa_token(";");
            }
            else { // declaracao de constante
                negativo = false;
                casa_token("const");
                // pesquisar registro na tabela para verificar se ja foi declarado
                // caso tenha sido, indica erro de identificador ja declarado
                registroTabela registro = t.pesquisar(reg.lexema);
                registro = t.pesquisar(reg.lexema);
                    if ( registro != null ) {
                        erro2();
                    }
                String lexema = reg.lexema;
                casa_token("id");
                casa_token("=");
                if ( reg.token == "-" ) {
                    negativo = true;
                    casa_token("-");
                }
                // geracao de codigo
                registro = new registroTabela("id", "classe-const", reg.tipo, memoriaDados);
                t.inserir(lexema, registro);
                    if ( reg.tipo == "inteiro" ) {
                        myWriter.write("dd ");
                        if ( negativo ) {
                            myWriter.write("-");
                        }
                        myWriter.write(reg.lexema + "\t;Int em " + toHex(memoriaDados) + "\t; declaracao de constante inteira\n");
                        memoriaDados += 4;
                    }
                    else if ( reg.tipo == "real" ) {
                        myWriter.write("dd ");
                        if ( negativo ) {
                            myWriter.write("-");
                        }
                        myWriter.write(reg.lexema + "\t;Float em " + toHex(memoriaDados) + "\t; declaracao de constante real\n");
                        memoriaDados += 4;
                    }
                    else if ( reg.tipo == "caractere" ) {
                        myWriter.write(";declaracao de constante caractere\n");
                        myWriter.write("db " + reg.lexema + "\t;Caractere em " + toHex(memoriaDados) + "\t;declaracao de constante caractere\n");
                        memoriaDados += 4;
                    }
                    else { // tipo == string
                        myWriter.write("db " + reg.lexema + ",0\t;String em " + toHex(memoriaDados) + "\t;declaracao de constante string\n");
                        registro.tamanho = reg.lexema.length()-1;
                        memoriaDados += reg.lexema.length()-1;
                    }
                casa_token("valor");
                casa_token(";");
            }
            // voltar para sessao de codigo no fim da declaracao
            myWriter.write("\nsection .text\t; sessao de codigo\n");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Bloco_de_comandos -> Comando | "{" {Bloco_de_comandos} "}"
    static void Bloco_de_comandos () {
        if ( reg.token == "id" || reg.token == "while" || reg.token == "if" || reg.token == ";"
        || reg.token == "readln" || reg.token == "write" || reg.token == "writeln" ) {
            Comando();
        }
        else {
            casa_token("{");
            while ( reg.token == "{" || reg.token == "id" || reg.token == "while" || reg.token == "if" || reg.token == ";"
            || reg.token == "readln" || reg.token == "write" || reg.token == "writeln" ) {
                Bloco_de_comandos();
            }
            casa_token("}");
        }
    }

    /* Comando -> id [ "[" Expressao "]" ] <- expressão ;
        | While expressão bloco_de_comandos
        | if expressão Bloco_de_comandos [else Bloco_de_comandos ]
        | ;
        | readln "(" id ")" ;
        | (write|writeln) "(" expressao{,expressão} ")" ;
    */
    static void Comando () {
        /*
        primeira regra
        comando de atribuicao
        id [ "[" Expressao "]" ] <- expressão ;
        */
        if ( reg.token == "id" ) {
            // declaracao das variaveis que serao utilizadas nas acoes sintaticas
            String tipoId = "";
            String lexemaId = "";
            Boolean negado = false;
            int enderecoId = 0;
            /*
            pesquisar id na tabela de registros
            se nao existir, indica erro de identificador nao declarado
            senao a classe for classe-const indica erro ja que constantes nao podem ser alteradas
            senao, se a classe for classe-var indica erro de tipos incompativeis, ja que tambem sendo
            diferente de classe-var a classe sera vazia, e isso indica que o token e' uma palavra reservada,
            e valores nao podem ser atribuidos a palavras reservadas
            senao, altera o tipo e endereco do id
            */
            registroTabela registro = t.pesquisar(reg.lexema);
            if ( registro == null ) {
                erro1();
            }
            else if ( registro.classe == "classe-const" ) {
                erro4();
            }
            else if ( registro.classe != "classe-var" ) {
                erro3();
            }
            else {
                tipoId = registro.tipo;
                enderecoId = registro.endereco;
            }
            lexemaId = reg.lexema;
            casa_token("id");
            if ( reg.token == "[" ) { // acesso a posicao do vetor
                casa_token("[");
                paramString tipoExpressao = new paramString();
                paramInt enderecoExpressao = new paramInt();
                paramInt tamanhoExpressao = new paramInt();
                temporario = 0;
                Expressao(tipoExpressao, enderecoExpressao, tamanhoExpressao);
                // indica erro de tipos incompativeis se estiver tentando acessar a posicao de um id 
                // de tipo diferente de string ou acessar com um valor de tipo diferente de inteiro
                if ( tipoId != "string" || tipoExpressao.s != "inteiro")
                    erro3();
                else
                    tipoId = "caractere";
                casa_token("]");
            }
            casa_token("<-");
            if ( reg.token == "-" ) {
                casa_token("-");
                negado = true;
            }
            paramString tipoExpressao = new paramString();
            paramInt enderecoExpressao = new paramInt();
            paramInt tamanhoExpressao = new paramInt();
            temporario = 0;
            Expressao(tipoExpressao, enderecoExpressao, tamanhoExpressao);
            // indica erro de tipos incompativeis caso tenha sido encontrado um - antes do valor e 
            // o tipo seja diferente de inteiro e real, ja que apenas esses dois tipos podem ser negados
            // ou entao caso os tipos sejam diferentes entre si e tipo de id diferente de real e tipo da expressao 
            // diferente de inteiro, ja' que esse e' o unico caso em que um valor pode ser atribuido a um de outro tipo
            if ( ( negado && tipoExpressao.s != "inteiro" && tipoExpressao.s != "real" ) || ( tipoExpressao.s != tipoId && tipoId != "real" && tipoExpressao.s != "inteiro" ) ) {
                erro3();
            }
            casa_token(";");
            try {
                // geracao de codigo da atribuicao
                if ( tipoExpressao.s == "inteiro" ) {
                    myWriter.write(";atribuicao de inteiro\n");
                    myWriter.write("mov eax, [M+" + toHex(enderecoExpressao.v) + "]\n");
                    myWriter.write("mov [M+" + toHex(enderecoId) + "], eax\n");
                }
                else if ( tipoExpressao.s == "real" ) {
                    myWriter.write(";atribuicao de real\n");
                    myWriter.write("movss xmm0, [M+" + toHex(enderecoExpressao.v) + "]\n");
                    myWriter.write("movss [M+" + toHex(enderecoId) + "], xmm0\n");
                }
                else if ( tipoExpressao.s == "caractere" ) {
                    myWriter.write(";atribuicao de caractere\n");
                    myWriter.write("mov al, [M+" + toHex(enderecoExpressao.v) + "]\n");
                    myWriter.write("mov [M+" + enderecoId + "], al\n");
                }
                else { // tipo string
                    myWriter.write(";atribuicao de string\n");
                    String rotInicio = novoRot();
                    String rotFim = novoRot();
                    myWriter.write("mov al, 0\t; contador recebe 0\n");
                    myWriter.write("mov bl, " + tamanhoExpressao.v + "\t; bl recebe tamanho expressao\n");
                    myWriter.write("mov rdi, M+" + toHex(enderecoId) + "\t; armazena endereco da string do id em rdi\n");
                    myWriter.write("mov rsi, M+" + toHex(enderecoExpressao.v) + "\t; armazena endereco da string da expressao em rsi\n");
                    myWriter.write("\n" + rotInicio + ":\t; definicao do rotInicio\n");
                    myWriter.write("cmp al, bl\t; compara tamanho com contador\n");
                    myWriter.write("je " + rotFim + "\t; se contador for igual a tamanho, pular para rotfim\n");
                    myWriter.write("mov cl, [rsi]");
                    myWriter.write("mov [rdi], cl\t; armazena o caractere de cl para o endereco apontado por rdi\n");
                    myWriter.write("add al, 1\t; incrementa contador\n");
                    // aumenta enderecos do id e da expressao para acessar o proximo caractere na proxima iteracao
                    myWriter.write("add rdi, 1\t; incrementa endereco da string de id\n");
                    myWriter.write("add rsi, 1\t; incrementa endereco da string da expressao\n");
                    myWriter.write("jmp " + rotInicio + "\t; volta para rotInicio para atribuir proximo caractere\n");
                    myWriter.write("\n" + rotFim + ":\t; definicao do rotFim\n\n");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        /*
        segunda regra
        comando de repita enquanto (while)
        While expressão bloco_de_comandos
        */
        else if ( reg.token == "while" ) {
            casa_token("while");
            paramString tipoExpressao = new paramString();
            paramInt enderecoExpressao = new paramInt();
            paramInt tamanhoExpressao = new paramInt();
            try {
                String rotInicio = novoRot();
                String rotFim = novoRot();
                myWriter.write("; inicio repita enquanto (while)\n");
                myWriter.write("\n" + rotInicio + ":\n");
                temporario = 0;
                Expressao(tipoExpressao, enderecoExpressao, tamanhoExpressao);
                // detecta erro de tipos incompativeis se a expressao nao for to tipo logica
                if ( tipoExpressao.s != "logica" ) {
                    erro3();
                }
                myWriter.write("mov eax, [M+" + toHex(enderecoExpressao.v) + "]\t; guarda conteudo de " + toHex(enderecoExpressao.v) + " em eax \n");
                myWriter.write("cmp eax, 0\t; compara eax com 0\n");
                myWriter.write("je " + rotFim + "\t; se eax for 0, a expressao e falsa, entao pula para o fim\n");
                Bloco_de_comandos();
                myWriter.write("jmp " + rotInicio + "\t; pula para o inicio para comecar a proxima iteracao do while\n");
                myWriter.write("\n" + rotFim + ":\t; rotulo do fim do while\n");
                myWriter.write("; fim repita enquanto (while)\n");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        /*
        terceira regra
        comando de teste (if)
        if expressão Bloco_de_comandos [else Bloco_de_comandos ]
        */
        else if ( reg.token == "if" ) {
            casa_token("if");
            String rotFalso = novoRot();
            String rotFim = novoRot();
            paramString tipoExpressao = new paramString();
            paramInt enderecoExpressao = new paramInt();
            paramInt tamanhoExpressao = new paramInt();
            temporario = 0;
            Expressao(tipoExpressao, enderecoExpressao, tamanhoExpressao);
            try {
                myWriter.write("; inicio comando de teste (if)\n");
                myWriter.write("mov eax, [M+" + toHex(enderecoExpressao.v) + "]\t; armazena o conteudo de " + toHex(enderecoExpressao.v) + " em eax\n");
                myWriter.write("cmp eax, 0\t; compara eax com 0\n");
                myWriter.write("je " + rotFalso + "\t; se eax for 0, a expressao e falsa, entao pula para o else ou o fim\n");
                if ( tipoExpressao.s != "logica" ) {
                    erro3();
                }
                Bloco_de_comandos();
                myWriter.write("jmp " + rotFim + "\t; pula para o fim do teste\n");
                myWriter.write("\n" + rotFalso + ":\t; definicao do rotFalso\n");
                if ( reg.token == "else" ) {
                    casa_token("else");
                    Bloco_de_comandos();
                }
                myWriter.write("\n " + rotFim + ":\t; definicao do rotFim\n");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        // quarta regra: comando nulo (;)
        else if ( reg.token == ";" ) {
            casa_token(";");
        }
        /*
        quinta regra
        comando de entrada
        readln "(" id ")" ;
        */
        else if ( reg.token == "readln" ) {
            casa_token("readln");
            casa_token("(");
            /*
            pesquisa o registro em que o valor lido sera armazenado
            caso nao exista, indica erro de que o id nao foi declarado
            senao, caso seja uma constante, indica erro ja que nao podem ser alteradas
            senao, caso nao seja da classe var indica erro ja que se trata de uma palavra reservada, e elas armazenam valor algum
            senao, define o tipo para ser utilizado na geracao de codigo
            */
            registroTabela registro = t.pesquisar(reg.lexema);
            String tipo;
            if ( registro == null ) {
                erro1();
            }
            else if ( registro.classe == "classe-const" ) {
                erro4();
            }
            else if ( registro.classe != "classe-var" ) {
                erro3();
            }
            else {
                tipo = registro.tipo;
            }
            casa_token("id");
            casa_token(")");
            casa_token(";");
        }
        /*
        sexta regra
        comando de saida
        (write|writeln) "(" expressao{,expressão} ")" ;
        */
        else {
            boolean novaLinha = false;
            if ( reg.token == "writeln" ) {
                novaLinha = true;
            }
            casa_token(reg.token);
            casa_token("(");
            paramString tipoExpressao = new paramString();
            paramInt enderecoExpressao = new paramInt();
            paramInt tamanhoExpressao = new paramInt();
            temporario = 0;
            Expressao(tipoExpressao, enderecoExpressao, tamanhoExpressao);
            try {
                int bufferEnd = 0;
                // nao e' preciso definir um endereco do buffer para caracteres ou strings
                if ( novaLinha || tipoExpressao.s == "inteiro" || tipoExpressao.s == "logica" || tipoExpressao.s == "real" ) { 
                    bufferEnd = novoTemp("inteiro");
                }
                if ( tipoExpressao.s == "inteiro" || tipoExpressao.s == "logica" ) {
                    myWriter.write("\n; impressao de inteiro\n");
                    myWriter.write("\nmov eax, [qword M+" + toHex(enderecoExpressao.v) + "]\t; inteiro a ser convertido\n");
                    myWriter.write("mov rsi, M+" + toHex(bufferEnd) + "\t;end. string ou temp.);\n");
                    myWriter.write("mov rcx, 0 \t;contador pilha\n");
                    myWriter.write("mov rdi, 0 \t;tam. string convertido\n");
                    myWriter.write("cmp eax, 0 \t;verifica sinal\n");
                    String rot0 = novoRot();
                    myWriter.write("jge " + rot0 + "\t;salta se número positivo\n");
                    myWriter.write("mov bl, '-' \t;senão, escreve sinal –\n");
                    myWriter.write("mov [rsi], bl\n");
                    myWriter.write("add rsi, 1 \t;incrementa índice\n");
                    myWriter.write("add rdi, 1 \t;incrementa tamanho\n");
                    myWriter.write("neg eax \t;toma módulo do número\n\n");
                    myWriter.write(rot0 + ":\n");
                    myWriter.write("mov ebx, 10 \t;divisor\n\n");
                    
                    String rot1 = novoRot();
                    myWriter.write(rot1 + ":\n");
                    myWriter.write("add rcx, 1 \t;incrementa contador\n");
                    myWriter.write("cdq \t;estende edx:eax p/ div.\n");
                    myWriter.write("idiv ebx \t;divide edx;eax por ebx\n");
                    myWriter.write("push dx \t;empilha valor do resto\n");
                    myWriter.write("cmp eax, 0 \t;verifica se quoc. é 0\n");
                    myWriter.write("jne " + rot1 + "\t;se não for 0, continua\n\n");
                    myWriter.write("add rdi,rcx \t;atualiza tam. string\n\n");
                    myWriter.write(";agora, desemp. os valores e escreve o string\n\n");

                    String rot2 = novoRot();
                    myWriter.write(rot2 + ":\n");
                    myWriter.write("pop dx ;desempilha valor\n");
                    myWriter.write("add dl, '0' ;transforma em caractere\n");
                    myWriter.write("mov [rsi], dl ;escreve caractere\n");
                    myWriter.write("add rsi, 1 ;incrementa base\n");
                    myWriter.write("sub rcx, 1 ;decrementa contador\n");
                    myWriter.write("cmp rcx, 0 ;verifica pilha vazia\n");
                    myWriter.write("jne " + rot2 + " ;se não pilha vazia, loop\n\n");

                    myWriter.write(";executa interrupção de saída\n");
                    myWriter.write("mov rsi, M+" + toHex(bufferEnd) + " ;ou buffer.end\n");
                    myWriter.write("mov rdx, rdi ;ou buffer.tam\n");
                    myWriter.write("mov rax, 1 ;chamada para saída\n");
                    myWriter.write("mov rdi, 1 ;saída para tela\n");
                    myWriter.write("syscall\n\n");

                }
                else if ( tipoExpressao.s == "real" ) {
                    myWriter.write("\n; impressao de real\n");
                    myWriter.write("movss xmm0, [qword M+" + toHex(enderecoExpressao.v) + "] ;real a ser convertido\n");
                    myWriter.write("mov rsi, M+" + toHex(bufferEnd) + ";end. temporário\n");
                    myWriter.write("mov rcx, 0 ;contador pilha\n");
                    myWriter.write("mov rdi, 6 ;precisao 6 casas compart\n");
                    myWriter.write("mov rbx, 10 ;divisor\n");
                    myWriter.write("cvtsi2ss xmm2, rbx ;divisor real\n");
                    myWriter.write("subss xmm1, xmm1 ;zera registrador\n");
                    myWriter.write("comiss xmm0, xmm1 ;verifica sinal\n");
                    String rot0 = novoRot();
                    myWriter.write("jae " + rot0 + " ;salta se número positivo\n");
                    myWriter.write("mov dl, '-' ;senão, escreve sinal –\n");
                    myWriter.write("mov [rsi], dl\n");
                    myWriter.write("mov rdx, -1 ;Carrega -1 em RDX\n");
                    myWriter.write("cvtsi2ss xmm1, rdx ;Converte para real\n");
                    myWriter.write("mulss xmm0, xmm1 ;Toma módulo\n");
                    myWriter.write("add rsi, 1 ;incrementa índice\n");
                    myWriter.write("\n" + rot0 + ":\n");
                    myWriter.write("roundss xmm1, xmm0, 0b0011 ;parte inteira xmm1\n");
                    myWriter.write("subss xmm0, xmm1 ;parte frac xmm0\n");
                    myWriter.write("cvtss2si rax, xmm1 ;convertido para int\n");
                    myWriter.write(";converte parte inteira que está em rax\n");
                    String rot1 = novoRot();
                    myWriter.write("\n" + rot1 + ":\n");
                    myWriter.write("add rcx, 1 ;incrementa contador\n");
                    myWriter.write("cdq ;estende edx:eax p/ div.\n");
                    myWriter.write("idiv ebx ;divide edx;eax por ebx\n");
                    myWriter.write("push dx ;empilha valor do resto\n");
                    myWriter.write("cmp eax, 0 ;verifica se quoc. é 0\n");
                    myWriter.write("jne " + rot1 +";se não for 0, continua\n");
                    myWriter.write("sub rdi, rcx ;decrementa precisao\n");
                    myWriter.write(";agora, desemp valores e escreve parte int\n");
                    String rot2 = novoRot();
                    myWriter.write("\n" + rot2 + ":\n");
                    myWriter.write("pop dx ;desempilha valor\n");
                    myWriter.write("add dl, '0' ;transforma em caractere\n");
                    myWriter.write("mov [rsi], dl ;escreve caractere\n");
                    myWriter.write("add rsi, 1 ;incrementa base\n");
                    myWriter.write("sub rcx, 1 ;decrementa contador\n");
                    myWriter.write("cmp rcx, 0 ;verifica pilha vazia\n");
                    myWriter.write("jne " + rot2 + ";se não pilha vazia, loop\n");
                    myWriter.write("mov dl, '.' ;escreve ponto decimal\n");
                    myWriter.write("mov [rsi], dl\n");
                    myWriter.write("add rsi, 1 ;incrementa base\n");
                    myWriter.write(";converte parte fracionaria que está em xmm0\n");
                    String rot3 = novoRot();
                    myWriter.write("\n" + rot3 + ":\n");
                    myWriter.write("cmp rdi, 0 ;verifica precisao\n");
                    String rot4 = novoRot();
                    myWriter.write("jle " + rot4 + ";terminou precisao ?\n");
                    myWriter.write("mulss xmm0,xmm2 ;desloca para esquerda\n");
                    myWriter.write("roundss xmm1,xmm0,0b0011 ;parte inteira xmm1\n");
                    myWriter.write("subss xmm0,xmm1 ;atualiza xmm0\n");
                    myWriter.write("cvtss2si rdx, xmm1 ;convertido para int\n");
                    myWriter.write("add dl, '0' ;transforma em caractere\n");
                    myWriter.write("mov [rsi], dl ;escreve caractere\n");
                    myWriter.write("add rsi, 1 ;incrementa base\n");
                    myWriter.write("sub rdi, 1 ;decrementa precisao\n");
                    myWriter.write("jmp " + rot3 + "\n");
                    myWriter.write("; impressão\n");
                    myWriter.write("\n" + rot4 + ":\n");
                    myWriter.write("mov dl, 0 ;fim string, opcional\n");
                    myWriter.write("mov [rsi], dl ;escreve caractere\n");
                    myWriter.write("mov rdx, rsi ;calc tam str convertido\n");
                    myWriter.write("mov rbx, M+" + toHex(bufferEnd) + "\n");
                    myWriter.write("sub rdx, rbx ;tam=rsi-M-buffer.end\n");
                    myWriter.write("mov rsi, M+" + toHex(bufferEnd) + "; endereço do buffer\n");
                    myWriter.write(";executa interrupção de saída.\n");
                    myWriter.write("mov rax, 1 ;chamada para saída\n");
                    myWriter.write("mov rdi, 1 ;saída para tela\n");
                    myWriter.write("syscall\n\n");
                }
                else if (tipoExpressao.s == "caractere" ) { // tipo caractere
                    myWriter.write("\n; impressao de caractere\n");
                    myWriter.write("mov rsi, M+"+ toHex(enderecoExpressao.v) +" ;ou buffer.end\n");
                    myWriter.write("mov rdx, 1 ; tamanho char\n");
                    myWriter.write("mov rax, 1 ;chamada para saída\n");
                    myWriter.write("mov rdi, 1 ;saída para tela\n");
                    myWriter.write("syscall\n\n");
                }
                else { //tipo string
                    myWriter.write("\n; impressao de string\n");
                    myWriter.write("mov rsi, M+"+ toHex(enderecoExpressao.v) +" ;ou buffer.end\n");
                    myWriter.write("mov rdx, "+ tamanhoExpressao.v + " ;ou buffer.tam\n");
                    myWriter.write("mov rax, 1 ;chamada para saída\n");
                    myWriter.write("mov rdi, 1 ;saída para tela\n");
                    myWriter.write("syscall\n\n");
                }

                if ( novaLinha ) {
                    myWriter.write("mov al, 0ah\n");
                    myWriter.write("mov [M+" + toHex(bufferEnd) + "], al\n");
                    myWriter.write("mov rsi, M+"+ toHex(bufferEnd) +" ;ou buffer.end\n");
                    myWriter.write("mov rdx, "+ 1 + "\n");
                    myWriter.write("mov rax, 1 ;chamada para saída\n");
                    myWriter.write("mov rdi, 1 ;saída para tela\n");
                    myWriter.write("syscall\n");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            // continua imprimindo outras expressoes caso tenha lido o token ,
            while ( reg.token == ",") {
                casa_token(",");
                tipoExpressao = new paramString();
                enderecoExpressao = new paramInt();
                tamanhoExpressao = new paramInt();
                temporario = 0;
                Expressao(tipoExpressao, enderecoExpressao, tamanhoExpressao);
                try {
                    int bufferEnd = 0;
                    // nao e' preciso definir um endereco do buffer para caracteres ou strings
                    if ( novaLinha || tipoExpressao.s == "inteiro" || tipoExpressao.s == "logica" || tipoExpressao.s == "real" ) { 
                        bufferEnd = novoTemp("inteiro");
                    }
                    if ( tipoExpressao.s == "inteiro" || tipoExpressao.s == "logica" ) {
                        myWriter.write("\n; impressao de inteiro\n");
                        myWriter.write("\nmov eax, [qword M+" + toHex(enderecoExpressao.v) + "]\t; inteiro a ser convertido\n");
                        myWriter.write("mov rsi, M+" + toHex(bufferEnd) + "\t;end. string ou temp.);\n");
                        myWriter.write("mov rcx, 0 \t;contador pilha\n");
                        myWriter.write("mov rdi, 0 \t;tam. string convertido\n");
                        myWriter.write("cmp eax, 0 \t;verifica sinal\n");
                        String rot0 = novoRot();
                        myWriter.write("jge " + rot0 + "\t;salta se número positivo\n");
                        myWriter.write("mov bl, '-' \t;senão, escreve sinal –\n");
                        myWriter.write("mov [rsi], bl\n");
                        myWriter.write("add rsi, 1 \t;incrementa índice\n");
                        myWriter.write("add rdi, 1 \t;incrementa tamanho\n");
                        myWriter.write("neg eax \t;toma módulo do número\n\n");
                        myWriter.write(rot0 + ":\n");
                        myWriter.write("mov ebx, 10 \t;divisor\n\n");
                        
                        String rot1 = novoRot();
                        myWriter.write(rot1 + ":\n");
                        myWriter.write("add rcx, 1 \t;incrementa contador\n");
                        myWriter.write("cdq \t;estende edx:eax p/ div.\n");
                        myWriter.write("idiv ebx \t;divide edx;eax por ebx\n");
                        myWriter.write("push dx \t;empilha valor do resto\n");
                        myWriter.write("cmp eax, 0 \t;verifica se quoc. é 0\n");
                        myWriter.write("jne " + rot1 + "\t;se não for 0, continua\n\n");
                        myWriter.write("add rdi,rcx \t;atualiza tam. string\n\n");
                        myWriter.write(";agora, desemp. os valores e escreve o string\n\n");
    
                        String rot2 = novoRot();
                        myWriter.write(rot2 + ":\n");
                        myWriter.write("pop dx ;desempilha valor\n");
                        myWriter.write("add dl, '0' ;transforma em caractere\n");
                        myWriter.write("mov [rsi], dl ;escreve caractere\n");
                        myWriter.write("add rsi, 1 ;incrementa base\n");
                        myWriter.write("sub rcx, 1 ;decrementa contador\n");
                        myWriter.write("cmp rcx, 0 ;verifica pilha vazia\n");
                        myWriter.write("jne " + rot2 + " ;se não pilha vazia, loop\n\n");
    
                        myWriter.write(";executa interrupção de saída\n");
                        myWriter.write("mov rsi, M+" + toHex(bufferEnd) + " ;ou buffer.end\n");
                        myWriter.write("mov rdx, rdi ;ou buffer.tam\n");
                        myWriter.write("mov rax, 1 ;chamada para saída\n");
                        myWriter.write("mov rdi, 1 ;saída para tela\n");
                        myWriter.write("syscall\n\n");
    
                    }
                    else if ( tipoExpressao.s == "real" ) {
                        myWriter.write("\n; impressao de real\n");
                        myWriter.write("movss xmm0, [qword M+" + toHex(enderecoExpressao.v) + "] ;real a ser convertido\n");
                        myWriter.write("mov rsi, M+" + toHex(bufferEnd) + ";end. temporário\n");
                        myWriter.write("mov rcx, 0 ;contador pilha\n");
                        myWriter.write("mov rdi, 6 ;precisao 6 casas compart\n");
                        myWriter.write("mov rbx, 10 ;divisor\n");
                        myWriter.write("cvtsi2ss xmm2, rbx ;divisor real\n");
                        myWriter.write("subss xmm1, xmm1 ;zera registrador\n");
                        myWriter.write("comiss xmm0, xmm1 ;verifica sinal\n");
                        String rot0 = novoRot();
                        myWriter.write("jae " + rot0 + " ;salta se número positivo\n");
                        myWriter.write("mov dl, '-' ;senão, escreve sinal –\n");
                        myWriter.write("mov [rsi], dl\n");
                        myWriter.write("mov rdx, -1 ;Carrega -1 em RDX\n");
                        myWriter.write("cvtsi2ss xmm1, rdx ;Converte para real\n");
                        myWriter.write("mulss xmm0, xmm1 ;Toma módulo\n");
                        myWriter.write("add rsi, 1 ;incrementa índice\n");
                        myWriter.write("\n" + rot0 + ":\n");
                        myWriter.write("roundss xmm1, xmm0, 0b0011 ;parte inteira xmm1\n");
                        myWriter.write("subss xmm0, xmm1 ;parte frac xmm0\n");
                        myWriter.write("cvtss2si rax, xmm1 ;convertido para int\n");
                        myWriter.write(";converte parte inteira que está em rax\n");
                        String rot1 = novoRot();
                        myWriter.write("\n" + rot1 + ":\n");
                        myWriter.write("add rcx, 1 ;incrementa contador\n");
                        myWriter.write("cdq ;estende edx:eax p/ div.\n");
                        myWriter.write("idiv ebx ;divide edx;eax por ebx\n");
                        myWriter.write("push dx ;empilha valor do resto\n");
                        myWriter.write("cmp eax, 0 ;verifica se quoc. é 0\n");
                        myWriter.write("jne " + rot1 +";se não for 0, continua\n");
                        myWriter.write("sub rdi, rcx ;decrementa precisao\n");
                        myWriter.write(";agora, desemp valores e escreve parte int\n");
                        String rot2 = novoRot();
                        myWriter.write("\n" + rot2 + ":\n");
                        myWriter.write("pop dx ;desempilha valor\n");
                        myWriter.write("add dl, '0' ;transforma em caractere\n");
                        myWriter.write("mov [rsi], dl ;escreve caractere\n");
                        myWriter.write("add rsi, 1 ;incrementa base\n");
                        myWriter.write("sub rcx, 1 ;decrementa contador\n");
                        myWriter.write("cmp rcx, 0 ;verifica pilha vazia\n");
                        myWriter.write("jne " + rot2 + ";se não pilha vazia, loop\n");
                        myWriter.write("mov dl, '.' ;escreve ponto decimal\n");
                        myWriter.write("mov [rsi], dl\n");
                        myWriter.write("add rsi, 1 ;incrementa base\n");
                        myWriter.write(";converte parte fracionaria que está em xmm0\n");
                        String rot3 = novoRot();
                        myWriter.write("\n" + rot3 + ":\n");
                        myWriter.write("cmp rdi, 0 ;verifica precisao\n");
                        String rot4 = novoRot();
                        myWriter.write("jle " + rot4 + ";terminou precisao ?\n");
                        myWriter.write("mulss xmm0,xmm2 ;desloca para esquerda\n");
                        myWriter.write("roundss xmm1,xmm0,0b0011 ;parte inteira xmm1\n");
                        myWriter.write("subss xmm0,xmm1 ;atualiza xmm0\n");
                        myWriter.write("cvtss2si rdx, xmm1 ;convertido para int\n");
                        myWriter.write("add dl, '0' ;transforma em caractere\n");
                        myWriter.write("mov [rsi], dl ;escreve caractere\n");
                        myWriter.write("add rsi, 1 ;incrementa base\n");
                        myWriter.write("sub rdi, 1 ;decrementa precisao\n");
                        myWriter.write("jmp " + rot3 + "\n");
                        myWriter.write("; impressão\n");
                        myWriter.write("\n" + rot4 + ":\n");
                        myWriter.write("mov dl, 0 ;fim string, opcional\n");
                        myWriter.write("mov [rsi], dl ;escreve caractere\n");
                        myWriter.write("mov rdx, rsi ;calc tam str convertido\n");
                        myWriter.write("mov rbx, M+" + toHex(bufferEnd) + "\n");
                        myWriter.write("sub rdx, rbx ;tam=rsi-M-buffer.end\n");
                        myWriter.write("mov rsi, M+" + toHex(bufferEnd) + "; endereço do buffer\n");
                        myWriter.write(";executa interrupção de saída.\n");
                        myWriter.write("mov rax, 1 ;chamada para saída\n");
                        myWriter.write("mov rdi, 1 ;saída para tela\n");
                        myWriter.write("syscall\n\n");
                    }
                    else if (tipoExpressao.s == "caractere" ) { // tipo caractere
                        myWriter.write("\n; impressao de caractere\n");
                        myWriter.write("mov rsi, M+"+ toHex(enderecoExpressao.v) +" ;ou buffer.end\n");
                        myWriter.write("mov rdx, 1 ; tamanho char\n");
                        myWriter.write("mov rax, 1 ;chamada para saída\n");
                        myWriter.write("mov rdi, 1 ;saída para tela\n");
                        myWriter.write("syscall\n\n");
                    }
                    else { //tipo string
                        myWriter.write("\n; impressao de string\n");
                        myWriter.write("mov rsi, M+"+ toHex(enderecoExpressao.v) +" ;ou buffer.end\n");
                        myWriter.write("mov rdx, "+ tamanhoExpressao.v + " ;ou buffer.tam\n");
                        myWriter.write("mov rax, 1 ;chamada para saída\n");
                        myWriter.write("mov rdi, 1 ;saída para tela\n");
                        myWriter.write("syscall\n\n");
                    }
    
                    if ( novaLinha ) {
                        myWriter.write("mov al, 0ah\n");
                        myWriter.write("mov [M+" + toHex(bufferEnd) + "], al\n");
                        myWriter.write("mov rsi, M+"+ toHex(bufferEnd) +" ;ou buffer.end\n");
                        myWriter.write("mov rdx, "+ 1 + "\n");
                        myWriter.write("mov rax, 1 ;chamada para saída\n");
                        myWriter.write("mov rdi, 1 ;saída para tela\n");
                        myWriter.write("syscall\n");
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            casa_token(")");
            casa_token(";");
        }
    }

    // Expressao -> F [ ([!]=|<[=]|>[=]) F ]
    static void Expressao ( paramString tipoExpressao, paramInt enderecoExpressao, paramInt tamanhoExpressao ) {
        paramString tipoF = new paramString();
        paramInt enderecoF = new paramInt();
        paramInt tamanhoF = new paramInt();
        F(tipoF, enderecoF, tamanhoF);
        tipoExpressao.s = tipoF.s;
        enderecoExpressao.v = enderecoF.v;
        tamanhoExpressao.v = tamanhoF.v;
        String operador = reg.token;
        if ( reg.token == "=" || reg.token == "!=" || reg.token == "==" || reg.token == "<" || reg.token == "<="
        || reg.token == ">" || reg.token == ">=" ) {
            casa_token(reg.token);
            paramString tipoF1 = new paramString();
            paramInt enderecoF1 = new paramInt();
            paramInt tamanhoF1 = new paramInt();
            F(tipoF1, enderecoF1, tamanhoF1);
            // geracao de codigo
            try {
                /*
                comparacao entre strings
                unica operacao valida entre strings e' a igualdade (=)
                tambem aponta erro caso os tipos sejam diferentes
                */
                if ( tipoF.s == "string" || tipoF1.s == "string" ) {
                    if ( operador != "=" || ( tipoF.s != tipoF1.s )) {
                        erro3();
                    }
                    else {
                        /*
                        comparacao entre strings
                        o resultado da expressao esta sendo armazenado em eax
                        foi necessario definir tambem um rotulo para o caso de ser verdadeiro porque nao tinha
                        um registrador disponivel para armazenar o resultado durante a comparacao, ja que em
                        al estava o contador, bl com o tamanho, cl o caractere em F e dl o caractere em F1
                        */
                        myWriter.write(";comparacao entre strings\n");
                        String rotInicio = novoRot();
                        String rotVerdadeiro = novoRot();
                        String rotFalso = novoRot();
                        String rotFim = novoRot();
                        myWriter.write("mov al, 0\t; contador recebe 0\n");
                        myWriter.write("mov bl, " + tamanhoF.v + "\t; bl recebe tamanho expressao\n");
                        myWriter.write("mov rdi, M+" + toHex(enderecoF.v) + "\t; armazena endereco da string de F id em rdi\n");
                        myWriter.write("mov rsi, M+" + toHex(enderecoF1.v) + "\t; armazena endereco da string de F1 em rsi\n");
                        myWriter.write("\n" + rotInicio + ":\t; definicao do rotInicio\n");
                        myWriter.write("cmp al, bl");
                        myWriter.write("je " + rotVerdadeiro + "\t; se contador for igual a tamanho, terminou a comparacao entao pula para rotVerdadeiro\n");
                        myWriter.write("mov cl, [rsi]\t; passa caractere no endereco apontador por rsi para cl\n");
                        myWriter.write("mov dl, [rdi]\t; passa caractere no endereco apontador por rsi para dl\n");
                        myWriter.write("cmp cl, dl\t; compara caractere das strings\n");
                        myWriter.write("jne " + rotFalso + "\t; se nao forem iguais pula para rotfalso\n");
                        myWriter.write("add al, 1\t; incrementa contador\n");
                        // aumenta enderecos do id e da expressao para acessar o proximo caractere na proxima iteracao
                        myWriter.write("add rdi, 1\t; incrementa endereco da string de F\n");
                        myWriter.write("add rsi, 1\t; incrementa endereco da string da F1\n");
                        myWriter.write("jmp " + rotInicio + "\t; volta para rotInicio para atribuir proximo caractere\n");
                        myWriter.write("\n" + rotVerdadeiro + ":\t; definicao do rotVerdadeiro\n");
                        myWriter.write("mov eax, 1\t; define resultado como 1 (true)\n");
                        myWriter.write("jmp " + rotFim + "; pula para o fim da comparacao\n");
                        myWriter.write("\n" + rotFalso + ":\t; definicao do rotFalso\n");
                        myWriter.write("mov eax, 0\t; define resultado como 0 (false)\n");
                        myWriter.write("\n" + rotFim + ":\t; definicao do rotFim\n");
                        myWriter.write("mov [M+" + toHex(enderecoExpressao.v) + "], eax\t; guarda resultado logico da expressao\n");
                        tipoExpressao.s = "logica";
                    }
                }
                // se algum dos operadores for do tipo vazio e' uma palavra reservada, e nao pode fazer nenhuma operacao
                else if ( tipoF.s == "" || tipoF1.s == "" ) {
                    erro3();
                }
                // operacoes entre tipos inteiros ou reais
                else {
                    // comparacao entre caracteres
                    if ( tipoF.s == "caractere" || tipoF1.s == "caractere" ) {
                        // aponta erro de tipos incompatives caso um dos dois nao seja um caractere
                        if ( tipoF.s != tipoF1.s ) {
                            erro3();
                        }
                        else {
                            myWriter.write("; comparacao entre caracteres\n");
                            myWriter.write("mov al, [M+" + toHex(enderecoF.v) + "]\t; armazena valor de " + toHex(enderecoF.v) + " em al\n");
                            myWriter.write("mov bl, [M+" + toHex(enderecoF1.v) + "]\t; armazena valor de " + toHex(enderecoF1.v) + " em bl\n");
                            myWriter.write("cmp al, bl\t; compara al com bl\n");
                        }
                    }
                    // comparacao entre reais
                    // se algum deles for inteiro, faz a conversao para real
                    else if ( tipoF.s == "real" || tipoF.s == "real" ) {
                        if ( tipoF.s == "real" ) {
                            myWriter.write("movss xmm0, [M+" + toHex(enderecoF.v) + "]\t; armazena valor de " + toHex(enderecoF.v) + " em xmm0\n");
                        }
                        else {
                            myWriter.write(";converte inteiro em " + toHex(enderecoF.v) + " para real e guarda em xmm0\n");
                            myWriter.write("mov eax, [M+" + toHex(enderecoF.v) + "]\n");
                            myWriter.write("cdqe\n");
                            myWriter.write("cvtsi2ss xmm0, rax\n");
                        }
                        if ( tipoF1.s == "real" ) {
                            myWriter.write("movss xmm1, [M+" + toHex(enderecoF1.v) + "]\t; armazena valor de " + toHex(enderecoF1.v) + " em xmm1\n");
                        }
                        else {
                            myWriter.write(";converte inteiro em " + toHex(enderecoF1.v) + " para real e guarda em xmm1\n");
                            myWriter.write("mov eax, [M+" + toHex(enderecoF1.v) + "]\n");
                            myWriter.write("cdqe\n");
                            myWriter.write("cvtsi2ss xmm1, rax\n");
                        }
                        myWriter.write("comiss xmm0, xmm1\t; compara xmm0 com xmm1\n");
                    }
                    // comparacao entre inteiros
                    else {
                        myWriter.write("mov eax, [M+" + toHex(enderecoF.v) + "]\t; armazena valor de " + toHex(enderecoF.v) + " em eax\n");
                        myWriter.write("mov ebx, [M+" + toHex(enderecoF1.v) + "]\t; armazena valor de " + toHex(enderecoF1.v) + " em ebx\n");
                        myWriter.write("cmp eax, ebx\t; compara eax com ebx\n");
                    }
                    String rotVerdadeiro = novoRot();
                    // escreve o pulo de acordo com o operador
                    if ( operador == "=" ) {
                        myWriter.write("je " + rotVerdadeiro + "\t; caso sejam iguais, pula para rotVerdadeiro\n");
                    }
                    else if ( operador == "!=" ) {
                        myWriter.write("jne " + rotVerdadeiro + "\t; caso nao sejam iguais, pula para rotVerdadeiro\n");
                    }
                    else if ( operador == "<" ) {
                        myWriter.write("jb " + rotVerdadeiro + "\t; caso xmm0 seja menor que xmm1, pula para rotVerdadeiro\n");
                    }
                    else if ( operador == "<=" ) {
                        myWriter.write("jbe " + rotVerdadeiro + "\t; caso xmm0 seja menor ou igual a xmm1, pula para rotVerdadeiro\n");
                    }
                    else if ( operador == ">" ) {
                        myWriter.write("jg " + rotVerdadeiro + "\t; caso xmm0 seja maior que xmm1, pula para rotVerdadeiro\n");
                    }
                    else { // operador >=
                        myWriter.write("jge " + rotVerdadeiro + "\t; caso xmm0 seja maior ou igual a xmm1, pula para rotVerdadeiro\n");
                    }
                    myWriter.write("mov eax, 0\t; se nao tiver pulado, define o valor logico em como 0\n");
                    String rotFim = novoRot();
                    myWriter.write("jmp " + rotFim + "\t ; pula para rotFim \n");
                    myWriter.write("\n" + rotVerdadeiro + ":\t; definicao do rotVerdadeiro\n");
                    myWriter.write("mov eax, 1\t; caso a expressao seja verdadeira, muda o valor logico em eax para 1\n");
                    myWriter.write("\n" + rotFim + ":\t; definicao do rotFim\n");
                    enderecoExpressao.v = novoTemp("logica");
                    tipoExpressao.s = "logica";
                    myWriter.write("mov [qword M+" + toHex(enderecoExpressao.v) + "], eax\t; guarda o valor logico da expressao em " + toHex(enderecoExpressao.v) + "\n");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // F -> E { ( -|+|"|""|") E }
    static void F (paramString tipoF, paramInt enderecoF, paramInt tamanhoF) {
        paramString tipoE = new paramString();
        paramInt enderecoE = new paramInt();
        paramInt tamanhoE = new paramInt();
        E(tipoE, enderecoE, tamanhoE);
        tipoF.s = tipoE.s;
        enderecoF.v = enderecoE.v;
        tamanhoF.v = tamanhoE.v;
        while ( reg.token == "-" || reg.token == "+" || reg.token == "||" ) {
            String operador = reg.token;
            casa_token(reg.token);
            paramString tipoE1 = new paramString();
            paramInt enderecoE1 = new paramInt();
            paramInt tamanhoE1 = new paramInt();
            E(tipoE1, enderecoE1, tamanhoE1);
            try {
                // geracao de codigo
                // ou logico
                if ( operador == "||" ) {
                    // se algum dos operandos nao for do tipo logico indica erro de incompatibilidade de tipos
                    if ( tipoE.s != "logica" || tipoE1.s != "logica" ) {
                        erro3();
                    }
                    else {
                        myWriter.write("; inicio de operacao ou logico (||)\n");
                        myWriter.write("mov eax, [M+" + toHex(enderecoE.v) + "]\t; armazena o valor de " + toHex(enderecoE.v) + " em eax\n");
                        myWriter.write("mov ebx, [M+" + toHex(enderecoE1.v) + "]\t; armazena o valor de " + toHex(enderecoE.v) + " em eax\n");
                        myWriter.write("add eax, ebx\t; soma eax e ebx\n");
                        myWriter.write("cmp eax, 0\t; compara eax com 0\n");
                        String rotFalso = novoRot();
                        String rotFim = novoRot();
                        myWriter.write("je " + rotFalso + "\t; caso eax seja igual a 0, nenhum dos operandos era igual a 1, entao pula para rotFalso\n");
                        myWriter.write("mov eax, 1\t; muda o valor de eax para 1 (true)\n");
                        myWriter.write("jmp " + rotFim + "\t; pula para o fim da operacao\n");
                        myWriter.write("\n"+  rotFalso + ":\t; definicao do rotFalso\n");
                        myWriter.write("mov eax, 0\t; muda o valor de eax para 0 (false)\n");
                        myWriter.write("\n" + rotFim + ":\t; definicao do rotFim\n");
                        myWriter.write("mov [M+" + toHex(enderecoE.v) + "], eax\t; armazena resultado do ou logico em " + toHex(enderecoE.v) + "\n");
                        myWriter.write("; fim da operacao ou logico (||)\n");
                        tipoF.s = "logica";
                    }
                }
                // soma ou subtracao aritmetica
                // indica erro de tipos incompativeis caso algum dos operandos nao seja inteiro ou real
                else if ( ( tipoE.s != "inteiro" && tipoE.s != "real" ) || ( tipoE1.s != "inteiro" && tipoE1.s != "real") ) {
                    erro3();
                }
                // se algum deles for real, faz a conversao
                else if ( tipoE.s == "real" || tipoE1.s == "real" ) {
                    if ( tipoF.s == "real" ) {
                        myWriter.write("movss xmm0, [M+" + toHex(enderecoF.v) + "]\t; armazena valor de " + toHex(enderecoF.v) + " em xmm0\n");
                    }
                    else {
                        myWriter.write(";converte inteiro em " + toHex(enderecoF.v) + " para real e guarda em xmm0\n");
                        myWriter.write("mov eax, [M+" + toHex(enderecoF.v) + "]\n");
                        myWriter.write("cdqe\n");
                        myWriter.write("cvtsi2ss xmm0, rax\n");
                    }
                    if ( tipoE1.s == "real" ) {
                        myWriter.write("movss xmm1, [M+" + toHex(enderecoE1.v) + "]\t; armazena valor de " + toHex(enderecoE1.v) + " em xmm1\n");
                    }
                    else {
                        myWriter.write(";converte inteiro em " + toHex(enderecoE1.v) + " para real e guarda em xmm1\n");
                        myWriter.write("mov eax, [M+" + toHex(enderecoE1.v) + "]\n");
                        myWriter.write("cdqe\n");
                        myWriter.write("cvtsi2ss xmm1, rax\n");
                    }
                    if ( operador == "+" ) {
                        myWriter.write("addss xmm0, xmm1\t; soma xmm0 e xmm1\n");
                    }
                    else { // operador -
                        myWriter.write("subss xmm0, xmm1\t; subtrai xmm1 de xmm0\n");
                    }
                    myWriter.write("movss [M+" + toHex(enderecoF.v) + "], xmm0\t; armazena o resultado em " + toHex(enderecoF.v) + "\n");
                    tipoF.s = "real";
                }
                // senao, se trata de uma operacao entre inteiros
                else {
                    tipoF.s = "inteiro";
                    myWriter.write("mov eax, [M+" + toHex(enderecoF.v) + "]\t; armazena o valor de " + toHex(enderecoF.v) +"em eax\n");
                    myWriter.write("mov ebx, [M+" + toHex(enderecoE1.v) + "]\t; armazena o valor de " + toHex(enderecoE1.v) +"em ebx\n");
                    if ( operador == "+" ) {
                        myWriter.write("add eax, ebx\t; soma eax e ebx\n");
                    }
                    else { //operador - 
                        myWriter.write("sub eax, ebx\t; subtrai ebx de eax\n");
                    }
                    myWriter.write("mov [M+" + toHex(enderecoF.v) + "], eax\t; armazena o resultado em " + toHex(enderecoF.v) + "\n");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // E -> D { (*|/|div|mod|&&) D }
    static void E (paramString tipoE, paramInt enderecoE, paramInt tamanhoE) {
        paramString tipoD = new paramString();
        paramInt enderecoD = new paramInt();
        paramInt tamanhoD = new paramInt();
        D(tipoD, enderecoD, tamanhoD);
        tipoE.s = tipoD.s;
        enderecoE.v = enderecoD.v;
        tamanhoE.v = tamanhoD.v;
        while ( reg.token == "*" || reg.token == "/" || reg.token == "div"
        || reg.token == "mod" || reg.token == "&&" ) {
            try {
                String operador = reg.token;
                casa_token(reg.token);
                paramString tipoD1 = new paramString();
                paramInt enderecoD1 = new paramInt();
                paramInt tamanhoD1 = new paramInt();
                D(tipoD1, enderecoD1, tamanhoD1);
                if ( operador == "&&" ) {
                    // os operandos do and logico tem que ser do tipo logico
                    if ( tipoE.s != "logica" || tipoD1.s != "logica") {
                        erro3();
                    }
                    else {
                        // geracao de codigo do &&
                        myWriter.write(";inicio do &&\n");
                        myWriter.write("mov eax, [M+" + toHex(enderecoD.v) + "]\t; armazena o valor de " + toHex(enderecoD.v) +"em eax\n");
                        myWriter.write("mov ebx, [M+" + toHex(enderecoD1.v) + "]\t; armazena o valor de " + toHex(enderecoD1.v) +"em ebx\n");
                        myWriter.write("add eax, ebx\t; soma eax a ebx\n");
                        myWriter.write("cmp eax, 2\t; compara eax com 2\n");
                        String rotFalso = novoRot();
                        String rotFim = novoRot();
                        myWriter.write(";se eax nao for igual a 2, algum dos operadores nao era 1, entao a expressao era falsa");
                        myWriter.write("jne " + rotFalso + "\t; se eax nao for igual a 2, pula para + " + rotFalso + "\n");
                        myWriter.write("mov eax, 1\t; armazena resultado do and logico em eax\n");
                        myWriter.write("jmp " + rotFim + "\t; pula para rotFim\n");
                        myWriter.write("\n"+  rotFalso + ":\t; definicao do rotFalso\n");
                        myWriter.write("mov eax, 0\t; armazena resultado do and em eax\n");
                        myWriter.write("\n" + rotFim + ":\t; definicao do rotFim\n");
                        myWriter.write("mov [M+" + toHex(enderecoD.v) + "], eax\t; armazena o resultado do and logico em " + toHex(enderecoD.v) +"\n");
                        tipoE.s = "logica";
                    }
                }
                else if ( operador == "div" || operador == "mod" ) {
                    
                    if ( tipoE.s != "inteiro" || tipoD1.s != "inteiro")   { 
                        erro3();
                    }
                    else {
                        tipoE.s = "inteiro";
                        // geracao do codigo de div ou mod
                        myWriter.write("mov eax, [M+" + toHex(enderecoE.v) + "]\n");
                        myWriter.write("mov ebx, [M+" + toHex(enderecoD1.v) + "]\n");
                        myWriter.write("cdq\t; expande eax\n");
                        myWriter.write("idiv ebx\t; divide eax por ebx\n");
                        if ( operador == "div" ) {
                            myWriter.write("mov [M+" + toHex(enderecoE.v) + "], eax\t; armazena quociente da divisao em " + toHex(enderecoE.v) +"\n");
                        }
                        else { // operador mod
                            myWriter.write("mov [M+" + toHex(enderecoE.v) + "], edx\t; armazena resto da divisao em " + toHex(enderecoE.v) +"\n");
                        }
                    }
                }
                // operador * ou / (divisao real), os operadores tem que ser do tipo inteiro ou real
                else if ( ( tipoE.s != "inteiro" && tipoE.s != "real" ) || ( tipoD1.s != "inteiro" && tipoD1.s != "real" ) ) {
                    erro3();
                }
                // geracao de codigo do * ou /
                // caso um dos dois operandos seja real, converte o outro
                else if ( tipoE.s == "real" || tipoD1.s == "real" ) {
                    if ( tipoE.s == "real" ) {
                        myWriter.write("movss xmm0, [M+" + toHex(enderecoE.v) +"]\t; armazena o valor de " + toHex(enderecoE.v) +"em xmm0\n");
                    }
                    else {
                        myWriter.write(";converte inteiro em " + toHex(enderecoE.v) + " para real e guarda em xmm1\n");
                        myWriter.write("mov eax, [M+" + toHex(enderecoE.v) + "]\n");
                        myWriter.write("cdqe\n");
                        myWriter.write("cvtsi2ss xmm0, rax\n");
                    }
                    if ( tipoD1.s == "real" ) {
                        myWriter.write("movss xmm1, [M+" + toHex(enderecoD1.v) + "]\t; armazena o valor de " + toHex(enderecoD1.v) +"em xmm1\n");
                    }
                    else {
                        myWriter.write(";converte inteiro em " + toHex(enderecoD1.v) + " para real e guarda em xmm1\n");
                        myWriter.write("mov eax, [M+" + toHex(enderecoD1.v) + "]\n");
                        myWriter.write("cdqe\n");
                        myWriter.write("cvtsi2ss xmm1, rax\n");
                    }
                    if ( operador == "*" ) {
                        myWriter.write("mulss xmm0, xmm1\t; multiplica xmm0 e xmm1\n");
                        myWriter.write("movss [M+" + toHex(enderecoE.v) + "], xmm0\t; armazena o resultado da multiplicacao em " + toHex(enderecoE.v) +"\n" );
                    }
                    else { // operador /
                        myWriter.write("divss xmm0, xmm1\t; divide xmm0 por xmm1\n");
                        myWriter.write("movss [M+" + toHex(enderecoE.v) + "], xmm0\t; armazena o resultado da divisao em " + toHex(enderecoE.v) +"\n");
                    }
                    tipoE.s = "real";
                }
                // * ou / entre inteiros
                else {
                    tipoE.s = "inteiro";
                    if ( operador == "*" ) {
                        myWriter.write("mov eax, [M+" + toHex(enderecoE.v) + "]\t; armazena o valor de " + toHex(enderecoE.v) +"em eax\n");
                        myWriter.write("mov ebx, [M+" + toHex(enderecoD1.v) + "]\t; armazena o valor de " + toHex(enderecoD1.v) +"em ebx\n");
                        myWriter.write("imul ebx\t; multiplica eax por ebx\n");
                        myWriter.write("mov [M+" + toHex(enderecoE.v) + "], eax\t; armazena o resultado da multiplicacao " + toHex(enderecoE.v) +"\n");
                    }
                    else { // operador /
                        tipoE.s = "real";
                        myWriter.write(";converte inteiro em " + toHex(enderecoE.v) + " para real e guarda em xmm1\n");
                        myWriter.write("mov eax, [M+" + toHex(enderecoE.v) + "]\n");
                        myWriter.write("cdqe\n");
                        myWriter.write("cvtsi2ss xmm0, rax\n");
                        myWriter.write(";converte inteiro em " + toHex(enderecoD1.v) + " para real e guarda em xmm1\n");
                        myWriter.write("mov eax, [M+" + toHex(enderecoD1.v) + "]\n");
                        myWriter.write("cdqe\n");
                        myWriter.write("cvtsi2ss xmm1, rax\n");
                        myWriter.write("divss xmm0, xmm1\t; divide xmm0 por xmm1\n");
                        myWriter.write("movss [M+" + toHex(enderecoE.v) + "], xmm0\t; armazena o resultado da divisao em " + toHex(enderecoE.v) +"\n");
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // D -> {!}C
    static void D (paramString tipoD, paramInt enderecoD, paramInt tamanhoD) {
        String operador = reg.token;
        boolean negado = false;
        while ( reg.token == "!" ) {
            negado = !negado;
            casa_token("!");
        }
        paramString tipoC = new paramString();
        paramInt enderecoC = new paramInt();
        paramInt tamanhoC = new paramInt();
        C(tipoC, enderecoC, tamanhoC);
        tipoD.s = tipoC.s;
        enderecoD.v = enderecoC.v;
        tamanhoD.v = tamanhoC.v;
        if ( operador == "!" ) {
            // a operacao not so pode ser feita em tipos logicos
            if ( tipoC.s != "logica" ) {
                erro3();
            }
            // mesmo se tiver encontrado o operador !, nao e necessario negar o valor caso 
            // a quantidade de operadores ! seja par, ja que o resultado e' o mesmo
            else if ( negado ) {
                tipoD.s = "logica";
                enderecoD.v = novoTemp("logica");
                try {
                    // geracao de codigo do not
                    myWriter.write("mov eax, [qword M+" + toHex(enderecoC.v) + "]\t; armazena " + toHex(enderecoC.v) +" em eax\n");
                    myWriter.write(";negacao de eax\n");
                    myWriter.write("neg eax\t; \n");
                    myWriter.write("add eax, 1\n");
                    myWriter.write("mov [qword M+" + toHex(enderecoD.v) + "], eax\t; guarda o valor da negacao em " + toHex(enderecoD.v) + "\n");
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                enderecoD.v = enderecoC.v;
            }
        }
        else {
            tipoD.s = tipoC.s;
        }
    }

    // C -> B | {(int|float) "(" Expressao ")"}+
    static void C (paramString tipoC, paramInt enderecoC, paramInt tamanhoC) {
        
        if ( reg.token == "(" || reg.token == "id" || reg.token == "valor" ) {
            paramString tipoB = new paramString();
            paramInt enderecoB = new paramInt();
            paramInt tamanhoB = new paramInt();
            B(tipoB, enderecoB, tamanhoB);
            tipoC.s = tipoB.s;
            enderecoC.v = enderecoB.v;
            tamanhoC.v = tamanhoB.v;
        }
        else {
            boolean negado = false;
            // definir o tipo de C baseado no tipo para o qual sera convertido
            if ( reg.token == "int" ) {
                tipoC.s = "inteiro";
                casa_token("int");
            }
            else {
                tipoC.s = "real";
                casa_token("float");
            }
            casa_token("(");
            negado = false;
            if ( reg.token == "-" ) {
                negado = true;
                casa_token("-");
            }
            paramString tipoExpressao = new paramString();
            paramInt enderecoExpressao = new paramInt();
            paramInt tamanhoExpressao = new paramInt();
            Expressao(tipoExpressao, enderecoExpressao, tamanhoExpressao);
            // apenas numeros podem ser convertidos
            // indica erro de tipos incompativeis caso tipo seja caractere, string ou vazio
            if ( tipoExpressao.s != "inteiro" && tipoExpressao.s != "real" ) {
                erro3();
            }
            try {
                if ( tipoC.s != tipoExpressao.s ) {
                    if ( tipoExpressao.s == "inteiro" ) {
                        myWriter.write("mov rax, [M+" + toHex(enderecoExpressao.v) + "]\t; armazena o valor de " + toHex(enderecoExpressao.v) +"em rax\n");
                        if ( negado ) {
                            myWriter.write("neg rax\t; rax = -rax\n");
                        }
                        myWriter.write("cvtsi2ss xmm0, rax\t; converte rax para real em xmm0\n");
                        enderecoC.v = novoTemp("real");
                        myWriter.write("movss [M+" + toHex(enderecoC.v) + "], xmm0\t; armazena o resultado da conversao para float em " + toHex(enderecoC.v) +"\n");
                    }
                    else { // expressao real, converter para inteiro
                        myWriter.write("movss xmm0, [M+" + toHex(enderecoExpressao.v) + "]\t; armazena o valor de " + toHex(enderecoExpressao.v) +"em xmm0\n");
                        myWriter.write("cvtss2si rax, xmm0\t; converte xmm0 para inteiro em rax\n");
                        enderecoC.v = novoTemp("inteiro");
                        if ( negado ) {
                            myWriter.write("neg rax\t; rax = -rax\n");
                        }
                        myWriter.write("mov [M+" + toHex(enderecoC.v) + "], rax\t; armazena o resultado da conversao para int em " + toHex(enderecoExpressao.v) +"\n");
                    }
                }
                else {
                    enderecoC.v = enderecoExpressao.v;
                }
                casa_token(")");
                // repete o codigo acima caso existam mais conversoes
                while ( reg.token == "int" || reg.token == "float" ) {
                    if ( reg.token == "int" ) {
                        tipoC.s = "inteiro";
                    }
                    else {
                        tipoC.s = "real";
                    }
                    casa_token(reg.token);
                    casa_token("(");
                    if ( reg.token == "-" ) {
                        negado = true;
                        casa_token("-");
                    }
                    else {
                        negado = false;
                    }
                    paramString tipoExpressao1 = new paramString();
                    paramInt enderecoExpressao1 = new paramInt();
                    paramInt tamanhoExpressao1 = new paramInt();
                    Expressao(tipoExpressao1, enderecoExpressao1, tamanhoExpressao1);
                    if ( tipoExpressao1.s != "inteiro" && tipoExpressao1.s != "real" ) {
                        erro3();
                    }
                    if ( tipoC.s != tipoExpressao1.s ) {
                        if ( tipoExpressao1.s == "inteiro" ) {
                            myWriter.write("mov rax, [M+" + toHex(enderecoExpressao1.v) + "]\t; armazena o valor de " + toHex(enderecoExpressao1.v) +"em rax\n");
                            if ( negado ) {
                                myWriter.write("neg rax\t; rax = -rax\n");
                            }
                            myWriter.write("cvtsi2ss xmm0, rax\t; converte rax para real em xmm0\n");
                            enderecoC.v = novoTemp("real");
                            myWriter.write("movss [M+" + toHex(enderecoC.v) + "], xmm0\t; armazena o resultado da conversao para float em " + toHex(enderecoC.v) +"\n");
                        }
                        else { // expressao real, converter para inteiro
                            myWriter.write("movss xmm0, [M+" + toHex(enderecoExpressao1.v) + "]\t; armazena o valor de " + toHex(enderecoExpressao.v) +"em xmm0\n");
                            myWriter.write("cvtss2si rax, xmm0\t; converte xmm0 para inteiro em rax\n");
                            enderecoC.v = novoTemp("inteiro");
                            if ( negado ) {
                                myWriter.write("neg rax\t; rax = -rax\n");
                            }
                            myWriter.write("mov [M+" + toHex(enderecoC.v) + "], rax\t; armazena o resultado da conversao para int em " + toHex(enderecoC.v) +"\n");
                        }
                    }
                    else {
                        enderecoC.v = enderecoExpressao1.v;
                    }
                    casa_token(")");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // B -> A | {"(" Expressao ")"}+
    static void B (paramString tipoB, paramInt enderecoB, paramInt tamanhoB) {
        
        // primeira regra caso token seja id ou valor
        // B -> A
        if ( reg.token == "id" || reg.token == "valor" ) {
            paramString tipoA = new paramString();
            paramInt enderecoA = new paramInt();
            paramInt tamanhoA = new paramInt();
            A(tipoA, enderecoA, tamanhoA);
            tipoB.s = tipoA.s;
            enderecoB.v = enderecoA.v;
            tamanhoB.v = tamanhoA.v;
            }
        // segunda regra caso contrario
        // B -> {"(" Expressao ")"}+
        else {
            casa_token("(");
            paramString tipoExpressao = new paramString();
            paramInt enderecoExpressao = new paramInt();
            paramInt tamanhoExpressao = new paramInt();
            Expressao(tipoExpressao, enderecoExpressao, tamanhoExpressao);
            tipoB.s = tipoExpressao.s;
            enderecoB.v = enderecoExpressao.v;
            tamanhoB.v = tamanhoExpressao.v;
            casa_token(")");
            // continua a operacao de parenteses caso encontre outro parenteses aberto
            while ( reg.token == "(" ) {
                casa_token("(");
                paramString tipoExpressao1 = new paramString();
                paramInt enderecoExpressao1 = new paramInt();
                paramInt tamanhoExpressao1 = new paramInt();
                Expressao(tipoExpressao1, enderecoExpressao1, tamanhoExpressao1);
                tipoB.s = tipoExpressao1.s;
                enderecoB.v = enderecoExpressao1.v;
                tamanhoB.v = tamanhoExpressao1.v;
                casa_token(")");
            }
        }
    }

    // A -> id [ "["valor"]"] | valor
    static void A (paramString tipoA, paramInt enderecoA, paramInt tamanhoA) {
        String tipo = "";
        int enderecoId = 0;
        int tamanhoId = 0;
        // primeira regra caso o token lido seja um id
        // A -> id [ "["valor"]"] 
        if ( reg.token == "id" ) {
            boolean acessoVetor = false;
            registroTabela registro = t.pesquisar(reg.lexema);
            // caso tente acessar um registro que nao existe, indica erro de identificador nao declarado
            // senao, caso seja uma palavra reservada, indica erro de tipos incompativeis
            // senao, define o tipo de a como o tipo do identificador
            if ( registro == null ) {
                erro1();
            }
            else if ( registro.classe != "classe-var" && registro.classe != "classe-const" ) {
                erro3();
            }
            else {
                tipoA.s = registro.tipo;
            }
            enderecoId = registro.endereco;
            // armazena tamanho caso seja uma string
            if ( registro.tipo == "string" ) {
                tamanhoId = registro.tamanho;
                tipo = "string";
            }
            casa_token("id");
            paramString tipoExpressao = new paramString();
            paramInt enderecoExpressao = new paramInt();
            paramInt tamanhoExpressao = new paramInt();
            // depois do identificador, caso o token lido seja um [ inicia a parte de acesso a posicao do vetor
            if ( reg.token == "[" ) {
                acessoVetor = true;
                casa_token("[");
                Expressao(tipoExpressao, enderecoExpressao, tamanhoExpressao);
                // e possivel acessar apenas posicoes de strings
                // a posicao acessada sera um caractere
                if ( tipoA.s != "string" || tipoExpressao.s != "inteiro" ) {
                    erro3();
                }
                else {
                    tipoA.s = "caractere";
                }
                casa_token("]");
            }
            try {
                // geracao de codigo
                if ( acessoVetor ) { // acesso a posicao de string, endereco de a sera o endereco da posicao acessada
                    enderecoA.v = novoTemp(tipoA.s);
                    myWriter.write("; acesso a posicao de um string\n");
                    myWriter.write("mov rax, [M+" + toHex(enderecoExpressao.v) +"]\t; armazena o conteudo de " + toHex(enderecoExpressao.v) +" (indice) em rax\n");
                    myWriter.write("add rax, M+" + toHex(enderecoId) + "\t; soma rax ao endereco da string\n");
                    myWriter.write("mov rbx, [rax]\t; armazena o conteudo do endereco da posicao em rbx\n");
                    myWriter.write("mov [M+" + toHex(enderecoA.v) + "], rbx\t; armazena o conteudo da posicao da string em " + toHex(enderecoA.v) +"\n");
                }
                else {
                    // atualiza endereco de a para o endereco do identificador
                    // tambem atualiza o tamanho no caso de ser um string
                    enderecoA.v = enderecoId;
                    if ( tipo == "string" ) {
                        tamanhoA.v = tamanhoId;
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        // segunda regra caso o token lido nao seja um id
        // B -> valor 
        else {
            tipoA.s = reg.tipo;
            try {
                // geracao de codigo
                // acessa o valor da constante e faz as reservas de memoria de acordo com o tipo
                if ( reg.tipo == "string" ) {
                    myWriter.write("\nsection .data\t; sessao de dados\n");
                    myWriter.write("db " + reg.lexema + ",0\t; String em + " + toHex(memoriaDados) + "\n");
                    myWriter.write("\nsection .text\t ; sessao de codigo\n");
                    enderecoA.v = memoriaDados;
                    memoriaDados += reg.lexema.length()-1;
                    tamanhoA.v = reg.lexema.length()-1;
                }
                else if ( reg.tipo == "real" ) {
                    myWriter.write("\nsection .data\t; sessao de dados\n");
                    myWriter.write("dd " + reg.lexema + "; float em + " + toHex(memoriaDados) + "\n");
                    myWriter.write("\nsection .text\t; sessao de codigo\n");
                    enderecoA.v = memoriaDados;
                    memoriaDados += 4;
                }
                else if ( reg.tipo == "inteiro" ) {
                    enderecoA.v = novoTemp("inteiro");
                    myWriter.write(";armazena inteiro em " + toHex(enderecoA.v) + "\n");
                    myWriter.write("mov eax, " + reg.lexema + "\n");
                    myWriter.write("mov [M+" + toHex(enderecoA.v) +"], eax\n");
                }
                else { // caractere
                    enderecoA.v = novoTemp("caractere");
                    myWriter.write(";armazena caractere em " + toHex(enderecoA.v) + "\n");
                    myWriter.write("mov al, " + reg.lexema +"\n");
                    myWriter.write("mov [M+" + toHex(enderecoA.v) + "], al\n" );
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            casa_token("valor");
        }
    }

    
    public static void main(String[] args){
        try {

            InputStream is = System.in;

            // guardar palavras reservadas na tabela de simbolos
            t.inserir("const", new registroTabela("const"));
            t.inserir("int", new registroTabela("int"));
            t.inserir("char", new registroTabela("char"));
            t.inserir("while", new registroTabela("while"));
            t.inserir("if", new registroTabela("if"));
            t.inserir("float", new registroTabela("float"));
            t.inserir("else", new registroTabela("else"));
            t.inserir("&&", new registroTabela("&&"));
            t.inserir("||", new registroTabela("||"));
            t.inserir("!", new registroTabela("!"));
            t.inserir("<-", new registroTabela("<-"));
            t.inserir("=", new registroTabela("="));
            t.inserir("(", new registroTabela("("));
            t.inserir(")", new registroTabela(")"));
            t.inserir("<", new registroTabela("<"));
            t.inserir("<", new registroTabela("<"));
            t.inserir("!=", new registroTabela("!="));
            t.inserir(">=", new registroTabela(">="));
            t.inserir("<=", new registroTabela("<="));
            t.inserir(",", new registroTabela(","));
            t.inserir("+", new registroTabela("+"));
            t.inserir("-", new registroTabela("-"));
            t.inserir("*", new registroTabela("*"));
            t.inserir("/", new registroTabela("/"));
            t.inserir(";", new registroTabela(";"));
            t.inserir("{", new registroTabela("{"));
            t.inserir("}", new registroTabela("}"));
            t.inserir("readln", new registroTabela("readln"));
            t.inserir("div", new registroTabela("div"));
            t.inserir("string", new registroTabela("string"));
            t.inserir("write", new registroTabela("write"));
            t.inserir("writeln", new registroTabela("writeln"));
            t.inserir("mod", new registroTabela("mod"));
            t.inserir("[", new registroTabela("["));
            t.inserir("]", new registroTabela("]"));

            // abrir e escrever inicio do arquivo asm
            myWriter = new FileWriter("arq.asm");
            myWriter.write("section .data ; Sessão de dados\nM: ; Rótulo para demarcar o início da sessão de dados\nresb 10000h ; Reserva de temporários\n\n; ***Definições de variáveis e constantes\n\nsection .text ; Sessão de código\nglobal _start ; Ponto inicial do programa\n\n_start: ; Início do programa\n; ***Comandos\n\n; Halt\n\n");

            // chamada do analisador lexico e inicio da gramatica
            analisadorLexico();
            S();

            // fim do arquivo asm
            myWriter.write("\nmov rax, 60 ; Chamada de saída\nmov rdi, 0 ; Código de saida sem erros\nsyscall ; Chama o kernel\n");
            myWriter.close();

            System.out.println(line_count + " linhas compiladas.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}


// tabela de simbolos
// armazena os lexemas e os dados associados a eles
class tabelaSimbolos {

        Map<String, registroTabela> tabela = new HashMap<String, registroTabela>();
        
        // insere na tabela o lexema e o registro
        public registroTabela inserir ( String lex, registroTabela reg) {
            this.tabela.put(lex, reg);
            return tabela.get(lex);
        }

        // pesquisa o lexema recebido como parametro na tabela
        // caso seja encontrado, retorna o registro da tabela
        // senao, retorna null
        public registroTabela pesquisar ( String lex ) {
            if ( tabela.containsKey(lex) ) {
                return tabela.get(lex);
            }
            else {
                return null;
            }
        }

        @Override
        public String toString ( ) {
            String s = "Lexema\t\tToken\t\tClasse\t\tTipo\t\tTamanho\n";
            for (String i : tabela.keySet()) {
                registroTabela reg = tabela.get(i);
                s += i + "\t\t" + reg.token + "\t\t" + reg.classe + "\t\t" + reg.tipo + "\t\t" + reg.tamanho + "\n";
            }
            return s;
        }

    }



    // registro da tabela de simbolos
    class registroTabela {
        
        String token = "";
        String classe = "";
        String tipo = "";
        int endereco;
        int tamanho;

        public registroTabela ( String tok ) {
            this.token = tok;
        }

        public registroTabela ( String tok, String cl ) {
            this.token = tok;
            this.classe = cl;
        }

        public registroTabela ( String tok, String cl, String tp ) {
            this.token = tok;
            this.classe = cl;
            this.tipo = tp;
        }

        public registroTabela ( String tok, String cl, String tp, int end ) {
            this.token = tok;
            this.classe = cl;
            this.tipo = tp;
            this.endereco = end;
        }

        @Override
        public String toString () { 
            String s = "Token:" + token + "\nClasse:" + classe + "\nTipo:" + tipo + "\nEndereco:" + endereco + "\nTamanho:" + tamanho;
            return s;
        }

    }



    // registro global
    class Registro { 
        int numero;
        String lexema;
        String token;
        int tamanho;
        String tipo;

        public Registro () {
            this.numero = 0;
            lexema = "";
            token = "";
            tamanho = 0;
            tipo = "";
        }

        @Override
        public String toString() {
            String s = "Numero:" + numero + "\nLexema:" + lexema + "\nToken:" + token + "\nTamanho:" + tamanho + "\nTipo:" + tipo ;
            return s;
        }

    }


    /*
    para passar um parametro por referencia em java e preciso utilizar um objeto
    entao para a passagem de parametros por referencia na gramatica foram criadas duas classes que armazenam o valor de um inteiro ou string
    */

    class paramString {
        String s;

        public paramString () {
            this.s = "";
        }

        public paramString ( String str ) {
            this.s = str;
        }

    }


    class paramInt {
        int v;

        public paramInt () {
            this.v = 0;
        }

        public paramInt ( int i ) {
            this.v = i;
        }

    }
