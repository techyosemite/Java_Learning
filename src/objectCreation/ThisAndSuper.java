package objectCreation;

interface TestInterface {
	
	static int k =100;
	public void testMethod();
}
class ThisClass{
	
	int i  = 10;
	
}
public class ThisAndSuper extends ThisClass {
	
	final int j; // blank final variable
	static int q; //static final variable
	static {
		q = 100;
	}
	int k ;
	
	ThisAndSuper(){
		super();
		this.k = 20;
		j = 100;
		System.out.println("Inside constructor!!");
	}
	
	//Main method is set to final
	public static  final void main(String[] args) {
		ThisAndSuper obj = new ThisAndSuper();
		String s = null;
		s = s;
	}

}
