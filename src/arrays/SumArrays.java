package arrays;

import java.util.HashMap;
import java.util.Map;

public class SumArrays {

	public static void findNumbers(int[] arr, int number) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i]))
				map.put(arr[i], map.get(arr[i]) + 1);
			else
				map.put(arr[i], 1);
		}

		for (int i = 0; i < arr.length; i++) {
			if (map.get(arr[i]) >= 1) {
				map.put(arr[i], map.get(arr[i]) - 1);
				if (map.containsKey(number - arr[i])) {
					if (map.get(number - arr[i]) >= 1) {
						System.out.println("Numbers are ::{" + arr[i] + ","
								+ (number - arr[i]) + "}");
						map.put(number - arr[i], map.get(number - arr[i]) - 1);
						map.put(arr[i], map.get(arr[i]) - 1);
					}
				}
				map.put(arr[i], map.get(arr[i]) + 1);
			}

		}

	}

	public static void main(String[] args) {

		int[] arr = { 3, 3, 3, 3, 6, 1, 9, 6, 5, 7, -1, -3, 9, -3, 10, -4, 11,
				-5 };
		findNumbers(arr, 6);
		String str = "KARAN";
		System.out.println((int)str.charAt(1));
	}

}
