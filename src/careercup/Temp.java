package careercup;

import java.util.stream.IntStream;

public class Temp {

	public static void sum(int [] array){
		int sum = IntStream.of(array).sum();
		System.out.println("The sum is " + sum);
		
	} 
	public static void main(String[] args) {
		int [] array = {1,2,3,4,5,6,7,8,9};
		
		sum(array);
	}
	
	
}

