package com.java.learning.socketprogramming;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class LowPortScanner {
	public static void main(String[] args) throws UnknownHostException {

		String host = "java.sun.com";
//		InetAddress OReilly = InetAddress.getByName("www.oreilly.com");
		InetAddress OReilly = InetAddress.getByName(host);

		System.out.println(OReilly.getHostAddress());
		if (args.length > 0) {
			host = args[0];
		}
		for (int i = 1; i < 1024; i++) {
			try {
//				System.out.println("Checking for port ::" + i);
				Socket s = new Socket(host, 80);
				System.out.println(s.getPort());
				System.out.println("There is a server on port " + i + " of "
						+ host);
			} catch (UnknownHostException e) {
				System.err.println(e);
				break;
			} catch (IOException e) {
//				System.err.println(e);
//				System.out.println("Connection refused!!!");
			} // end for
		}
	}
}