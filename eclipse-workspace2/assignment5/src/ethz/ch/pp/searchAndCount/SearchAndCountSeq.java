package ethz.ch.pp.searchAndCount;

import ethz.ch.pp.util.Workload;

public class SearchAndCountSeq {

	private int[] input;	
	Workload.Type workloadType;

	private SearchAndCountSeq(int[] input, Workload.Type wt) {
		this.input = input;		
		this.workloadType = wt;
	}

	public static int countNoAppearances(int[] input, Workload.Type wt) {
		long startTime = System.nanoTime();
		SearchAndCountSeq counter = new SearchAndCountSeq(input, wt);
		int num = counter.count();
		long endTime = System.nanoTime();
		long elapsedNs = endTime - startTime;
		double elapsedMs = elapsedNs / 1.0e6;
		System.out.println("sequential time: " +elapsedMs+ "Ms");
		return num;
	}

	// count the number of elements for which doWork returns true
	private int count() {
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			if (Workload.doWork(input[i], workloadType))
				count++;
		}		
		return count;		
	}

}