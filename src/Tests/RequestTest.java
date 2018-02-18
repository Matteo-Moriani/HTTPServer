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
	void getMethodTestCase() {
		assertEquals(req.getMethod(),"method");
	}
	
	@Test
	void getUrlTestCase() {
		assertEquals(req.getPath(),"url");
	}
	
	@Test
	void getVersioneTestCase() {
		assertEquals(req.getVersion(),"version");
	}
	
	@Test
	void getParametersTestCase() {
		assertEquals(req.getParameters(),parameters);
	}
	
	@Test
	void getBodyTestCase() {
		assertEquals(req.getEntityBody(),"body");
	}

}
