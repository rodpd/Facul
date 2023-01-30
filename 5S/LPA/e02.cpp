#include<iostream>
#include<string>
using namespace std;

int main () {
    int qnt;
    do {
        cin >> qnt;
        cin.ignore();
        string frases[qnt];
        int maior = 0;
        for ( int i = 0; i < qnt; i++ ) {
            string linha;
            getline(cin, linha);

            // tirar espacos antes e depois da frase
            int inicio = linha.find_first_not_of(' ');
            int fim = linha.find_last_not_of(' ');
            linha = linha.substr(inicio, fim - inicio+1);
            frases[i] = "";

            // tirar espacos entre palavras
            for ( int i = 0; i < linha.length(); i++ ) {
                int espacos = 0;
                if ( linha[i] == ' ' ) {
                    int j = i+1;
                    // contar quantidade de espacos a partir de j para apagar
                    while ( linha[j] == ' ') {
                        espacos++;
                        j++;
                    }
                    linha.erase(i, espacos);
                }
            }
            frases[i] = linha;

            // guardar tamanho da maior frase p/ adicionar espacos 'a esquerda das outras depois
            if ( linha.length() > maior ) {
                maior = linha.length();
            }
        }

        // adicionar espacos 'a esquerda da frase
        for ( int i = 0; i < qnt; i++ ) {
            int tamanho = frases[i].length();
            string espacos = "";
            while ( tamanho < maior ) {
                espacos += ' ';
                tamanho++;
            }
            frases[i] = espacos + frases[i];
        }

        // imprimir frases
        for ( int i = 0; i < qnt; i++ ) {
            cout << frases[i] << endl;
        }
        
    } while ( qnt > 0 );
    return 0;
}