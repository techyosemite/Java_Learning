package objectCreation;

class TestA {
	ListIterator itr ;
	private  static  int k = 10;
	 
}
public class StaticVariablesInClass {

	private static int a =10;
	
	int b;
	
	public void abc(){
		int c = 32;
		
		System.out.println("a =" + a);
		System.out.println("b =" + b);
		System.out.println("c =" + c);
	}
	public static void main(String[] args) {
		StaticVariablesInClass t = new StaticVariablesInClass();
		t.abc();
		t.a++;
		System.out.println(a);
		TestA a = new TestA();
//		TestA.k++;
		System.out.println(a.k);
		a.k++;
		System.out.println(a.k);
	}
}
