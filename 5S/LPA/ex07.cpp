#include <iostream>

using namespace std;

int main ( ) {



int qnt, substr1, substr2;
string str1, str2, substr;
bool comum;
cin >> qnt;
// controlar quantidade de iteracoes
for ( int i = 0; i < qnt; i++ ) {
    cin >> str1 >> str2;
    comum = true;
    // percorrer c/ substrings de tamanho = 1 ate tamanho total da palvra
    for ( int tamanho = 1; tamanho < str1.length(); tamanho++ ) {
        // controlar inicio da substring
        for ( int inicio = 0; inicio < str1.length()-tamanho+1; inicio++ ) {
            // gerar substring com inicio e tamanhos atuais para comparar com as palavras
            substr = str1.substr(inicio, tamanho);
            substr1 = substr2 = 0;
            // comparar substring atual com todas substrings de mesmo tamanho das palavras
            for ( int j = 0; j < str1.length()-tamanho+1; j++ ) {
                if ( str1.substr(j,tamanho) == substr )
                substr1++;
                if ( str2.substr(j,tamanho) == substr )
                substr2++;
            }
            // parar loop caso quantidades de substrings sejam diferentes
            if ( substr1 > 1 && substr1 != substr2 ) {
                tamanho = inicio = str1.length();
                comum = false;
            }
        }

    }
    // imprimir resposta da iteracao atual
    if ( comum )
    cout << 's' << endl;
    else
    cout << 'n' << endl;

}


    return 0;
}