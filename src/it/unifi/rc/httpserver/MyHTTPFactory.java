package it.unifi.rc.httpserver;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;

public class MyHTTPFactory implements HTTPFactory {

	@Override
	public HTTPInputStream getHTTPInputStream(InputStream is) {
		HTTPInputStream myInputS = new HTTPInputStreamClass(is);
		return myInputS;
	}

	@Override
	public HTTPOutputStream getHTTPOutputStream(OutputStream os) {
		HTTPOutputStreamClass myOutputS = new HTTPOutputStreamClass(os);
		return myOutputS;
	}

	@Override
	public HTTPServer getHTTPServer(int port, int backlog, InetAddress address, HTTPHandler... handlers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HTTPHandler getFileSystemHandler1_0(File root) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HTTPHandler getFileSystemHandler1_0(String host, File root) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HTTPHandler getFileSystemHandler1_1(File root) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HTTPHandler getFileSystemHandler1_1(String host, File root) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HTTPHandler getProxyHandler() {
		// TODO Auto-generated method stub
		return null;
	}

}
