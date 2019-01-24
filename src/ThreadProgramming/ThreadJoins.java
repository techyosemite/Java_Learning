package ThreadProgramming;

import java.util.concurrent.ArrayBlockingQueue;

//class TestRunnable implements Runnable {
//
//	String name;
//	TestRunnable t;
//
//	TestRunnable(String name, Thread t) {
//		this.name = name;
//		this.t = t;
//	}
//
//	@Override
//	public void run() {
//
//		if (t != null)
//			try {
//				t.join();
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		System.out.println("Inside thread :: " + name);
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//}

class MyNewThread extends Thread {

	String name;
	MyNewThread t;

	MyNewThread(String name, MyNewThread t) {

		this.name = name;
		this.t = t;
	}

	@Override
	public void run() {
		System.out.println("Entry 1 for thread ::" + name);
		if (t != null)
			try {
				t.join();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.println("Inside thread :: " + name);
		try {
			Thread.sleep(5000);
			Thread.dumpStack();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

public class ThreadJoins {

	public static void main(String[] args) throws InterruptedException {

		MyNewThread th2 = new MyNewThread("T2", null);
		MyNewThread th1 = new MyNewThread("T1", th2);
		MyNewThread th3 = new MyNewThread("T3", th1);
		th2.start();
		th1.start();
		th3.start();
		ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(10);
		q.add(10);
		q.remove();
	}

}
