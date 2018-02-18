package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Map;
import org.junit.jupiter.api.Test;
import it.unifi.rc.httpserver.*;

class HandlerTest {
	
	// handle() e' composto dai metodi replyTo_()
	
	File file = new File();
	
	@Test
	void replyToGetTest() {
		HandlerGenericHost1_0 h = new HandlerGenericHost1_0(/);
		HTTPRequestClass req = new HTTPRequestClass("GET", "/src/Tests/TestTxt", "HTTP/1.0", Map<String,String> parameters, "body");
		HTTPReplyClass rep = getTest(req);
		
		fail("Not yet implemented");
	}
	
	@Test
	void replyToGetPost() {
		HTTPRequestClass req = new HTTPRequestClass("POST", "/src/Tests/TestTxt", "HTTP/1.0", Map<String,String> parameters, "body");
		
		fail("Not yet implemented");
	}
	
	@Test
	void replyToGetHead() {
		HTTPRequestClass req = new HTTPRequestClass("HEAD", "/src/Tests/TestTxt", "HTTP/1.0", Map<String,String> parameters, "body");
		
		fail("Not yet implemented");
	}
	
	@Test
	void replyToGetPut() {
		HTTPRequestClass req = new HTTPRequestClass("PUT", "/src/Tests/TestTxt", "HTTP/1.1", Map<String,String> parameters, "body");
		
		fail("Not yet implemented");
	}
	
	@Test
	void replyToGetDelete() {
		HTTPRequestClass req = new HTTPRequestClass("DELETE", "/src/Tests/TestTxt", "HTTP/1.1", Map<String,String> parameters, "body");
		
		fail("Not yet implemented");
	}

}
