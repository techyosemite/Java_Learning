package arrays;

public class Rotation {

	public static int findElement(int[] arr, int start, int end, int n) {

		int mid = (start + end) / 2;

		if (n == arr[mid])
			return mid;

		if(mid + 1 > arr.length - 1 || mid - 1 < 0)
			return -1 ;
		if (arr[mid + 1] <= n && arr[end] >= n)
			return findElement(arr, mid + 1, end, n);
		else
			return findElement(arr, start, mid - 1, n);

	}

	public static void main(String[] args) {

//		int[] arr = { 5, 7, 9, 2, 3 }
		;
		int  []  arr = {2,3,5,7,9};
		System.out.println(findElement(arr, 0, arr.length - 1, 5));
	}
}
