
public class SelectionSort {

	static int[] a = {1,10, 5, 8, 9, 11, 44, 18, 1, 3, 2, 39};
	
	//We scan the array for the smallest value and bring it to the bottom of the array
	//(once for each iteration)
	
	public static void main(String[] args) {
		int[] sorted = sort(a);
		for(int i=0; i<a.length; i++) {
			System.out.print(sorted[i] + " ");
		}
	}
	
	public static int[] sort(int[] a) {
		int n = a.length;
		for(int i=0; i<n-1; i++) {
			int jMin = i;
			for(int j= i+1; j<n; j++) {
				if(a[j]<a[jMin]) {
					jMin = j;
				}
			}
			if(jMin != i) {
				int temp = a[i];
				a[i] = a[jMin];
				a[jMin] = temp;
			}
		}
		return a;
	}
}
