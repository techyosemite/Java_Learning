package officeprograms;

public class DoublyLinkedNode {

	public int key;
	
	public DoublyLinkedNode prev;
	
	public DoublyLinkedNode next;
	

	public DoublyLinkedNode(int key) {
		this.key = key;
	}
	
	public void setPrevNode(DoublyLinkedNode node){
		this.prev = node;
	}
	
	public void setNextNode(DoublyLinkedNode node){
		this.next= node;
	}
	
	public DoublyLinkedNode getPreveNode() {
		return this.prev;
	}
	
	public DoublyLinkedNode getNextNode() {
		return this.next;
	}
	
	public int getKey(){
		return key;
	}
	
}
