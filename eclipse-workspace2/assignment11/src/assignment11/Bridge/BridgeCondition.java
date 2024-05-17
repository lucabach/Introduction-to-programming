package assignment11.Bridge;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BridgeCondition extends Bridge {
	
	int totalcars;

	//TODO use this given lock and create conditions form it
	//you might find that you need some additional variables
	
	final Lock bridgeLock = new ReentrantLock();
	final Condition carcanenter = bridgeLock.newCondition();
	final Condition truckcanenter = bridgeLock.newCondition();
	
	volatile private int carcount = 0;
	volatile private int truckcount = 0;
	
	

	public void enterCar() throws InterruptedException {
		bridgeLock.lock();
		//TODO implement rules for car entry
		while(carcount>=2 || truckcount>=1) {
				carcanenter.await();
		}
		carcount++;
		bridgeLock.unlock();
	}

	public void leaveCar() {
		//TODO implement rules for car leave
		bridgeLock.lock();
		carcount--;
		if (carcount==0) {
			truckcanenter.signal();
		}
		if (carcount < 3) {
			carcanenter.signalAll();
		}
		bridgeLock.unlock();
	}

	public void enterTruck() throws InterruptedException {
		//TODO implement rules for truck entry - similar to car entry
		bridgeLock.lock();
		//TODO implement rules for car entry
		while(carcount>=1 || truckcount>=1) {
				truckcanenter.await();
		}
		truckcount++;
		bridgeLock.unlock();
	}

	public void leaveTruck() {
		//TODO implement rules for car leave - similar to car leave
		bridgeLock.lock();
		truckcount--;
		if(truckcount==0) {
			truckcanenter.signal();
			carcanenter.signalAll();
		}
		bridgeLock.unlock();
	}

	public static void main(String[] args) {
		Random r = new Random();
		BridgeCondition b = new BridgeCondition();
		for (int i = 0; i < 100; ++i) {
			if (r.nextBoolean()) {
				(new Car()).driveTo(b);
			} else {
				(new Truck()).driveTo(b);
			}
		}
	}

}
