package deriveddatastructures;

class NodeWithMin {

	Object item;
	int min;
	NodeWithMin next;

	NodeWithMin(Object item, int min) {
		this.item = item;
		this.min = min;
	}

}

public class StackWithMin {

	NodeWithMin top;

	public void push(int value) {

		int newMin = Math.min(value, min());
		NodeWithMin n = new NodeWithMin(value, newMin);
		n.next = top;
		top = n;
	}

	public NodeWithMin pop() {
		if (top != null) {
			NodeWithMin n = top;
			top = top.next;
			return n;
		}
		return null;
	}

	public int min() {
		if (top == null) {
			return Integer.MAX_VALUE;
		} else
			return top.min;
	}

	public static void main(String[] args) {
		StackWithMin st = new StackWithMin();
		st.push(90);
		st.push(20);
		st.push(30);
		st.push(1);

		System.out.println(st.min());
		st.pop();
		System.out.println(st.min());
		st.pop();
		System.out.println(st.min());
		st.pop();
		System.out.println(st.min());



		
	}

}
