package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import it.unifi.rc.httpserver.HTTPReplyClass;

class ReplyTest {
	
	private Map<String,String> parameters = new HashMap<>();
	private HTTPReplyClass req = new HTTPReplyClass("version", "statusCode", "statusMessage", parameters, "data");
	
	@Test
	void getMethodTestCase() {
		assertEquals(req.getVersion(),"version");
	}
	
	@Test
	void getStatusCodeTestCase() {
		assertEquals(req.getStatusCode(),"statusCode");
	}
	
	@Test
	void getStatusMessageTestCase() {
		assertEquals(req.getStatusMessage(),"statusMessage");
	}
	
	@Test
	void getParametersTestCase() {
		assertEquals(req.getParameters(),parameters);
	}
	
	@Test
	void getDataTestCase() {
		assertEquals(req.getData(),"data");
	}

}