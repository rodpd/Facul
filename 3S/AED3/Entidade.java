package aed3;
import java.io.*;

public interface Entidade  {
    
    public void setId(int codigo);
    public int getId();
    
    public byte[] toByteArray() throws IOException;
    public void fromByteArray(byte[] b) throws IOException;
    
}
