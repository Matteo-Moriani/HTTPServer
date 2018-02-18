package Tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import org.junit.jupiter.api.Test;
import it.unifi.rc.httpserver.*;

class HandlerTest {

	@Test
	
	// handle() e' composto dai metodi replyTo_()
	
	void replyToGetTest() {
		HTTPRequestClass r = new HTTPRequestClass("GET", "/path", "HTTP/1.0", Map<String,String> parameters, "body");
		
		fail("Not yet implemented");
	}
	
	void replyToGetPost() {
		HTTPRequestClass r = new HTTPRequestClass("POST", "/path", "HTTP/1.0", Map<String,String> parameters, "body");
		
		fail("Not yet implemented");
	}
	
	void replyToGetHead() {
		HTTPRequestClass r = new HTTPRequestClass("HEAD", "/path", "HTTP/1.0", Map<String,String> parameters, "body");
		
		fail("Not yet implemented");
	}
	
	void replyToGetPut() {
		HTTPRequestClass r = new HTTPRequestClass("PUT", "/path", "HTTP/1.1", Map<String,String> parameters, "body");
		
		fail("Not yet implemented");
	}
	
	void replyToGetDelete() {
		HTTPRequestClass r = new HTTPRequestClass("DELETE", "/path", "HTTP/1.1", Map<String,String> parameters, "body");
		
		fail("Not yet implemented");
	}

}
