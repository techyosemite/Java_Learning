package objectCreation;

public class StringCreation {

	public static void main(String[] args) {
		String testStr = "Hello Karan";
		System.out.println(testStr.hashCode() + "****" + testStr);
		String testStr1 = "Hello Karan";
		String testStr2 = new String("Hello Karan");
		System.out.println(testStr1.hashCode() + "****" + "testStr1...");
		System.out.println(testStr2.hashCode() + "*** "+ "testStr2...");
		for(int i = 0 ; i< 10 ;i ++){
			String strJ = new String("JAVA" );
			System.out.println("i::"+ i + " Str::" + strJ.hashCode() );
		}
	}
}
