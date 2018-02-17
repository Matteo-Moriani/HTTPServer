package it.unifi.rc.httpserver;

import java.io.File;

public class GenericHostHandler1_0 extends AbstractHandler1_0{

	public GenericHostHandler1_0(File pathFile) {
		super(pathFile);
	}

	@Override
	public boolean hostControl(HTTPRequest request) {
		return true;
	}

}
