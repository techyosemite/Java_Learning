package callable;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class RunnableThread extends Thread {

	boolean isRunning;
	RunnableThread(){
		this.isRunning = true;
	}
	public void run() {
		while (this.isRunning) {
			System.out.println("Inside Run of the thread..");
			TestCallable.staticIntValue ++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	void stopThread(){
		this.isRunning = false;
	}
	
}
public class TestCallable {

	public static int staticIntValue = 10;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		RunnableThread t = new RunnableThread();
//		t.start();
//		Thread.sleep(1000);
//		t.stopThread();
//		t.join();
		ExecutorService pool = Executors.newFixedThreadPool(3);
		 Set<Future<Integer>> set = new HashSet<Future<Integer>>();
		 TestCallableImpl obj = new TestCallableImpl();
		 System.out.println("Thread group count --" + Thread.currentThread().getThreadGroup().activeCount());
		Future<Integer> FutObj =  pool.submit(obj);
		set.add(FutObj);
		 System.out.println("Thread group count --" + Thread.currentThread().getThreadGroup().activeCount());
 		System.out.println("future Object gett -- " + FutObj.get());

	}
	
}
class  TestCallableImpl implements Callable<Integer>{
	@Override
	public Integer call() throws Exception {
		System.out.println("Inside call of the callable");
		return new Integer(10);
	}
}
