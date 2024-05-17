import java.util.concurrent.atomic.AtomicBoolean;

class TASBackoffLock implements MyLock {


AtomicBoolean state = new AtomicBoolean(false);
long initialBackoff = 100;
long backoff = 100;
long maxBackoff = 100000;


public void lock() {
while (state.getAndSet(true)) {
backoff *= 2;
long start = System.nanoTime();
while(start + backoff >= System.nanoTime());
}
backoff=initialBackoff;
}


public void unlock() {state.set(false);}


public String getName() {return "BackoffSpin";}
}
