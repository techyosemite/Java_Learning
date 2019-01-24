package officeprograms;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {
	
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

	public ReverseLinkedList(Node HEAD,Node TAIL) {
		this.HEAD = HEAD;
		this.TAIL = TAIL;
		}
	
	public void traveseList(){

		Node n = this.HEAD;

		while(n != null){
		System.out.println("Value at Node::" + n.getKey());
		n = n.getNext();
		}
		}
	
	public List<String> reverseList(){

		Node n,n1,n2;
		n = this.HEAD;
		n1 = n.getNext();
		n2 = n1.getNext();
		List<String> strArrayList = new ArrayList<String>();
		int i = 0;
		
		this.TAIL = n;	
		n.setNext(null);
		
		while(n1.getNext() != null){
		strArrayList.add(i,n.getKey());
		n1.setNext(n);
		n = n1;
		n1 = n2;
		n2 = n2.getNext();
		i++;
		}
		
		strArrayList.add(i,n.getKey());
		i++;
		
		strArrayList.add(i,n1.getKey());
		
		n1.setNext(n);
		this.HEAD = n1;
		return strArrayList;
		}
	
	
	public boolean isPalindrome(List<String> listOfArray){
		
		int i = 0 ;
		Node n = this.HEAD;
		while(n!=null){
			if(!listOfArray.get(i).equals(n.getKey())){
				System.out.println("List is not palidrome..");
				return false;
			}
			i++;
			n = n.getNext();
		}
		System.out.println("List is palindrome..");
		return true;
	}
	
	//This also works
	public void reverseListNew(){
		 
		Node current = this.getHEAD();
		Node first = null;
		Node save = null;
		
		this.setTAIL(this.getHEAD());
		
		while(current != null){
			save = current;
			current = current.getNext();
			save.next = first;
			first = save;
		}
		
		this.setHEAD(save);
		
		
	}
	public static void main(String[] args) {

		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();
		Node n5 = new Node();
		Node n6 = new Node();

		n1.setKey("JAVA");
		n2.setKey("RUBY");
		n3.setKey("HTML");
		n4.setKey("ORACLE");
		n5.setKey("C++");
		n6.setKey("C");

		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(null);

		ReverseLinkedList list = new ReverseLinkedList(n1, n6);
		list.traveseList();
//		list.reverseList(); // Reverse the list
		System.out.println("Revers List...");
		list.reverseListNew();
		list.traveseList();
		list.isPalindrome(list.reverseList());
		}
}
