
package grafos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Aeroporto extends JPanel {
    
    private String nome;
    private int posicaoX;
    private int posicaoY;
    
    
    public Aeroporto( ) {
        this.nome = "";
        this.posicaoX = 0;
        this.posicaoY = 0;
    }
    
    public Aeroporto( String nome, double posY, double posX, int imgX, int imgY) {
        this.nome = nome;
        this.posicaoX = calcularLongitude(posX, imgX);
        this.posicaoY = calcularLatitude(posY, imgY);
    }

    @Override
    public String toString() {
        return "Aeroporto{" + "nome=" + nome + ", posicaoX=" + posicaoX + ", posicaoY=" + posicaoY + '}';
    }
    
    
    
    public void setNome( String nome ) {
        this.nome = nome;
    }
    
    public String getNome( ){
        return this.nome;
    }
    
    
    public int calcularLatitude( double pos, int imgY ) {
        int y;
        if ( pos < 0 ) {
            y = (int) Math.round(imgY*(0.5-(pos/180.0)));
        }
        else { 
            y = (int) Math.round(imgY*(0.5-pos/180.0));
        }
        return y;
    }
    
    public void setLatitude( int pos ) {
        this.posicaoY = pos;
    }
    
        public int getLatitude( ) {
        return this.posicaoY;
    } 
        

    public int calcularLongitude( double pos, int imgX ) {
        int x;
        if ( pos < 0 ) {
            x = (int) Math.round(imgX*(0.5+pos/360.0));
            //x = (int) Math.round()
        }
        else {
            x = (int) Math.round(imgX*(0.5+(pos/360.0)));
            
        }
       //x = (int) (pos/Math.PI);
        //System.out.println("LONGITUDE: " + imgX/Math.PI);
        return x;
    }
    
    public void setLongitude( int pos ) {
        this.posicaoX = pos;
    }
    
        public int getLongitude( ) {
        return this.posicaoX;
    }
       
        
}
