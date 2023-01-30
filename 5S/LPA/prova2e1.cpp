#include <iostream>
#include <vector>

using namespace std;

int main ( ) {

int qntIntersecoes, qntRuas, acessiveis;
short partida, destino, direcao;
cin >> qntIntersecoes >> qntRuas;
vector <int> ruasVisitadas;
while ( !(qntIntersecoes == 0 && qntRuas == 0) ) {
    // reiniciar grafo
    short intersecoes [qntIntersecoes][qntIntersecoes];
    for ( int i = 0; i < qntIntersecoes; i++ ) {
        for ( int j = 0; j < qntIntersecoes; j++ ) {
            intersecoes[i][j] = 0;
        }
    }
    // preencher grafo com as vias que estao conectadas
    for ( int i = 0; i < qntRuas; i++ ) {
        cin >> partida >> destino >> direcao;
        // reduzir partida e destino em 1 porque no problema comecam em 1 ao inves de 0
        partida--;
        destino--;
        // mao unica
        if ( direcao == 1 ) {
            intersecoes[partida][destino] = 1;
        }
        // mao dupla
        else if ( direcao == 2 ) {
            intersecoes[partida][destino] = 1;
            intersecoes[destino][partida] = 1;
        }
    }

    bool visitadas [qntIntersecoes], conexo = true;
    // testar todos vertices (intersecoes)
    for ( int i = 0; i < qntIntersecoes; i++ ) {
        // reiniciar vetores e variaveis
        acessiveis = 1;
        ruasVisitadas.clear();
        ruasVisitadas.push_back(i);
        for ( int j = 0; j < qntIntersecoes; j++ ) {
            visitadas[j] = false; 
        }
        visitadas[i] = true;
        // busca em largura p/ determinar se vertice atual pode acessar todas intersecoes
        while ( ruasVisitadas.size() != 0 ) {
            for ( int j = 0; j < qntIntersecoes; j++ ) {
                if ( intersecoes[ruasVisitadas[0]][j] == 1 && !visitadas[j] ) {
                    ruasVisitadas.push_back(j);
                    visitadas[j] = true;
                    acessiveis++;
                }
            }
            ruasVisitadas.erase(ruasVisitadas.begin());
        }
        // se vertice atual nao puder acessar o resto, parar loop
        if ( acessiveis != qntIntersecoes ) {
            i = qntIntersecoes;
            conexo = false;
        }
    }

    if ( conexo )
    cout << "1\n";
    else
    cout << "0\n";

    cin >> qntIntersecoes >> qntRuas;
}


    return 0;
}