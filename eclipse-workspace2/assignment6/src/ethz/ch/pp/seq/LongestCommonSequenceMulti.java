package ethz.ch.pp.seq;

import java.util.concurrent.*;

public class LongestCommonSequenceMulti extends RecursiveTask<Sequence> {
	
	private static final long serialVersionUID = 4179716026313995745L;
	
	int[] input;
	int startIndex;
	int length;
	
	LongestCommonSequenceMulti(int[] input, int si, int l){
		this.input = input;
		this.startIndex = si;
		this.length =l;
	}
	
	
		public static Sequence longestCommonSequence(int[] input, int numThreads) {
		// TODO Implement
		ForkJoinPool fjp = new ForkJoinPool(numThreads);
		LongestCommonSequenceMulti t = new LongestCommonSequenceMulti(input, 0, input.length);
		Sequence result = fjp.invoke(t);
		return result;
	}

	@Override
	protected Sequence compute() {
		// TODO Implement	
		if (this.length <= 100) {
			return LongestCommonSequence.longestCommonSequence(this.input, this.startIndex, this.length);
		}
		else {
			int halfsize = this.length / 2;
			LongestCommonSequenceMulti left = new LongestCommonSequenceMulti(this.input, this.startIndex, halfsize);
			LongestCommonSequenceMulti right = new LongestCommonSequenceMulti(this.input, halfsize , this.length - halfsize);
			left.fork();
			Sequence second = right.compute();
			Sequence first = left.join();
			
			Sequence best = (first.isGreaterThan(second)) ? first:second;
			
			if (this.input[this.startIndex+halfsize-1] != this.input[this.startIndex+halfsize]) {
				return best;
			}
			
			else {
				Sequence middle = LongestCommonSequence.longestCommonSequence(this.input, this.startIndex + Math.max(0, halfsize-best.lenght()), Math.min(best.lenght()*2, this.length));
				best = (middle.isGreaterThan(best))? middle : best;
				return best;
			}
		}
	}
}
