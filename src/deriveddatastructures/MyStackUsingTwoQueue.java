package deriveddatastructures;

import java.util.LinkedList;
import java.util.Queue;

class MyStackUsing2Queues<T>{
	
	Queue<T> q1;
	Queue<T> q2;
	
	MyStackUsing2Queues(){
		 this.q1 = new LinkedList<T>();
		 this.q2 = new LinkedList<T>();
	}
	
	
	public T pop(){
		
		if(q1.isEmpty())
			return null;
		
		return q1.remove();
	}
	
	public void push(T obj){
		
		Queue<T> tempQueue = new LinkedList<T>();
		q2.add(obj);
		
		while(!q1.isEmpty()){
			
			T temp = q1.remove();
			
			q2.add(temp);
			
		}
		tempQueue = q1;
		q1 = q2;
		q2 = tempQueue;
	}
	
	
	public T top(){
		
		if(this.q1.isEmpty())
			return null;
		
		return this.q1.peek();
		
	}
}
public class MyStackUsingTwoQueue {
	
	public static void main(String[] args) {
	
		MyStackUsing2Queues<Integer> stack = new MyStackUsing2Queues<Integer>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println(stack.pop());
		
	}
	
		
}

