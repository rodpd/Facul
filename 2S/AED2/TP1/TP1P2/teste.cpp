#include <stdio.h>
#include <stdlib.h>

int main ( )
{
   int a = 5;
   FILE *arq = fopen ( "censo2.dat", "r" );
   char str [500];
   char sigla [50];
   int codigo;
   char noman [50];
   int i = 0;
   /*int j;
   scanf ( "%d", &j );
   while ( j > 0 )
   {
   j--;
   fgets ( str, 1, arq );
   }*/
   //fgets ( str, 500, arq );
   fscanf ( arq, "%s", str );
   fscanf ( arq, "%s", sigla );
   //fscanf ( arq, "%d", codigo );
   fscanf ( arq, "%s", noman );
   printf ( "%s", str );
   printf ( "\t%s", sigla );
   //printf ( "\t%d", codigo );
   printf ( "\t%s", noman );
   return 0;
}
/*typedef struct Instituicao
{
	// atributos
	int ultimo;
	Lista [] inst;
	Lista [] retornada;
	private int codigo;
	private String nome;
	private String sigla;
	private int codigoMantenedora;
	private String mantenedora;
	private int categoria;
	private int organizacao;
	private int codigoMunicipio;
	private String municipio;
	private String uf;
	private String regiao;
	private int tecnico;
	private int periodico;
	private int livro;
	private double receita;
	private double transferencia;
	private double outraReceita;
	private double despesaDocente;
	private double despesaTecnico;
	private double despesaEncargo;
	private double despesaCusteio;
	private double despesaInvestimento;
	private double despesaPesquisa;
	private double despesaOutras;
   }*/