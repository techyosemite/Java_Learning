package com.java.learning.socketprogramming;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerSocket {
	public static void main(String args[]) {
		// declaration section:
		// declare a server socket and a client socket for the server
		// declare an input and an output stream
		ServerSocket echoServer = null;
		String line;
		DataInputStream is;
		PrintStream os;
		Socket clientSocket = null;
		// Try to open a server socket on port 9999
		// Note that we can't choose a port less than 1023 if we are not
		// privileged users (root)
		try {
			echoServer = new ServerSocket(9999);
			System.out.println("Started Server Socket at port :" + 9999);
		} catch (IOException e) {
			System.out.println(e);
		}
		// Create a socket object from the ServerSocket to listen and accept
		// connections.
		// Open input and output streams
		try {
			clientSocket = echoServer.accept();
			is = new DataInputStream(clientSocket.getInputStream());
			os = new PrintStream(clientSocket.getOutputStream());
			// As long as we receive data, echo that data back to the client.
			byte []byteArray =new byte[1000];
			int len = 0;
			String word = "";
			ByteArrayOutputStream serverinput=new ByteArrayOutputStream();
//			 while ((len = is.read(byteArray))>=0) {
					is.read(byteArray);
//	              serverinput.write(byteArray, 0, len);
	              serverinput.write(byteArray);
//	        }
			 word=new String(serverinput.toByteArray());
			    System.out.println("Client send "+word);
//			while (true) {
				
//				System.out.println(is.readByte());
//				line = is.readLine();
//				os.println(line);
//				System.out.println(byteArray[0]+"--"+byteArray[1]);
//			}
//				for(int i=0;i<10;i++)
//					System.out.println("byteArray[i] --" +byteArray[i]);
//				
					
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}