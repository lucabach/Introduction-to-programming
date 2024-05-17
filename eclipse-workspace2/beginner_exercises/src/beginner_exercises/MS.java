package beginner_exercises;
import java.util.Random;

public class MS {
	
	public void MergeSort(int[]A) {
		int n = A.length;
		if(n<2) {
			return;
		}
		int mid = n/2;
		int [] L = new int [mid];
		int [] R = new int [n-mid];
		
		for (int i = 0; i<L.length; i++) {
			L[i] = A[i];
		}
		
		for (int i = 0; i<R.length; i++) {
			R[i] = A[mid + i];
		}
		
		MergeSort(L);
		MergeSort(R);
		Merge(A, L, R);
	}
	
	public void Merge(int[] A, int[] L, int[] R) {
		int ln = L.length;
		int rn = R.length;
		int i = 0, j = 0, k = 0;
		while (i<ln && j<rn) {
			if (L[i] < R[j]) {
				A[k] = L[i];
				i++;
			}
			else {
				A[k]=R[j];
				j++;
			}
			k++;
		}
		while (i<ln) {
			A[k]=L[i];
			i++;
			k++;
		}
		while (j<rn) {
			A[k]=R[j];
			j++;
			k++;
		}
	}
	
	public void main (String [] args) {
		Random random = new Random();
		int [] MergeBitch = new int [10];
		for (int i = 0; i<MergeBitch.length; i++) {
			int x = random.nextInt();
			MergeBitch[i] = x;
		}
		System.out.println("Before:" +MergeBitch);
		MergeSort(MergeBitch);
		System.out.println("After: " +MergeBitch);
	}
}

