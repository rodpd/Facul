#include <iostream>
#include <fstream>
#include <math.h>
#include <chrono>
#include <string>

using namespace std;

// operadores geneticos (%)
int taxaMutacao = 3;
int taxaCrossingOver = 70;

struct individuo {
    short * caminho;
    int distancia;
};

int main ( ) {

    // guardar informacao sobre quando o programa iniciou
    chrono::high_resolution_clock::time_point t1 = chrono::high_resolution_clock::now();
    // ler e armazenar dados do arquivo
    ifstream arq("input.txt");
    srand (time(NULL));
	short qnt;
	arq >> qnt;
    individuo melhor;
    string menorCaminho;
    short indiceMelhor;
    int menorDistancia = INT32_MAX;
	short posicoes[qnt][2];
    int distancias[qnt][qnt];
    // ler e armazenar dados do arquivo
    for ( short i = 0; i < qnt; i++ ) {
        arq >> posicoes[i][0] >> posicoes[i][1];
    }
    arq.close();

//  calcular e armazenar distancia entre as cidades
    for ( int i = 0; i < qnt; i++ ) {
        for ( int j = 0; j < qnt; j++ ) {
            distancias[i][j] = sqrt((posicoes[i][0]-posicoes[j][0])*(posicoes[i][0]-posicoes[j][0])
                    +(posicoes[i][1]-posicoes[j][1])*(posicoes[i][1]-posicoes[j][1]));
        }
    }

    // criar populacao inicial
    individuo populacao [10];
    bool visitados [qnt];
    short random;
    for ( int i = 0; i < 10; i++ ) {
        populacao[i].caminho = new short[qnt];
        populacao[i].caminho[0] = 0;
        populacao[i].distancia = 0;
        visitados[0] = true;
        for ( int j = 1; j < qnt; j++ ) {
            visitados[j] = false;
        }
        for ( int j = 1; j < qnt; j++ ) {
            // gerar numero aleatorio ate conseguir um que nao tenha sido visitado
            do {
                random = rand() % qnt;
            } while ( visitados[random] );
            // adicionar cidade e caminho
            populacao[i].caminho[j] = random;
            populacao[i].distancia += distancias[populacao[i].caminho[j-1]][random];
            visitados[random] = true;
        }
        // adicionar distancia ate vertice inicial a partir da ultima cidade
        populacao[i].distancia += distancias[populacao[i].caminho[qnt-1]][0];
    }


    bool alterado;
    for ( int iteracoes = 0; iteracoes < qnt; iteracoes++ ) {
        // guardar melhor individuo
        menorDistancia = INT32_MAX;
        for ( int i = 0; i < 10; i++ ) {
            if ( populacao[i].distancia < menorDistancia ) {
                melhor = populacao[i];
                indiceMelhor = i;
                menorDistancia = melhor.distancia;
            }
        }

        for( int i = 0; i < 10; i++ ) {
            // gerar proxima geracao
            alterado = false;
            // nao alterar caso seja o melhor individuo da ultima geracao
            if ( i != indiceMelhor ) {
                // alterar individuo
                // crossing over
                if ( rand() % 100 < taxaCrossingOver ) {
                    alterado = true;
                // troca as ultimos 20% cidades pelo do melhor individuo
                // as cidades serao trocadas com uma aleatoria dos 80% depois da cidade inicial
                    for ( int j = qnt*0.8; j < qnt; j++ ) {
                        short temp = populacao[i].caminho[j];
                        do {
                            random = rand() % (int)(qnt*0.8);
                        } while ( random == 0 );
                        populacao[i].caminho[j] = populacao[i].caminho[random];
                        populacao[i].caminho[random] = temp;
                    }
                }

                // mutacao
                // caso aconteca, a cidade atual troca de posicao com outra cidade aleatoriamente
                for ( int j = 1; j < qnt; j++ ) {
                    if ( rand() % 100 < taxaMutacao ) {
                        alterado = true;
                        // continuar gerando um numero aleatorio ate encontrar um diferente do indice da cidade atual e da inicial
                        do { 
                            random = rand() % qnt;
                        } while ( random == j || random == 0 );
                        short temp = populacao[i].caminho[j];
                        populacao[i].caminho[j] = populacao[i].caminho[random];
                        populacao[i].caminho[random] = temp;
                    }
                }

                // recalcular distancia do individuo atual considerando o novo caminho
                if ( alterado ) {
                    // iniciar distancia do individuo como distancia da ultima cidade ate a inicial
                    populacao[i].distancia = distancias[populacao[i].caminho[qnt-1]][0];
                    // calcular resto da distancia
                    for ( int j = 1; j < qnt; j++ ) {
                        populacao[i].distancia += distancias[populacao[i].caminho[j-1]][populacao[i].caminho[j]];
                    }
                }
            }
        }
    }

        // comparar e imprimir informacoes sobre distancia, caminho e tempo de execucao
        menorDistancia = INT32_MAX;
        for ( int i = 0; i < 10; i++ ) {
            if ( populacao[i].distancia < menorDistancia ) {
            melhor = populacao[i];
            menorDistancia = melhor.distancia;
            }
        }
        menorCaminho = "";
        for ( int i = 0; i < qnt; i++ ) {
            menorCaminho += to_string(melhor.caminho[i]+1) + " ";
        }

    // escrever no arquivo informacoes sobre distancia, caminho e tempo de execucao
    ofstream fb;
    fb.open("genetico.txt");
    fb << "Menor Caminho: " << menorCaminho << "\nMenor Distancia: " << menorDistancia << endl;
    chrono::high_resolution_clock::time_point t2 = chrono::high_resolution_clock::now();
    chrono::duration<double, std::milli> time_span = t2 - t1;
    fb << time_span.count() << " ms";
    fb.close();


    return 0;
}