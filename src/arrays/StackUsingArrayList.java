package arrays;

import java.util.ArrayList;

class StackUsingArrayList<T> {

	private int size;

	private int currentIndex;

	private ArrayList<T> arrayList;

	StackUsingArrayList(int size) {

		this.arrayList = new ArrayList<T>(size);

		this.currentIndex = -1;

		this.size = size;

	}

	public void push(T obj) throws Exception {
		if (this.arrayList.size() == this.size)
			throw new Exception("Size full!! ");

		this.arrayList.add(currentIndex + 1, obj);

		currentIndex += 1;
	}

	public T pop() throws Exception {

		if (currentIndex == -1)
			throw new Exception("Stack is empty !!");

		T obj = arrayList.remove(currentIndex);

		currentIndex -= 1;

		return obj;

	}

	public int getSize() {

		return currentIndex;
	}

	@Override
	public String toString() {
		return "StackUsingArrayList [size=" + size + ", currentIndex=" + currentIndex + ", arrayList=" + arrayList
				+ "]";
	}

	public static void main(String[] args) throws Exception {

		StackUsingArrayList<Integer> stack = new StackUsingArrayList<>(5);

		stack.push(new Integer(10));

		stack.push(new Integer(20));

		stack.push(new Integer(30));
		
		stack.push(new Integer(40));
		
		stack.push(new Integer(50));
		
		stack.pop();

		stack.pop();

		System.out.println(stack);

	}

}
