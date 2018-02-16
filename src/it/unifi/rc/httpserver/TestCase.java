package it.unifi.rc.httpserver;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
//import java.util.Map;
import org.junit.jupiter.api.Test;

class TestCase {
	
	String reply = "HTTP/1.1 200 OK\r\nDate: Sun, 18 Oct 2009 08:56:53 GMT\r\nServer: Apache/2.2.14 (Win32)\r\n\r\nI am a body";
	InputStream i1 = new ByteArrayInputStream(reply.getBytes());
	HTTPInputStreamClass a = new HTTPInputStreamClass(i1);

	String request = "GET /wiki.com/Pagina_principale HTTP/1.1\r\nConnection: Keep-Alive\r\nHost: it.wikipedia.org\r\n\r\nBody";
	InputStream i = new ByteArrayInputStream(request.getBytes());
	HTTPInputStreamClass b = new HTTPInputStreamClass(i);

	@Test
	
	void inputStreamReply() throws HTTPProtocolException {
		HTTPReply r = a.readHttpReply();
		
		assertEquals("HTTP/1.1",r.getVersion());
		assertEquals("200",r.getStatusCode());
		assertEquals("OK",r.getStatusMessage());
		assertEquals("Sun, 18 Oct 2009 08:56:53 GMT",r.getParameters().get("Date"));
		assertEquals("Apache/2.2.14 (Win32)",r.getParameters().get("Server"));
		assertEquals("I am a body",r.getData());
	}
	
	void inputStreamRequest() throws HTTPProtocolException {
		HTTPRequest r = b.readHttpRequest();
		
		assertEquals("GET",r.getMethod());
		assertEquals("/wiki.com/Pagina_principale",r.getPath());
		assertEquals("HTTP/1.1",r.getVersion());
		assertEquals("Keep-Alive",r.getParameters().get("Connection"));
		assertEquals("it.wikipedia.org",r.getParameters().get("Host"));
		assertEquals("Body",r.getEntityBody());
	}

}
