package objectCreation;

public class LongObject {
	
	public static void print(int num){
		System.out.println("Inside int");
		System.out.println(num);
	}
	public static void print(long num){
		System.out.println("Inside long");
		System.out.println(num);
	}
	public static void print(double num){
		System.out.println("Inside double");
		System.out.println(num);
	}
	public static void main(String[] args) {
		
		int n = 10;
		
		long m = 11;
		
		LongObject.print(11L);
	}

}
