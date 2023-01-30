package aed3;
import java.io.*;

public class ArquivoProduto {
    
    private final RandomAccessFile arquivo;
    private final String nomeArquivo;
    
    public ArquivoProduto ( String nome ) throws IOException {
        this.nomeArquivo = nome;
        arquivo = new RandomAccessFile ( this.nomeArquivo, "rw" );
        if ( arquivo.length( ) < 2 ) {
            arquivo.writeInt( 0 );
        }
        }
    
    public int incluir ( Produto p ) throws IOException {
        // Aumentar ultimo id no cabecote e mudar id do produto
        short ultimoID;
        arquivo.seek(0);
        ultimoID = arquivo.readShort( );
        System.out.println ("ultimo: " + ultimoID);
        arquivo.seek(0);
        arquivo.writeShort( ultimoID + 1 );
        p.id = (short) (ultimoID + 1);
        // Guardar endereco para usar nas operacoes do indice
        p.endereco = arquivo.length();
        arquivo.seek ( p.endereco );
        // Adicionar dados no arquivo
        byte[] b = p.toByteArray();
        arquivo.writeByte(' ');
        arquivo.writeShort(b.length);
        System.out.println(b.length);
        arquivo.write(b);
        return p.id;
    }

        public Produto buscar ( short id, long endereco ) throws IOException {
        Produto p = new Produto();
        short tamanho;
        byte lapide;
        byte[] b;
        arquivo.seek(endereco);
        lapide = arquivo.readByte();
        tamanho = arquivo.readShort();
        b = new byte[tamanho];
        arquivo.read(b);
        p.fromByteArray(b);
        if ( lapide == ' ' && p.id == id ) {
            p.mostrarID();
            return p;
        }
        System.out.println ("Produto nao encontrado");
        return null;
    }
        
        public void excluir ( long endereco ) throws IOException {
        arquivo.seek(endereco);
        arquivo.writeByte('*');
    }

        public void listar ( ) throws IOException {
            arquivo.seek(2);
            Produto p = new Produto();
            byte lapide;
            short tamanho;
            byte[] b;
            while ( arquivo.getFilePointer() < arquivo.length()) {
                lapide = arquivo.readByte();
                tamanho = arquivo.readShort();
                b = new byte[tamanho];
                arquivo.read(b);
                p.fromByteArray(b);
                if (lapide == ' ') {
                    System.out.println(p);
                }
            }
        }
}
