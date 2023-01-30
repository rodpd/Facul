public class Fila
{
   private static Celula primeiro, ultimo;
   public Fila ( )
   {
      primeiro = new Celula( );
      ultimo = primeiro;
   }
   public void inserir ( int x )
   {
      ultimo.prox = new Celula ( x );
      ultimo = ultimo.prox;
   }
   public void mostrar ( )
   {
      MyIO.print ( "[ " );
      for ( Celula i = primeiro.prox; i != null; i = i.prox )
      {
         MyIO.print ( i.elemento + " " );
      }
      MyIO.println ( "]" );
   }
   // U5c - pag. 27 +
   public static int maior ( )
   {
      int maior = 0;
      if ( primeiro == ultimo )
      {
         MyIO.println ( "ERRO: fila vazia" );
      }
      else
      {
         for ( Celula i = primeiro.prox; i != null; i = i.prox )
         {
            if ( i.elemento > maior )
            {
               maior = i.elemento;
            }
         }
      }
      return ( maior );
   }
   
   public static void mostrarTerceiro ( )
   {
      MyIO.println ( primeiro.prox.prox.prox.elemento );
   }
   public static void somar( )
   {
      int soma = 0;
      for ( Celula i = primeiro.prox; i != null; i = i.prox )
      {
         soma += i.elemento;
      }
      MyIO.println ( soma );
   }
   public static void inverter ( )
   {
   // declarar celulas auxiliares e mudar primeiro para nova celula
      Celula i = primeiro;
      primeiro = new Celula ( );
      Celula temp = primeiro;
      Celula j;
      // destruir fila atual copiando em ordem decrescente para
      // a nova enquanto nao estiver vazia
      while ( i.prox != null )
      {
         for ( j = i; j.prox != ultimo; j = j.prox );
         temp.prox = new Celula ( j.prox.elemento );
         temp = temp.prox;
         j.prox = null;
         ultimo = j;
      }
      ultimo = temp;
   }
   // metodo para contar quantidade de elementos pares e multiplos de 5
   // inicializar com Celula primeiro.prox e quantidade de multiplos 0
   public static int contar ( Celula i, int multiplos )
   {
      if ( i != null )
      {
         if ( i.elemento % 10 == 0 )
         {
            multiplos++;
         }
         multiplos = contar ( i.prox, multiplos );
      }
      return ( multiplos );
   }
   // pag. 38
   public static Celula toFila ( Celula topo )
   { 
   // variaveis auxiliares
      int qnt = 1;
      Celula cell = new Celula ( );
      Celula temp = cell;
      Celula t = topo;
      // contar quantidade de elementos na pilha
      while ( t.prox != null )
      {
         qnt++;
         t = t.prox;
      }
      // reset topo
      t = topo;
      int cont = qnt-1;
      // percorrer  n vezes
      for ( int i = 0; i < qnt; i++ )
      {
      // percorrer pilha em ordem decrescente
         for ( int j = 0; j < cont; j++ )
         {
            t = t.prox;
         }
         // mudar fila e alterar variaveis para o proximo loop
         cont--;
         temp.prox = new Celula ( t.elemento );
         temp = temp.prox;
         t = topo;
      }
      return ( cell );
   }
   public static int tamanho ( )
   {
      int tamanho = 0;
      for ( Celula i = primeiro.prox; i != null; i = i.prox )
      {
         tamanho++;
      }
      return ( tamanho );
   }
   public static void main ( String [] args )
   {
      Fila fila = new Fila ( );
      fila.inserir(14);
      fila.inserir(3);
      fila.inserir(6);
      fila.inserir(1);
      fila.inserir(9);
   }
}