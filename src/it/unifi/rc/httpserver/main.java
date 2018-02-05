package it.unifi.rc.httpserver;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class main {

	public static void main(String[] args) throws HTTPProtocolException {
		String string="ciao";
		byte [] aaa = string.getBytes();
		InputStream ab = new ByteArrayInputStream(aaa);
		HTTPInputStreamClass a = new HTTPInputStreamClass(ab);
		a.readHttpRequest();
	}

}