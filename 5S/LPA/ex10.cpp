#include <iostream>
#include <vector>

using namespace std;

int main ( ) {

short dinheiro, qntRoupas, qntColuna, maior, qnt;
vector <int> solucoes;
for ( cin >> qnt; qnt > 0; qnt-- ) {
    cin >> dinheiro >> qntRoupas;
    bool soluvel = false;
    short qntModelos[qntRoupas];
    short precoModelos[qntRoupas][20];
    short matriz[qntRoupas][dinheiro+1];
    short qntItens[qntRoupas][dinheiro+1];
    // inicializar matrizes
    for ( int i = 0; i < qntRoupas; i++ ) {
        for ( int j = 0; j < 20; j++ ) {
            precoModelos[i][j] = 0;
        }
    }
    for ( int i = 0; i < qntRoupas; i++ ) {
        for ( int j = 0; j < dinheiro; j++ ) {
            matriz[i][j] = 0;
            qntItens[i][j] = 0;
        }
    }
    // preencher matrizes
    // matriz com os precos dos modelos dos itens
    for ( int i = 0; i < qntRoupas; i++ ) {
        short modelos;
        cin >> modelos;
        qntModelos[i] = modelos;
        for ( int j = 0; j < modelos; j++ ) {
            cin >> precoModelos[i][j];
        }
    }

    // precos do primeiro tipo de roupa
    for ( int i = 1; i <= dinheiro; i++ ) {
        maior = 0;
        for ( int j = 0; j < qntModelos[0]; j++ ){
            if ( precoModelos[0][j] <= i && precoModelos[0][j] > maior ) {
            maior = precoModelos[0][j];
            qntItens[0][i] = 1;
            }
        }
        matriz[0][i] = maior;
    }

    // precos dos outros itens
    for ( int i = 1; i < qntRoupas; i++ ) {
        for ( int j = 1; j <= dinheiro; j++ ) {
            maior = matriz[i-1][j];
            // compara os precos de todos modelos do tipo de roupa atual
            for ( int k = 0; k < qntModelos[i]; k++ ) {
                // trocar caso tenha dinheiro suficiente e seja maior que o ultimo valor calculado
                // o valor inicial e' o que esta' na linha anterior e mesma coluna
                if ( precoModelos[i][k] <= j && precoModelos[i][k] + matriz[i-1][j-(precoModelos[i][k])] >= maior ) {
                    if ( j-precoModelos[i][k] == 0 ) {
                        qntItens[i][j] = 1;
                        maior = precoModelos[i][k];
                    }
                    else if ( qntItens[i][j] <= qntItens[i-1][j-precoModelos[i][k]] + 1) {
                        qntItens[i][j] = qntItens[i-1][j-precoModelos[i][k]] + 1;
                        maior = precoModelos[i][k] + matriz[i-1][j-precoModelos[i][k]];
                    }
                }
            }
            matriz[i][j] = maior;
        }
    }

    // imprimir a resposta
    for ( int i = dinheiro; i > 0; i-- ) {
        // procurar na ultima linha um valor que utilize todos os itens
        if ( qntItens[qntRoupas-1][i] == qntRoupas ) {
            soluvel = true;
            //cout << matriz[qntRoupas-1][i] << endl;
            solucoes.push_back(matriz[qntRoupas-1][i]);
            i = 0;
        }
    }
    if ( !soluvel )
    //cout << "no solution\n";
    solucoes.push_back(0);
    }

    for ( int i = 0; i < solucoes.size(); i++ ) {
        solucoes[i] != 0 ? cout << solucoes[i] << endl : cout << "no solution\n";
    }


    return 0;
} 