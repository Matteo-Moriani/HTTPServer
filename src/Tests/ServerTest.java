package Tests;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.net.InetAddress;
import it.unifi.rc.httpserver.*;
import org.junit.jupiter.api.Test;

class ServerTest {
	
	File path = new File("");
	HandlerGenericHost1_1 h = new HandlerGenericHost1_1(path);

//	@Test
//	void addHandlerTest() {
//		HTTPServerClass server = new HTTPServerClass(1,1,new InetAddress());
//		server.addHandler(h);
//		assertEquals(h,server.getHandlers().get(0));
//	}
}
