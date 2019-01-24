package objectCreation;

class   KKStr{
	
	int i = 90;
	
	public boolean equals(Object o) {
		if (!(o instanceof KKStr))
			return false;

		KKStr testObj = (KKStr) o;
		if (testObj.i == this.i)
			return true;

		return false;

	}
}
public class TestStrClass extends KKStr{
	int i = 90;
	int j = 30;
	
	public boolean equals(Object o){
		if (!(o instanceof KKStr))
			return false;
		
		if(!(o instanceof TestStrClass))
			return o.equals(this);
		
		KKStr testObj = (KKStr)o;
		if (testObj.i == this.i)
			return true;
			
			
		return false;
		
	}
	
public static void main(String[] args) {
	
	TestStrClass o = new TestStrClass();
//	System.out.println(o instanceof KKStr);
//	System.out.println(o instanceof TestStrClass);
	KKStr o1 = new KKStr();
//	System.out.println(o1 instanceof TestStrClass);


}
}
