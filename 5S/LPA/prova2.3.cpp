#include <iostream>

using namespace std;

int main () {

int qnt;
cin >> qnt;
int alturas[qnt];
for ( int i = 0; i < qnt; i++ ) {
    cin >> alturas[i];
}
bool resolvido = false;
int maior, indiceMaior;
while ( !resolvido ) {
    maior = INT32_MIN;
    // encontrar coluna com maior altura
    for ( int i = 0; i < qnt; i++ ) {
        if ( alturas[i] > maior ) {
            maior = alturas[i];
            indiceMaior = i;
        }
    }

    // verificar se e possivel formar um triangulo iscosceles a partir dessa coluna
    resolvido = true;
    if ( indiceMaior >= maior-1 && qnt-indiceMaior >= maior ) {
        for ( int i = 1; i < maior; i++ ) {
            if ( alturas[indiceMaior-i] < maior-i || alturas[indiceMaior+i] < maior-i ){
                resolvido = false;
                i = maior;
            }
        }
    }
    else {
        resolvido = false;
    }
    // se sim, retornar valor
    if ( resolvido )
    cout << maior << endl;
    // senao, diminuir altura da coluna atual
    else
    alturas[indiceMaior]--;
}



    return 0;
}