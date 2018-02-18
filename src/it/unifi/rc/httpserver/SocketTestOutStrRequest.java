package it.unifi.rc.httpserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class SocketTestOutStrRequest {
	String result = "";
	
	public String simulateSocket() throws IOException{
		
		ServerSocket ssocket = new ServerSocket(4356);	
		new Thread(
				  new Runnable(){
					public void run(){
				      try {
						Socket acc = ssocket.accept();
						Map<String,String> parameters = new HashMap<>();
						parameters.put("name1", "value1");
						parameters.put("name2", "value2");
						OutputStream os = acc.getOutputStream();
						HTTPOutputStreamClass httpsOS = new HTTPOutputStreamClass(os);	
						httpsOS.writeHttpRequest(new HTTPRequestClass("version", "statusCode", "statusMessage", parameters, "data"));
						acc.close();
				      } catch (IOException e) {
						e.printStackTrace();
				      }
				    }
				  }
				).start();
		Socket socket = new Socket("localhost", 4356);
//		byte [] mybytearray  = new byte [1000];
	    InputStream is = socket.getInputStream();
	    int a = is.read();
	    while(a != -1) {
	    	result = result + (char)a;
	    	a = is.read();
	    }
	    ssocket.close();
	    socket.close();
		return result;
	}

}
