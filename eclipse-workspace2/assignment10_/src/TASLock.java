import java.util.concurrent.atomic.AtomicBoolean;

class TASLock implements MyLock {

AtomicBoolean state = new AtomicBoolean(false);

public void lock() {
while (state.getAndSet(true)) {}
}

public void unlock() {
state.set(false);
}

public String getName() {
return "TAS";
}
}
