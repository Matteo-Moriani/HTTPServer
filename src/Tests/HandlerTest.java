package Tests;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import it.unifi.rc.httpserver.*;

class HandlerTest {
	
	// handle() e' composto dai metodi replyTo_()
	
	@Test
	void replyToGetOKTest() {
		File f = new File("");
		HandlerGenericHost1_0 h = new HandlerGenericHost1_0(f);
		HTTPRequestClass req = new HTTPRequestClass("GET", "/src/Tests/GetHeadTxt", "HTTP/1.0", null, null);
		HTTPReplyClass rep = h.replyToGet(req);
		
		assertEquals("HTTP/1.0",rep.getVersion());
		assertEquals("200",rep.getStatusCode());
		assertEquals("OK",rep.getStatusMessage());
		assertEquals("11",rep.getParameters().get("Content-Length"));
		assertEquals("length = 11",rep.getData());
	}
	
	@Test
	void replyToGetNOTFOUNDTest() {
		File f = new File("");
		HandlerGenericHost1_0 h = new HandlerGenericHost1_0(f);
		HTTPRequestClass req = new HTTPRequestClass("GET", "/wrongPath", "HTTP/1.0", null, null);
		HTTPReplyClass rep = h.replyToGet(req);
		
		assertEquals("HTTP/1.0",rep.getVersion());
		assertEquals("404",rep.getStatusCode());
		assertEquals("Not Found",rep.getStatusMessage());
		assertEquals(null,rep.getParameters());
		assertEquals(null,rep.getData());
	}
	
	@Test
	void replyToHeadOKTest() {
		File f = new File("");
		HandlerGenericHost1_0 h = new HandlerGenericHost1_0(f);
		HTTPRequestClass req = new HTTPRequestClass("HEAD", "/src/Tests/GetHeadTxt", "HTTP/1.0", null, null);
		HTTPReplyClass rep = h.replyToHead(req);
		
		assertEquals("HTTP/1.0",rep.getVersion());
		assertEquals("200",rep.getStatusCode());
		assertEquals("OK",rep.getStatusMessage());
		assertEquals("11",rep.getParameters().get("Content-Length"));
		assertEquals(null,rep.getData());
	}
	
	@Test
	void replyToHeadNOTFOUNDTest() {
		File f = new File("");
		HandlerGenericHost1_0 h = new HandlerGenericHost1_0(f);
		HTTPRequestClass req = new HTTPRequestClass("HEAD", "/wrongPath", "HTTP/1.0", null, null);
		HTTPReplyClass rep = h.replyToHead(req);
		
		assertEquals("HTTP/1.0",rep.getVersion());
		assertEquals("404",rep.getStatusCode());
		assertEquals("Not Found",rep.getStatusMessage());
		assertEquals(null,rep.getParameters());
		assertEquals(null,rep.getData());
	}
	
	@Test
	void replyToPostOKTest() {
		File f = new File("");
		HandlerGenericHost1_0 h = new HandlerGenericHost1_0(f);
		HTTPRequestClass req = new HTTPRequestClass("POST", "/src/Tests/PostTxt", "HTTP/1.0", null, "|");
		HTTPReplyClass rep = h.replyToPost(req);
		
		// verificare che l'ultimo carettere e' "|"
		
		assertEquals("HTTP/1.0",rep.getVersion());
		assertEquals("200",rep.getStatusCode());
		assertEquals("OK",rep.getStatusMessage());
		assertEquals(null,rep.getParameters());
		assertEquals(null,rep.getData());
	}
	
	@Test
	void replyToPostNOCONTENTTest() {
		File f = new File("");
		HandlerGenericHost1_0 h = new HandlerGenericHost1_0(f);
		HTTPRequestClass req = new HTTPRequestClass("POST", "/src/Tests/PostTxt", "HTTP/1.0", null, "");
		HTTPReplyClass rep = h.replyToPost(req);
		
		assertEquals("HTTP/1.0",rep.getVersion());
		assertEquals("204",rep.getStatusCode());
		assertEquals("No Content",rep.getStatusMessage());
		assertEquals(null,rep.getParameters());
		assertEquals(null,rep.getData());
	}
	
//	@Test boh vedi un po' come farlo
//	void replyToPostBADREQUESTTest(){}
	
	@Test
	void replyToPutOKTest() {
		File f = new File("");
		HandlerGenericHost1_1 h = new HandlerGenericHost1_1(f);
		String random = String.valueOf(Math.random());
		HTTPRequestClass req = new HTTPRequestClass("PUT", "/src/Tests/PutTxt", "HTTP/1.1", null, random);
		HTTPReplyClass rep = h.replyToPut(req);
		
		// verificare che ora c'e' scritto il nuovo random
		
		assertEquals("HTTP/1.1",rep.getVersion());
		assertEquals("200",rep.getStatusCode());
		assertEquals("OK",rep.getStatusMessage());
		assertEquals(null,rep.getParameters());
		assertEquals(null,rep.getData());
	}
	
	@Test
	void replyToPutNOCONTENTTest() {
		File f = new File("");
		HandlerGenericHost1_1 h = new HandlerGenericHost1_1(f);
		HTTPRequestClass req = new HTTPRequestClass("PUT", "/src/Tests/PutTxt", "HTTP/1.1", null, "");
		HTTPReplyClass rep = h.replyToPut(req);
		
		assertEquals("HTTP/1.1",rep.getVersion());
		assertEquals("204",rep.getStatusCode());
		assertEquals("No Content",rep.getStatusMessage());
		assertEquals(null,rep.getParameters());
		assertEquals(null,rep.getData());
	}
	
//	@Test boh vedi un po' come farlo
//	void replyToPutBADREQUESTTest(){}
	
	@Test
	void replyToDeleteOKTest() {
		
		List<String> lines = Arrays.asList("The first line", "The second line");
		Path file = Paths.get("src/Tests/DeleteTxt");
		try {
			Files.write(file, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File f = new File("");
		HandlerGenericHost1_1 h = new HandlerGenericHost1_1(f);
		HTTPRequestClass req = new HTTPRequestClass("DELETE", "/src/Tests/DeleteTxt", "HTTP/1.1", null, "");
		HTTPReplyClass rep = h.replyToDelete(req);
		
		assertEquals("HTTP/1.1",rep.getVersion());
		assertEquals("200",rep.getStatusCode());
		assertEquals("OK",rep.getStatusMessage());
		assertEquals(null,rep.getParameters());
		assertEquals(null,rep.getData());
	}
	
	
	@Test
	void replyToDeleteNOTFOUNDTest() {
		File f = new File("");
		HandlerGenericHost1_1 h = new HandlerGenericHost1_1(f);
		HTTPRequestClass req = new HTTPRequestClass("DELETE", "/emptyPath", "HTTP/1.1", null, "");
		HTTPReplyClass rep = h.replyToDelete(req);
		
		assertEquals("HTTP/1.1",rep.getVersion());
		assertEquals("404",rep.getStatusCode());
		assertEquals("Not Found",rep.getStatusMessage());
		assertEquals(null,rep.getParameters());
		assertEquals(null,rep.getData());
	}

}
