package Tests;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import it.unifi.rc.httpserver.*;
import org.junit.jupiter.api.Test;

class ServerTest {
	
	File path = new File("");
	HandlerGenericHost1_1 h = new HandlerGenericHost1_1(path);

	@Test
	void addHandlerTest() {
		HTTPServerSinglClientClass server = null;
		try {
			server = new HTTPServerSinglClientClass(1,1,InetAddress.getByName("localhost"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		server.addHandler(h);
		assertEquals(h,server.getHandlers().get(0));
	}
}
