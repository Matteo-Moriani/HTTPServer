package it.unifi.rc.httpserver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.xml.crypto.Data;

//import java.io.ByteArrayInputStream;
////import java.io.ByteArrayOutputStream;
//import java.io.InputStream;
////import java.io.OutputStream;

public class Main {	// ora ci sono i test

	public static void main(String[] args) throws HTTPProtocolException {
		File f = new File("s.txt");
		f.delete();
		System.out.println(f.exists());
	}

}