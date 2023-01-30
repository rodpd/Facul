#include <iostream>

using namespace std;

int main ( ) {

short qnt, num1, num2, temp;
cin >> qnt;
for ( int i = 0; i < qnt; i++ ) {
    // calcular tamanho da pilha (mdc)
    cin >> num1 >> num2;
    if ( num1 < num2 ) {
        temp = num1;
        num1 = num2;
        num2 = temp;
    }
    while ( num1 % num2 != 0 ) {
        temp = num1;
        num1 = num2;
        num2 = temp % num2;
    }
    cout << num2 << endl;

}
    return 0;
}