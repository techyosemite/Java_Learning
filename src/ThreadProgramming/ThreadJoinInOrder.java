package ThreadProgramming;

class MyThreadName implements Runnable {

	String name;

	Thread t;

	int sleepInterval;

	MyThreadName(String name, Thread t, int sleepInterval) {
		this.name = name;
		this.t = t;
		this.sleepInterval = sleepInterval;
	}

	public void run() {

		System.out.println(name);
		try {
			Thread.sleep(sleepInterval);
			if (t != null)
				t.join();
			System.out.println("This thread just completed!!!" + name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class ThreadJoinInOrder {

	public static int count = 1;

	public static void main(String[] args) throws InterruptedException {

		Thread t2 = new Thread(new MyThreadName("Thread 2", null, 6000));
		Thread t1 = new Thread(new MyThreadName("Thread 1", t2, 5000));
		Thread t3 = new Thread(new MyThreadName("Thread 3", t1, 3000));

		t1.start();
		// t1.join();
		t2.start();
		// t2.join();
		t3.start();
		// t3.join();
		System.out.println("All thread started!!");
	}
}
