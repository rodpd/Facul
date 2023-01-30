#include <iostream>

using namespace std;


int main ( ) {

int qnt;
cin >> qnt;
// repetir ate input ser 0
while ( qnt != 0 ) {
    int inversoes = 0, inversoesAtual = 1, temp;
    int nums [qnt];
    
    
    // montar vetor c/ os numeros
    for ( int i = 0; i < qnt; i++ ) {
        cin >> nums[i];
    }
    // repetir ate tudo estar ordenado
    while ( inversoesAtual != 0 ) {
        inversoesAtual = 0;
        // trocar elemento da posicao atual pela correta e calcular inversoes
        for ( int i = 0; i < qnt; i++ ) {
            /* quantidade de movimentos necessaria para inverter dois numeros para colocar o primeiro 
            na posicao do segundo, sao n movimentos e para colocar o segundo na posicao do primeiro, n-1, 
            ja que comeca depois de ser trocado pelo primeiro, na posicao anterior a onde estava inicialmente
            ex
            6 5 4 3 2 1
            5 4 3 2 1 6  - 5 movimentos para 6 ir para sua posicao, 1 estando uma posicao atras da original
            1 5 4 3 2 6  - 4 movimentos
            */
            if ( nums[i] != i+1 ) {
                // a formula muda dependendo do numero em relacao a sua posicao
                if ( nums[i] > i )
                inversoesAtual = (nums[i] - (i+1))*2-1;
                else
                inversoesAtual = ((i+1) - nums[i])*2-1;
                // e` necessario saber apenas a paridade da quantidade de trocas
                inversoes = ( inversoes + inversoesAtual )%2 ;
                temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[temp-1] = temp;
            }
        }
    }
    // determinar vencedor pela paridade da quantidade de inversoes
    // Carlos se for par, Marcelo se for impar
    if ( inversoes == 0 )
        cout << "Carlos" << endl;
    else
        cout << "Marcelo" << endl;


    cin >> qnt;
}

return 0;
}