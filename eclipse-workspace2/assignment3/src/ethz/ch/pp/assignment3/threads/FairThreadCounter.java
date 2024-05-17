package ethz.ch.pp.assignment3.threads;

import ethz.ch.pp.assignment3.counters.Counter;

public class FairThreadCounter extends ThreadCounter {
		
	public FairThreadCounter(Counter counter, int id, int numThreads, int numIterations) {
		super(counter, id, numThreads, numIterations);
	}

	@Override
	public void run() {
		//TODO: implement
		synchronized(counter) {
		for (int i = 0; i < numIterations; i++) {
			while (counter.value() % 2 == id) {
				try {
					counter.wait();
				} catch (InterruptedException e) {}
			}
			counter.increment();
			counter.notifyAll();
			}
		
		}
	}
}
