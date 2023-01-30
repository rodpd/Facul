public class ArvoreBinaria
{
   public No raiz;
   public ArvoreBinaria ( )
   {
      raiz = null;
   }
   public void inserir ( int x )
   {
      raiz = inserir ( x, raiz );
   }
   private No inserir ( int x, No i )
   {
      if ( i == null )
      {
         i = new No ( x );
      }
      else if ( x < i.elemento )
      {
         i.esq = inserir ( x, i.esq );
      }
      else if ( x > i.elemento )
      {
         i.dir = inserir ( x, i.dir );
      }
      else
      {
         MyIO.println ( "Erro!" );
      }
      return i;
   }
   public void remover ( int x ) throws Exception
   {
      raiz = remover ( x, raiz );
   }
   private No remover ( int x, No i ) throws Exception
   {
      if ( i == null )
      {
         throw new Exception ( "Erro!" );
      }
      else if ( x < i.elemento )
      {
         i.esq = remover ( x, i.esq );
      }
      else if ( x > i.elemento )
      {
         i.dir = remover ( x, i.dir );
      }
      else if ( i.dir == null )
      {
         i = i.esq;
      }
      else if ( i.esq == null )
      {
         i = i.dir;
      }
      else
      {
         i.esq = anterior ( i, i.esq );
      }
      return i;
   }
   private No anterior ( No i, No j )
   {
      if ( j.dir != null )
      {
         j.dir = anterior ( i, j.dir );
      }
      else
      {
         i.elemento = j.elemento;
         j = j.esq;
      }
      return j;
   }
   public void mostrarCentral ( No i )
   {
      if ( i != null )
      {
         mostrarCentral ( i.esq );
         MyIO.println ( i.elemento + " " );
         mostrarCentral ( i.dir );
      }
   }
}