package it.unifi.rc.httpserver;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class main {

	public static void main(String[] args) throws HTTPProtocolException {
		String p = "HTTP/1.1 200 OK\r\nDate: Sun, 18 Oct 2009 08:56:53 GMT\r\nServer: Apache/2.2.14 (Win32)\r\n\r\naaac";
		InputStream s = new ByteArrayInputStream(p.getBytes());
		HTTPInputStreamClass a = new HTTPInputStreamClass(s);
		a.readHttpRequest();
	}

}