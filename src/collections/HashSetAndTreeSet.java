package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Vector;

public class HashSetAndTreeSet {
	public static void main(String[] args) {

		HashSet hashSet = new HashSet<String>();
		TreeSet treeSet = new TreeSet<String>();

		// Hash set gives us the random order output
		hashSet.add("Zubin");
		hashSet.add("Karan");
		hashSet.add("Abhi");

		// Tree set gives us the sorted order output
		treeSet.add("Zubin");
		treeSet.add("Karan");
		treeSet.add("Abhi");

		System.out.println(hashSet);
		System.out.println(treeSet);

		ArrayList<String> list = new ArrayList<String>();

		list.add("Zubin");
		list.add("Karan");
		list.add("Abhi");
		list.add("Zubin");

		System.out.println(list.get(2));
		list.add(2, "Zubin2");
		System.out.println(list);
		
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("Zubin");
		linkedList.add("Karan");
		System.out.println(linkedList);

		String s = "karan";
		
		System.out.println(s.compareTo("Aaran"));
	}

}
