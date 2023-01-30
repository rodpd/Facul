public class Matriz
{
   private CelulaQuad inicio;
   int linhas, colunas;
   public Matriz ( )
   {
      this( 0, 0 );
   }
   public Matriz ( int linha, int coluna )
   {
      inicio = new CelulaQuad ( );
      this.linhas = linha;
      this.colunas = coluna;
   // adicionar teste tamanho n pode ser <= 0
      CelulaQuad temp = inicio;
      for ( int i = 0; i < linha; i++ )
      {
         for ( int j = 0; j < coluna; j++ )
         {
            if ( j < coluna-1 )
            {
            // criar celula a direita caso esteja na primeira linha
               if ( i == 0 )
               {
                  temp.dir = new CelulaQuad ( );
                  temp.dir.esq = temp;
               }
               // caso contrario apenas ligar as celulas
               else
               {
                  temp.dir = temp.sup.dir.inf;
                  temp.dir.esq = temp;
               }
            }
         // criar celulas de baixo e ligar
            if ( i < linha-1 )
            {
               temp.inf = new CelulaQuad ( );
               temp.inf.sup = temp;
            }
            temp.elemento = i*linha+j;
            temp = temp.dir;
         // as ligacoes restantes sao null quando a celula e criada
         }
         // voltar temp para inicio e mover para a linha desejada caso nao esteja na ultima linha
         temp = inicio;
         if ( i < linha-1 )
         {
            for ( int cont = i+1; cont > 0; cont--, temp = temp.inf );
         }
      }
   }
   public Matriz soma ( Matriz outra )
   {
      Matriz resp = null;
      if ( outra.linhas == this.linhas && outra.colunas == this.colunas )
      {
         resp = new Matriz ( this.linhas, this.colunas );
      // temporarias que serao usadas para percorrer as outras
         CelulaQuad temp1 = this.inicio;
         CelulaQuad temp2 = outra.inicio;
         CelulaQuad temp3 = resp.inicio;
         for ( int i = 0; i < this.linhas; i++ )
         {
         // percorrer linha mudando elemento
            for ( int j = 0 ; j < this.colunas; j++ )
            {
               temp3.elemento = temp1.elemento + temp2.elemento ;
               temp1 = temp1.dir;
               temp2 = temp2.dir;
               temp3 = temp3.dir;
            }
         // voltar p/ inicio da linha
            temp1 = this.inicio;
            temp2 = outra.inicio;
            temp3 = resp.inicio;
         // ir p/ coluna desejada
            for ( int cont = i+1; cont > 0; cont--)
            {
               temp1 = temp1.inf;
               temp2 = temp2.inf;
               temp3 = temp3.inf;
            }
         } // fim primeiro for
      } // fim if
      return ( resp );
   }
   public void mostrar ( )
   {
      CelulaQuad temp = inicio;
      for ( int i = 0; i < linhas; i++ )
      {
         for ( int j = 0; j < colunas; j++ )
         {
            MyIO.print ( temp.elemento + "\t" );
            temp = temp.dir;
         }
         temp = inicio;
         for ( int cont = i+1; cont > 0; cont--, temp = temp.inf );
         MyIO.println ( "" );
      }
   }
   public static void main ( String [] args )
   {
      Matriz teste = new Matriz ( 3, 3 );
      Matriz outra = new Matriz ( 3, 3 );
      MyIO.println ( "" );
      Matriz resp = teste.soma( outra );
      teste.mostrar ( );
      MyIO.println ( "" );
      outra.mostrar ( );
      MyIO.println ( "" );
      resp.mostrar ( );
   }
}
