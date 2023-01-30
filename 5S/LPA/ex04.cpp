#include <iostream>
#include <map>
#include <vector>

using namespace std;


int main ( ) {

int qntEstacoes, qntCaminhos;
cin >> qntEstacoes >> qntCaminhos;
// continuar executando ate entrada ser igual a 0 0
while ( qntEstacoes != 0 && qntCaminhos != 0 ) {
    // reiniciar grafo e estacoes visitadas
    int grafo [qntEstacoes][qntEstacoes];
    bool indiceVisitados[qntEstacoes];
    vector <int> visitados;
    for ( int i = 0; i < qntEstacoes; i++ ) {
        for ( int j = 0; j < qntEstacoes; j++ ) {
            grafo[i][j] = INT32_MAX;
        }
        indiceVisitados[i] = false;
    }
    // ler estacoes
    map <string, int> estacoes;
    string estacao;
    for ( int i = 0; i < qntEstacoes; i++ ) {
        cin >> estacao;
        estacoes[estacao] = i;
    }

    // montar grafo c estacoes
    string partida, destino;
    int preco;
    for ( int i = 0; i < qntCaminhos; i++ ) {
        cin >> partida >> destino >> preco;
        if ( preco < grafo [estacoes[partida]] [estacoes[destino]] ) {
        grafo [estacoes[partida]] [estacoes[destino]] = preco;
        grafo [estacoes[destino]] [estacoes[partida]] = preco;
        }
    }
    // calcular menor preco
    cin >> partida;
    int menor = INT32_MAX, atual = estacoes[partida], indiceDestino;
    visitados.clear();
    visitados.push_back(atual);
    indiceVisitados[atual] = true;
    preco = 0;
    // continuar executando o loop ate chegar a uma estacao nao conectada
    // ou todas terem sido visitadas
    while ( menor != -1 && visitados.size() != qntEstacoes ) {
        menor = INT32_MAX;
        // algoritmo de prim
        for ( int i = 0; i < visitados.size(); i++ ) {
            //cout << "IND: " << visitados[i] << endl;
            atual = visitados[i];
            for ( int j = 0; j < qntEstacoes; j++ ) {
                //cout << "visitado[" << j << "]: " << indiceVisitados[j] << endl;
                if ( grafo[atual][j] != INT32_MAX && !indiceVisitados[j] ) {
                    if ( grafo[atual][j] < menor ) {
                        menor = grafo[atual][j];
                        indiceDestino = j;
                    }
                }
            }
        }
        // verificar uma nova estacao pode ser adicionada a lista atual
        // se sim, adicionar a estacoes visitadas e aumentar o preco
        if ( menor != INT32_MAX ) {
            visitados.push_back(indiceDestino);
            indiceVisitados[indiceDestino] = true;
            preco += menor;
        }
        // senao, parar o loop
        else {
            menor = -1;
        }
    }
    // checar se todos vertices foram visitados
    // se sim, imprimir valor
    if ( visitados.size() == qntEstacoes ) {
    cout << preco << endl;
    }
    // se nao, imprimir impossivel
    else {
        cout << "Impossible" << endl;
    }
    // prox
    cin >> qntEstacoes >> qntCaminhos;
    }


return 0;

}