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

	@Override
	protected void setInputStream(InputStream is) {
		this.inputS = is;
	}

	@Override
	public HTTPRequest readHttpRequest() throws HTTPProtocolException {//legge una stringa dall'input stream e ne genera l'HTTPRequest
		Scanner sc = new Scanner(inputS);
		sc.useDelimiter("%%%###");
		String message = sc.next();
		p = new Parser(message);
		sc.close();
		return new HTTPRequestClass(p.extractMethOrVers(), p.extractURLOrStatN(), p.extractVersOrStatCode(), p.extractHeadersOrParam(), p.extractBodyOrData());
	}

	@Override
	public HTTPReply readHttpReply() throws HTTPProtocolException {//legge una stringa dall'input stream e ne genera l'HTTPRply
		Scanner sc = new Scanner(inputS);
		sc.useDelimiter("%%%###");
		String message = sc.next();
		p = new Parser(message);
		sc.close();
		return new HTTPReplyClass(p.extractMethOrVers(), p.extractURLOrStatN(), p.extractVersOrStatCode(), p.extractHeadersOrParam(), p.extractBodyOrData());
	}

	@Override
	public void close() throws IOException {
		inputS.close();
	}

}
