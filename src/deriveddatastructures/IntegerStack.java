package deriveddatastructures;

public class IntegerStack {

	IntegerNode top;

	public void push(Integer num) {

		int newMin = Math.min(num, min());

		IntegerNode n = new IntegerNode(num, newMin);

		n.next = top;

		top = n;
	}

	public int min() {
		if (top == null)
			return Integer.MAX_VALUE;
		else
			return top.minValue;

	}

	public Object pop() {

		if (top != null) {
			Integer item = top.value;
			top = top.next;
			return item;
		}
		return null;
	}

	public static void main(String[] args) {

		IntegerStack st = new IntegerStack();

		st.push(90);
		st.push(45);
		st.push(100);
		st.push(20);
		System.out.println(st.min());
		st.pop();
		System.out.println(st.min());
		st.pop();
		System.out.println(st.min());
		st.pop();
		System.out.println(st.min());
		st.pop();
		System.out.println(st.min());

		

	}
}
