package com.java.learning;

public class StringClasses {

	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("Test Str Builder");
		String strCommon = new String("KARAN");
		System.out.println("str hashCode::" + str.hashCode());
		System.out.println("StrCommon hash code::" + strCommon.hashCode());
		strCommon +=" Ratra";
		System.out.println("StrCommon hash code After::" + strCommon.hashCode());
		str.append("Ratra");
		System.out.println("str hashCode After::" + str.hashCode());


	}
	
	
}
