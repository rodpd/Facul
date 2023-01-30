// pag. 39
public class FilaSemNo
{
   private static Celula primeiro, ultimo;
   public FilaSemNo ( )
   {
      primeiro = new Celula ( );
      ultimo = primeiro;
   }
   public void inserir ( int x )
   {
      if ( primeiro == ultimo )
      {
         ultimo.elemento = x;
         MyIO.println ( primeiro.elemento );
         primeiro.prox = new Celula ( x );
         ultimo = primeiro.prox;
      }
      else
      {
         ultimo.elemento = x;
         ultimo.prox = new Celula ( );
         ultimo = ultimo.prox;
      }
   }
   public void mostrar ( )
   {
      MyIO.print ( "[ " );
      for ( Celula i = primeiro; i.prox != null; i = i.prox )
      {
         MyIO.print ( i.elemento + " " );
      }
      MyIO.println ( "]" );
   }
   public static void main ( String [] args )
   {
      FilaSemNo fila = new FilaSemNo( );
      fila.inserir(1);
      fila.inserir(3);
      fila.inserir(17);
      fila.inserir(6);
      fila.inserir(9);
      fila.mostrar( );
      MyIO.println ( primeiro.elemento );
   }
}