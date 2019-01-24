package careercup;

import java.util.HashMap;
import java.util.Map;

/*
 * If A and B, two integers are given.

 compute A/B.

 Ex. 2/5 --> Ans should be 0.4
 225/1000 --> Ans should be 0.225
 22/7 --> Ans Should be 3.(142857) where 142857 are repeating decimal
 */
public class TwoIntegers {

	public static void divideIntegers(int i, int j) {
		System.out.println("i is --"
				+ Integer.parseInt(Integer.toBinaryString(i))
				/ Integer.parseInt(Integer.toBinaryString(j)));
		System.out.println("j is --" + Integer.toBinaryString(j));

	}

	public static String divide(int A, int B) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		return divide(A, B, "", map);

	}

	public static String divide(int A, int B, String soFar, Map map) {
		if (A == 0)
			return soFar;
		if (A >= B) {
			soFar += (A / B);
			return divide(A % B, B, soFar, map);
		} else {
			if (soFar.indexOf('.') == -1) {
				if (soFar.length() > 0)
					soFar += ".";
				else
					soFar = "0.";
			}

			if (map.containsKey(A)) {
				int index = (Integer) map.get(A);
				return soFar.substring(0, index) + "(" + soFar.substring(index)
						+ ")";
			} else {
				map.put(A, soFar.length());
			}

			A = A * 10;
			while (A < B) {
				A = A * 10;
				soFar += "0";
			}
			return divide(A, B, soFar, map);
		}
	}

	public static void main(String[] args) {

		int i, j;
		i = 22;
		j = 57;

		// divideIntegers(i, j);
		System.out.println(divide(i, j));

	}

}
