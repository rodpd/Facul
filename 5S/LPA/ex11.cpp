#include <iostream>

using namespace std;

int main ( ) {

short qnt, inicio, fim, sinal;
unsigned long n1, n2, max, min;
string str, expressao, num1, num2;

cin >> qnt;
for ( int i = 0; i < qnt; i++ ) {
    cin >> str;
    expressao = str;
    // calcular maximo
    // calcula somas primeiro, e depois as multiplicacoes
    // resolver somas
    sinal = str.find_first_of('+');
    // cotinuar ate nao encontrar um sinal de +
    while ( sinal != -1 ) {
        num1 = num2 = "";
        inicio = fim = sinal;
        // pegar primeiro numero
        for ( inicio = sinal-1; inicio >= 0 && !(str[inicio] == '+' || str[inicio] == '*'); inicio-- ) {
            num1 = str[inicio] + num1;
        }
        // segundo
        for ( fim = sinal+1; fim <= str.length() && !(str[fim] == '+' || str[fim] == '*'); fim++ ) {
            num2 += str[fim];
        }
        // mudar indices em 1 p/ reverter ultima alteracao do for
        inicio++;
        fim--;
        n1 = stol(num1);
        n2 = stol(num2);
        // substituir na expressao
        str.replace(inicio, fim-inicio+1, to_string(n1+n2));
        sinal = str.find_first_of('+');
    }

    // resolver multiplicacoes
    sinal = str.find_first_of('*');
    // continuar ate nao encontrar um sinal de *
    while ( sinal != -1 ) {
        // obter numeros
        num1 = str.substr(0, sinal);
        str = str.substr(sinal+1);
        num2 = str.substr(0,str.find_first_of('*'));
        n1 = stol(num1);
        n2 = stol(num2);
        // substituir pelo resultado na expressao
        str.replace(0, str.find_first_of('*'), to_string(n1*n2));
        sinal = str.find_first_of('*');
    }

    max = stol(str);

    // calcular minimo
    // funciona como a parte acima, apenas com sinais trocados
    str = expressao;
    sinal = str.find_first_of('*');
    while ( sinal != -1 ) {
        num1 = num2 = "";
        inicio = fim = sinal;
        for ( inicio = sinal-1; inicio >= 0 && !(str[inicio] == '+' || str[inicio] == '*'); inicio-- ) {
            num1 = str[inicio] + num1;
        }
        for ( fim = sinal+1; fim <= str.length() && !(str[fim] == '+' || str[fim] == '*'); fim++ ) {
            num2 += str[fim];
        }
        inicio++;
        fim--;
        n1 = stol(num1);
        n2 = stol(num2);
        str.replace(inicio, fim-inicio+1, to_string(n1*n2));
        sinal = str.find_first_of('*');
    }

    sinal = str.find_first_of('+');
    while ( sinal != -1 ) {
        num1 = str.substr(0, sinal);
        str = str.substr(sinal+1);
        num2 = str.substr(0,str.find_first_of('+'));
        n1 = stol(num1);
        n2 = stol(num2);
        str.replace(0, str.find_first_of('+'), to_string(n1+n2));
        sinal = str.find_first_of('+');
    }

    min = stol(str);


    cout << "The maximum and minimum are " << max << " and " << min << ".\n";

}

    return 0;
}