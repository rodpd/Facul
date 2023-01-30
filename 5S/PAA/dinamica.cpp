#include <iostream>
#include <fstream>
#include <math.h>
#include <bitset>
#include <string>
#include <chrono>

using namespace std;

int main ( ) {

    // guardar informacao sobre quando o programa iniciou
    chrono::high_resolution_clock::time_point t1 = chrono::high_resolution_clock::now();
    // ler e armazenar dados do arquivo
    ifstream arq("input.txt");
    short qnt;
    arq >> qnt;
    short colunas = pow(2,qnt-1);
    short ultimaCidade[qnt][colunas];
    short indiceUltimaCidade;
    short dinamica [qnt][colunas];
    short posicoes[qnt][2];
    int distancias[qnt][qnt];
    int menorDistancia = INT16_MAX, distanciaAtual;
    string menorCaminho = "";
    for ( int i = 0; i < qnt; i++ ) {
        arq >> posicoes[i][0] >> posicoes[i][1];
    }
    arq.close();

    // calcular e armazenar distancia entre as cidades
    for ( int i = 0; i < qnt; i++ ) {
        for ( int j = 0; j < qnt; j++ ) {
            distancias[i][j] = sqrt((posicoes[i][0]-posicoes[j][0])*(posicoes[i][0]-posicoes[j][0])
                    +(posicoes[i][1]-posicoes[j][1])*(posicoes[i][1]-posicoes[j][1]));
        }
        // inicializar matriz dinamica
        for ( int j = 0; j < colunas; j++ ) {
            dinamica[i][j] = 0;
            ultimaCidade[i][j] = -1;
        }
    }

    // primeira coluna, contem distancias das cidades ate a inicial
    for ( int i = 1; i < qnt; i++ ) {
        dinamica[i][0] = distancias[i][0];
        ultimaCidade[i][0] = 0;
    }

    // colunas restantes, possuem a distancia de uma cidade ate um subconjunto
    for ( int j = 1; j < colunas-1; j++ ) {
        for ( int i = 1; i < qnt; i++ ) {
            // comparar indice da cidade atual com bits da coluna, que representa os subconjuntos
            // se o bit for igual a 0, a cidade nao faz parte do subconjunto, entao sua distancia ate
            // o conjunto sera calculada para armazenar na matriz dinamica
            if ( ! ( j & ( 1 << (i-1 ) ) ) ) {
                menorDistancia = INT16_MAX;
                indiceUltimaCidade = -1;
                // percorrer bits p/ determinar indices das cidades do subconjunto
                for ( int k = 0; k < qnt-1; k++ ) {
                    // para cada cidade do subconjunto, gerar a distancia somando a distancia da cidade atual a cidade retirada do subconjunto
                    // com a distancia do elemento retirado do subconjunto ao restante do subconjunto
                    if ( ( j >> k ) & 1 ) {
                        distanciaAtual = distancias[i][k+1] + dinamica[k+1][j-(int)pow(2,k)];
                        // guardar apenas o menor valor encontrado ate o momento
                        if ( distanciaAtual < menorDistancia ) {
                            menorDistancia = distanciaAtual;
                            indiceUltimaCidade = k+1;
                        }
                    }
                }
                // armazenar menor valor encontrado
                dinamica[i][j] = menorDistancia;
                ultimaCidade[i][j] = indiceUltimaCidade;
            }
        }
    }

    // ultima coluna, retornar a cidade inicial
    menorDistancia = INT16_MAX;
    for ( int k = 0; k < qnt-1; k++ ) {
        // para cada cidade do subconjunto, gerar a distancia somando a distancia da cidade atual a cidade retirada do subconjunto
        // com a distancia do elemento retirado do subconjunto ao restante do subconjunto
        if ( ( ( colunas-1 ) >> k ) & 1 ) {
            distanciaAtual = distancias[0][k+1] + dinamica[k+1][colunas-1-(int)pow(2,k)];
            // guardar apenas o menor valor encontrado ate o momento
            if ( distanciaAtual < menorDistancia ) {
                menorDistancia = distanciaAtual;
                indiceUltimaCidade = k+1;
            }
        }
    }
    dinamica[0][colunas-1] = menorDistancia;
    ultimaCidade[0][colunas-1] = indiceUltimaCidade;

    // encontrar menor caminho
    menorCaminho = "1 " + to_string(indiceUltimaCidade+1) + " ";
    for ( int i = 2, coluna = colunas-1; i < qnt; i++ ) {
        coluna -= pow(2,indiceUltimaCidade-1);
        indiceUltimaCidade = ultimaCidade[indiceUltimaCidade][coluna];
        menorCaminho += to_string(indiceUltimaCidade+1) + " ";
    }

    // escrever no arquivo informacoes sobre distancia, caminho e tempo de execucao
    ofstream fb;
    fb.open("Dinamica.txt");
    fb << "Menor Caminho: " << menorCaminho << "\nMenor Distancia: " << dinamica[0][colunas-1] << endl;
    chrono::high_resolution_clock::time_point t2 = chrono::high_resolution_clock::now();
    chrono::duration<double, std::milli> time_span = t2 - t1;
    fb << time_span.count() << " ms";
    fb.close();

    return 0;
}