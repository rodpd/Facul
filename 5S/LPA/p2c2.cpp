#include <iostream>
using namespace std;

int main ( ) {

    int num1, num2, dividendo, divisor, resto, estacas;

    string s;
    // continuar lendo ate chegar ate encontrar linha vazia
    while ( getline(cin, s) && s.length() > 1 ) {
            // retirar numeros da linha lida
            num1 = stoi(s.substr(0, s.find_first_of(' ')));
            s = s.substr(s.find_first_of(' '), s.length()-s.find_first_of(' '));
            num2 = stoi(s.substr(s.find_first_not_of(' '), (s.find_last_not_of(' ')-s.find_first_not_of(' ')+1)));
            dividendo = num1;
            divisor = num2;
            // calcular mdc e guardar em resto
            resto = dividendo%divisor;
            while ( resto != 0 ) {
                dividendo = divisor;
                divisor = resto;
                resto = dividendo%divisor;
            }

            // calcular e mostrar qnt de estacas
            estacas = (num1/divisor + num2/divisor )*2;
            cout << estacas << endl;
    }
        


    return 0;
}