package deriveddatastructures;

public class Stack {

	Node top;

	public void push(Object item) {

		Node t = new Node(item);
		t.next = top;
		top = t;
	}

	public Object pop() {

		if (top != null) {
			Object item = top.item;
			top = top.next;
			return item;
		}
		return null;
	}

	public static void main(String[] args) {
		Stack st = new Stack();
		st.push("Nitin");
		st.push("Karan");
		st.push("Rahul");
		st.push(20);
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
	}
}
