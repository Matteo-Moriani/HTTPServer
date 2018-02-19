package it.unifi.rc.httpserver;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServerMultiClientClass extends HTTPServerClass implements Runnable{
	private Socket s;
	private boolean run = true;
	private boolean bool = true;
	private Thread h;

	public HTTPServerMultiClientClass(int port, int backlog, InetAddress address, HTTPHandler... handlers) {
		super(port, backlog, address, handlers);
		try {
			setSSsocket(new ServerSocket(getPort(), getBacklog(), getAddress()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	public HTTPServerMultiClientClass(Socket s, int port, int backlog, InetAddress address, HTTPHandler... handlers) {
//		super(port, backlog, address, handlers);
//		this.s = s;
//	}	

	@Override
	public void start() throws IOException {
		h = new Thread(
				  new Runnable(){
					public void run(){
				      try {
				    	  while(run) {
				    		s = getSSocket().accept();
				    		setAcc(s);
				    		System.out.println("connected");
				    		bool = false;
				    		//new Thread(this.HTTPServerMultiClientClass(getAcc(), getPort(), getBacklog(), getAddress(), getHandlers())).start();
				    	  }
				      } catch (IOException e) {
				      }
				    }
					}
				  
				);
		h.start();
	}

	@Override
	public void stop() {
		while(bool) {
			
		}
		run = false;
		try {
			getSSocket().close();
			getAcc().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("stopped");
	}

	@Override
	public void run() {
		
	}
	
}
