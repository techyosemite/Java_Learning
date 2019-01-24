package sortingandsearching;

public class InsertionSort {

	/*
	 * The worst case for this will be when the array is reversed.
	 * And we have to compare each element in the inner loop
	 * 
	 */
	public static void insertionSort(int[] arr) {

		int temp, j;
		for (int i = 1; i < arr.length - 1; i++) {
			j = i - 1;
			if (arr[i] < arr[j]) {
				temp = arr[i];
				while (j >= 0 && temp < arr[j]) {
					arr[j + 1] = arr[j];
					j = j - 1;
				}
				arr[j + 1] = temp;
			}
		}
		System.out.println("**********SORTED ARRAY*******");
		for(int i = 0 ; i< arr.length ; i++){
			System.out.print(arr[i] + ",");
		}
	}

	public static void main(String[] args) {
		
		int []arr = {2,23,90,43,28,67,45,777,90,100,485,1234,534124,8849,-1,34,587};
		insertionSort(arr);
		
	}

}
