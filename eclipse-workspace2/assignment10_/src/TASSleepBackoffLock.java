import java.util.concurrent.atomic.AtomicBoolean;

class TASSleepBackoffLock implements MyLock {
	
AtomicBoolean state = new AtomicBoolean(false);
long backoff = 1;
long maxBackoff = 100;
long initialBackoff = 1;


public void lock() {
while (state.getAndSet(true)) {
try {
Thread.sleep(backoff);
if (backoff < maxBackoff) backoff *= 2;
} catch (InterruptedException e) {
}
}
backoff=initialBackoff;
}


public void unlock() {state.set(false); }


public String getName() {return "BackoffSleep"; }
}
