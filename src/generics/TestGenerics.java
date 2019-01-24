package generics;

import java.util.ArrayList;
import java.util.List;

interface TestGenIf<E> {
	
	public void printElement(E e);
		

}

class TestGenImpl<E> implements TestGenIf<E> {

	@Override
	public void printElement(E e) {
		System.out.println(e);
	}
	
}
public class TestGenerics {
	
	public static void main(String[] args) {
		TestGenIf<String> genr = new TestGenImpl<String>();
		List<String> strList = new ArrayList<String>();
		List<Object> lo = strList;
		TestGenIf<Object> lo = genr;
		genr.printElement("Karan");
		
	}

}
