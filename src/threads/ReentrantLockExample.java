package threads;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

}

class Runner {
	 private int count = 0; 
	 private Lock lock = new ReentrantLock();
	 private Condition cond = lock.newCondition();
	 
	 private void increment(){
		 for (int i = 0; i< 1000 ; i++){
			 count++;
		 }
	 }
	 
	 private void firstThread() throws InterruptedException{
		 
		 lock.lock();
		 
		 System.out.println("Current thread is waiting !! ");
		 cond.await();// It is just like object.wait()
		 
		 try{
			 increment();
		 }finally{
			 lock.unlock();
		 }
	 }
	 
	 private void secondThread() throws InterruptedException{
		 
		 Thread.sleep(1000);
		 lock.lock();
		 
		 System.out.println("Press the return key :: ");
		 new Scanner(System.in).nextInt();
		 
		 cond.signal();// It is just like object.notify()
		 
		 try{
			 increment();
		 }finally{
			 lock.unlock();
		 }
	 }
}



