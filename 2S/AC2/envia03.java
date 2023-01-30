import java.io.*;
import java.util.Scanner;

public class envia03 {

   public static void main (String [] args) throws Exception {
      char a = '0', b = '0';
      // abrir arquivos
      FileReader fr = new FileReader("testeula.ula");
      BufferedReader br = new BufferedReader( fr );
      FileWriter fw = new FileWriter("teste.hex");
      BufferedWriter bw = new BufferedWriter ( fw );
      // pular primeira linha
      br.readLine();
      // ler segundalinha
      String linha = br.readLine();
      // continuar lendo enquanto nao encontrar fim.
      while ( linha.compareTo("fim.") != 0 ) {
      // se segundo char for = , fazer atribuicao
         if ( linha.charAt(1) == '=' ) {
         // caso primeira letra seja a, mudar valor de a
            if ( linha.charAt(0) == 'A' ) {
               a = linha.charAt(2);
            }
            // caso seja b, mudar b
            else if ( linha.charAt(0) == 'B' ) {
               b = linha.charAt(2);
            }
         }
         // caso nao seja uma atribuicao, comparar para ver qual operacao sera feita,
         // escrever valor de a, b, e codigo hexa da operacao e passar para proxima linha
         else if ( linha.compareTo("zeroL;") == 0 ) {
         bw.write ( a+b+"0" );
         bw.newLine();
         }
         else if ( linha.compareTo("umL;") == 0 ) {
         bw.write ( a+b+"1" );
         bw.newLine();
         }
         else if ( linha.compareTo("An;") == 0 ) {
         bw.write ( a+""+b+"2" );
         bw.newLine();
         }
         else if ( linha.compareTo("Bn;") == 0 ) {
         bw.write ( a+""+b+"3" );
         bw.newLine();
         }
         else if ( linha.compareTo("AouB;") == 0 ) {
         bw.write ( a+""+b+"4" );
         bw.newLine();
         }
         else if ( linha.compareTo("AeB;") == 0 ) {
         bw.write ( a+""+b+"5" );
         bw.newLine();
         }
         else if ( linha.compareTo("AxorB;") == 0 ) {
         bw.write ( a+""+b+"6" );
         bw.newLine();
         }
         else if ( linha.compareTo("AnandB;") == 0 ) {
         bw.write ( a+""+b+"7" );
         bw.newLine();
         }
         else if ( linha.compareTo("AnorB;") == 0 ) {
         bw.write ( a+""+b+"8" );
         bw.newLine();
         }
         else if ( linha.compareTo("AxnorB;") == 0 ) {
         bw.write ( a+""+b+"9" );
         bw.newLine();
         }
         else if ( linha.compareTo("AnouB;") == 0 ) {
         bw.write ( a+""+b+"A" );
         bw.newLine();
         }
         else if ( linha.compareTo("AouBn;") == 0 ) {
         bw.write ( a+""+b+"B" );
         bw.newLine();
         }
         else if ( linha.compareTo("AneB;") == 0 ) {
         bw.write ( a+""+b+"C" );
         bw.newLine();
         }
         else if ( linha.compareTo("AeBn;") == 0 ) {
         bw.write ( a+""+b+"D" );
         bw.newLine();
         }
         else if ( linha.compareTo("AnouBn;") == 0 ) {
         bw.write ( a+""+b+"E" );
         bw.newLine();
         }
         else if ( linha.compareTo("AneBn;") == 0 ) {
         bw.write ( a+""+b+"F" );
         bw.newLine();
         }
         // ler proxima linha para a proxima execucao
         linha = br.readLine();
      }
      // fechar arquivos
      bw.close();
      br.close();
      fw.close();
      fr.close();
      ProcessBuilder pb;
      Process p;
      // abrir arquivo
      Scanner scanner = new Scanner(System.in);
      fr = new FileReader("teste.hex");
      br = new BufferedReader( fr );
      // ler primeira linha
      linha = br.readLine();
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