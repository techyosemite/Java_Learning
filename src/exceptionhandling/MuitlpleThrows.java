package exceptionhandling;

import java.io.IOException;

public class MuitlpleThrows {

	public static void main(String[] args) {

		try {
			throw new IOException();
		} catch (IOException e) {
			System.out.println("Inside io Exception...");
			try {
				throw new Exception();
			} catch (Exception e1) {
				System.out.println("Inside Excception...");
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("Inside Excception1...");
		}
	}

}
