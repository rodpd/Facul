public class No
{
   public No esq;
   public No dir;
   public int elemento;
   public No ( int elemento )
   {
      this ( elemento, null, null );
   }
   public No ( int elemento, No esq, No dir )
   {
      this.elemento = elemento;
      this.esq = esq;
      this.dir = dir;
   }
}