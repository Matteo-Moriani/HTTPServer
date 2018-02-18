package it.unifi.rc.httpserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class SocketTestInputStrReply {
String result = "";
	
	public HTTPReply simulateSocket() throws IOException{
		
		ServerSocket ssocket = new ServerSocket(4371);	
		new Thread(
				  new Runnable(){
					public void run(){
				      try {
						Socket acc = ssocket.accept();
						OutputStream os = acc.getOutputStream();	
						os.write("version statuscode statusmessage\r\nprova1: value1\r\nprova2: value2\r\n\r\nbody".getBytes());
						acc.close();
				      } catch (IOException e) {
						e.printStackTrace();
				      }
				    }
				  }
				).start();
		Socket socket = new Socket("localhost", 4371);
		HTTPInputStreamClass httpsOS = new HTTPInputStreamClass(socket.getInputStream());
		HTTPReply ret = httpsOS.readHttpReply();
	    ssocket.close();
	    socket.close();
		return ret;
	}
}
