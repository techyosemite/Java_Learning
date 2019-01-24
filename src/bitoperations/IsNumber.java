package bitoperations;

public class IsNumber {

	
	public static boolean isNumber(String str){
//		str.matches("-?\\d+(\\.\\d+)?")
		
		return str.matches("-?\\d+(\\.\\d+)?");
	}
	public static void main(String[] args) {
		
		System.out.println(isNumber("-9292"));
	}
}
