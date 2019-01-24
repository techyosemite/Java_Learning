package bitoperations;

public class SwapOddAndEvenPositions {

	public static void main(String[] args) {

		int num = 7;

		int a = (num & 0XAAAAAAAA) >> 1; // unset all even bits
		int b = (num & 0X55555555) << 1; // unset all odd bits

		int result = a | b;

		System.out.println(Integer.toBinaryString(num));
		System.out.println(result);
		System.out.println(Integer.toBinaryString(result));
	}

}
