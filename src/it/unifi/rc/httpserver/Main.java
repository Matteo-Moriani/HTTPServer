package it.unifi.rc.httpserver;

import java.io.File;

public class Main {	// ora ci sono i test

	public static void main(String[] args) throws HTTPProtocolException {
		Parser p = new Parser("method aaa ");
		System.out.println(p.extractMethOrVers());
		System.out.println(p.extractURLOrStatN());
	}

}