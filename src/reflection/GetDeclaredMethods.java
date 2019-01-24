package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Test {

	private int i;

	int j;

	public Test() {
	}

	Test(int i) {

	}

	public Test(float ff) {

	}

	private void testPrivate() {
		System.out.println("Inside private method..");
	}

	public void testPublic() {
		System.out.println("Inside public method..");
	}

	public int getI() {
		return i;
	}

}

public class GetDeclaredMethods {

	public static void main(String[] args) throws IllegalArgumentException,
			IllegalAccessException {

		try {
			Test o1 = new Test();
			Class c = o1.getClass();
			Method[] methods = c.getDeclaredMethods();
			methods[0].invoke(o1,new Class[]{color});
			Class c = Class.forName("reflection.Test");
			Constructor[] cons = c.getConstructors();
			System.out.println("Cons size -- " + cons.length);
			for (Constructor cs : cons) {
				System.out.println(cs);
			}
			Method[] methods = c.getDeclaredMethods();
			for (Method m : methods) {
				System.out.println(m.getName());
			}
			Constructor con = c.getConstructor(90);

			Field[] f = c.getDeclaredFields();
			Field f4 = c.getDeclaredField("j");
			System.out.println(f4.getType());
			Test obj = new Test();
			f4.setInt(obj, 20);
			System.out.println(obj.j);
			for (Field f1 : f) {
				System.out.println(f1.getName());

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
