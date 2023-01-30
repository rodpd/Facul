// Aluno: Rodrigo Padilha
// Matricula: 628826
// 9. Arquivo em Java

import java.io.*;

public class questao09
{
   public static void main ( String [] args ) throws FileNotFoundException, IOException
   {
   // ler do input e gravar no arquivo
      int qnt = MyIO.readInt( );
      RandomAccessFile raf = new RandomAccessFile ( "q09.out", "rw" );
      double num;
      for ( int i = 0; i < qnt; i++ )
      {
         num = MyIO.readDouble( );
         raf.writeDouble ( num );
      }
      raf.close( );
      RandomAccessFile ler = new RandomAccessFile ( "q09.out", "r" );
      // posicao que sera lida com seek
      int pos = (qnt-1)*8;
      for ( int i = 0; i < qnt; i++ )
      {
      // leitura do arquivo e mudanca na posicao
         ler.seek ( pos );
         num = ler.readDouble( );
         pos -= 8;
         // imprime int caso seja inteiro para sumir com o .0
         if ( (int) num == num )
         {
         MyIO.println ( (int) num );
         }
         else
         {
         MyIO.println ( num );
         }
      }
   }
}