package it.unifi.rc.httpserver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class HTTPInputStreamClass extends HTTPInputStream{
	private InputStream inputS;

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
		System.out.print(sc.next());
		return new HTTPRequestClass(null, null, null, null, null);
	}

	@Override
	public HTTPReply readHttpReply() throws HTTPProtocolException {//legge una stringa dall'input stream e ne genera l'HTTPRply
		String message = "";
		HTTPReply cast = null;
		try {
			int i = 0;
			while((i = inputS.read()) != -1) {
				message = message + (char)i;
			}
			System.out.println(message);
			//cast = new HTTPReplyClass (message);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cast;
	}

	@Override
	public void close() throws IOException {
		inputS.close();
	}

}
