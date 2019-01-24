package sortingandsearching;

public class BubbleSort {

	/*
	 * In Bubble sort we make the bubble of numbers in the front portion of the
	 * array. And at every iteration we push the largest element at the last of
	 * the array and in next iteration we compare the left element with the
	 * adjacent elements.
	 * 
	 * The complexity here will be : First iteration : n*n-1 comparisons Second
	 * iteration : (n-1)(n-2) comparisons . . Nth iteration : n*n-1.....+ 3 + 2
	 * + 1 Hence, the complexity will be O(n2)
	 */
	
	public static void bubbleSort(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					count++;
					arr[j] = arr[j] + arr[j + 1];
					arr[j + 1] = arr[j] - arr[j + 1];
					arr[j] = arr[j] - arr[j + 1];
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}

		System.out.println("count is ::" + count);
	}

	public static void main(String[] args) {
		
//		int[] arr = { 2, 23, 90, 43, 28, 67, 45, 777, 90, 100, 485, 1234,
//				534124, 8849, -1, 34, 587 };
		int [] arr = {0,1,0,1,0,1,0,1,1};
		bubbleSort(arr);
	}
}
