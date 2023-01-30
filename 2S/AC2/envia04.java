import java.io.*;
import java.util.Scanner;

public class envia04 {

   public static void main (String [] args) throws Exception {
   
      ProcessBuilder pb;
      Process p;
      // abrir arquivo
      Scanner scanner = new Scanner(System.in);
      FileReader fr = new FileReader("teste.txt");
      BufferedReader br = new BufferedReader( fr );
      // ler primeira linha
      String linha = br.readLine();
      while ( true ) {
      System.out.println(linha);
      // comecar processo no arduino enviando string lida do arquivo
         //pb = new ProcessBuilder("envia.exe","com7",linha);
         //p = pb.start();
         //p.waitFor();
         // ler proxima linha para a proxima execucao
         linha = br.readLine();
         // esperar enter para proxima execucao
         scanner.nextLine();
      }
      // br.close();
      // fr.close();
   }
}