package arrays;

public class MaxSumSubArray {

	// Brute force approach O(n3) solution
	public static int maximumSumSubsequenceUsingBruteForceApproach(int[] A) {
		int sum, max = A[0];
		int start, end;
		start = end = sum = 0;
		for (int i = 0; i < A.length; i++)
			for (int j = i; j < A.length; j++) {
				sum = 0;
				for (int k = i; k <= j; k++)
					sum += A[k];
				if (sum >= max) {
					start = i;//Set the start index
					end = j; //Set the end index
					max = sum;
				}
			}

		return sum;
	}

	// Largest Sum Contiguous Subarray Kadane's Algorithm

	public static void maxSum(int[] arr) {

		int globalMaxima, localMaxima;
		globalMaxima = localMaxima = 0;

		for (int i = 0; i < arr.length; i++) {
			localMaxima += arr[i];

			if (localMaxima < 0)
				localMaxima = 0;
			else if (globalMaxima < localMaxima)
				globalMaxima = localMaxima;
		}
		System.out.println("Max continous sub array is :: " + globalMaxima);
	}

	public static int maxSumSubArray(int[] arr) {

		int localMaxima, globalMaxima;
		boolean flag = true;// It assumes that all the numbers in the array is
							// negative

		localMaxima = globalMaxima = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (flag) { // Resets the flag to false if any of the element in the
						// array is found positive
				if (arr[i] > 0) {
					flag = false;
					localMaxima = 0;
				}
			}

			if (flag) {
				localMaxima = Math.max(localMaxima, arr[i]);
			} else {
				localMaxima += arr[i];
				if (localMaxima < 0)
					localMaxima = 0;
			}

			// This condition is common for both the case (positive/negative
			// numbers)
			if (globalMaxima < localMaxima)
				globalMaxima = localMaxima;

		}
		return globalMaxima;
	}

	public static void main(String[] args) {
		// int arr[] = { -4, -2, -6, -1, -8 };
		// int arr[] = { -2, 10, -3, 4, -1, 2, 1, -5, 4 };
		// int arr[] = { -12, -910, -3, -4, -1, -2, -1, -5, -4 };
		// int[] arr = { -2, -3, -344, -1, -2, -2, -33, -3 };
		int[] arr = { 5, -8, -4, 50, -1, 10, -9 };

		System.out.println("Brute force solution ::"
				+ maximumSumSubsequenceUsingBruteForceApproach(arr));

		System.out.println("Max sum of sub array is ::" + maxSumSubArray(arr));// To
																				// handle
																				// the
																				// negative
																				// numbers
		maxSum(arr);

	}

}
