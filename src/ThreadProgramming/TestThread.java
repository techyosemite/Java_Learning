package ThreadProgramming;

class TestThreadRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++){
			System.out.println("Inside run of a thread.." + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}

class TestThreadOne extends Thread{
	
	public void run(){
		for (int i = 100; i < 200; i++){
			System.out.println("Inside run of a thread.." + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

public class TestThread {
	public static void main(String[] args) {
		Thread t1 = new Thread(new TestThreadRunnable());
		t1.start();
		System.out.println(t1.getPriority());
		 
		TestThreadOne threadOne = new TestThreadOne();
		threadOne.start();
	}

}
