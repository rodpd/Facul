#include <iostream>

using namespace std;

int main () {

int qnt, coluna;
long menor1, menor2;
string s;
while ( getline(cin, s) ) {
    qnt = stoi(s);
    long cartoes [qnt][qnt];
    // inicializar matriz
    for ( int i = 0; i < qnt; i++ ) {
        for ( int j = 0; j < qnt; j++ ) {
            cartoes[i][j] = 0;
        }
        cin >> cartoes[i][i];
    }
    // altera apenas a matriz triangular superior
    // em cada iteracao, as somas sao armazenadas em uma diagonal da matriz
    // primeira iteracao, compara apenas os numeros lidos
    for ( int i = 0; i < qnt; i++ ) {
        cartoes[i][i] > cartoes[i+1][i+1] ? cartoes[i][i+1] = cartoes[i][i] : cartoes[i][i+1] = cartoes[i+1][i+1];
    }
    // proximas iteracoes, a partir de i=1 utiliza os resultados anteriores
    for ( int i = 0; i < qnt-2; i++ ) {
        for ( int j = 0; j < qnt-i-2; j++ ) {
            coluna = i+j;
            // calcular primeiro numero
            cartoes[j][coluna] < cartoes[j+1][coluna+1] ? menor1 = cartoes[j][coluna] : menor1 = cartoes[j+1][coluna+1];
            menor1 += cartoes[coluna+2][coluna+2];
            // calcular segundo
            cartoes[j+1][coluna+1] < cartoes[j+2][coluna+2] ? menor2 = cartoes[j+1][coluna+1] : menor2 = cartoes[j+2][coluna+2];
            menor2 += cartoes[j][j];
            // decidir qual sera guardado na matriz
            menor1 > menor2 ? cartoes[j][coluna+2] = menor1 : cartoes[j][coluna+2] = menor2;
        }
    }
    cout << cartoes[0][qnt-1] << endl;
    cin.ignore();
}


    return 0;
}