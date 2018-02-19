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

public class Main {	// ora ci sono i test

	public static void main(String[] args) throws IOException {
		HTTPServerMultiClientClass server = new HTTPServerMultiClientClass(4000, 500000, InetAddress.getByName("localhost"), new HandlerGenericHost1_0(new File("AAA")));
		server.start();
		Socket client = new Socket("localhost", 4000);
		client.getOutputStream().write("no".getBytes());
		InputStream stream = server.getAcc().getInputStream();
		
		System.out.println((char)stream.read());
		
		//server.start();
		Socket client1 = new Socket("localhost", 4000);
		client1.getOutputStream().write("sii".getBytes());
		InputStream stream2 = server.getAcc().getInputStream();
		//System.out.println("1");
		//System.out.println("2");
		//System.out.println("3");
		System.out.println((char)stream.read());
		System.out.println((char)stream2.read());
		System.out.println((char)stream2.read());
		//System.out.println("4");
		//server.stop();
		//System.out.println("5");
		server.stop();
	}

}