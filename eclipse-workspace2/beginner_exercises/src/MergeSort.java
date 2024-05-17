
public class MergeSort {

	public static void main (String[] args) {
		int []A = {3,4,7,6,3,9,8,7,9,5,6,4,3,5,1,4,3,6,9,8,0};
		mergeSort(A);
		for (int i = 0; i<A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}
	
	public static void mergeSort(int[] A) {
		int n = A.length;
		if (n<2) {
			return;
		}
		int mid = n/2;
		int[] left = new int[mid];
		int[] right = new int[n-mid];
	
	
	for (int i = 0; i<mid; i++) {
		left[i]=A[i];
	}
	for (int i=mid; i<n; i++) {
		right[i-mid]=A[i];
	}
	
	mergeSort(left);
	mergeSort(right);
	
	merge(A, left, right);
	}
	
	
	public static void merge(int[] A, int[] left, int[] right) {
		int leftSize = left.length;
		int rightSize = right.length;
		
		int i=0, j=0, k=0;
		
		while (i<leftSize && j<rightSize) {
			if (left[i]<=right[j]) {
				A[k]=left[i];
				i++;
			}
			else {
				A[k] = right[j];
				j++;
			}
			k++;
		}
		
		while (i<leftSize) {
			A[k]=left[i];
			i++;
			k++;
		}
		
		while (j<rightSize) {
			A[k] = right[j];
			j++;
			k++;
		}
	}
	
}
