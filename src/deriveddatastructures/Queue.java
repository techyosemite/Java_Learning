package deriveddatastructures;

public class Queue {

	Node front, rear;

	public void enqueue(Object item) {

		Node n = new Node(item);

		if (front == null) {
			rear = n;
			front = rear;
		} else {
			rear.next = n;
			rear = n;
		}
	}

	public Object dequeue() {

		if (front == null) {
			return null;
		} else {
			Object item = front.item;
			front = front.next;
			return item;
		}
	}

	public static void main(String[] args) {
		Queue q = new Queue();
		q.enqueue("Nitin");
		q.enqueue("Karan");
		q.enqueue("Rahul");
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

	}
}
