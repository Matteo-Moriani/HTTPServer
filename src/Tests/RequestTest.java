package Tests;

import static org.junit.jupiter.api.Assertions.*;
import it.unifi.rc.httpserver.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class RequestTest {
	
	 Map<String,String> parameters = new HashMap<>();
	 HTTPRequestClass req = new HTTPRequestClass("method", "url", "version", parameters, "body");
	
	@Test
	void getMethodTest() {
		assertEquals(req.getMethod(),"method");
	}
	
	@Test
	void getUrlTest() {
		assertEquals(req.getPath(),"url");
	}
	
	@Test
	void getVersioneTest() {
		assertEquals(req.getVersion(),"version");
	}
	
	@Test
	void getParametersTest() {
		assertEquals(req.getParameters(),parameters);
	}
	
	@Test
	void getBodyTest() {
		assertEquals(req.getEntityBody(),"body");
	}
	
	@Test
	void equalsTest() {
		HTTPRequestClass req1 = new HTTPRequestClass("method", "url", "version", parameters, "body");
		HTTPRequestClass req2 = new HTTPRequestClass("method", "url", "version", parameters, "body");
		HTTPRequestClass req3 = new HTTPRequestClass("m", "u", "v", parameters, "b");
		assertEquals(true,req1.equals(req2));
		assertEquals(false,req1.equals(req3));
	}

}
