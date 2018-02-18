package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

import it.unifi.rc.httpserver.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class OutputStreamTest {

	private OutputStream outputS = new ByteArrayOutputStream();
	private HTTPOutputStreamClass httpsOS = new HTTPOutputStreamClass(outputS);	
	
//	@BeforeAll
//	public void setup(){
//		
//	}
	
	@Test
	void test() {
		httpsOS.writeHttpReply(new HTTPReplyClass("aaa","bbb", "ccc", new HashMap<String,String>(),"noooo"));
		fail("Not yet implemented");
	}

}
