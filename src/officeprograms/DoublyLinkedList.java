package officeprograms;

public class DoublyLinkedList {

	public static DoublyLinkedNode HEAD;

	public static DoublyLinkedNode TAIL;

	void isLinkedListPalindrome() {

		DoublyLinkedNode first;
		DoublyLinkedNode last;
		first = this.HEAD;
		last = this.TAIL;
		int flag = 0;
		while (first != last && first.getPreveNode() != last) {

			if (first.getKey() != last.getKey()) {
				flag = 1;
				break;
			}
			first = first.getNextNode();
			last = last.getPreveNode();
		}

		if (flag == 1) {
			System.err.println("List is not Palidrome..");
		} else
			System.err.println("List is Palidrome..");
	}

	public static void main(String[] args) {

		DoublyLinkedNode node1 = new DoublyLinkedNode(1);
		DoublyLinkedNode node2 = new DoublyLinkedNode(2);
		DoublyLinkedNode node3 = new DoublyLinkedNode(3);
		
		DoublyLinkedNode node4 = new DoublyLinkedNode(22);
		DoublyLinkedNode node5 = new DoublyLinkedNode(1);

		node1.setNextNode(node2);
		node2.setNextNode(node3);
		node3.setNextNode(null);

//		node3.setNextNode(node4);
//		node4.setNextNode(node5);
//		node5.setNextNode(null);
		

		node1.setPrevNode(null);
		node2.setPrevNode(node1);
		node3.setPrevNode(node2);
//		node4.setPrevNode(node3);
//		node5.setPrevNode(node4);

		DoublyLinkedList list = new DoublyLinkedList();
		list.HEAD = node1;
		list.TAIL = node5;
//		list.isLinkedListPalindrome();

	}

}
