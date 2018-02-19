package Tests;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import it.unifi.rc.httpserver.*;

class ProxyTest {

	@Test
	void addTest() {
		HTTPHandler alternative = new HandlerGenericHost1_0(new File(""));
		Map<String,String> p = new HashMap<>();
		ProxyHandler h = new ProxyHandler();
		HTTPRequestClass req = new HTTPRequestClass("GET", "/src/Tests/GetHeadTxt", "HTTP/1.0", p, "");
		HTTPReply rep = alternative.handle(req);
		h.add(req,rep);
		
		assertEquals(req,h.getRequests().get(0));
		assertEquals(rep,h.getReplies().get(0));
	}
	
	@Test
	void handleTest() {
		HTTPHandler alternative = new HandlerGenericHost1_0(new File(""));
		Map<String,String> p = new HashMap<>();
		ProxyHandler h = new ProxyHandler();
		HTTPRequestClass req = new HTTPRequestClass("WRONG", "/src/Tests/GetHeadTxt", "HTTP/1.0", p, "");
		HTTPReply rep = alternative.handle(req);
		h.add(req,rep);
		
		HTTPRequestClass sameReq = new HTTPRequestClass("WRONG", "/src/Tests/GetHeadTxt", "HTTP/1.0", p, "");
		HTTPRequestClass otherReq = new HTTPRequestClass("OTHERWRONG", "/src/Tests/GetHeadTxt", "HTTP/1.0", p, "");
		HTTPReply sameRep = h.handle(sameReq);
		HTTPReply otherRep = h.handle(otherReq);
		
		assertEquals("400",sameRep.getStatusCode());
		assertEquals("400",otherRep.getStatusCode());
	}

}
