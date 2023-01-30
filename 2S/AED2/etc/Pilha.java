public class Pilha
{
   private static Celula topo;
   public Pilha ( )
   {
      topo = null;
   }
   public void inserir ( int x )
   {
      Celula temp =  new Celula ( x );
      temp.prox = topo;
      topo = temp;
      temp = null;
   }
   public void mostrar ( )
   {
      MyIO.print ( "[" );
      for ( Celula i = topo; i != null; i = i.prox )
      {
         MyIO.print ( i.elemento + " " );
      }
      MyIO.println ( "]" );
   }
   // Rodrigo Padilha
   // Matricula: 628826
   // U5b - pag. 49 a 55
   public void soma ( )
   {
      int soma = 0;
      for ( Celula i = topo; i != null; i = i.prox )
      {
         soma += i.elemento;
      }
      MyIO.println ( soma );
   }
   public void somaRecursiva ( int soma, Celula i )
   {
      if ( i != null )
      {
         soma += i.elemento;
         somaRecursiva ( soma, i.prox );
      }
      else
      {
         MyIO.println ( soma );
      }
   }
   public int maior ( )
   {
      int maior = 0;
      for ( Celula i = topo; i != null; i = i.prox )
      {
         if ( i.elemento > maior ) 
         {
            maior = i.elemento;
         }
      }
      return ( maior );
   }
   public static int maiorRecursivo ( int maior, Celula i )
   {
      if ( i != null )
      {
         if ( i.elemento > maior )
         {
            maior = i.elemento;
         }
         maiorRecursivo ( maior, i.prox );
      }
      return ( maior );
   }
   public void mostrarRemovidos ( Celula i )
   {
      if ( i != null )
      {
         MyIO.println ( i.elemento );
         mostrarRemovidos ( i.prox );
      }
   }
   public void mostrarInseridos ( Celula i )
   {
      if ( i != null )
      {
         mostrarInseridos ( i.prox );
         MyIO.println ( i.elemento );
      }
   }
   public void mostrarIterativo ( )
   {
      int cont = 0;
      // contar quantidade de celulas
      for ( Celula i = topo; i != null; i = i.prox )
      {
         cont += 1;
      }
      // loop que percorre ate a posicao do contador, imprime
      // elemento e reduz contador para percorrer ate
      //  a posicao anterior
      for ( Celula i = topo; cont > 0; i = topo, cont-- )
      {
         for ( int j = 0; j < cont; j++ )
         {
            i = i.prox;
         }
         MyIO.println ( i.elemento );
      }
   }
   public static void main ( String [] args )
   {
      Pilha pilha = new Pilha ( );
      pilha.inserir(1);
      pilha.inserir(2);
      pilha.inserir(3);
      pilha.mostrar( );
      pilha.mostrarInseridos( topo );
   }
}