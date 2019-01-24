package exceptionhandling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

class TestValodate {

	void m() throws IOException {
		throw new IOException();
	}

	public void validate(int i) {
		if (i < 10)
			throw new ArithmeticException();
		else
			System.out.println(i);
	}
}

public class MultipleFinally {

	public static void main(String[] args) {

		/*
		 * TestValodate obj = new TestValodate();
		 * System.out.println(obj.hashCode()); try { int k = 25 / 0; } finally {
		 * 
		 * }
		 */
		// Write code here

		System.out.println("Inside main...");

		Hashtable<Integer, String> table = new Hashtable<Integer, String>();
		Iterator itr2 = table.entrySet().iterator();
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(2, "KARAN");

		Iterator<Map.Entry<Integer, String>> itr1 = map.entrySet().iterator();

		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		Vector<Integer> vectorObj = new Vector<Integer>(5);
		vectorObj.add(0, 1);
		vectorObj.add(1, 2);
		vectorObj.add(3);
		Iterator<Integer> itr = vectorObj.iterator();
		while (itr.hasNext()) {
			Integer intObj = itr.next();
			System.out.println(intObj);
		}

		arrlist.add(0, 9);
		arrlist.add(1, 10);
		arrlist.add(90);

		Iterator itrList = arrlist.iterator();
		while (itrList.hasNext()) {
			System.out.println(itrList.next());
		}
		
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("KARAN");
	HashMap<Character,Integer> characterCount = new HashMap<Character, Integer>();
	characterCount.put('C', 99);
	
	System.out.println(characterCount.get('C'));
	String name = "K~RAN";
	System.out.println(name.charAt(2));
	//Code point will give the ASCII value for the characters
	System.out.println(name.codePointAt(1));
	}

}
