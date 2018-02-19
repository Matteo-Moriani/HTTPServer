package it.unifi.rc.httpserver;

public class ProxyHandler implements HTTPHandler {
	private HTTPRequest[] requests;
	private HTTPReply[] replies;
	private HTTPHandler alternative;
	private int lastIndex = 0;
	
	public ProxyHandler(int maxLength, HTTPHandler alternative) {
		this.requests = new HTTPRequest[maxLength];
		this.replies = new HTTPReply[maxLength];
		this.alternative = alternative;
	}


	public HTTPReply handle(HTTPRequest request) {
		HTTPReply reply = null;
		for (int i=0; i<requests.length ; i++) {
			if(requests[i].equals(request)){
				reply = replies[i];
			}
		}
		reply = alternative.handle(request);
		return reply;
	}
	
	public void add(HTTPRequest request, HTTPReply reply) {
		if()
	}
	
	
}
