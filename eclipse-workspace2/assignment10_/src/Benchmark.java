import java.util.concurrent.*;

class Benchmark {
	
private static MyLock locks[];

public Benchmark() {
this.locks = new MyLock[3];
this.locks[0] = new TASLock();
this.locks[1] = new TASBackoffLock();
this.locks[2] = new TASSleepBackoffLock();
}

public static void benchall(int threadPoolSize) {
	
	ExecutorService executorService;
	
		for (int lidx = 0; lidx<3; lidx++) {
			Counter counter = new Counter(locks[lidx]);
			executorService = Executors.newFixedThreadPool(threadPoolSize);
			long start = System.currentTimeMillis();
				for (int i = 0; i < threadPoolSize; i++) {
					executorService.submit(counter);
				}
			executorService.shutdown();
			try { executorService.awaitTermination(999, TimeUnit.SECONDS); }
			catch (InterruptedException e) { System.out.println("Benchmark aborted"); }
			long end = System.currentTimeMillis();
			System.out.println(threadPoolSize + " " + locks[lidx].getName() +
			" " + (((double)(end-start))/1000.0));
		}
}


public static void main(String[] args) {
	
	Benchmark benchmark = new Benchmark();
		for (int run=0; run<11; run++) {
			for (int nThreads=1; nThreads<8; nThreads++) {
				benchmark.benchall(nThreads);
			}
		}
}
}
