package officeprograms;

import java.util.HashMap;
import java.util.Map;

public class LinkedList {

	Node HEAD;
	Node TAIL;

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

	LinkedList(Node HEAD, Node TAIL) {
		this.HEAD = HEAD;
		this.TAIL = TAIL;
	}

	public void traverseList() {

		Node x = this.getHEAD();

		while (x != null) {
			System.out.println("Node Value ::" + x.getKey());
			x = x.next;

		}
	}

	public static void deleteDups(Node n) {

		if (n == null)
			return;

		Map<String, Integer> map = new HashMap<String, Integer>();

		Node previous = null;
		while (n != null) {
			if (map.containsKey(n.key)) {
				previous.next = n.next;
			} else {
				map.put(n.key, 1);
				previous = n;
			}
			n = n.next;

		}
	}

	public void swapEverySecondElement() {

		Node current, previous, previous2, next, temp;

		current = previous = this.getHEAD();

		previous2 = previous;

		next = current.getNext();

		// here check the case if the linkedlist contains only one element. In that case just return the list as it is.
		this.setHEAD(this.getHEAD().getNext());

		int i = 1;

		while (next != null) {

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

	// This solution doesn't work properly
	public void swapEveryKthElement(int k) {

		Node current, previous, previous2, next, temp;

		current = previous = this.getHEAD();

		for (int i = 0; i < k - 1; i++) {
			previous = current;
			current = current.getNext();
		}

		System.out.println("Current Node Key ::" + current.getKey());
		// current = current.getNext();
		previous2 = previous;

		next = current.getNext();

		if (k == 2)
			this.setHEAD(current);

		int j = 1;

		while (next != null) {

			j++;

			// previous = current;
			//
			// current = next;
			//
			// next = next.getNext();

			if (j % k == 0) {

				previous2.setNext(current);

				current.setNext(previous);

				previous.setNext(next);

				temp = previous;

				previous = current;

				current = temp;

			}
			previous = current;
			current = next;
			next = next.getNext();
			previous2 = previous;

		}

		// this.setTAIL(current);

	}

	public static void printKthLastElementFromLast(Node head, int k) {

		Node fast, slow;
		fast = slow = head;

		int flag = 0;
		for (int i = 2; i <= k; i++) {
			if (fast.next == null) {
				flag = 1;
				break;
			}
			fast = fast.next;
		}
		if (flag == 1) {
			System.out
					.println("Size of Linked list is less than the size of the "
							+ k + " element.");
			return;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		System.out.println("The kth last element from last is ::" + slow.key);
	}

	/*
	 * This method will also compute the size of the linked list
	 */
	public void middleElement() {

		Node first, second;
		int i = 0;
		int size;

		first = this.getHEAD();
		second = this.getHEAD().getNext();

		while (second != null && second.next != null) {
			i++;
			first = first.next;
			second = second.next.next;
		}
		System.out.println("i " + i);
		System.out.println("Element in the middle :: " + first.getKey());
		if (i % 2 == 0) {
			size = (i * 2) + 1;
			System.out.println("Size of the List::" + size);
		} else {
			size = i * 2 + 2;
			System.out.println("Size of the List::" + size);
		}

	}

	public static void nthLastElement(LinkedList list, int n) {

		Node last, nthlast;
		last = nthlast = list.HEAD;
		int j = 1;
		int size;

		while (last.getNext() != null && last != null) {
			last = last.getNext();
			j++;
			nthlast = nthlast.getNext();
		}
		size = j + n - 1;
		System.out.println("j::" + j);
		System.out.println("size::" + size);
		System.out.println("Third Last Element::" + nthlast.getKey());

	}

	public static void main(String[] args) {

		Node n8 = new Node();
		Node n7 = new Node();
		Node n6 = new Node();
		Node n5 = new Node();
		Node n4 = new Node();
		Node n3 = new Node();
		Node n2 = new Node();
		Node n1 = new Node();

		n1.setKey("RUBY");
		n2.setKey("JAVA");
		n3.setKey("C++");
		n4.setKey("HTML");
		n5.setKey("C");
		n6.setKey("JAVASCRIPT");
		n7.setKey("Obj C");
		n8.setKey("ORACLE");

		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n7);
		n7.setNext(null);
		n8.setNext(null);

		LinkedList l = new LinkedList(n1, n7);
		// traverseList(l);
		// l.middleElement();
		// nthLastElement(l, 3);

		l.traverseList();
		l.swapEverySecondElement();
		// l.swapEveryKthElement(2);
		System.out.println("After swap..");

		l.traverseList();
		// printKthLastElementFromLast(n1, 2);
		// l.middleElement();

	}
}
