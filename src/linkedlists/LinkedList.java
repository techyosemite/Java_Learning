package linkedlists;

class NodeInt {
	int value;
	NodeInt next;
}

public class LinkedList {

	Node HEAD;

	public Node getHEAD() {
		return HEAD;
	}

	public void setHEAD(Node hEAD) {
		HEAD = hEAD;
	}

	public Node getTAIL() {
		return TAIL;
	}

	public void setTAIL(Node tAIL) {
		TAIL = tAIL;
	}

	Node TAIL;

	public LinkedList(Node HEAD, Node TAIL) {
		this.HEAD = HEAD;
		this.TAIL = TAIL;
	}

	public void traveseList() {
		Node n = this.HEAD;
		if (n == null) {
			System.out.println("List is empty..");
			return;
		}
		while (n != null) {
			System.out.println("Value at Node::" + n.getKey());
			n = n.getNext();
		}
	}

	public void swapEverySecondElement() {
		//
		// if(head == null || head.next == null)
		// return; It means that it had null or one element
		Node current, previous, previous2, next, temp;
		System.out.println("Inside swap...");

		current = previous = this.getHEAD();
		previous2 = previous;
		next = current.getNext();
		this.setHEAD(this.getHEAD().getNext());
		int i = 1;

		while (next != null) {// && current != null){
			i++;
			previous = current;
			current = next;
			next = next.getNext();
			if (i % 2 == 0) {

				previous2.setNext(current);
				current.setNext(previous);
				previous.setNext(next);
				temp = previous;
				previous = current;
				current = temp;

			}
			previous2 = previous;
		}
		this.setTAIL(current);
	}

	// Approach 1 - Swap the data keep the link as it is
	// Approach 2 - Change the links

	// Approach 1 recursively
	public static void pairWiseSwap(Node head) {

		if (head != null && head.next != null) {
			// Call swap method
			swap(head, head.next);

			// Cal the method recursively again
			pairWiseSwap(head.next.next);
		}
	}

	// Approach 1 - Iteratively swap the data with the next node

	// Approach 2 - Iteratively change the links

	public void swapPairWise(Node head) {

		if (head == null || head.next == null)
			return;

		Node first, second, previous = null, next;
		first = head;

		this.setHEAD(first.next);
		while (first != null && first.next != null) {
			second = first.next.next;
			next = first.next;
			first.next.next = first;
			first.next = second;
			if (previous != null)
				previous.next = next;
			previous = first;
			first = second;
		}

	}

	public static void swap(Node n1, Node n2) {
		String temp = n1.key;
		n1.key = n2.key;
		n2.key = temp;

	}

	public void reverseList() {

		Node n, n1, n2;
		n = this.HEAD;
		n1 = n.getNext();
		n2 = n1.getNext();
		this.TAIL = n;
		n.setNext(null);
		while (n1.getNext() != null) {
			n1.setNext(n);
			n = n1;
			n1 = n2;
			n2 = n2.getNext();
		}
		n1.setNext(n);
		this.HEAD = n1;
	}

	// This is good one & simple to explain
	public void reverseListUsingPrevious() {

		Node temp, current;
		Node previous = null;
		current = this.HEAD;
		while (current != null) {
			temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		this.HEAD = previous;
	}

	/*
	 * This requires 3 pointers any how. Approach 1 : Find the middle element
	 * and its previous. make previous to point to middle elements next element.
	 * 
	 * Approach 2 : Find the middle element and its next element. Copy the data
	 * from its next element to middle element and point middle elements next to
	 * its next element next.
	 */
	public static boolean deleteMiddleNode(LinkedList list) {

		if (list.HEAD == null)
			return false;
		if (list.HEAD.next == null) {
			list.HEAD = null;
			return false;
		}

		Node slow, fast, previous, next;

		slow = fast = previous = list.HEAD;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			previous = slow;
			slow = slow.getNext();
		}
		// next = slow.next;
		// slow.key = slow.next.key;
		// slow.next = slow.next.next;
		previous.next = slow.next;
		slow = null;

		return true;

	}

	// public static boolean deleteNode

