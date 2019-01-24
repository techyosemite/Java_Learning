package com.java.learning;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.util.Date;

class TestNotSerializableClass {
	int i;
	String str;

	TestNotSerializableClass(int i, String str) {
		this.i = i;
		this.str = str;
	}

	public int getInt() {
		return this.i;
	}

	public String getStr() {
		return this.str;

	}

}

class TestSerializableClass implements Serializable {
	
	private static final long serialVersionUID = 1;
	
	int intVariable;
	transient String str;
	static int staticInt = 92;
	Date testDate;
	private Integer testIntegerValue;
	transient int transientInt;

	// TestNotSerializableClass notSerializedClass;

	TestSerializableClass(int i, String str, Integer intV) {
		this.intVariable = i;
		this.str = str;
		this.testDate = new Date();
		this.testIntegerValue = new Integer(10033);
		this.transientInt = 99;
		// this.notSerializedClass = new TestNotSerializableClass(10,
		// "This is not serializable");
	}

	public String toString() {
		return "Str =" + str + "  testDate =" + testDate + " testIneger="
				+ testIntegerValue.intValue() + " transient=" + transientInt;
		// + " Static int =" + staticInt + " TestNotSerializable -->i:"
		// + notSerializedClass.getInt() + "  TestNotSerializable -->Str:"
		// + notSerializedClass.getStr();
	}
}

public class TestSerializable {
	public static void main(String[] args) throws ClassNotFoundException,
			IOException {
//		TestSerializableClass obj = new TestSerializableClass(10,
//				"Hello Karan..", new Integer(100));
//		System.out.println("Serial version UID --"
//				+ ObjectStreamClass.lookup(TestSerializableClass.class)
//						.getSerialVersionUID());
//
//		// Serialization
//		// Changing static variable
//		System.out
//				.println("Staic variable :" + TestSerializableClass.staticInt);
//		TestSerializableClass.staticInt = 99;
//		System.out.println("Before saving..");
//		System.out.println(obj);
//		FileOutputStream fiOutputStream = new FileOutputStream(
//				"/Users/karanratra/Desktop/test.txt");
//		ObjectOutputStream oos = new ObjectOutputStream(fiOutputStream);
//		oos.writeObject(obj);
//		oos.flush();
//		oos.close();

		// Deserialization
		TestSerializableClass object2;
		FileInputStream inpStr = new FileInputStream(
				"/Users/karanratra/Desktop/test.txt");
		ObjectInputStream ips = new ObjectInputStream(inpStr);
		object2 = (TestSerializableClass) ips.readObject();
		// System.out.println(object2.notSerializedClass.i);;
		// System.out.println(object2.notSerializedClass.str);;

		ips.close();
		System.out.println(object2);
		TestSerializableClass.staticInt = 99;

	}
}
