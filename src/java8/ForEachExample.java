package java8;

import java.util.Arrays;
import java.util.List;

public class ForEachExample {

	public static void main(String[] args) {
		List<Integer> values =  Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		//This in Java8 is known as internal for loop
		
		//This is an implementation of Consumer interface
		values.forEach(i -> System.out.println(i));
		
		
	}
}
