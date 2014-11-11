package Concurrency;

public abstract class IntGenerator {
	private volatile boolean canceled = false;
	public abstract int next();
	public void cancel() {
		this.canceled = true;
	}
	public boolean isCanceled() {
		return this.canceled;
	}
}
