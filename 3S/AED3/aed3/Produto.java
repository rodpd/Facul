package aed3;
import java.io.*;

public class Produto {

    protected short id;
    protected String nome;
    protected String marca;
    protected String categoria;
    protected String descricao;
    protected double preco;
    protected long endereco;

    public Produto ( String nome, String marca, String categoria, String descricao, double preco ) {
        this.id = -1;
        this.nome = nome;
        this.marca = marca;
        this.categoria = categoria;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Produto ( ) {
        this.id = -1;
        this.nome = "";
        this.marca = "";
        this.categoria = "";
        this.descricao = "";
        this.preco = 0.0;
    }

    public int getId () {
        return this.id;
    }

    public void setId ( short id ) {
        this.id = id;
    }

    @Override
    public String toString () {
        return "ID: " + this.id +
                "\nNome: " + this.nome +
                "\nMarca: " + this.marca +
                "\nCategoria: " + this.categoria +
                "\nDescricao: " + this.descricao +
                "\nPreco: R$ " + this.preco;
    }

    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream dados = new ByteArrayOutputStream();
        DataOutputStream saida = new DataOutputStream(dados);
        saida.writeShort(this.id);
        System.out.println("id: " + id);
        saida.writeUTF(this.nome);
        saida.writeUTF(this.marca);
        saida.writeUTF(this.categoria);
        saida.writeUTF(this.descricao);
        saida.writeDouble(this.preco);
        System.out.println("preco: " + preco);
        return dados.toByteArray();
    }

    public void fromByteArray ( byte[] b ) throws IOException {
        ByteArrayInputStream dados = new ByteArrayInputStream(b);
        DataInputStream entrada = new DataInputStream(dados);
        this.id = entrada.readShort();
        this.nome = entrada.readUTF();
        this.marca = entrada.readUTF();
        this.categoria = entrada.readUTF();
        this.descricao = entrada.readUTF();
        this.preco = entrada.readDouble();
    }
    
    public void mostrar() {
        System.out.println("\nNome: " + this.nome +
        "\nMarca: " + this.marca +
        "\nCategoria: " + this.categoria +
        "\nDescricao: " + this.descricao +
        "\nPreco: " + this.preco);
    }
    
    public void mostrarID() {
        System.out.println("\nID: " + this.id +
        "\nNome: " + this.nome +
        "\nMarca: " + this.marca +
        "\nCategoria: " + this.categoria +
        "\nDescricao: " + this.descricao +
        "\nPreco: " + this.preco);
    }
}