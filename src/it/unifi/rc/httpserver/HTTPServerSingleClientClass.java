package it.unifi.rc.httpserver;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class HTTPServerSingleClientClass extends HTTPServerClass{

	public HTTPServerSingleClientClass(int port, int backlog, InetAddress address, HTTPHandler... handlers) {
		super(port, backlog, address, handlers);
	}

	@Override
	public void start() throws IOException {
		setSSsocket(new ServerSocket(getPort(), getBacklog(), getAddress()));
		System.out.println("ooop");
		setAcc(getSSocket().accept());
		System.out.println("ooop");
	}

	@Override
	public void stop() {
		try {
			getSSocket().close();
			getAcc().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
