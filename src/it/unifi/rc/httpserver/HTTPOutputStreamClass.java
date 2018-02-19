package it.unifi.rc.httpserver;

import java.io.IOException;
import java.io.OutputStream;

public class HTTPOutputStreamClass extends HTTPOutputStream{
	private OutputStream outputS;

	public HTTPOutputStreamClass(OutputStream os) {
		super(os);
	}

	protected void setOutputStream(OutputStream os) {
		this.outputS = os;
	}

	public void writeHttpReply(HTTPReply reply) {
		String rep = reply.getVersion()+ " " + reply.getStatusCode() + " " +reply.getStatusMessage() + "\r\n";
		String rep1 = "";
		for (String key: reply.getParameters().keySet()) {
			rep1 = key + ": " + reply.getParameters().get(key) + "\r\n" + rep1;
		}
		rep = rep + rep1;
		rep = rep + "\r\n";
		rep = rep + reply.getData();
		try {
			outputS.write(rep.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeHttpRequest(HTTPRequest request) {
		String req = request.getMethod()+ " " + request.getPath() + " " +request.getVersion() + "\r\n";
		String req1 = "";
		for (String key: request.getParameters().keySet()) {
			req1 = key + ": " + request.getParameters().get(key) + "\r\n" + req1;
		}
		req = req + req1;
		req = req + "\r\n";
		req = req + request.getEntityBody();
		try {
			outputS.write(req.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() throws IOException {
		outputS.close();	
	}
	
	public OutputStream getOutputStream(){
		return outputS;
	}

}
