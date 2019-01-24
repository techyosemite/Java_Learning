package ThreadProgramming;

interface TestInterface {
	void test();
}
class KaranRunnable implements Runnable {

	@Override
	public void run() {

		System.out
				.println("Inside the run method of the Runnable interface !!");
	}

}

class KaranThread extends Thread {

	Runnable target;

	KaranThread(Runnable target) {
		this.target = target;
	}

	@Override
	public void run() {
		System.out.println("Starting thread...");
		target.run();
		System.out.println("Completing thread..");
	}
}

public class MultipleCallToStart extends Thread {

	public static void main(String[] args) throws InterruptedException {

		Thread t = new KaranThread(new KaranRunnable());
		t.run();
		t.run();
		System.out.println("Starting a thread!!");

		t.start();

	}
}
