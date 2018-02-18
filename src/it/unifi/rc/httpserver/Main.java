package it.unifi.rc.httpserver;

import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.nio.charset.Charset;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {	// ora ci sono i test

	public static void main(String[] args) throws IOException {
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
		System.out.println(httpsOS.readHttpReply());
	    ssocket.close();
	    socket.close();
	}

}