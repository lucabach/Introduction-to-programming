package ethz.ch.pp.searchAndCount;

import java.util.concurrent.Executors;

import ethz.ch.pp.util.Workload;

public class SearchAndCountThreadDivideAndConquer extends Thread{
	
	int[] input;
	int low;
	int high;
	int SEQ_CUTOFF;
	int result = 0;
	Workload.Type wt;
	int numThreads;
	
	
	SearchAndCountThreadDivideAndConquer(){
	}
	
	
	SearchAndCountThreadDivideAndConquer(int[] input, int low, int high, Workload.Type wt, int numThreads, int cutOff){
	
		this.input = input;
		this.low=low;
		this.high = high;
		this.wt = wt;
		this.numThreads = numThreads;
		this.SEQ_CUTOFF = cutOff;
	}
	
	public void run() {
		
		int size = high - low;
		if(size<1000000 || numThreads<1) {
			for(int i = low; i<high; i++) {
				 if (Workload.doWork(input[i], wt)){
					 result+=1;
				 }
			}
		}
		else {
			int mid = size/2;
			SearchAndCountThreadDivideAndConquer t1 = new SearchAndCountThreadDivideAndConquer(input, low, low+mid, wt, numThreads--, SEQ_CUTOFF);
			SearchAndCountThreadDivideAndConquer t2 = new SearchAndCountThreadDivideAndConquer(input, low+mid, high, wt, numThreads--, SEQ_CUTOFF);
			t1.start();
			t2.run();
			try {
				t1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			result = t1.result+t2.result;
		}
	}
		
	public static int countNoAppearances(int[] input, Workload.Type wt, int cutOff, int numThreads) {
		//TODO implement
		long startTime = System.nanoTime();
		SearchAndCountThreadDivideAndConquer t = new SearchAndCountThreadDivideAndConquer(input, 0, input.length, wt, numThreads, cutOff);
		t.run();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.nanoTime();
		long elapsedNs = endTime - startTime;
		double elapsedMs = elapsedNs / 1.0e6;
		System.out.println("parallel time: " + elapsedMs+ "Ms");
		return t.result;
		}
	


}