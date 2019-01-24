package com.java.learning.socketprogramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket {
	public static void main(String[] args) {
		// declaration section:
		// smtpClient: our client socket
		// os: output stream
		// is: input stream
		Socket smtpSocket = null;
		DataOutputStream os = null;
		DataInputStream is = null;
		// Initialization section:
		// Try to open a socket on port 25
		// Try to open input and output streams
		try {
			smtpSocket = new Socket("127.0.0.1", 9999);
			os = new DataOutputStream(smtpSocket.getOutputStream());
			is = new DataInputStream(smtpSocket.getInputStream());
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: hostname");
		} catch (IOException e) {
			e.printStackTrace();
			System.err
					.println("Couldn't get I/O for the connection to: hostname");
		}
		// If everything has been initialized then we want to write some data
		// to the socket we have opened a connection to on port 25
		System.out.println("Helloo");
		if (smtpSocket != null && os != null && is != null) {
			try {
				byte []b = new byte[20];
				for(int i=0;i<20;i++)
					b[i]=(byte) i;
				// The capital string before each colon has a special meaning to
				// SMTP
				// you may want to read the SMTP specification, RFC1822/3
//				os.writeBytes("HELO\n");
//				os.writeBytes("MAIL From: k3is@fundy.csd.unbsj.ca\n");
//				os.writeBytes("RCPT To: k3is@fundy.csd.unbsj.ca\n");
//				os.writeBytes("DATA\n");
//				os.writeBytes("From: k3is@fundy.csd.unbsj.ca\n");
//				os.writeBytes("Subject: testing\n");
//				os.writeBytes("Hi there\n"); // message body
//				os.writeBytes("\n.\n");
//				os.writeBytes("QUIT");
//				os.writeBytes("Karan Kumar Ratra");
//				os.writeByte(1);
//				os.write(b);
				os.writeBytes("Prevea ROC CRM");
				System.out.println("writting into the socket..");
				// keep on reading from/to the socket till we receive the "Ok"
				// from SMTP,
				// once we received that then we want to break.
				String responseLine;
				while ((responseLine = is.readLine()) != null) {
					System.out.println("Server: " + responseLine);
					if (responseLine.indexOf("Ok") != -1) {
						break;
					}
				}
				// clean up:
				// close the output stream
				// close the input stream
				// close the socket
				os.close();
				is.close();
				smtpSocket.close();
			} catch (UnknownHostException e) {
				System.err.println("Trying to connect to unknown host: " + e);
			} catch (IOException e) {
				System.err.println("IOException:  " + e);
			}
		}
	}
}