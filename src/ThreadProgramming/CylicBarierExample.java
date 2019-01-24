package ThreadProgramming;

/*
 * Points to be noted before referring to the Cyclic Barrier Synchronizer
 * The waiting threads waits at the CyclicBarrier until either:
 * 1. The last thread arrives (calls await() )
 * 2. The thread is interrupted by another thread (another thread calls its interrupt() method)
 * 3. Another waiting thread is interrupted
 * 4. Another waiting thread times out while waiting at the CyclicBarrier.
 * 5. The CyclicBarrier.reset() method is called by some external thread.
 */
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class MyBarrierRunnable implements Runnable {

	int sleepInterval;

	CyclicBarrier barrier;

	String name;

	MyBarrierRunnable(int sleepInterval, CyclicBarrier barrier, String name) {
		this.sleepInterval = sleepInterval;
		this.barrier = barrier;
		this.name = name;
	}

	@Override
	public void run() {

		try {
			System.out.println("Inside run of - " + name);
			Thread.sleep(sleepInterval);
			System.out.println("Calling await on -- " + name);
			barrier.await();
			barrier.reset();
			System.out.println("Await over on -- " + name);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

public class CylicBarierExample {

	public static void main(String[] args) {

		CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {

			@Override
			public void run() {
				System.out.println("Both barriers are completed!!");
			}
		});

		MyBarrierRunnable barrier1 = new MyBarrierRunnable(3000, barrier,
				"Thread 1");
		MyBarrierRunnable barrier2 = new MyBarrierRunnable(5000, barrier,
				"Thread 2");

		Thread t1 = new Thread(barrier1);
		Thread t2 = new Thread(barrier2);

		t1.start();
		t2.start();
		// try {
		// Thread.sleep(3000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// t1.interrupt();
	}
}
