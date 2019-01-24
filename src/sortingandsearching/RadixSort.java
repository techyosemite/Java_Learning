package sortingandsearching;

public class RadixSort {

	public static void radixSort(int[] arr, int radix) {
		int m, n, tempMod, tempQuotient, k;

		m = 10;
		n = 1;
		class TempNode {

			int value;

			TempNode next;

			public TempNode(int value) {

				this.value = value;
			}

		}

		TempNode[] list = new TempNode[10];

		for (int i = 0; i < radix; i++) {

			for (int q = 0; q < arr.length; q++) {

				tempMod = arr[q] % m;
				tempQuotient = tempMod / n;

				TempNode listNode = list[tempQuotient];

				if (listNode == null) {
					TempNode node = new TempNode(arr[q]);
					list[tempQuotient] = node;
				} else {
					TempNode previous = null;
					while (listNode != null) {
						previous = listNode;
						listNode = listNode.next;
					}
					previous.next = new TempNode(arr[q]);
				}
			}

			m = m * 10;

			n = n * 10;

			k = 0;

			for (int h = 0; h < list.length; h++) {
				TempNode innerList = list[h];
				while (innerList != null) {
					arr[k] = innerList.value;
					innerList = innerList.next;
					k++;
				}
				list[h] = null;
			}

		}

		System.out.println("Sorted array ..");
		for (int z = 0; z < arr.length; z++) {
			System.out.println(arr[z]);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 9, 179, 139, 38, 10, 5, 36 };

		radixSort(arr, 3);
	}
}
