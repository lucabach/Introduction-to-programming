package ethz.ch.pp.searchAndCount;

import ethz.ch.pp.util.Workload;

public class SearchAndCountSeqDivideAndConquer {
	
	Workload.Type workloadType;

	public static int countNoAppearances(int[] input, Workload.Type wt) {
		//TODO implement
		int lo=0;
		int hi=input.length;
		return countNoRecursive(input, wt, lo, hi);
}
	
	
	public static int countNoRecursive(int[] input, Workload.Type wt, int lo, int hi) {
		//TODO implement
		int size = hi-lo;
		if(size == 1) {
		 if (Workload.doWork(input[lo], wt)){
			 return 1;
		 }
		 else {
			 return 0;
		 }
		}
	    int mid = size/2;
		 
		int count1 = countNoRecursive(input, wt, lo, lo+mid);
		int count2 = countNoRecursive(input, wt, lo+mid, hi);
		
		return count1+count2;
}

}