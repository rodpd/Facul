#include <iostream>
#include <map>
#include <vector>

using namespace std;


int main ( ) {

int qntCidades, qntEstradas;
cin >> qntCidades >> qntEstradas;
// continuar executando ate entrada ser igual a 0 0
    while ( !(qntCidades == 0 && qntEstradas == 0) ) {
        // reiniciar grafo e cidades visitadas
        int grafo [qntCidades][qntCidades];
        bool indiceVisitados[qntCidades];
        vector <int> visitados;
        for ( int i = 0; i < qntCidades; i++ ) {
            for ( int j = 0; j < qntCidades; j++ ) {
                grafo[i][j] = 0;
            }
            indiceVisitados[i] = false;
        }

        // montar grafo c/ cidades
        int partida, destino;
        int distancia;
        for ( int i = 0; i < qntEstradas; i++ ) {
            cin >> partida >> destino >> distancia;
            if ( grafo[partida][destino] == 0 || distancia < grafo[partida][destino] ) {
            grafo [partida] [destino] = distancia;
            grafo [destino] [partida] = distancia;
            }
        }
        // calcular maior distancia
        int maior = 0, atual = partida = 0, indiceDestino;
        visitados.clear();
        visitados.push_back(atual);
        indiceVisitados[atual] = true;
        distancia = 0;
        // continuar executando o loop ate chegar a uma cidade nao conectada
        // ou todas terem sido visitadas
        while ( maior != -1 && visitados.size() != qntCidades ) {
            maior = INT32_MAX;
            // algoritmo de prim
            for ( int i = 0; i < visitados.size(); i++ ) {
                atual = visitados[i];
                for ( int j = 0; j < qntCidades; j++ ) {
                    if ( grafo[atual][j] != 0 && !indiceVisitados[j] ) {
                        if ( grafo[atual][j] < maior ) {
                            maior = grafo[atual][j];
                            indiceDestino = j;
                        }
                    }
                }
            }
            // verificar uma nova cidade pode ser adicionada a lista atual
            // se sim, adicionar a cidades visitadas e alterar maior distancia entre as cidades
            if ( maior != INT32_MAX ) {
                visitados.push_back(indiceDestino);
                indiceVisitados[indiceDestino] = true;
                if ( maior > distancia )
                distancia = maior;
            }
            // senao, parar o loop
            else {
                maior = -1;
            }
        }
        // checar se todos vertices foram visitados
        // se sim, imprimir maior distancia
        if ( visitados.size() == qntCidades ) {
            cout << distancia << endl;
        }
        // se nao, imprimir impossivel
        else {
            cout << "IMPOSSIBLE" << endl;
        }
        // prox
        cin >> qntCidades >> qntEstradas;
    }


return 0;

}