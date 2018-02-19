package it.unifi.rc.httpserver;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public abstract class HTTPServerClass implements HTTPServer{
	private int port;
	private int backlog;
	private InetAddress address;
	private List<HTTPHandler> handlers = new ArrayList<HTTPHandler>();
	private ServerSocket ssocket;
	private Socket acc;
	
	public HTTPServerClass(int port, int backlog, InetAddress address, HTTPHandler... handlers) {
		this.port = port;
		this.backlog = backlog;
		this.address = address;
		for(int i = 0; i<handlers.length; i++) {
			this.handlers.add(handlers[i]);
		}
	}

	@Override
	public void addHandler(HTTPHandler handler) {
		handlers.add(handler);
	}
	
	public List<HTTPHandler> getHandlers(){			// serve ai test
		return handlers;
	}
	
	public InputStream getInputStream() {
		InputStream stream = null;
		try {
			stream = acc.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stream;
	}
	
	public int getPort() {
		return port;
	}
	
	public int getBacklog(){
		return backlog;
	}
	
	public InetAddress getAddress(){
		return address;
	}
	
	public ServerSocket getSSocket() {
		return ssocket;
	}
	
	public void setAcc(Socket a) {
		acc = a;
	}
	
	public Socket getAcc() {
		return acc;
	}
	
	public void setSSsocket(ServerSocket s) {
		ssocket = s;
	}

	@Override
	public abstract void start() throws IOException;

	@Override
	public abstract void stop();

}
