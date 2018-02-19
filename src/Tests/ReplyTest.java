package Tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import it.unifi.rc.httpserver.*;

class ReplyTest {
	
	private Map<String,String> parameters = new HashMap<>();
	private HTTPReplyClass req = new HTTPReplyClass("version", "statusCode", "statusMessage", parameters, "data");
	
	@Test
	void getMethodTest() {
		assertEquals(req.getVersion(),"version");
	}
	
	@Test
	void getStatusCodeTest() {
		assertEquals(req.getStatusCode(),"statusCode");
	}
	
	@Test
	void getStatusMessageTest() {
		assertEquals(req.getStatusMessage(),"statusMessage");
	}
	
	@Test
	void getParametersTest() {
		assertEquals(req.getParameters(),parameters);
	}
	
	@Test
	void getDataTest() {
		assertEquals(req.getData(),"data");
	}

}