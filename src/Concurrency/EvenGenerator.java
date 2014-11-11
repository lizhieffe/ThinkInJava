package Concurrency;

public class EvenGenerator extends IntGenerator {
	
	private int val = 0;
	synchronized public int next() {
		val++;
		Thread.yield();
		val++;
		return this.val;
	}
}
