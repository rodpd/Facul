#include <iostream>

using namespace std;

int main ( ) {


int tam;
cin >> tam;
int nums[tam][tam];
int soma, maiorKadane, maior = INT32_MIN;

    // montar matriz 
    for ( int i = 0; i < tam; i++ ) {
        for ( int j = 0; j < tam; j++ ) {
            cin >> nums[i][j];
        }
    }

    int kadane [tam];
    for ( int up = 0; up < tam; up++ ) {
        // reiniciar vetor de kadane
        for ( int j = 0; j < tam; j++ ) {
            kadane[j] = 0;
        }
        for ( int down = up; down < tam; down++ ) {
            // atualizar vetor de kadane
            for ( int j = 0; j < tam; j++ ) {
                kadane[j] += nums[down][j];
            }
            // algoritmo de kadane
            soma = 0;
            maiorKadane = 0;
            for ( int j = 0; j < tam; j++ ) {
                soma += kadane[j];
                // comparar soma com o valor do maior conjunto encontrado ate agora
                // se soma for positiva, continuar. senao, reiniciar valor de soma
                // atualizar soma de kadane caso seja o maior valor encontrado ate agora
                    if ( soma > 0 ) {
                        if ( soma > maiorKadane )
                        maiorKadane = soma;
                    }
                    else { 
                        soma = 0;
                    }
                }
                if ( maiorKadane > maior )
                maior = maiorKadane;
        }
    }

cout << maior;

    return 0;
}