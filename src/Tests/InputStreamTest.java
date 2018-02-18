package Tests;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import it.unifi.rc.httpserver.*;

class InputStreamTest {
	Map<String, String> parameters = new HashMap<String, String>();
	SocketTestInputStrReply socktest = new SocketTestInputStrReply();
	SocketTestInputStrRequest socktest1 = new SocketTestInputStrRequest();
	
	@Test
	void writeHttpReplyTest() {
		parameters.put("prova1", "value1");
		parameters.put("prova2", "value2");
//		HTTPReplyClass rep = new HTTPReplyClass("version", "statuscode", "statusmessage", parameters, "body");
		try {
			assertEquals("body", socktest.simulateSocket().getData());
			assertEquals("version", socktest.simulateSocket().getVersion());
			assertEquals("statuscode", socktest.simulateSocket().getStatusCode());
			assertEquals("statusmessage", socktest.simulateSocket().getStatusMessage());
			assertEquals(parameters.get("prova1"), socktest.simulateSocket().getParameters().get("prova1"));
			assertEquals(parameters.get("prova2"), socktest.simulateSocket().getParameters().get("prova2"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void writeHttpRequestTest() {
		parameters.put("prova1", "value1");
		parameters.put("prova2", "value2");
//		HTTPRequestClass rep = new HTTPRequestClass("version", "statuscode", "statusmessage", parameters, "body");
		try {
			assertEquals("body", socktest1.simulateSocket().getEntityBody());
			assertEquals("version", socktest1.simulateSocket().getMethod());
			assertEquals("statuscode", socktest1.simulateSocket().getPath());
			assertEquals("statusmessage", socktest1.simulateSocket().getVersion());
			assertEquals(parameters.get("prova1"), socktest1.simulateSocket().getParameters().get("prova1"));
			assertEquals(parameters.get("prova2"), socktest.simulateSocket().getParameters().get("prova2"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
