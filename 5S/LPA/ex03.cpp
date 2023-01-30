#include <iostream>
#include <vector>
using namespace std;

int main ( ) {

    int qnt;
    cin >> qnt;
    for ( int i = 0; i < qnt; i++ ) {
        int qntCidadaos, qntPares;
        cin >> qntCidadaos >> qntPares;
        bool grafo [qntCidadaos][qntCidadaos];
        for ( int j = 0; j < qntCidadaos; j++ ) {
            for ( int k = 0; k < qntCidadaos; k++ ) {
                grafo[j][k] = 0;
            }
        }
        int cidadao1, cidadao2;

        // montar matriz de adjacencia dos cidadaos
        for ( int j = 0; j < qntPares; j++ ) {
            cin >> cidadao1 >> cidadao2;
            // diminuir valor dos cidados pq entrada comeca em 1
            cidadao1--;
            cidadao2--;
            grafo[cidadao1][cidadao2] = 1;
            grafo[cidadao2][cidadao1] = 1;
        }

        bool visitados[qntCidadaos];
        for ( int j = 0; j < qntCidadaos; j++ ) {
            visitados[j] = 0;
        }
        int maior = 0, qntVisitados = 0;
        vector <int> amigos;
        qntPares = 0;

        // percorrer grafo p/ encontrar maior qnt de pares
        while ( qntVisitados != qntCidadaos ) {
            // encontrar algum cidadao nao visitado p/ comecar a contar seus amigos
            for ( int j = 0; j < qntCidadaos; j++ ) {
                if ( !visitados[j] ) {
                    // iniciar lista com o primeiro cidadao
                    amigos.push_back(j);
                    int atual;
                    // percorrer lista de amigos enquanto nao estiver vazia
                    while ( !amigos.empty() ) {
                        atual = amigos[0];
                        amigos.erase(amigos.begin());
                        // ignorar caso ja tenha sido visitado
                        if ( !visitados[atual] ) {
                            // adicionar amigos do cidadao atual
                            for ( int k = 0; k < qntCidadaos; k++ ) {
                                if ( grafo[atual][k] ) {
                                    amigos.push_back(k);
                                }
                            }
                            visitados[atual] = 1;
                            qntPares++;
                            qntVisitados++;
                        }
                    }
                }
                if ( qntPares > maior )
                maior = qntPares;
                qntPares = 0;
            }
        }
        
        cout << maior << endl;

    }
    return 0;
}