package Tests;

import static org.junit.jupiter.api.Assertions.*;
import it.unifi.rc.httpserver.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class RequestTest {
	
	private Map<String,String> parameters = new HashMap<>();
	private HTTPRequestClass req = new HTTPRequestClass("method", "url", "version", parameters, "body");
	
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

}
