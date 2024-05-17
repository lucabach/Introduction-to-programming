package Locks;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.atomic.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class TASLockBackoff implements Lock{
	int min = 0;
	int max = 1;
	
	AtomicBoolean state = new AtomicBoolean(false);
	
	public void lock() {
		Backoff backoff = null;
		
		while(true) {
			while(state.get()) {}
			if(!state.getAndSet(true)) {
				return;
			}
			else {
				try {
					if(backoff == null) {
						backoff = new Backoff(this.min++, this.max++);
								backoff.backoff();
					}
				}
				catch(InterruptedException e) {}
			}
		}
	}
	
	public void unlock() {
		state.set(false);
	}
	
	public void lockInterruptibly() {}
	
	public boolean tryLock() {return true;}
	
	public boolean tryLock(long time, TimeUnit unit) {return true;}
	
	public Condition newCondition() {
		Condition condition = this.newCondition();
		return condition;
	}
	
}
