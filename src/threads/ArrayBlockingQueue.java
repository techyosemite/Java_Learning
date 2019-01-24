package threads;

import java.util.LinkedList;
import java.util.Random;

public class ArrayBlockingQueue {

	private LinkedList<Integer> list = new LinkedList<Integer>();
	
	private int SIZE;
	
	private Object lock;
	
	public ArrayBlockingQueue(int size) {
		this.SIZE = size;
		lock = new Object();
	}
	
	public void take() throws InterruptedException{
		
		Random random = new Random();
		
		while(true){

			//Lock before accessing the list. 
			synchronized (lock) {
				
				//If the list does not contain any data
				while(list.size() == 0){
					lock.wait();
				}
				
				System.out.println("List size is  : "  + SIZE);
				int value = list.removeFirst();
				System.out.println("Removed value : " + value);
				lock.notify();
				
			}
			
			//Put the thread to sleep and wake up every second to take the value from the list. 
			Thread.sleep(random.nextInt(1000));
		}
		
	}
	
	public void put(Integer value) throws InterruptedException{
		
		while(true){
			
			synchronized (lock) {
			
				//If the size is equal to the limit of the BlockingQueue then wait.
				while(list.size() == SIZE){
					lock.wait();
				}
				
				System.out.println("List size is : " + SIZE);
				list.add(value);
				
				lock.notify();
						
			}
			 
		}
	}
}
