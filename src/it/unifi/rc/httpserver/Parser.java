package it.unifi.rc.httpserver;

import java.util.HashMap;
import java.util.Map;

public class Parser {
	
	private String message = "";
	private int i = 0;
	
	public Parser(String message) {
		this.message = message;
	}
	
	public String extractMethOrVers(){
		String method = "";
		while(message.charAt(i) != ' '){
			method = method + message.charAt(i);
			i++;
		}
		System.out.println(method);
		return method;
	}
	
	public String extractURLOrStatN(){
		String URL = "";
		i++;
		while(message.charAt(i) != ' '){
			URL = URL + message.charAt(i);
			i++;
		}
		System.out.println(URL);
		return URL;
	}
	
	public String extractVersOrStatCode(){
		String version = "";
		i++;
		while(message.charAt(i) != '\r' && message.charAt(i+1) != '\n'){
			version = version + message.charAt(i);
			i++;
		}
		System.out.println(version);
		return version;
	}
	
	public Map<String, String> extractHeadersOrParam(){
		Map<String,String> parameters = new HashMap<>();
		String head = "";
		String value = "";
		i = i+2;
		while(message.charAt(i) != '\r' && message.charAt(i+1) != '\n') {
			head = "";
			value = "";
			while(message.charAt(i) != ':'){
				head = head + message.charAt(i);
				i++;
			}
			i = i+2;
			while(message.charAt(i) != '\r' && message.charAt(i+1) != '\n'){
				value = value + message.charAt(i);
				i++;
			}
			i = i+2;
			parameters.put(head, value);
		}
		return parameters;
	}
	
	public String extractBodyOrData(){
		String body = "";
		i = i+2;
		while(i < message.length()){
			body = body + message.charAt(i);
			i++;
		}
		System.out.println(body);
		return body;
	}
}
