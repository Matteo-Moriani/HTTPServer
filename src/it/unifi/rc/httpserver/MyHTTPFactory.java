package it.unifi.rc.httpserver;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;

public class MyHTTPFactory implements HTTPFactory {

	public HTTPInputStream getHTTPInputStream(InputStream is) { // vedi se ha senso fare un factory di classi che hanno costruttori definiti
		return new HTTPInputStreamClass(is);
	}

	public HTTPOutputStream getHTTPOutputStream(OutputStream os) {
		return new HTTPOutputStreamClass(os);
	}

	public HTTPHandler getFileSystemHandler1_0(File root) {
		return new HandlerGenericHost1_0(root);
	}

	public HTTPHandler getFileSystemHandler1_0(String host, File root) {
		return new HandlerSpecificHost1_0(root,host);
	}

	public HTTPHandler getFileSystemHandler1_1(File root) {
		return new HandlerGenericHost1_1(root);
	}

	public HTTPHandler getFileSystemHandler1_1(String host, File root) {
		return new HandlerSpecificHost1_1(root, host);
	}

	@Override
	public HTTPHandler getProxyHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HTTPServer getHTTPServer(int port, int backlog, InetAddress address, HTTPHandler... handlers) {
		// TODO Auto-generated method stub
		return null;
	}

}
