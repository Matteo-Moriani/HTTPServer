package it.unifi.rc.httpserver;

import java.io.File;
import java.io.FileOutputStream;

public abstract class AbstractHandler1_1 extends AbstractHandler{

	public AbstractHandler1_1(File pathFile) {
		super(pathFile);
		getMethods().add("PUT");
		getMethods().add("DELETE");
	}

	@Override
	public String getCurrentVersion() {
		return "HTTP/1.1";
	}
	
	public HTTPReply replyToPut(HTTPRequest request) {
		File f = new File(getPathFile() + request.getPath());
		
		if(request.getEntityBody().isEmpty()) {
			return new HTTPReplyClass(request.getVersion(), "204", "No Content", null, ""); //non sic
		}
		
		try {
			if(f.exists()){
				FileOutputStream fstream = new FileOutputStream(f, false); //se il secondo argomento e' a true appende in fondo, altrimenti sovrascrive.
				byte[] content = request.getEntityBody().getBytes();
				fstream.write(content);
				fstream.close();
			}else {
				f.getParentFile().mkdirs();
                f.createNewFile();
                FileOutputStream fstream = new FileOutputStream(f, false);
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
	
	public HTTPReply replyToDelete(HTTPRequest request) {
		File f = new File(getPathFile() + request.getPath());
		if(f.exists()){
			f.delete();
			return new HTTPReplyClass(request.getVersion(), "200", "OK", null, "");
		}else if(f.length() == 0){
			return new HTTPReplyClass(request.getVersion(), "204", "No Content", null, "");
		}else{
			return new HTTPReplyClass(request.getVersion(), "404", "Not Found", null, "");
		}
		
	}
	
	public HTTPReply chooseMethod(HTTPRequest request) {
		switch(request.getMethod()) {
			case("GET"):
				replyToGet(request);
			case("POST"):
				replyToPost(request);
			case("HEAD"):
				replyToHead(request);
			case("PUT"):
				replyToPut(request);
			case("DELETE"):
				replyToDelete(request);
		}
		return null;					// altrimenti return null si puo' fare?
	}

}
