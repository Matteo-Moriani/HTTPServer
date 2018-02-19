package it.unifi.rc.httpserver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Main {	// ora ci sono i test

	public static void main(String[] args) throws IOException {
		HTTPServerMultiClientClass server = new HTTPServerMultiClientClass(4000, 500000, InetAddress.getByName("localhost"), new HandlerGenericHost1_0(new File("AAA")));
		server.start();
		Socket client = new Socket("localhost", 4000);
		Socket client1 = new Socket("localhost", 4000);
		Socket client2 = new Socket("localhost", 4000);
		//System.out.println("AAAA");
		
		//Socket client2 = new Socket("localhost", 4000);
		//System.out.println("AAAA");
		//client.getOutputStream().write("a".getBytes());
		//client2.getOutputStream().write("a".getBytes());
	
		//System.out.println(server.getInputStream().read());
		//client2.getOutputStream().write("s".getBytes());
	
//		System.out.println((char)stream.read());
//		
//		server.stop();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		server.stop();
		
	}

}