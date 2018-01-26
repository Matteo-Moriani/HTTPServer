package it.unifi.rc.httpserver;

public class main {

	public static void main(String[] args) {
		HTTPRequestClass A = new HTTPRequestClass("ABCD http://gesucristo HTTP/1.0\r\nHost: Ciao\r\nAccept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, application/x-shockwave-flash, application/msword, application/vnd.ms-excel, */*\r\n" + 
				"Accept-Encoding: gzip, deflate\r\n\r\naaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.");
		String a = A.getMethod();
		System.out.println(a);
		String b = A.getPath();
		System.out.println(b);
		String c = A.getVersion();
		System.out.println(c);
		System.out.println(A.getParameters().get("Host"));
		System.out.println(A.getParameters().get("Accept"));
		System.out.println(A.getParameters().get("Accept-Encoding"));
		String d = A.getEntityBody();
		System.out.println(d);
	}

}
