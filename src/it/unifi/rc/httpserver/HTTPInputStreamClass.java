package it.unifi.rc.httpserver;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class HTTPInputStreamClass extends HTTPInputStream{
	private InputStream inputS;
	private Parser p;

	public HTTPInputStreamClass(InputStream is) {
		super(is);
	}

	protected void setInputStream(InputStream is) {
		this.inputS = is;
	}

	public HTTPRequest readHttpRequest() throws HTTPProtocolException {
		Scanner sc = new Scanner(inputS);
		sc.useDelimiter("%%%###");	// questo delimitatore e' inteso in modo da non essere realisticamente mai trovato
		String message = sc.next();
		p = new Parser(message);
		sc.close();
		return new HTTPRequestClass(p.extractMethOrVers(), p.extractURLOrStatN(), p.extractVersOrStatCode(), p.extractHeadersOrParam(), p.extractBodyOrData());
	}

	public HTTPReply readHttpReply() throws HTTPProtocolException {
		Scanner sc = new Scanner(inputS);
		sc.useDelimiter("%%%###");
		String message = sc.next();
		p = new Parser(message);
		sc.close();
		return new HTTPReplyClass(p.extractMethOrVers(), p.extractURLOrStatN(), p.extractVersOrStatCode(), p.extractHeadersOrParam(), p.extractBodyOrData());
	}

	public void close() throws IOException {
		inputS.close();
	}

}
