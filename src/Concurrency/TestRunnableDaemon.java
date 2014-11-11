package Concurrency;

import java.util.concurrent.TimeUnit;

public class TestRunnableDaemon implements Runnable {

	private int globalCount = 0;
	private int id;
	
	public TestRunnableDaemon() {
		this.id = ++globalCount;
	}
	
	@Override
	public void run() {
		while (true) {
			System.out.println("thread " + id + " is running");
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("main starts");
		for (int i = 0; i < 5; i ++) {
			Thread t = new Thread(new TestRunnableDaemon());
			t.setDaemon(true);
			t.start();
		}
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
