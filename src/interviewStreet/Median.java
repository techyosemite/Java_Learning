package interviewStreet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;

public class Median {

	int binarySearch(long number, int startIndex, int endIndex, long[] arr) {
		Thread t;
		LinkedList l;
		Hashtable h;

		int position = (int) Math.ceil((startIndex + endIndex) / 2f);

		if (arr[position] == number)
			return position;

		if (startIndex == endIndex || startIndex > endIndex)
			return -endIndex;

		if (arr[position] < number)
			return binarySearch(number, position + 1, endIndex, arr);
		else
			return binarySearch(number, startIndex, position - 1, arr);

	}

	public void process(String[] inputStrArray, long[] num) {

		int length = num.length;
		long[] intArr = new long[length];
		Arrays.fill(intArr, Integer.MAX_VALUE);
		int i = 0;
		int index = -1;
		for (int j = 0; j < length; j++) {
			if (inputStrArray[j].equalsIgnoreCase("r")) {
				index = binarySearch(num[j], 0, num.length - 1, intArr);

				if (index < 0) {
					System.out.println("Wrong!");
				} else {
					if (index == 0) {
						if (intArr[0] == num[j]) {
							for (int k = index; k < length - 1; k++) {
								intArr[k] = intArr[k + 1];
							}
							intArr[intArr.length - 1] = Integer.MAX_VALUE;
							i--;
						} else
							System.out.println("Wrong!");
					}
					// for (int k = index; k < length - 1; k++) {
					// intArr[k] = intArr[k + 1];
					// }
					// intArr[intArr.length - 1] = Integer.MAX_VALUE;
					// i--;
					if (i != 0) {
						if (i % 2 == 0) {
							if ((intArr[i / 2] + intArr[(i / 2) - 1]) % 2 != 0)
								System.out
										.println((intArr[i / 2] + intArr[(i / 2) - 1]) / 2f);
							else {
								System.out
										.println((intArr[i / 2] + intArr[(i / 2) - 1]) / 2);
							}
						} else {
							System.out.println(intArr[(int) Math.ceil(i / 2)]);
						}
					}// else if (i == 0) {
						// System.out.println("Wrong!");
					// }
				}

			} else if (inputStrArray[j].equalsIgnoreCase("a")) {

				index = binarySearch(num[j], 0, length - 1, intArr);

				if (index >= 0) {
					if (intArr[index] < num[j]) {
						for (int k = intArr.length - 2; k >= index + 1; k--) {
							intArr[k + 1] = intArr[k];
						}
						intArr[index + 1] = num[j];
					} else {
						for (int k = intArr.length - 2; k >= index; k--) {
							intArr[k + 1] = intArr[k];
						}
						intArr[index] = num[j];
					}
				} else {
					if (intArr[-index] < num[j]) {
						for (int k = intArr.length - 2; k >= -(index - 1); k--) {
							intArr[k + 1] = intArr[k];
						}
						intArr[-(index - 1)] = num[j];
					} else {
						for (int k = intArr.length - 2; k >= -(index); k--) {
							intArr[k + 1] = intArr[k];
						}
						intArr[-(index)] = num[j];
					}
				}
				i++;
				if (i % 2 == 0) {
					if ((intArr[i / 2] + intArr[(i / 2) - 1]) % 2 != 0)
						System.out
								.println((intArr[i / 2] + intArr[(i / 2) - 1]) / 2f);
					else
						System.out
								.println((intArr[i / 2] + intArr[(i / 2) - 1]) / 2);

				} else {
					System.out.println(intArr[(int) Math.ceil(i / 2)]);
				}

			}
		}

	}

	public static void main(String[] args) throws IOException {

		Scanner snr = new Scanner(System.in);

		int num = snr.nextInt();
		String s[] = new String[num];
		long x[] = new long[num];

		for (int i = 0; i < num; i++) {
			s[i] = snr.next();
			x[i] = snr.nextInt();
		}

		Median med = new Median();
		med.process(s, x);
		/*
		 * long[] arr = { -1, 3, 3, 3, 4, 6, 9, 15, 26, Integer.MAX_VALUE }; int
		 * num = 26; int position = med.binarySearch(num, 0, 9, arr); if
		 * (position >= 0) { if (arr[position] < num) { for (int k = arr.length
		 * - 2; k >= position + 1; k--) { arr[k + 1] = arr[k]; } arr[position +
		 * 1] = num; } else { for (int k = arr.length - 2; k >= position; k--) {
		 * arr[k + 1] = arr[k]; } arr[position] = num; } } else { if
		 * (arr[-position] < num) { for (int k = arr.length - 2; k >= -(position
		 * - 1); k--) { arr[k + 1] = arr[k]; } arr[-(position - 1)] = num; }
		 * else { for (int k = arr.length - 2; k >= -(position); k--) { arr[k +
		 * 1] = arr[k]; } arr[-(position)] = num; } }
		 * 
		 * // // if(position >=0){ // for (int k = position; k < arr.length - 1;
		 * k++) { // arr[k] = arr[k + 1]; // } // arr[arr.length - 1] =
		 * Integer.MAX_VALUE; // } // System.out.println("Position to insert:: "
		 * + position);
		 * 
		 * // for (int k = position; k < arr.length - 1; k++) { // arr[k] =
		 * arr[k + 1]; // } // arr[arr.length - 1] = Integer.MAX_VALUE; for (int
		 * k = 0; k < arr.length; k++) System.out.println(arr[k]); //
		 * System.out.println("Last element.." + arr[arr.length-1]); // float a
		 * ; // // a= 3/2f; // System.out.println(3.500);
		 */
	}
}