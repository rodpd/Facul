package aed3;
import java.io.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class ArquivoIndexado<T extends Entidade> {
    
    private RandomAccessFile arquivo;
    private String nomeArquivo;
    private String nomeIndice;
    private Constructor<T> construtor;
    private ArvoreBMais_Int_Long indice;
    
    public ArquivoIndexado(Constructor<T> c, String nomeArq, String nomeIdx) throws IOException {
        this.nomeArquivo = nomeArq;
        this.nomeIndice = nomeIdx;
        this.construtor = c;
        arquivo = new RandomAccessFile(this.nomeArquivo, "rw");
        indice = new ArvoreBMais_Int_Long(20, this.nomeIndice);
        if(arquivo.length()<4) {
            arquivo.writeInt(0);
            indice.apagar();
        }
    }
    
    public int incluir(T obj) throws IOException {
        
        int ultimoID;
        arquivo.seek(0);
        ultimoID = arquivo.readInt();
        arquivo.seek(0);
        arquivo.writeInt(ultimoID+1);
        obj.setId(ultimoID+1);
        
        arquivo.seek(arquivo.length());
        long endereco = arquivo.getFilePointer();
        byte[] b;
        b = obj.toByteArray();
        arquivo.writeByte(' ');
        arquivo.writeShort(b.length);
        arquivo.write(b);
        indice.inserir(obj.getId(), endereco);
        return obj.getId();
    }
    
    public T buscar(int id) throws Exception {
        T obj = construtor.newInstance();
        short tamanho;
        byte[] b;
        byte lapide;

        long endereco = indice.buscar(id);
        if(endereco != -1) {
            arquivo.seek(endereco);
            lapide = arquivo.readByte();
            tamanho = arquivo.readShort();
            b = new byte[tamanho];
            arquivo.read(b);
            obj.fromByteArray(b);
            return obj;
        } 
        return null;
    }
    
    public boolean excluir(int id) throws Exception {
        T obj = construtor.newInstance();
        short tamanho;
        byte[] b;
        byte lapide;
        long endereco;

        endereco = indice.buscar(id);
        if(endereco != -1) {
            arquivo.seek(endereco);
            arquivo.writeByte('*');
            indice.excluir(id);
            return true;
        }
        return false;
    }
    
    public boolean alterar(T novoObj) throws Exception {
        T obj = construtor.newInstance();
        short tamanho;
        byte[] b;
        byte lapide;
        long endereco;

        endereco = indice.buscar(novoObj.getId());
        if(endereco != -1) {
            // apaga o registro anterior
            arquivo.seek(endereco);
            arquivo.writeByte('*');
            
            // cria o novo registro
            arquivo.seek(arquivo.length());
            endereco = arquivo.getFilePointer();
            arquivo.writeByte(' ');
            b = novoObj.toByteArray();
            arquivo.writeInt(b.length);
            arquivo.write(b);
            indice.atualizar(novoObj.getId(), endereco);
            return true;
        }
        return false;
    }
    
    public Object[] listar() throws Exception {
        ArrayList<T> lista = new ArrayList<>();
        T obj;
        short tamanho;
        byte[] b;
        byte lapide;

        arquivo.seek(4);
        while(arquivo.getFilePointer() < arquivo.length()) {
            lapide = arquivo.readByte();
            tamanho = arquivo.readShort();
            b = new byte[tamanho];
            arquivo.read(b);
            obj = construtor.newInstance();
            obj.fromByteArray(b);
            if(lapide==' ')
                lista.add(obj);
        }
        return lista.toArray();
    }
    
}
