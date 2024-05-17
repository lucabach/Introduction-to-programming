
public class MergeSort {

	static int[] a = {1,10, 5, 8, 9, 11, 44, 18, 1, 3, 2, 39};
	
	
	//this algorithm functions recursively. It first splits the array until it consists only of
	//single elements, then it merges them together by sorting them.
	
	public static void main(String[] args) {
		split(a);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	
	public static void split(int[] a) {
		int n = a.length;
		if(n<2) {
			return;
		}
		
		int mid = n/2;
		int[] left = new int[mid];
		int[] right = new int[n-mid];
		
		for(int i=0; i<mid; i++) {
			left[i] = a[i];
		}
		for(int i= mid; i<n; i++) {
			right[i-mid] = a[i];
		}
		split(left);
		split(right);
		
		merge(a, left, right);
	}
	
	
	public static void merge(int[] a, int[] left, int[] right) {
		int leftsize = left.length;
		int rightsize = right.length;
		
		int i=0;
		int j=0;
		int k=0;
		
		while(i<leftsize && j<rightsize) {
			if(left[i]<=right[j]) {
				a[k]=left[i];
				i++;
			}
			else {
				a[k] = right[j];
				j++;
			}
			k++;
		}
		
		while(i<leftsize) {
			a[k] = left[i];
			k++;
			i++;
		}
		
		while(j<rightsize) {
			a[k] = right[j];
			k++;
			j++;
		}
	}
		
}
