package com.java.learning;

public class Batman {

	int squares = 81;

	public static void main(String[] args) {

		new Batman().go();
	}

	public void go() {
		incr(++squares);
		System.out.println(squares);
	}

	public void incr(int a) {
		squares = a + 10;
	}
}
