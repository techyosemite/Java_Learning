package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Union {

	public static void doUnion(int[] arr1, int[] arr2) {

		Set<Integer> hashSet = new HashSet<Integer>();
		ArrayList<Integer> arrList = new ArrayList<Integer>();

		if (arr1.length < arr2.length) {
			for (int i = 0; i < arr1.length; i++) {
				if (!hashSet.contains(arr1[i])) {
					hashSet.add(arr1[i]);
					arrList.add(arr1[i]);
				}
			}
			for (int j = 0; j < arr2.length; j++) {
				if (!hashSet.contains(arr2[j])) {
					hashSet.add(arr2[j]);
					arrList.add(arr2[j]);
				}
			}

		} else {
			for (int i = 0; i < arr2.length; i++) {
				if (!hashSet.contains(arr2[i])) {
					hashSet.add(arr2[i]);
					arrList.add(arr2[i]);
				}
			}
			for (int j = 0; j < arr1.length; j++) {
				if (!hashSet.contains(arr1[j])) {
					hashSet.add(arr2[j]);
					arrList.add(arr1[j]);
				}
			}
		}

		for (int i = 0; i < arrList.size(); i++) {
			System.out.println(arrList.get(i));
		}

	}

	public static void doIntersection(int[] arr1, int[] arr2) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		ArrayList<Integer> arrList = new ArrayList<Integer>();

		if (arr1.length < arr2.length) {

		}
	}

	public static void merge(int[] a, int[] b, int size_a, int size_b) {

		int i, j, k;

		i = size_a - 1;
		j = size_b - 1;
		k = a.length - 1;
		while (j >= 0 && i >=0) {
			if (a[i] > b[j]) {
				a[k] = a[i];
				i--;
			} else {
				a[k] = b[j];
				j--;
			}
			k--;
		}

		if(i < 0){
			while(j >=0){
				a[k] = b[j];
				k--;
				j--;
			}
		}else{
			while(i >=0){
				a[k] = a[i];
				i--;
				k--;
			}
		}
		for (i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

	}

	public static void main(String[] args) {
		// int[] arr1 = { 1, 1, 1, 3, 3, 4, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
		// 9,
		// 9, 9, 9, 9, 10, 1111, };
		// int[] arr2 = { 1, 1, 1, 1, 5, 7, 9 };
		// Union.doUnion(arr1, arr2);
		int[] a = { 10, 11,12,13,14, 0, 0, 0, 0, 0 };
		int[] b = { 1,2,3,4,5};

		merge(a, b, 5, 5);

	}

}
