package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import it.unifi.rc.httpserver.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
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
