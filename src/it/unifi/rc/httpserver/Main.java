package it.unifi.rc.httpserver;

import java.io.File;

public class Main {	// ora ci sono i test

	public static void main(String[] args) throws HTTPProtocolException {
		File f = new File("s.txt");
		f.delete();
		System.out.println(f.exists());
	}

}