#include <stdio.h>
#include <stdlib.h>

int quantidade;
double altura = 0;
int cod = 0;
int maior = 0;
int menor = 0;
double mediafem = 0;
double media = 0;
int qnt = 0;
int qntfem = 0;

for ( int i = 0; i < quantidade; i = i+ 1 )
{
	scanf ( "Qual a altura? %d", &altura )
	if ( altura > maior )
{
	maior = altura;
}
	else
{
	if ( altura < menor )
{
		menor = altura;
}
}
media = media + altura;
qnt = qnt + 1;
scanf ( "Qual o sexo? %i", &cod )
if ( cod == 2 )
{
	qntfem = qntfem + 1;
	mediafem = mediafem + altura;
}
}
media = media / qnt;
mediafem = mediafem / qntfem;
printf ( "Maior altura: %d", &maior );
printf ( "Menor altura: %d", &menor );
printf ( "Media de altura das mulheres: %d", &mediafem );
printf ( "Media de altura da turma: %d", &media );
