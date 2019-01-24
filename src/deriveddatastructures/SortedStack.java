package deriveddatastructures;

import java.util.Iterator;
import java.util.Stack;

public class SortedStack {

	public static Stack<Integer> sort(Stack<Integer> st) {

		if (st == null)
			return null;
		Stack<Integer> newSt = new Stack<Integer>();

		while (!st.isEmpty()) {
			int temp = st.pop();

			while (!newSt.isEmpty() && newSt.peek() > temp) {
				st.push(newSt.pop());
			}
			newSt.push(temp);
		}
		return newSt;

	}

	public static void main(String[] args) {

		Stack<Integer> st = new Stack<Integer>();
		st.push(20);
		st.push(10);
		st.push(90);
		st.push(80);
		st.push(1);

		Stack<Integer> sortedStack = sort(st);
		System.out.println(sortedStack.pop());
		for (Iterator iterator = sortedStack.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);

		}


	}

}
