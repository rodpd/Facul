// pag. 40
public class PilhaComNo
{
   private static Celula topo;
   public PilhaComNo ( )
   {
      topo = new Celula ( );
   }
   public void inserir ( int x )
   {
      Celula temp =  new Celula ( x );
      temp.prox = topo.prox;
      topo.prox = temp;
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
   public static void main ( String [] args )
   {
      PilhaComNo fila = new PilhaComNo( );
      fila.inserir(1);
      fila.inserir(3);
      fila.inserir(17);
      fila.inserir(6);
      fila.inserir(9);
      fila.mostrar( );
   }
}