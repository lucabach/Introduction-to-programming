package Locks;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.atomic.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class TASLock implements Lock{
	
	AtomicBoolean state = new AtomicBoolean(false);
	
	public void lock() {
		while(state.getAndSet(true)) {}
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
