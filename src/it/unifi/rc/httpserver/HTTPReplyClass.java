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

	@Override
	public String getVersion() {
		return version;
	}

	@Override
	public String getStatusCode() {
		return statusCode;
	}

	@Override
	public String getStatusMessage() {
		return statusMessage;
	}

	@Override
	public String getData() {
		return data;
	}

	@Override
	public Map<String, String> getParameters() {
		return parameters;
	}

}
