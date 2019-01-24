package inheritance;

/**
 * In Java8 we can define the method inside the interface.
 * 1. Default methods inside the interface
 * 2. Static methods inside the interface
 * Point to note - We cannot override the methods defined in Object classes inside an interface.   
 * @author karanratra
 *
 */


interface interface0{

	static void show(){
		System.out.println("Inside interface 0");
	}
}
interface interface1{
	default void show(){
		System.out.println("Insie interface A");
	}
}


interface interface2{
	default void show(){
		System.out.println("Insie interface B");
	}
}

class MainClass implements interface1, interface2{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		//interface1.super.show();
		System.out.println("Inside MainClass show method!!");
	}
	
}

public class DiamondClassProblem {

	public static void main(String[] args) {
		MainClass obj = new MainClass();
		
		obj.show();
		
		interface1 obj1 = new MainClass();
		
		obj1.show();
		
		interface0.show();
	}	
}

