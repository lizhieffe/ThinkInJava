package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestRunnable implements Runnable {

	private int i = 10;
	private int id;
	private static int globalCount = 0;
	
	public TestRunnable() {
		this.id = ++globalCount;
	}
	
	@Override
	public void run() {
		while (i >= 1) {
			String output = "Thread # " + id + " is working. i = " + i;
			System.out.println(output);
			i--;
		}
		System.out.println("Testrunnable finishes\n");
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 5; i ++) {
			Thread t = new Thread(new TestRunnable());
			t.start();
			System.out.println("main started");
		}
		
		ExecutorService es = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i ++) {
			es.execute(new TestRunnable());
			System.out.println("main started again");
		}
		es.shutdown();
	}
}
