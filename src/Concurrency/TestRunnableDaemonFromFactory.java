package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestRunnableDaemonFromFactory implements Runnable {

	private final int id;
	private static int globalCount = 0;
	
	public TestRunnableDaemonFromFactory() {
		this.id = ++globalCount;
	}
	
	@Override
	public void run() {
		while (true) {
			System.out.println("thread id = " + id + " is running");
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool(new DaemonThreadFactory());
		for (int i = 0; i < 5; i ++) {
			es.execute(new TestRunnableDaemonFromFactory());
		}
		
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
