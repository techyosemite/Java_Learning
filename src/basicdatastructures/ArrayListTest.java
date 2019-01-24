package basicdatastructures;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {

		ArrayListTest obj = new ArrayListTest();
		System.out.println(obj);
		// Thread
		List<Integer> list = new ArrayList<Integer>(20);
		list.add(new Integer(30));
		StringBuffer strBuf = new StringBuffer();
		// strBuf.append(obj);
		// List l = new ArrayList<Integer>();
		// l.add(90);
		// l.add(99);
		// l.add(l);
		System.out.println(list);
		// l.add(l);
		// l.add(l);
		// l.add(l);

		// System.out.println(l);

		//
		// for (int j = 0; j < l.size() ; j++)
		// System.out.println(l.get(j));

	}
}
