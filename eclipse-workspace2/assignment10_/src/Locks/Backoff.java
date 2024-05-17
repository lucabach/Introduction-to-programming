package Locks;
import java.util.Random;

public class Backoff {
	
	int min;
	int max;
	int limit = 2;
	
	Backoff(int MIN_DELAY, int MAX_DELAY){
		this.min = MIN_DELAY;
		this.max = MAX_DELAY;
	}
	
	public void backoff() throws InterruptedException{
		Random random = new Random();
		int delay = random.nextInt(limit);
		if(limit<max) {
			limit *=2;
		}
		Thread.sleep(delay);
	}
}
