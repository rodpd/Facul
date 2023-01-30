public class ListaDupla
{
private CelulaDupla primeiro, ultimo;
   public ListaDupla ( )
   {
      this(0);
   }
   public ListaDupla ( int x )
   {
      primeiro = new CelulaDupla ( );
      ultimo = primeiro;
   }
   public void inserirFim ( int x )
   {
      ultimo.prox = new CelulaDupla ( x );
      ultimo.prox.ant = ultimo;
      ultimo = ultimo.prox;
   }
   public void mostrar ( )
   {
      MyIO.print ( "[ " );
      for ( CelulaDupla i = primeiro.prox; i != null; i = i.prox )
      {
         MyIO.print ( i.elemento + " " );
      }
      MyIO.println ( "]" );
   }
   public void inverterDupla ( )
   {
      CelulaDupla i = primeiro.prox;
      CelulaDupla j = ultimo;
      int temp;
   // repetir enquanto i nao for igual ou passar de j
      while ( ! ( i == j || i == j.prox ) )
      {
         temp = i.elemento;
         i.elemento = j.elemento;
         j.elemento = temp;
         i = i.prox;
         j = j.ant;
      }
   }
   /* public void inverterSimples ( )
   {
      Celula i = primeiro.prox;
      Celula j = i;
      Celula temp = ultimo;
      int num;
      for ( Celula i = primeiro.prox; i != ultimo; i = i.prox, j = i )
      {
         while ( j.prox != temp )
         {
            j = j.prox;
         }
         num = i.elemento;
         i.elemento = temp.elemento;
         temp.elemento = num;
         temp = j;
      }
   } */
   public static void main ( String [] args )
   {
      ListaDupla lista = new ListaDupla ( 5 );
      lista.inserirFim ( 1 );
      lista.inserirFim ( 2 );
      lista.inserirFim ( 3 );
      lista.inserirFim ( 4 );
      lista.inserirFim ( 5 );
      lista.mostrar ( );
      lista.inverterDupla ( );
      lista.mostrar ( );
   }
}
