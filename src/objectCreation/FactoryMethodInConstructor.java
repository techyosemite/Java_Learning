package objectCreation;

public class FactoryMethodInConstructor {

	int a ;
	private static final FactoryMethodInConstructor testObj = new FactoryMethodInConstructor();
	
	private FactoryMethodInConstructor(){
//		if (testObj == null)
//			testObj = new FactoryMethodInConstructor();
		a = 900;
	}
	public void getA(){
		System.out.println("A is :: " + a);
	}
	public static FactoryMethodInConstructor getInstance(){
		return testObj;
	}
	
	public static void main(String[] args) {
		FactoryMethodInConstructor obj = FactoryMethodInConstructor.getInstance();
		FactoryMethodInConstructor.testObj.getA();
		obj.getA();
		
}
}
