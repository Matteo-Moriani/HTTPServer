package it.unifi.rc.httpserver;

import java.io.File;

public class HandlerGenericHost1_0 extends AbstractHandler1_0{

	public HandlerGenericHost1_0(File pathFile) {
		super(pathFile);
	}

	@Override
	public boolean hostControl(HTTPRequest request) {
		return true;
	}

}
