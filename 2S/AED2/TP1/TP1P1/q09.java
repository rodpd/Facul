// Aluno: Rodrigo Padilha
// Matricula: 628826
// 9. Arquivo em Java

import java.io.*;

public class q09
{
   public static void main ( String [] args ) throws FileNotFoundException, IOException
   {
      int qnt = MyIO.readInt( );
      Arq.openWrite ( "q09.out" );
      double num;
      int tamanho;
      int zeros = 0;
      for ( int i = 0; i < qnt; i++ )
      {
         num = MyIO.readDouble( );
         String s ="";
         String fim = "";
         s += num;
         tamanho = s.length( );
         for ( int j = 0; j < tamanho; j++ )
         {
            if ( ! ( s.charAt(j) == '0' ) )
            {
               zeros = 0;
            }
            else
            {
               zeros += 1;
            }
         }
         for ( int j = 0; j < tamanho-zeros-1; j++ )
         {
            fim += s.charAt(j);
         }
         if ( s.charAt(tamanho-zeros-1) != '.' )
         {
            fim += s.charAt(tamanho-zeros-1);
         }
         Arq.println ( fim ); 
      }
      Arq.close( );
      RandomAccessFile raf = new RandomAccessFile ( "q09.out", "r" );
      raf.seek(raf.length( )-2);
      double d = raf.readDouble( );
      MyIO.println ( d );
   	//while ( read != qnt )
   	//{
   		
   }
}
