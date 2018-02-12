package it.unifi.rc.httpserver;

import java.util.HashMap;
import java.util.Map;

public class HTTPRequestClass implements HTTPRequest {
	
	private String method = "";//nooooooooooo
	private String path = "";
	private String version = "";
	private Map<String,String> parameters = new HashMap<>();
	private String entityBody = "";
	
	public HTTPRequestClass(String method, String path, String version, Map<String,String> parameters, String entityBody) {
		this.method = method;
		this.path = path;
		this.version = version;
		this.parameters = parameters;
		this.entityBody = entityBody;
	}

	@Override
	public String getVersion() {
		return version;
	}

	@Override
	public String getMethod() {
		return method;
	}

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public String getEntityBody() {
		return entityBody;
	}

	@Override
	public Map<String, String> getParameters() {
		return parameters;
	}

}