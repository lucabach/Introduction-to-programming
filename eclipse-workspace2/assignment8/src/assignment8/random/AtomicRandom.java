package assignment8.random;


import java.util.concurrent.atomic.AtomicLong;

public class AtomicRandom implements RandomInterface {
    private static final long a = 25214903917L;
    private static final long c = 11;
    private AtomicLong state;
    
    
    public AtomicRandom(long seed) {
        state = new AtomicLong(seed);
    }
    
    @Override
    public int nextInt() {
    	long next;
    	long orig;
    	while(true) {
    	// get the current seed value
    	orig=state.get();
    	// using recurrence equation to generate next seed
    	next = (a * orig + c) & (~0L >>> 16);
    	// store the updated seed
    	if(state.compareAndSet(orig, next)) {
         return (int) (next >>> 16);
    	}else {
    		try {
    			Thread.sleep(1);
    		}
    		catch(InterruptedException e) {}
    		}
    	}
    }
}
