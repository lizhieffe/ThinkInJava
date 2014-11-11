package Concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	Lock lock = new ReentrantLock();
	
	public void f() {
		try {
			lock.lock();
			System.out.println("f is running");
			Thread.sleep(100);
		}
		catch (Exception e) {
			
		}
		finally {
			lock.unlock();
		}
	}
	
	public void g() {
		boolean success = false;
		try {
			success = lock.tryLock();
			Thread.sleep(50);
			System.out.println("g try to lock: " + success);
		}
		catch (Exception e) {
			
		}
		finally {
			if (success)
				lock.unlock();
		}
	}
}
