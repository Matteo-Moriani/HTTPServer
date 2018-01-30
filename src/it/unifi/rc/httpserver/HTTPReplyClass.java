package it.unifi.rc.httpserver;

import java.util.HashMap;
import java.util.Map;

public class HTTPReplyClass implements HTTPReply{
	
	private String statusMessage = "";
	private String statusCode = "";
	private String version = "";
	private Map<String,String> parameters = new HashMap<>();
	private String data = "";
	
	public HTTPReplyClass(String message) {
		int i = 0;

		while(message.charAt(i) != ' '){//VERSION
			this.version = this.version + message.charAt(i);
			i=i+1;
		}
		i=i+1;
		
		while(message.charAt(i) != ' '){//STATUS CODE
				this.statusCode = this.statusCode + message.charAt(i);
				i=i+1;
		}
		i=i+1;
		
		while(message.charAt(i) != '\r'){//STATU MESSAGE
				this.statusMessage = this.statusMessage + message.charAt(i);
				i=i+1;
		}
		i=i+2;
		
		while(message.charAt(i) != '\r') {//HEADER
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
		
		while(i < message.length()) {//DATA
			data = data  + message.charAt(i);
			i=i+1;
		}
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
