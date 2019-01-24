package objectCreation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ComparatorClass implements Comparator<ComparatorClass> {

	int id;

	String name;

	ComparatorClass(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compare(ComparatorClass o1, ComparatorClass o2) {
		// return o1.name.compareTo(o2.name);
		return o1.id - o2.id;
	}

}

public class ComparableClass implements Comparable<ComparableClass>,
		Comparator<ComparableClass> {

	int id;

	String name;

	int age;

	public ComparableClass() {
	}

	public ComparableClass(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(ComparableClass o) {
		if (this.age - o.age == 0) {
			return this.id - o.id;
		} else
			return this.age - o.age;
	}

	private static void printList(List<ComparableClass> list) {
		System.out.println("EmpId\tName\tAge");
		for (ComparableClass e : list) {
			System.out.println(e.getId() + "\t" + e.getName() + "\t"
					+ e.getAge());
		}
	}

	@Override
	public int compare(ComparableClass o1, ComparableClass o2) {
		System.out.println("22");
		if (o1.name.compareTo(o2.name) == 0) {
				return o1.compareTo(o2);
		}

		return o1.name.compareTo(o2.name);

	}

	private static void printComparatorList(List<ComparatorClass> list) {
		System.out.println("EmpId\tName");
		for (ComparatorClass e : list) {
			System.out.println(e.getId() + "\t" + e.getName());
		}
	}

	public static void main(String[] args) {

		List<ComparableClass> l = new ArrayList<ComparableClass>();

		l.add(new ComparableClass(2, "Karan", 25));
		l.add(new ComparableClass(1, "Karan", 26));
		l.add(new ComparableClass(4, "Nitin", 27));
		l.add(new ComparableClass(3, "Nitin", 27));

		// Collections.sort(l);
		Collections.sort(l, new ComparableClass());
		printList(l);

		// List<ComparatorClass> l1 = new ArrayList<ComparatorClass>();
		//
		// l1.add(new ComparatorClass(11, "Aman"));
		// l1.add(new ComparatorClass(15, "Zeeshan"));
		// l1.add(new ComparatorClass(1, "Nitin"));
		//
		// Collections.sort(l1, new ComparatorClass(12, "Karan"));
		// printComparatorList(l1);

	}

}