import java.util.Random;

public class teste {
   public static void main ( String [] args ) {
      int num, num2;
      //int j = 40, k = 255;
      for ( int i = 1; i <= 255; i++ ) {
         for ( int j = 1; j <= 255; j++ ) {
            for ( int k = 1; k <= 255; k++ ) {
               //num += 5*(i-1)*5*(j-1)*3*(k-1)+i+j+k;
            //num = ((5*(i-1))+(5*((j-1)*(i-1)))+(3*((k-1)*(j-1)*(i-1)))+(6+(6*(i-1))+4*(j-1)*(i-1)))+4;
            // ultimos 2
            //num = ((5*((j-1)))+(3*((k-1)*(j-1)))+(7+4*(j-1)));
            // todos
            // atraso normal
               num = ((7*(i-1))+(5*((j-1)*(i-1)))+(3*((k-1)*(j-1)*(i-1)))+(9+(7*(i-1))+4*(j-1)*(i-1)))+4;
               num2 = ((5*((j-1)))+(3*((k-1)*(j-1)))+(7+4*(j-1)));
               if ( num >= 999999 && num <= 1001000  && num2 >= 47000 && num2 <= 48000){
                  MyIO.println ( "num: " + num + "    i: " + i + "    j: " + j + "    k: " + k );
                  MyIO.println ( "num2: " + num2 );
                  // atraso botao
               /*num = ((5*(i-1))+(5*((j-1)*(i-1)))+(3*((k-1)*(j-1)*(i-1)))+(7+(7*(i-1))+4*(j-1)*(i-1)))+4;
               if ( num >= 1000000 && num <= 1000002 ){
               MyIO.println ( "num: " + num + "    i: " + i + "    j: " + j + "    k: " + k );*/
               }
               //MyIO.println ( "num: " + num + "    j: " + j + "    k: " + k ); }
               //if ( ( num >= 10628626 && num <= 10628826 ) || ( num >= 11628626 && num <= 11628826 ) || 
               //( num >= 12628626 && num <= 12628826 ) || ( num >= 13628626 && num <= 13628826 ) ) {
               //if ( ( num >= 12628808 && num <= 12628844 ) || ( num >= 13628808 && num <= 13628844 ) ) {
                 // MyIO.println ( "num: " + num + "    i: " + i + "    j: " + j + "    k: " + k );
            }
         }
      }
   }
}