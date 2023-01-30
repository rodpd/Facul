import java.io.*;

public class envia02
{

   public static char readChar ( ) {
      String input;
      char c = 0;
      try  {
         BufferedReader bf = new BufferedReader( new InputStreamReader(System.in) );
         input = bf.readLine();
         c = input.charAt(0);
      }
      catch ( NumberFormatException | IOException ex ) {
      }
      return c;
   }
   public static void main (String [] args)
   throws Exception
   {
   
      ProcessBuilder pb;
      Process p;
      char a, b, opcode;
      String x;
      Long start_time;
      Long diff_time;
   
      do {
         System.out.println ( "valor de a: " );
         a = readChar();
         System.out.println ( "valor de b: " );
         b = readChar();
         System.out.println ( "valor de opcode: " );
         opcode = readChar();
         x = a + " " + b + " " + opcode;
         pb = new ProcessBuilder("envia.exe", "com10", x );
         p = pb.start();
         p.waitFor();
      } while ( !( a == 0 && b == 0 && opcode == 0 ) );

   }
}