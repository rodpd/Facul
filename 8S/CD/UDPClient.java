import java.net.*;
import java.sql.Date;
import java.io.*;
public class UDPClient{
    public static void main(String args[]){ 
		// args give message contents and destination hostname
		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket();
			int tempo = Integer.parseInt(args[0]);
			InetAddress aHost = InetAddress.getByName(args[1]);
			int serverPort = 6789;
			long inicio = System.currentTimeMillis();
			while ( System.currentTimeMillis() - inicio < tempo ) {
				byte [] m = System.console().readLine().getBytes();	                                                 
				DatagramPacket request =
				new DatagramPacket(m,  m.length, aHost, serverPort);
				if ( System.currentTimeMillis() - inicio < tempo ) {
					aSocket.send(request);
					byte[] buffer = new byte[1000];
					DatagramPacket reply = new DatagramPacket(buffer, buffer.length);	
					aSocket.receive(reply);
					System.out.println("Reply: " + new String(reply.getData()));
				}
				else {
					System.out.println("Conexao encerrada");
				}
			}	
		}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		}catch (IOException e){System.out.println("IO: " + e.getMessage());
		}finally {if(aSocket != null) aSocket.close();}
	}		      	
}
