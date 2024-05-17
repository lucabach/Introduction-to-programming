package Locks;

import java.util.ArrayList;
import java.util.List;

public class Main {

	
	public void main(String[] args) {
		for(int i = 0; i<3; i++) {
			if (i==0) {System.out.println("Bakery Lock: ");}
			else if(i==1) {System.out.println("TAS Lock: ");}
			else {System.out.println("TAS Lock w/ BackOff: ");}
			if (i==0) {count1(new MyCounter(), 10);}
			else if (i==1){ count2(new MyCounter(), 10); }
		}
	}
		
		public static void count1(final MyCounter counter, int numThreads) {
			BakeryLock lock = new BakeryLock(numThreads);
			List<Thread> threads = new ArrayList<Thread>();
			for (int i = 0; i < numThreads; i++) {
				Thread t = new Thread();
				threads.add(t);
			}

			long timefirst = System.nanoTime();
			for (int i = 0; i < numThreads; i++) {
				lock.Acquire(i);
				threads.get(i).start();
			}
			
			for (int i = 0; i < numThreads; i++) {
				try {
					threads.get(i).join();
					lock.Release(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			long timelast = System.nanoTime();
			long elapsed = timelast -timefirst;
			System.out.println("" +elapsed +" Ns for" +numThreads+ " threads");
		}
		
		
		public static void count2(final MyCounter counter, int numThreads) {
			List<Thread> threads = new ArrayList<Thread>();
			for (int i = 0; i < numThreads; i++) {
				Thread t = new Thread();
				threads.add(t);
			}

			long timefirst = System.nanoTime();
			for (int i = 0; i < numThreads; i++) {
				threads.get(i).start();
			}
			
			for (int i = 0; i < numThreads; i++) {
				try {
					threads.get(i).join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			long timelast = System.nanoTime();
			long elapsed = timelast -timefirst;
			System.out.println("" +elapsed +" Ns for" +numThreads+ " threads");
		}
}
