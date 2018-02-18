package it.unifi.rc.httpserver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractHandler implements HTTPHandler{
	private File pathFile;
	private List<String> methods = new ArrayList<String>();
	
	public AbstractHandler(File pathFile){
		this.pathFile = pathFile;
		methods.add("GET");
		methods.add("POST");
		methods.add("HEAD");
	}
	
	public abstract boolean hostControl(HTTPRequest request);
	public abstract String getCurrentVersion();
	public abstract HTTPReply chooseMethod(HTTPRequest request);

	@Override
	public HTTPReply handle(HTTPRequest request) {
		HTTPReply reply = null;
		
		if(hostControl(request) == false){
			return null;
		}
		
		if(!request.getVersion().equals(getCurrentVersion())){
			return null;
		}
		
		if(!methods.contains(request.getMethod())) {
			return new HTTPReplyClass(request.getVersion(), "400", "Bad Request", new HashMap<String,String>(), "");
		}
		
		reply = chooseMethod(request);			// e' lo switch case, puo' ritornare null
		
//		switch(request.getMethod()) {
//			case("GET"):
//				reply = replyToGet(request);
//			case("POST"):
//				reply = replyToPost(request);
//			case("HEAD"):
//				reply = replyToHead(request);
//			
//		}
		return reply;
	}
	
	public HTTPReply replyToGet(HTTPRequest request) {
		File f = new File(pathFile.getAbsolutePath() + request.getPath());
		List<String> content = new ArrayList<String>();
		
		try {
			content = Files.readAllLines(Paths.get(f.getAbsolutePath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String text = contentToString(content); 
		
		if(f.exists()){
			return new HTTPReplyClass(request.getVersion(), "200", "OK", getParameters(f), text);
		}else{
			return new HTTPReplyClass(request.getVersion(), "404", "Not Found", new HashMap<String,String>(), "");
		}
	}
	
	public HTTPReply replyToHead(HTTPRequest request) {
		File f = new File(pathFile.getAbsolutePath() + request.getPath()); 
		
		if(f.exists()){
			return new HTTPReplyClass(request.getVersion(), "200", "OK", getParameters(f), "");
		}else{
			return new HTTPReplyClass(request.getVersion(), "404", "Not Found", new HashMap<String,String>(), "");
		}
	}
	
	public HTTPReply replyToPost(HTTPRequest request) {
		File f = new File(pathFile.getAbsolutePath() + request.getPath());
		
		if(request.getEntityBody().isEmpty()) {
			return new HTTPReplyClass(request.getVersion(), "204", "No Content", null, ""); //non sicuro dello status code e message
		}
		
		try {
			if(f.exists()){
				FileOutputStream fstream = new FileOutputStream(f, true);
				byte[] content = request.getEntityBody().getBytes();
				fstream.write(content);
				fstream.close();
			}else {
				f.getParentFile().mkdirs();
                f.createNewFile();
                FileOutputStream fstream = new FileOutputStream(f, true);
				byte[] content = request.getEntityBody().getBytes();
				fstream.write(content);
				fstream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new HTTPReplyClass(request.getVersion(), "400", "Bad Request", null, "");
		}
		
		return new HTTPReplyClass(request.getVersion(), "200", "OK", null, "");
	}

	public String contentToString(List<String> content) {
		String s = "";
		for(int i = 0; i < content.size(); i++) {
			s = s + content.get(i);
		}
		return s;
	}
	
	public Map<String,String> getParameters(File f){
		Map<String,String> parameters = new HashMap<>();
		parameters.put("Content-Length", String.valueOf(f.length()));
		parameters.put("Date", new Date().toString());
		return parameters;
	}
	
	public List<String> getMethods() {
		return methods;
	}
	
	public String getPathFile(){
		return pathFile.getAbsolutePath();
	}

}
