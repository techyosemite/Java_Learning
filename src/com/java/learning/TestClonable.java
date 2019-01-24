package com.java.learning;

public class TestClonable implements Cloneable {

	int i;

	String str;

	TestClonable(int i, String str) {
		this.i = i;
		this.str = str;
	}

	int getInt() {
		return i;
	}

	String getString() {
		return str;
	}

	public Object clone() { // clone this object
		System.out.println("Inside clone....");
		TestClonable that = null;
		try {
			that = (TestClonable) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// copy deep clones of reference members from this to that
		return that;
	}

	public static void main(String[] args) {
		TestClonable obj = new TestClonable(10, "Karan");
		TestClonable newObj = (TestClonable) obj.clone();
		System.out.println("Old Object --" + obj);
		System.out.println("New Object -- " + newObj);
		System.out.println(newObj.getInt() + "---" + newObj.getString());

	}
}
