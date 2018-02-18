package it.unifi.rc.httpserver;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class HTTPServerClass implements HTTPServer {
	private int port;
	private int backlog;
	private InetAddress address;
	private List<HTTPHandler> handlers = new ArrayList<HTTPHandler>();
	
	public HTTPServerClass(int port, int backlog, InetAddress address, HTTPHandler... handlers) {
		this.port = port;
		this.backlog = backlog;
		this.address = address;
		for(int i = 0; i<handlers.length; i++) {
			this.handlers.add(handlers[i]);
		}
	}

	public void addHandler(HTTPHandler handler) {
		handlers.add(handler);
	}

	@Override
	public void start() throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}
	
	public List<HTTPHandler> getHandlers(){			// serve ai test
		return handlers;
	}

}
