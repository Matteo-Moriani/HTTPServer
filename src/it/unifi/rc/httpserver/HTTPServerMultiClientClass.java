package it.unifi.rc.httpserver;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class HTTPServerMultiClientClass extends HTTPServerClass {
	
	public HTTPServerMultiClientClass(int port, int backlog, InetAddress address, HTTPHandler... handlers) {
		super(port, backlog, address, handlers);
	}

	@Override
	public void start() throws IOException {
		setSSsocket(new ServerSocket(getPort(), getBacklog(), getAddress()));
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
