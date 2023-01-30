import java.io.*;

public class envia01
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
        String x;
        while ( true ) {
            
            // vermelho
            for ( int i = 0; i < 3; i++ ) {
                pb = new ProcessBuilder("envia.exe", "com10", " 0");
                p = pb.start();
                p.waitFor();
                Thread.sleep(600);
                // System.out.println("0");
                pb = new ProcessBuilder("envia.exe", "com10", " 1");
                p = pb.start();
                p.waitFor();
                Thread.sleep(25);
                //System.out.println("1");
            }
            
            // verde
            for ( int i = 0; i < 4; i++ ) {
                pb = new ProcessBuilder("envia.exe", "com10", " 2");
                p = pb.start();
                p.waitFor();
                Thread.sleep(600);
                pb = new ProcessBuilder("envia.exe", "com10", " 3");
                p = pb.start();
                p.waitFor();
                Thread.sleep(25);
            }
            
            // amarelo
            for ( int i = 0; i < 2; i++ ) {
                pb = new ProcessBuilder("envia.exe", "com10", " 4");
                p = pb.start();
                p.waitFor();
                Thread.sleep(600);
                pb = new ProcessBuilder("envia.exe", "com10", " 5");
                p = pb.start();
                p.waitFor();
                Thread.sleep(25);
                //System.out.println("tempo c azul desligado: " + fim );
            }
            
        }
   }
}