	public void replaceKthCharacter(int k) {

		Node kthElementFromStart, slow, fast;
		slow = fast = this.getHEAD();

		if (slow == null || fast == null) {
			System.out.println("List is empty..");
			return;
		}

		int i;

		for (i = 1; i < k; i++) {
			fast = fast.getNext();
			if (fast == null) {
				System.out.println("List is of size:: " + i
						+ "  which is lesser then::" + k);
				return;
			}
		}

		kthElementFromStart = fast;

		while (fast != null && fast.getNext() != null) {
			fast = fast.getNext();
			slow = slow.getNext();
		}

		String tmpKey = kthElementFromStart.getKey();
		kthElementFromStart.setKey(slow.getKey());
		slow.setKey(tmpKey);

		this.traveseList();

	}

	/*
	 * This code is done used by iteration
	 */
	public static NodeInt sum(NodeInt head1, NodeInt head2) {

		if (head1 == null || head2 == null)
			return null;

		int sum, carry;
		sum = carry = 0;

		NodeInt head3 = null;
		NodeInt previous = null;

		while (head1 != null && head2 != null) {
			sum = head1.value + head2.value + carry;
			NodeInt n = new NodeInt();
			n.value = sum % 10;
			carry = sum / 10;
			if (head3 == null)
				head3 = n;
			if (previous != null)
				previous.next = n;
			previous = n;
			head1 = head1.next;
			head2 = head2.next;
		}
		return head3; // Returns the head of the 3rd linked list which contains
						// the sum
	}

	public static Node middleElement(Node head) {

		if (head == null)
			return null;
		if (head.next == null)
			return head;

		Node slow, fast;

		slow = fast = head;

		while (fast != null && fast.getNext() != null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		return slow;
	}

	public static boolean isLLEquals = true;
	public static int llLength1 = 0;
	public static int llLength2 = 0;

	public static void compareLinkedList(Node n1, Node n2) {

		if (n1 == null || n2 == null)
			return;

		if (n1.key != n2.key) {
			isLLEquals = false;
			return;
		} else {
			if (n1.next != null)
				llLength1++;
			if (n2.next != null)
				llLength2++;

			compareLinkedList(n1.next, n2.next);
		}

	}

	public static void main(String[] args) {

		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();
		Node n5 = new Node();
		Node n6 = new Node();
		Node n7 = new Node();

		n1.setKey("JAVA");
		n2.setKey("RUBY");
		n3.setKey("HTML");
		n4.setKey("C++");
		n5.setKey("C");
		n6.setKey("Obj C");
		n7.setKey("JavaScript");

		n1.setNext(n2);
		// n2.setNext(n3);
		n2.setNext(n3);

		n3.setNext(n4);
		// n3.setNext(null);

		n4.setNext(n5);
		// n4.setNext(null);

		n5.setNext(n6);
		n6.setNext(n7);
		n7.setNext(null);

		LinkedList list = new LinkedList(n1, n7);
		list.traveseList();
		// list.reverseList();
		// list.reverseListUsingPrevious();
		// System.out.println("Revers List...");
		// list.traveseList();
		// list.replaceKthCharacter(2);
		// pairWiseSwap(list.getHEAD());
		System.out.println("After swapping each 2 element..");
		// list.swapEverySecondElement();
		list.swapPairWise(list.getHEAD());
		list.traveseList();
		// System.out.println("Tail.." + list.getTAIL().getKey());
		// System.out.println("Head.." + list.getHEAD().getKey());
		// System.out.println("Middle element is ::" + middleElement(n1).key);
		// deleteMiddleNode(list);
		// System.out.println("After deleting the middle element.");
		// list.traveseList();

		Node n11 = new Node();
		Node n12 = new Node();
		Node n13 = new Node();

		Node m11 = new Node();
		Node m12 = new Node();
		Node m13 = new Node();
		Node m14 = new Node();

		n11.setKey("10");
		n12.setKey("20");
		n13.setKey("30");
		n11.setNext(n12);
		n12.setNext(n13);
		n13.setNext(null);

		m11.setKey("10");
		m12.setKey("20");
		m13.setKey("30");
		m14.setKey("40");
		m11.setNext(m12);
		m12.setNext(m13);
		m13.setNext(m14);

		// compareLinkedList(n11, m11);
		// if (isLLEquals && llLength1 == llLength2) {
		// System.out.println("The above Linked Lists are equal...");
		// } else
		// System.out.println("The above linked list are unequal...");
	}
}
