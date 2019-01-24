package officeprograms;

public class Node {
	
	String key;
	
	Node next;
	

	public void setKey(String key) {
		this.key = key;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	
	
	public String getKey(){
		return this.key;
	}
	

	public Node getNext(){
		return this.next;
	}
	
}
