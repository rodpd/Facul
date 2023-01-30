#include <iostream>
using namespace std;

int main ( ) {

    int qnt;
    cin >> qnt;

    for ( int i = 0; i < qnt; i++ ) {
        int novos = 1, maduros = 0, temp;
        int iteracoes;
        string s;
        cin >> s;
        // formatar entrada p/ gerar numero menor de iteracoes
        if ( s.length() > 9 )
        s = s.substr((s.length()-9), 9);
        // diminuir quantidade de iteracoes
        iteracoes = stoi(s);
        if ( iteracoes > 10000000 )
        iteracoes = iteracoes%10000000;

        // calcular quantidade de bacilos maduros
        for ( int i = 0; i < iteracoes; i++ ) {
            // guardar valor de maduros p/ adicionar a novos depois
            temp = maduros;
            maduros += novos;
            novos = temp;
            // dividir maduros caso seja maior que 1000 p/ evitar overflow
            if ( maduros > 1000 ) 
            maduros = maduros%1000;
        }

        // mostrar quantidade final de bacilos maduros
        if ( maduros > 99 ) {
            cout << maduros%1000 << endl;
        }
        else if ( maduros > 9 ) {
            cout << 0 << maduros%100 << endl;
        }
        else {
            cout << "00" << maduros%10 << endl;
        }
    }
    return 0;
}