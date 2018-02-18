package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import it.unifi.rc.httpserver.*;

class HandlerTest {
	
	// handle() e' composto dai metodi replyTo_()
	
	@Test
	void replyToGetOKTest() {
		File f = new File("");
		HandlerGenericHost1_0 h = new HandlerGenericHost1_0(f);
		HTTPRequestClass req = new HTTPRequestClass("GET", "/src/Tests/TestTxt", "HTTP/1.0", h.makeParameters(f), null);
		HTTPReplyClass rep = h.replyToGet(req);
		
		assertEquals("HTTP/1.0",rep.getVersion());
		assertEquals("200",rep.getStatusCode());
		assertEquals("OK",rep.getStatusMessage());
		assertEquals("7",rep.getParameters().get("Content-Length"));
		assertEquals("content",rep.getData());
	}
	
	@Test
	void replyToGetNOTFOUNDTest() {
		File f = new File("");
		HandlerGenericHost1_0 h = new HandlerGenericHost1_0(f);
		HTTPRequestClass req = new HTTPRequestClass("GET", "/wrongPath", "HTTP/1.0", h.makeParameters(f), null);
		HTTPReplyClass rep = h.replyToGet(req);
		
		assertEquals("HTTP/1.0",rep.getVersion());
		assertEquals("404",rep.getStatusCode());
		assertEquals("Not Found",rep.getStatusMessage());
		assertEquals(null,rep.getParameters());
		assertEquals(null,rep.getData());
	}
	
//	@Test
//	void replyToGetPost() {
//		HTTPRequestClass req = new HTTPRequestClass("POST", "/src/Tests/TestTxt", "HTTP/1.0", Map<String,String> parameters, "body");
//		
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	void replyToGetHead() {
//		HTTPRequestClass req = new HTTPRequestClass("HEAD", "/src/Tests/TestTxt", "HTTP/1.0", Map<String,String> parameters, "body");
//		
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	void replyToGetPut() {
//		HTTPRequestClass req = new HTTPRequestClass("PUT", "/src/Tests/TestTxt", "HTTP/1.1", Map<String,String> parameters, "body");
//		
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	void replyToGetDelete() {
//		HTTPRequestClass req = new HTTPRequestClass("DELETE", "/src/Tests/TestTxt", "HTTP/1.1", Map<String,String> parameters, "body");
//		
//		fail("Not yet implemented");
//	}

}
