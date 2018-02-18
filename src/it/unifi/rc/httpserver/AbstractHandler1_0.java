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
		switch(request.getMethod()) {
			case("GET"):
				replyToGet(request);
			case("POST"):
				replyToPost(request);
			case("HEAD"):
				replyToHead(request);
		}
		return null;					// altrimenti return null si puo' fare?
	}

}
