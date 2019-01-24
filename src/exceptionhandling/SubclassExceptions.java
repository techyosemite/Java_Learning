package exceptionhandling;

import java.io.IOException;


class A {
	
	public void testCheckedException (){
		System.out.println("Inside super class method!!");
	}
}

class B extends A {
	public void testCheckedException() {
		System.out.println("Inside super class method!!");
	}
}

public class SubclassExceptions {
	
	public static void main(String[] args) {
		int a = 1;
		int b = 3;
		
		System.out.println((a+b) + "5");
		System.out.println(a + b + "5");
		System.out.println("1 " + "3" + "5");
	}

}
