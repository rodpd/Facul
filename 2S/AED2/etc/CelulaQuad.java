public class CelulaQuad
{
   public int elemento;
   public CelulaQuad dir,esq,sup,inf;
   public CelulaQuad ( )
   {
      this(0);
   }
   public CelulaQuad ( int x )
   {
      this.elemento = x;
      this.dir = this.esq = this.sup = this.inf = null;
   }
}