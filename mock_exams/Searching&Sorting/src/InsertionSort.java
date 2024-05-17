
public class InsertionSort {
	
	static int[] a = {1,10, 5, 8, 9, 11, 44, 18, 1, 3, 2, 39};
	
	//For each iteration, we check a new element of the array and put it
	//in its correct position in the array.
	
	public static void main(String[] args) {
		int[] sorted = sort(a);
		for(int i=0; i<a.length; i++) {
			System.out.print(sorted[i] + " ");
		}
	}
	
	public static int[] sort(int[] a) {
		int n = a.length;
		
		for(int i=0; i<n; i++) {
			int j=i;
			while(j>0 && a[j-1]>a[j]) {
				int temp = a[j];
				a[j] = a[j-1];
				a[j-1] = temp;
				j--;
			}
		}
		return a;
	}

}
