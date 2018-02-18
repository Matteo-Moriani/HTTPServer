package Tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import it.unifi.rc.httpserver.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ParserTest {
	
	private static Parser parser;
	private static String method;
	private static String statm;
	private static String statc;
	private static Map<String, String> hash;
	private static String body;
	
	@BeforeAll
	public static void setup(){
		 parser = new Parser("method statmess statcode\r\nparam1: value1\r\nparam2: value2\r\n\r\nbody");
		 method = parser.extractMethOrVers();
		 statm = parser.extractURLOrStatN();
		 statc = parser.extractVersOrStatCode();
		 hash = parser.extractHeadersOrParam();
		 body = parser.extractBodyOrData();
	}
	
	@Test
	void extractMethOrVersrTest() {
		assertEquals("method", method);
	}
	
	@Test
	void extractURLOrStatNTest() {
		assertEquals("statmess", statm);
	}
	
	@Test
	void extractVersOrStatCodeTest() {
		assertEquals("statcode", statc);
	}
	
	@Test
	void extractHeadersOrParamTest() {
		assertEquals("value1", hash.get("param1"));
		assertEquals("value2", hash.get("param2"));
	}
	
	@Test
	void extractBodyOrDataTest() {
		assertEquals("body",body);
	}
	
}
