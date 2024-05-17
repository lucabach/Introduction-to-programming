package assignment11.Bridge;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BridgeMonitor extends Bridge {
	// TODO use this object as a monitor
	// you might find that you need some additional variables.
	int carcount=0;
	int truckcount=0;
	private final Object monitor = new Object();

	public void enterCar() throws InterruptedException {
		//TODO implement rules for car entry
		synchronized(monitor){
			while(carcount>=2||truckcount>=1) {
			monitor.wait();
			}
		carcount++;
		}
	}

	public void leaveCar() {
		//TODO implement rules for car leave
		synchronized(monitor) {
		carcount--;
		monitor.notifyAll();
		}
	}

	public void enterTruck() throws InterruptedException {
		//TODO implement rules for truck entry - similar to car entry
		synchronized(monitor){
			while(carcount>=1||truckcount>=1) {
			monitor.wait();
			}
		truckcount++;
		}
	}

	public void leaveTruck() {
		//TODO implement rules for car leave - similar to car leave
		synchronized(monitor) {
		truckcount--;
		monitor.notifyAll();
		}
	}

	public static void main(String[] args) {
		Random r = new Random();
		BridgeMonitor b = new BridgeMonitor();
		for (int i = 0; i < 100; ++i) {
			if (r.nextBoolean()) {
				(new Car()).driveTo(b);
			} else {
				(new Truck()).driveTo(b);
			}
		}
	}

}
