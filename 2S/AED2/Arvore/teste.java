public class teste
{
   public static boolean verificaSimiliar ( No raiz1, No raiz2 )
   {
      boolean resp = true;
      if ( raiz1 == null && raiz2 == null )
      {
         resp = true;
      }
      else if ( raiz1.elemento == raiz2.elemento )
      {
         resp = verificaSimiliar ( raiz1.esq, raiz2.esq );
         if ( resp == true )
         {
            resp = verificaSimiliar ( raiz1.dir, raiz2.dir );
         }
      }
      else
      {
         resp = false;
      }
      return ( resp );
   }
   public static void main ( String [] args )
   {
      ArvoreBinaria a1 = new ArvoreBinaria ( );
      ArvoreBinaria a2 = new ArvoreBinaria ( );
      a1.inserir ( 1 );
      a1.inserir ( 2 );
      a1.inserir ( 3 );
      a1.inserir ( 4 );
      a1.inserir ( 14 );
      a1.inserir ( 6 );
      a1.inserir ( 27 );
      a1.inserir ( 8 );
      a1.inserir ( 13 );
      MyIO.println ( a1.raiz.elemento );
      a2.inserir ( 13 );
      a2.inserir ( 2 );
      a2.inserir ( 3 );
      a2.inserir ( 4 );
      a2.inserir ( 27 );
      a2.inserir ( 6 );
      a2.inserir ( 14 );
      a2.inserir ( 8 );
      a2.inserir ( 1 );
      a1.mostrarCentral ( a1.raiz );
      a2.mostrarCentral ( a2.raiz );
      MyIO.println ( verificaSimiliar ( a1.raiz, a2.raiz ) );
   }
}