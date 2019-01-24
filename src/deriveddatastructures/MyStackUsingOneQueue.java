package deriveddatastructures;

import java.util.LinkedList;
import java.util.Queue;

class MyStack<T>{
	
	Queue<T> q;
	
	MyStack(){
		 this.q= new LinkedList<T>();
	}
	
	
	public T pop(){
		
		if(q.isEmpty()){
			return null;
		}
		
		return this.q.remove();
			
	}
	
	public void push(T obj){
		
		int size  = this.q.size();
		
		q.add(obj);
		
		for(int i =0 ; i< size; i++){
			T temp = this.q.remove();
			this.q.add(temp);
		}
	}
	
	
	public T top(){
		
		if(this.q.isEmpty())
			return null;
		
		return this.q.peek();
		
	}
}
public class MyStackUsingOneQueue {

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
