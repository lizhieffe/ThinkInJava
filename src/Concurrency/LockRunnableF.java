package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LockRunnableF implements Runnable {

	private LockTest lockTest;
	
	public LockRunnableF(LockTest test) {
		this.lockTest = test;
	}
	
	@Override
	public void run() {
		while (true)
			this.lockTest.f();
	}

	public static void main(String[] args) {
		LockTest lockTest = new LockTest();
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(new LockRunnableF(lockTest));
		es.execute(new LockRunnableG(lockTest));
	}
}
