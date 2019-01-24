package topcoderprograms;

public class AnyBaseToDecimal {
	
	public int convertToDecimal(int number,int base){
		
		int multiplier = 1;
		int returneNumber = 0;
		while (number > 0){
			
			returneNumber = returneNumber + number%10*multiplier;
			multiplier = base*multiplier;
			number = number%10;
			
		}
		return returneNumber;
	}

	public static void main(String[] args) {
		System.out.println("111111");
		AnyBaseToDecimal obj = new AnyBaseToDecimal();
		obj.hashCode();
		System.out.println(obj.convertToDecimal(739, 8));
	}
}
