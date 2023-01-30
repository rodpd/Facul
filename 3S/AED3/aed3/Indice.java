package aed3;
import java.io.*;

public class Indice {
    
    private final RandomAccessFile arquivo;
    private final String nomeArquivo;
    
    public Indice ( String nome ) throws IOException {
        this.nomeArquivo = nome;
        arquivo = new RandomAccessFile ( this.nomeArquivo, "rw" );
    }
    
    public void incluir ( short id, long endereco ) throws IOException {
        arquivo.seek(arquivo.length());
        arquivo.writeShort(id);
        arquivo.writeLong(endereco);
    }
    
    public long buscar ( short id ) throws IOException {
        long endereco;
        do {
            endereco = arquivo.getFilePointer();
            if ( arquivo.readShort() == id ) {
                return endereco;
            }
        } while ( endereco < arquivo.length());
        // se nao encontrar, retornar -1
        return -1;
    }
    
    public void excluir ( short id ) throws IOException {
        long endereco;
        do {
        endereco = arquivo.getFilePointer();
        if (arquivo.readShort() == id) {
            arquivo.seek(endereco);
            arquivo.writeShort(-1);
        }
        } while ( endereco < arquivo.length());
    }
    
    public void alterar ( short id, long endereco ) throws IOException {
        while (arquivo.readShort() != id )
        {
            arquivo.readLong();
        }
        arquivo.writeLong(endereco);
    }
    
    public void listar () throws IOException {
        short id;
        while (arquivo.getFilePointer() < arquivo.length()) {
            id = arquivo.readShort();
            if ( id != -1) {
            System.out.println ("ID: " + id);
            System.out.println ("Endereco: " + arquivo.readLong());
            }
        }
    }
    
}
