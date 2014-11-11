package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {

	private final IntGenerator generator;
	private final int id;
	private static int count = 0;
	
	public EvenChecker(IntGenerator generator) {
		this.generator = generator;
		this.id = ++count;
	}
	
	@Override
	public void run() {
		while (!generator.isCanceled()) {
			int tmp = generator.next();
			System.out.println("Runnable # " + id + " is running. tmp = " + tmp);
			if (tmp % 2 != 0) {
				generator.cancel();
				System.out.println(tmp + " is not even");
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		EvenGenerator generator = new EvenGenerator();
		for (int i = 0; i < 10; i++) {
			es.execute(new EvenChecker(generator));
		}
	}
}
