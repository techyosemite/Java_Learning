package reflection;

import java.lang.reflect.Field;
import java.util.Date;

public class MainClass {
	public static void main(String[] args) throws ClassNotFoundException,
			IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException {
		TestClass testClass = new TestClass();
		testClass.setTestInteger(new Integer(10));
		testClass.setTestFloat(10f);
		testClass.setTestString("Hello World");
		testClass.setTestDate(new Date());
//		System.out.println("111");
		Class c = testClass.getClass();
		Field[] fieldArray = c.getDeclaredFields();		
		System.out.println(testClass.testInteger);

		c.getDeclaredField("testInteger").setInt(testClass, 20);
		System.out.println(testClass.getTestInteger());
		
//		for (int i = 0; i < fieldArray.length; i++) {
//			Field f = fieldArray[i];
////			System.out.println(f.getType());
//				System.out.println(f.getInt("testInteger"));
////			System.out.println(fieldArray[i].toString());
//		}

	}
}
