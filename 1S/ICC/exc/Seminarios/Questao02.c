#import <stdio.h>
while ( IO.readint ( ) != 0 )
{
for ( int i = 0; i < n; i = i + 1 )
{
int numero = IO.readint ( );
if ( numero != 0 )
{
if ( numero % 2 == 0 )
{
IO.print ( "PAR," );
}
else
{
IO.print ( "IMPAR," );
}
IO.print ( numero * numero + "," );
IO.print ( numero * numero * numero * numero + "," );
if ( (char) numero >='a' || (char) numero <='z' || (char) numero >='A' || (char) numero >='Z' )
{
IO.println ( (char) numero );
}
else
{
IO.println ( "NAO E LETRA" );
}
}
}
}