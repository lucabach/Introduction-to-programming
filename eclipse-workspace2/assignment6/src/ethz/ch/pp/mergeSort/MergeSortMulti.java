package ethz.ch.pp.mergeSort;
import ethz.ch.pp.util.ArrayUtils;
import java.util.concurrent.*;

public class MergeSortMulti extends RecursiveAction {

int[] input;
int[] output;


MergeSortMulti (int[] input){
	this.input = input;
}



public void compute() {
	
	int[] result = new int[this.input.length];
	
	if (input.length <= 2) {
	    // Execute the simple task locally
		this.output = MergeSortSingle.sort(input);
	} 
	else {
	    // Split the input in two parts by forking to two tasks
		int high = input.length;
		int mid = input.length/2;
		int [] firstPart = new int[mid];
		int [] secondPart = new int[high-mid];
		int i = 0;
		for(i = 0; i<mid; i++) {
			firstPart[i]=input[i];
		}
		for (int j = 0; j<high-mid; j++) {
			secondPart[j]=input[i];
		}
	    MergeSortMulti left = new MergeSortMulti(firstPart);
	    MergeSortMulti right = new MergeSortMulti(secondPart);
	    left.fork();
	    right.fork();
	    left.join();
	    right.join();
		
	    ArrayUtils.merge(left.output, right.output, result);
	    this.output=result;
		}
	}


	private static final long serialVersionUID = 1531647254971804196L;

	//TODO: implement using ForkJoinPool
	// You should change this class to extend from RecursiveTask or RecursiveAction
	
	public static int[] sort(int[] input, int numThreads) {		
		ForkJoinPool fjp = new ForkJoinPool(numThreads);
		MergeSortMulti t = new MergeSortMulti(input);
		fjp.invoke(t);
		return t.output;
	}
	
	

}
