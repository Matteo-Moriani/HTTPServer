package it.unifi.rc.httpserver;

import java.io.File;

public class SpecificHostHandler1_0 extends AbstractHandler1_0{
	private String host;

	public SpecificHostHandler1_0(File pathFile, String host) {
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
