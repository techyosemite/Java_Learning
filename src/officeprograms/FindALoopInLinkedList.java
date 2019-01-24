package officeprograms;

public class FindALoopInLinkedList {

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

	public FindALoopInLinkedList(Node HEAD, Node TAIL) {

		this.HEAD = HEAD;
		this.TAIL = TAIL;
	}

	public void findLoop() {

		Node hare, tortoise;
		
		if(this.getHEAD() == null || this.getHEAD().getNext() == null){
			System.out.println("Head or next element after head is NULL");
			return;
		}
		
		if(this.getHEAD().getNext().getNext() == null){
			System.out.println("Linked list doesn't contain Cycle..");
			return ;
		}
		
		hare = this.getHEAD().getNext().getNext();
		
		tortoise = this.getHEAD().getNext();
		
		int noOfNodes = 3;
		
		while (hare != tortoise && hare != null && hare.getNext() != null
				&& hare.getNext().getNext() != null) {
			hare = hare.getNext().getNext();
			noOfNodes+=2;
			tortoise = tortoise.getNext();

		}

//		System.out.println("NoOfNodes::" + noOfNodes);
		
		if (hare == tortoise){
			System.out.println("There is a loop in Linked List");
			hare = this.getHEAD();
			
			int lengthOfPathFromHeadTotheStartingPoint = 0;
			
			while (tortoise != hare) {
				hare = hare.getNext();
				tortoise = tortoise.getNext();
				lengthOfPathFromHeadTotheStartingPoint++;
			}
			
			System.out.println("Cycle starts at Node::" + tortoise.getKey());
			System.out
					.println("Length of the path from the Node where cycle starts::"
							+ lengthOfPathFromHeadTotheStartingPoint);
			
			//Find the length of the cycle and the length of the path from start node
			int lengthOfCycle = 1;
			tortoise = tortoise.getNext();
			while(tortoise!=hare){
				tortoise = tortoise.getNext();
				lengthOfCycle++;
			}
			
			System.out.println("Length of the cyle::" + lengthOfCycle);
			int numberOfNodesInList = lengthOfCycle + lengthOfPathFromHeadTotheStartingPoint;
			System.out.println("Number of Node in the list::" + numberOfNodesInList);
		}
		else{
			System.out.println("There is no loop in Linked List");
			System.out.println("Number of Nodes in Linked List::" + noOfNodes);
		}


	}
	public void findAndFixLoop(){
		
		
	}
	
	public static void main(String[] args) {

		Node n1, n2, n3, n4, n5, n6, n7;
		n1 = new Node();
		n2 = new Node();
		n3 = new Node();
		n4 = new Node();
		n5 = new Node();
		n6 = new Node();
		n7 = new Node();

		n1.setKey("1");
		n2.setKey("2");
		n3.setKey("3");
//		n4.setKey("4");
//		n5.setKey("5");
//		n6.setKey("6");
//		n7.setKey("7");

		n1.setNext(n2);
		n2.setNext(n3);
		
		n3.setNext(n1);
//		n4.setNext(n5);
//		n5.setNext(n6);
//		n6.setNext(n7);
//		 n7.setNext(n3);
//		n7.setNext(null);

		FindALoopInLinkedList list = new FindALoopInLinkedList(n1, n3);
		list.findLoop();

	}
}
