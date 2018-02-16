package it.unifi.rc.httpserver;

import java.util.HashMap;
import java.util.Map;

public class HTTPReplyClass implements HTTPReply{
	
	private String statusMessage = "";
	private String statusCode = "";
	private String version = "";
	private Map<String,String> parameters = new HashMap<>();
	private String data = "";
	
	public HTTPReplyClass(String version, String statusCode, String statusMessage, Map<String,String> parameters, String data) {
		this.statusMessage = statusMessage;
		this.statusCode = statusCode;
		this.version = version;
		this.parameters = parameters;
		this.data = data;
	}

	public String getVersion() {
		return version;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public String getData() {
		return data;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

}
