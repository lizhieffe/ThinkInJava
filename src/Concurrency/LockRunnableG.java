package Concurrency;

public class LockRunnableG implements Runnable {
	
	private LockTest lockTest;
	
	public LockRunnableG(LockTest test) {
		this.lockTest = test;
	}
	
	public void run() {
		while (true)
			this.lockTest.g();
	}
}
