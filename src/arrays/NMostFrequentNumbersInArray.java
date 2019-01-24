package arrays;

import java.util.HashMap;
import java.util.Map;

public class NMostFrequentNumbersInArray {

	public static Map<Integer, Integer> m = new HashMap<Integer, Integer>();
	public static Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
	
	public static int heapSize;

	public static void heapfify(int[] arr, int i) {

		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int smallest;

		if (left < heapSize && m.get(arr[left]) <= m.get(arr[i])) {
			smallest = left;
		} else
			smallest = i;

		if (right < heapSize && m.get(arr[right]) <= m.get(arr[smallest])) {
			smallest = right;
		}
		if (smallest != i) {
			int temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
			heapfify(arr, smallest);
		}

	}

	public static void buildMinHeap(int[] arr,int tempHeapSize) {
		heapSize = tempHeapSize;
		for (int i = (int) Math.floor(arr.length / 2); i >= 0; i--) {
			heapfify(arr, i);
		}

	}

	public static void printKMostFrequentNumbers(int[] arr, int k) {
		if (arr == null)
			return;

		int[] temp = new int[k];

//		for (int i = 0; i < k; i++)
//			temp[i] = arr[i];
		for (int i = 0; i < arr.length; i++) {
			if (m.containsKey(arr[i])) {
				m.put(arr[i], m.get(arr[i]) + 1);
			} else {
				m.put(arr[i], 1);
			}
		}

		for (int i = 0; i < temp.length; i++) {
			temp[i] = arr[i];
			buildMinHeap(temp,i);

		}
		
		for (int i = k; i < arr.length; i++) {
			if (m.get(arr[i]) > m.get(temp[0])) {
				temp[0] = arr[i];
				heapfify(temp, 0);
			}
		}
		System.out.println("Below are the most frequent numbers in an array...");
		for(int i=0;i <temp.length ; i++){
			System.out.println(temp[i] + "----" + m.get(temp[i]));
			
		}

	}

	public static void main(String[] args) {

		int arr[] = {2,3,12,12,12,12,12,12,2,2,2,2,1,1};
		printKMostFrequentNumbers(arr, 3);
	}

}
