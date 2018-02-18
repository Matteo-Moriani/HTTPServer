package it.unifi.rc.httpserver;

import java.io.File;

public abstract class AbstractHandler1_0 extends AbstractHandler{
	
	public AbstractHandler1_0(File pathFile){
		super(pathFile);
	}
	
	public String getCurrentVersion() {
		return "HTTP/1.0";
	}
	
	public HTTPReply chooseMethod(HTTPRequest request) {
		HTTPReply reply = null;
		switch(request.getMethod()) {
			case("GET"):
				reply = replyToGet(request);
			case("POST"):
				reply = replyToPost(request);
			case("HEAD"):
				reply = replyToHead(request);
		}
		return reply;
	}

}
