#import <stdio.h>
int maior = 0;
int menor = 0;
int media = 0;
int impares = 0;
int n = IO.readint ( );
for ( int i = 0; i < n; i = i+1 )
{
int numero = IO.readint( );
if ( maior < numero )
{
maior = numero;
}
else
{
if ( menor > numero )
{
menor = numero;
}
}
if ( numero % 2 != 0 )
{
impares = impares + 1;
}
media = media + numero;
}
media = media / n;
IO.println ( maior );
IO.println ( menor );
IO.println ( media );
IO.println ( impares );
