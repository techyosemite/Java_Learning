package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PythagorasTripplet {

	public static void printPythagorasTripplet(int[] arr) {

		if (arr == null)
			return;

		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

		// O(n)
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i] * arr[i])) {
				map.get(arr[i] * arr[i]).add(arr[i]);
			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(arr[i]);
				map.put(arr[i] * arr[i], list);
			}
		}

		// O(n2) solution
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int sumSquare = arr[i] * arr[i] + arr[j] * arr[j];
				if (map.containsKey(sumSquare)) {
					System.out
							.println("The Pythagoras tripplet can be made from the following numbers :"
									+ arr[i] + "," + arr[j] + "::");
					for (int k = 0; k < map.get(sumSquare).size(); k++) {
						System.out.print(map.get(sumSquare).get(k));
					}
					System.out.println();
				}
			}
		}

	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 7, 5, 4, 12, 13, -5 };
		printPythagorasTripplet(arr);

	}

}
