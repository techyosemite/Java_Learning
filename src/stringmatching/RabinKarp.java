package stringmatching;

import java.math.BigInteger;
import java.util.Random;

public class RabinKarp {

	private static long longRandomPrime() {
        BigInteger prime = new BigInteger(31, new Random());
        return prime.longValue();
	}
	
	public static void main(String[] args) {
		System.out.println("Printing the number...");
		System.out.println(longRandomPrime());
		String str = "KARAN";
		System.out.println(str.toCharArray());
	}
}
