
class Counter implements Runnable {
	
private MyLock lock;
private static volatile int counter;
private static final int limit = 10000000;


public Counter(MyLock lock) {
this.lock = lock;
this.counter = 0;
}


public void run() {
while (increaseCounter() < limit) { }
}


private int increaseCounter() {
int res;
lock.lock();
counter++;
res = counter;
lock.unlock();
return res;
}
}
