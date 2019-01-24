package objectCreation;

import java.util.ArrayList;
import java.util.List;

public class ListWithDifferentObjects {
	public static void main(String[] args) {
		
		List l = new ArrayList();
		l.add(new Integer(10));
		l.add("KARAN");
		l.add(new Character('C'));
		l.add(new Float(90.0));
		for(Object obj : l){
			System.out.println(obj);
		}
		Integer in = new Integer(99);
		Integer out = in +1; //Auto Boxing
	}

}
