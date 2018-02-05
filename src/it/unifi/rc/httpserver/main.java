package it.unifi.rc.httpserver;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class main {

	public static void main(String[] args) throws HTTPProtocolException {
		String a = "HTTP/1.0 200 OK\r\nHost: Ciao\r\n\r\naaaaaaaaaaaaa.";
		OutputStream asd = new ByteArrayOutputStream();
		HTTPOutputStreamClass ddd = new HTTPOutputStreamClass(asd);
		//HTTPReply aaa = new HTTPReplyClass(a);
		//ddd.writeHttpReply(aaa);
	}

}