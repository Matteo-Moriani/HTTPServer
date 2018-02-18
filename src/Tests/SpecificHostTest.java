package Tests;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import it.unifi.rc.httpserver.*;

class SpecificHostTest {

	File path = new File("");
	HandlerSpecificHost1_0 h = new HandlerSpecificHost1_0(path,"host1");
	
	@Test
	void trueHostControlTest() {
		Map<String,String> parameters = new HashMap<String,String>();
		parameters.put("Host", "host1");
		HTTPRequestClass req = new HTTPRequestClass("method", "path", "version", parameters, "body");
		assertEquals(true,h.hostControl(req));
	}
	
	@Test
	void falseHostControlTest() {
		Map<String,String> parameters = new HashMap<String,String>();
		parameters.put("Host", "host2");
		HTTPRequestClass req = new HTTPRequestClass("method", "path", "version", parameters, "body");
		assertEquals(false,h.hostControl(req));
	}

}
