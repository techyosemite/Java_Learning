package inheritance;

class A{
	
	A(){
		System.out.println("Inside A...");
	}
	A(int a,int b){
		System.out.println("Inside para cons..");
	}
}


class B extends A {
	
	B(int a, int b){
		System.out.println("Inside B...");
	}
}
public class ConstructorChaining {

	public static void main(String[] args) {
		B obj  = new B(10,20);
		
	}
}
