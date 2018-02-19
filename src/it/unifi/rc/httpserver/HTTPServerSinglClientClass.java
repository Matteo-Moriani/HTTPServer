package it.unifi.rc.httpserver;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class HTTPServerSinglClientClass extends HTTPServerClass {
	
	public HTTPServerSinglClientClass(int port, int backlog, InetAddress address, HTTPHandler... handlers) {
		super(port, backlog, address, handlers);
		try {
			setSSsocket(new ServerSocket(getPort(), getBacklog(), getAddress()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start() throws HTTPProtocolException {
		new Thread(
				  new Runnable(){
					public void run(){
				      try {
				    		setAcc(getSSocket().accept());
				      } catch (IOException e) {
						e.printStackTrace();
				      }
				    }
				  }
				).start();
	}

	@Override
	public void stop() {
		try {
			getAcc().close();
			getSSocket().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
