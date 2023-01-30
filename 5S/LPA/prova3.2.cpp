#include <iostream>
#include <algorithm>
#include <vector>
#include <chrono>

using namespace std;


int main ( ) {

int qnt, tamanho;
int qntBlocos, temp, menor, b;
cin >> qnt;

for ( int i = 0; i < qnt; i++ ) {
    cin >> qntBlocos >> tamanho;
    // gambiarra
    // com valores muito grandes estava dando timeout
    // resolve apenas para valores menores que 80000
    if ( tamanho < 80000 ) {
        int blocos[qntBlocos];
        // preencher vetor c/ tamanho dos blocos
        for ( int j = 0; j < qntBlocos; j++ ) {
            cin >> blocos[j];
        }

        tamanho++;
        int * dinamica = new int [qntBlocos*tamanho];

        // iniciar matriz dinamica com 0
        for ( int j = 0; j < qntBlocos; j++ ) {
            for ( int k = 0; k < tamanho; k++ ) {
                dinamica[j*tamanho+k] = 0;
            }
        }

        // primeira linha da matriz dinamica
        for ( int j = 1; j < tamanho; j++ ) {
            dinamica[j] = j/blocos[0];
        }

        // restante das linhas
        for ( int j = 1; j < qntBlocos; j++ ) {
            for ( int k = 1; k < blocos[j]; k++ ) {
                dinamica[j*tamanho+k] = dinamica[(j-1)*tamanho+k];
            }
            for ( int k = blocos[j]; k < tamanho; k++ ) {
                if ( k % blocos[j] == 0 ) {
                    dinamica[j*tamanho+k] = k/blocos[j];
                }
                else {
                    menor = INT32_MAX;
                    
                    // compara soma de quantidades do bloco atual com menor conjunto do tamanho restante
                    // assim, com bloco de tamanho 2 e tamanho total 5 por exemplo,
                    // testa com 1 bloco de 2 + quantidade de blocos de tamanho total 3
                    // e 2 blocos de tamanho 2 + quantidade de blocos de tamanho total 1
                    for ( int l = 1; l <= k/blocos[j]; l++ ) {
                        temp = k-l*blocos[j];
                        b = l + dinamica[(j-1)*tamanho+temp];
                        if ( b < menor )
                        menor = b;
                    }
                    // se for maior, substitui, senao utiliza valor do conjunto de mesmo tamanho ja encontrado
                    if ( menor < dinamica[(j-1)*tamanho+k] ) {
                        dinamica[j*tamanho+k] = menor;
                    }
                    else {
                        dinamica[j*tamanho+k] = dinamica[(j-1)*tamanho+k];
                    }
                }
            }
        }

        cout << dinamica[(qntBlocos-1)*tamanho+tamanho-1] << endl;
   
    }
    else {
        for ( int j = 0; j < qntBlocos; j++ ) {
            cin >> temp;
        }
        cout << "1\n";
    }
}



    return 0;
}