#include <iostream>
using namespace std;

int main ( ) {
    int tam;
    cin >> tam;
    int nums [tam][tam];

    int maior = INT32_MIN;
    // montar vetor e comparar retangulos 1x1
    for ( int i = 0; i < tam; i++ ) {
        for ( int j = 0; j < tam; j++ ) {
            cin >> nums[i][j];
            //scanf ( "%d", &nums[i][j]);
            if ( nums[i][j] > maior ) {
                maior = nums[i][j];
            }
        }
    }

    // retangulos horizontais ( x > y)
    for ( int x = 2; x <= tam; x++ ) {
        for ( int y = 1; y <= tam; y++ ) {
            // mover retangulo
            for ( int xInicio = 0; xInicio <= tam-x; xInicio++ ) {
                for ( int yInicio = 0; yInicio <= tam-y; yInicio++ ) {
                    int soma = 0;
                    // somar valores do retangulo atual
                    for ( int i = xInicio; i < xInicio+x; i++ ) {
                        for ( int j = yInicio; j < yInicio+y; j++ ) {
                            soma += nums[i][j];
                        }
                    }
                    if ( soma > maior )
                        maior = soma;
                }
            }
        }
    }

    // retangulos verticais ( y > x )
    for ( int y = 2; y <= tam; y++ ) {
        for ( int x = 1; x <= tam; x++ ) {
            // mover retangulo
            for ( int yInicio = 0; yInicio <= tam-y; yInicio++ ) {
                for ( int xInicio = 0; xInicio <= tam-x; xInicio++ ) {
                    int soma = 0;
                    // somar valores do retangulo atual
                    for ( int i = xInicio; i < xInicio+x; i++ ) {
                        for ( int j = yInicio; j < yInicio+y; j++ ) {
                            soma += nums[j][i];
                        }
                    }
                    if ( soma > maior )
                        maior = soma;
                }
            }
        }
    }

    cout << maior << endl;
    
}