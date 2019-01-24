package HashMapImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

public class TestHashMap {

	private Map<Integer, String> mapTest;

	TestHashMap() {

	}

	public static void main(String[] args) {

		List li = new ArrayList();
		li.add(new Integer(20));
		li.add("KARAN");
		Iterator itr = li.iterator();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(12, 99);
		Iterator<Map.Entry<Integer, Integer>> itr2 = map.entrySet().iterator();
		while (itr2.hasNext()) {
			Entry ob = (Entry) itr2.next();
			System.out.println(ob.getKey());
			System.out.println(ob.getValue());
			itr2.remove();
			map.put(920, 920);

		}
		//

		Vector<String> vc = new Vector<String>();

		vc.add("Two");
		vc.add("One");
		vc.add("Four");
		vc.add("Three");

		// TreeMap<K, V>
		Hashtable<Integer, Integer> df = null;
		// Collections.synchronizedList(li);
		// Enumeration em=vc.elements();
		// while(em.hasMoreElements()){
		// System.out.println(em.nextElement());
		// }
		// System.out.println(10 >> 2);

		// itr.
		// while (itr.hasNext()) {
		// System.out.println(itr.next());
		// }
	}

}
