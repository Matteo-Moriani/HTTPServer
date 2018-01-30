package it.unifi.rc.httpserver;

import java.io.IOException;
import java.io.OutputStream;

public class HTTPOutputStreamClass extends HTTPOutputStream{
	OutputStream outputS;

	public HTTPOutputStreamClass(OutputStream os) {
		super(os);
	}

	@Override
	protected void setOutputStream(OutputStream os) {
		this.outputS = os;
	}

	@Override
	public void writeHttpReply(HTTPReply reply) {//SCRIVE HTTPREPLY NELL'OUTPUT STREAM
		String req = reply.getVersion()+ " " + reply.getStatusCode() + " " +reply.getStatusMessage() + "\r\n";
		
		for (String key: reply.getParameters().keySet()) {
			req = req + key + ": " + reply.getParameters().get(key) + "\r\n";
		}
		req = req + "\r\n";
		req = req + reply.getData();
		try {
			outputS.write(req.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void writeHttpRequest(HTTPRequest request) {//SCRIVE HTTPREQUEST NELL'OUTPUT STREAM
		String req = request.getMethod()+ " " + request.getPath() + " " +request.getVersion() + "\r\n";
		
		for (String key: request.getParameters().keySet()) {
			req = req + key + ": " + request.getParameters().get(key) + "\r\n";
		}
		req = req + "\r\n";
		req = req + request.getEntityBody();
		try {
			outputS.write(req.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
