package it.unifi.rc.httpserver;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class HTTPServerMultiClientClass extends HTTPServerClass{


	public HTTPServerMultiClientClass(int port, int backlog, InetAddress address, HTTPHandler... handlers) {
		super(port, backlog, address, handlers);
		try {
			setSSsocket(new ServerSocket(getPort(), getBacklog(), getAddress()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start() throws HTTPProtocolException {
		Socket s = null;
		while(true){
			s = null;
			try {
				setAcc(getSSocket().accept());
				s = getAcc();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			if(s != null) {
				new Thread(
						new Runnable(){
							public void run(){
							
							}
						}
						).start();
			}
		}
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
