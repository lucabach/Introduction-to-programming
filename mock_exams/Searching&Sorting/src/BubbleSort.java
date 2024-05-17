
public class BubbleSort {
	
	//the biggest value bubbles to the top of the array in each iteration (or in this case, the
	//smallest to the bottom).
	
	static int[] a = {1,10, 5, 8, 9, 11, 44, 18, 1, 3, 2, 39};
	
	public static void main(String[] args) {
		int[] sorted = sort(a);
		for(int i=0; i<a.length; i++) {
			System.out.print(sorted[i] + " ");
		}
	}
	
	public static int[] sort(int[] a) {
		int n = a.length;
		
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(a[i]>a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}
}
