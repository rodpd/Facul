#include <stdio.h>
#include <stdlib.h>

int num;
int menor = 0;
int segmenor = 0;
do
scanf ( "Digite um valor inteiro: %i", &num )
if ( num >= 0 )
{
if ( num < segmenor )
{
segmenor = num;
}
if ( num < menor )
{
segmenor = menor;
menor = num;
}
while ( num >= 0 )
