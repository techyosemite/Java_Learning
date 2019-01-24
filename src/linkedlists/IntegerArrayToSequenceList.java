package linkedlists;

class LinkedListNode {
	String sequeunce;
	LinkedListNode next;
}

public class IntegerArrayToSequenceList {

	public static void main(String[] args) {

		int[] inputArray = { 1, 3, 4, 5, 8, 9, 11, 13, 14, 15, 16, 20, 23, 30,
				31, 32 };

		LinkedListNode head = null;
		LinkedListNode current = new LinkedListNode();
		head = current;

		StringBuffer strBuf = new StringBuffer();

		for (int i = 0; i < inputArray.length; i++) {

			if (i + 1 < inputArray.length
					&& inputArray[i] == inputArray[i + 1] - 1)
				strBuf.append(inputArray[i] + ",");
			else {
				strBuf.append(inputArray[i]);
				current.sequeunce = strBuf.toString();
				strBuf.delete(0, strBuf.length());
				LinkedListNode temp = new LinkedListNode();
				current.next = temp;
				current = temp;
			}
		}
		while (head != null) {
			if (head.sequeunce != null)
				System.out.println(head.sequeunce);
			head = head.next;
		}
	}
}
