package Tests;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import it.unifi.rc.httpserver.*;
import org.junit.jupiter.api.Test;

class OutputStreamTest {
	SocketTestOutStrReply socktest = new SocketTestOutStrReply();
	SocketTestOutStrRequest socktest1 = new SocketTestOutStrRequest();
	
	@Test
	void writeHttpReplyTest() {
		try {
			assertEquals("version statusCode statusMessage\r\nname1: value1\r\nname2: value2\r\n\r\ndata", socktest.simulateSocket());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void writeHttpRequestTest() {
		try {
			assertEquals("version statusCode statusMessage\r\nname1: value1\r\nname2: value2\r\n\r\ndata", socktest1.simulateSocket());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
