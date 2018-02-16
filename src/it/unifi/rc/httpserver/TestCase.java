package it.unifi.rc.httpserver;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import org.junit.jupiter.api.Test;

class TestCase {

	@Test
	void requestCreation() {		// farla casuale e controllare che nei campi in cui non va bene tutto ci siano valori corretti
		HTTPRequestClass r = new HTTPRequestClass("GET", "/wiki.com/Pagina_principale", "HTTP/1.1", Map<String,String> parameters, "I am a body");
		assertEquals("GET", r.getMethod());
		assertEquals("/wiki.com/Pagina_principale", r.getPath());
		assertEquals("HTTP/1.1", r.getVersion());
		assertEquals(expected, r.getParameters());
		assertEquals("I am a body", r.getEntityBody());
	}
	
	void replyCreation() {
		HTTPReplyClass r = new HTTPReplyClass("HTTP/1.0", "200", "OK", Map<String,String> parameters, "I am a string of data");
		assertEquals("HTTP/1.0", r.getVersion());
		assertEquals("200", r.getStatusCode());
		assertEquals("OK", r.getStatusMessage());
		assertEquals(expected, r.getParameters());
		assertEquals("I am a string of data", r.getData());
	}

}
