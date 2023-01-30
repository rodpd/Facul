#include <cstdlib>
#include <iostream>
#include <fstream>
#include <math.h>
#include <string>
#include <algorithm>
#include <chrono>

using namespace std;

int main( ) {

    // guardar informacao sobre quando o programa iniciou
    chrono::high_resolution_clock::time_point t1 = chrono::high_resolution_clock::now();
    // ler e armazenar dados do arquivo
    ifstream arq("input.txt");
	short qnt;
	arq >> qnt;
	short posicoes[qnt][2];
    short distancias[qnt][qnt];
    short menorDistancia = INT16_MAX;
    short distancia;
    string menorCaminho;
    short cidades[qnt];
    for ( short i = 0; i < qnt; i++ ) {
        arq >> posicoes[i][0] >> posicoes[i][1];
        cidades[i] = i;
    }
    arq.close();
    
// calcular e armazenar distancia entre as cidades
    for ( int i = 0; i < qnt; i++ ) {
        for ( int j = 0; j < qnt; j++ ) {
            distancias[i][j] = sqrt((posicoes[i][0]-posicoes[j][0])*(posicoes[i][0]-posicoes[j][0])
                    +(posicoes[i][1]-posicoes[j][1])*(posicoes[i][1]-posicoes[j][1]));
        }
    }
    
    // gerar permutacoes e calcular distancia total para cada uma
    do {
        distancia = 0;
        distancia += distancias[0][cidades[1]];
        // continuar calculando a distancia ate certo ponto
        // caso a distancia da permutacao atual em dado momento seja maior que a menor distancia
        // encontrada ate o momento, ir para a proxima permutacao
        for ( short i = 1; distancia < menorDistancia && i < qnt-1; i++ ) {
            distancia += distancias[cidades[i]][cidades[i+1]];
        }
        if ( distancia < menorDistancia ) {
            distancia += distancias[cidades[qnt-1]][0];
            // armazenar distancia caso seja menor que a menor ja encontrada ate o momento
            if ( distancia < menorDistancia ){
                menorDistancia = distancia;
                menorCaminho = "";
                for ( int i = 0; i < qnt; i++ ) {
                    menorCaminho += to_string(cidades[i]+1) + " ";
                }
            }
        }
    } while ( next_permutation(cidades+1, cidades+qnt) );

    // escrever no arquivo informacoes sobre distancia, caminho e tempo de execucao
    ofstream fb;
    fb.open("branchAndBound.txt");
    fb << "Menor Caminho: " << menorCaminho << "\nMenor Distancia: " << menorDistancia << endl;
    chrono::high_resolution_clock::time_point t2 = chrono::high_resolution_clock::now();
    chrono::duration<double, std::milli> time_span = t2 - t1;
    fb << time_span.count() << " ms";
    fb.close();
    
    return 0;
}

