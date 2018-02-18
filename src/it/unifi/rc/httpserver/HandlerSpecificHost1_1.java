package it.unifi.rc.httpserver;

import java.io.File;

public class HandlerSpecificHost1_1 extends AbstractHandler1_1{
	private String host;

	public HandlerSpecificHost1_1(File pathFile, String host) {
		super(pathFile);
		this.host = host;
	}

	@Override
	public boolean hostControl(HTTPRequest request) {
		if(host.equals(request.getParameters().get("Host"))) {
			return true;
		}else {
			return false;
		}
	}

}
