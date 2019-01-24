package basicdatastructures;

abstract class Test {

	public void testMethod() {
		System.out.println("Inside the abstract method!!");
	}
	
	public void callMethod(){
		testMethod();
		
	}
}

class ConcreteTest extends Test {
//	public void testMethod() {
//		System.out.println("Inside the concrete method!!");
//	}	
//	
}

public class SuperClass {

	public static void main(String[] args) {

		Test obj = new ConcreteTest();
		obj.callMethod();
	}
}
