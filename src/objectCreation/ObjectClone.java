package objectCreation;

class TestCloneA {

	public Object clone() {
		try {
			super.clone();// Clone not supported exception, because at run time
							// object's clone will be called
							// There it will check if the class implements the
							// cloneable interface or not.
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new TestCloneA();
	}
}

class TestClone extends TestCloneA {

	int i = 10;

	public Object clone() {
		super.clone();

		//
		return new TestClone();
	}

}

public class ObjectClone {

	public static void main(String[] args) {

		TestClone obj = new TestClone();
		Object clone = obj.clone();
		if (clone == obj)
			System.out.println("true");
		else
			System.out.println("false");
	}

}
