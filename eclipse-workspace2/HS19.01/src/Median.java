import java.util.*;

public class Median {
	public static double median(Scanner scanner) {
		// TODO
		ArrayList<Integer> l = new ArrayList<>();
		while(scanner.hasNextInt()) {
			l.add(scanner.nextInt());
		}
		int[] a = new int[l.size()];
		for(int i=0; i<a.length; i++) {
			a[i]=l.get(i);
		}
		Arrays.sort(a);
		int n = a.length;
		if(n%2==0) {
			n = n/2;
			double res = a[n] + a[n-1];
			return res/2.0;
		}
		else {
			n=n/2;
			return a[n];
		}
	}
}
