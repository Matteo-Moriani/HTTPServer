package it.unifi.rc.httpserver;

import java.util.HashMap;
import java.util.Map;

public class HTTPRequestClass implements HTTPRequest {
	
	private String method = "";
	private String path = "";
	private String version = "";
	private Map<String,String> parameters = new HashMap<>();
	private String entityBody = "";
	
	public HTTPRequestClass(String message) {
		int i = 0;
		
		while(message.charAt(i) != ' '){//method
				this.method = this.method + message.charAt(i);
				i=i+1;
		}
		i=i+1;
		
		while(message.charAt(i) != ' '){//path
				this.path = this.path + message.charAt(i);
				i=i+1;
		}
		i=i+1;
		
		while(message.charAt(i) != '\r'){//version
				this.version = this.version + message.charAt(i);
				i=i+1;
		}
		i=i+2;
		
		while(message.charAt(i) != '\r') {//parameters
			String param = "";
			String value = "";
			while(message.charAt(i) != ':'){
				param = param + message.charAt(i);
				i=i+1;
			}
			i=i+2;
			while(message.charAt(i) != '\r'){
				value = value + message.charAt(i);
				i=i+1;
			}
			i=i+2;
			parameters.put(param,  value);
		}
		i=i+2;
		
		while(i < message.length()) {
			entityBody = entityBody  + message.charAt(i);
			i=i+1;
		}
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
