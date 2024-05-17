package ethz.ch.pp.assignment3.counters;

//TODO: implement
public class SynchronizedCounter implements Counter {
	
	private int value;
	Thread before = null;
	
	
	public SynchronizedCounter() {
		this.value = 0;
	}
	
	@Override
	public synchronized void increment() {
		//TODO: implement
		Thread current = Thread.currentThread();
		Long id = current.getId();
		this.value += 1;
		System.out.println(id);
	}

	@Override
	public int value() {
		//TODO: implement
		return this.value;		
	}

}