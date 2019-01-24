package sortingandsearching;

public class SelectionSort {

	/*
	 * The worst case here will occur when the array is already sorted and
	 * we have to compare each element to find the next minimum in the n-i list of 
	 * elements.
	 * 
	 */
	public static void selectionSort(int[] arr) {

		int temp,min,minIndex;
		for (int i = 0; i < arr.length ; i++) {
			min = arr[i];
			minIndex = i;
			//Inner loop to find the minimum in left n-i elements and it is done for each i in the loop
			for (int k = i; k < arr.length; k++) {
				if (min > arr[k]){
					min = arr[k];
					minIndex = k;
				}
			}
			temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp ;
			
		}
		for(int i = 0 ; i < arr.length ; i++){
				System.out.print(arr[i] + ",");
		}
	}

	public static void main(String[] args) {

		int []arr = {2,23,90,43,28,67,45,777,90,100,485,1234,534124,8849,-1,34,587};
		selectionSort(arr);
	}

}
