
package grafos;

public class Rota {
    Aeroporto a1;
    Aeroporto a2;
    int preco;
    int altura = 0;

    public Rota (Aeroporto a1, Aeroporto a2, int preco) {
        this.a1 = a1;
        this.a2 = a2;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Rota{" + "a1=" + a1 + ", a2=" + a2 + ", preco=" + preco + ", altura=" + altura + '}';
    }
    
    public int getPreco( ){
        return this.preco;
    }
    
    public void setAltura( int altura){
        this.altura = altura;
    }
    
    public int getAltura ( ) {
        return this.altura;
    }
}

