package it.unifi.rc.httpserver;

import java.io.File;

public class GenericHostHandler1_1 extends AbstractHandler1_1{

	public GenericHostHandler1_1(File pathFile) {
		super(pathFile);
	}

	@Override
	public boolean hostControl(HTTPRequest request) {
		return true;
	}

}
