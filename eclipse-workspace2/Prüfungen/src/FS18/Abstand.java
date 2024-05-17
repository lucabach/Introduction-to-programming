package FS18;
import java.math.*;

public class Abstand {

	public static int abstand (int[]A, int[] B) {
		int a = A.length;
		int b = B.length;
		int difference = 0;
		
		if (a>b) {
			int[] C = new int [a];
			for (int i=0; i<a; i++) {
				C[i] = 0;
			}
			for (int i=0; i<b; i++) {
				C[i]=B[i];
			}
			for (int i=0; i<a; i++) {
			difference += Math.abs(A[i]- C[i]);
		}
			return difference;
		}
		
		else if (a<b) {
			int[] C = new int [b];
			for (int i=0; i<b; i++) {
				C[i] = 0;
			}
			for (int i=0; i<a; i++) {
				C[i]=A[i];
			}
			for (int i=0; i<b; i++) {
				difference += Math.abs(C[i]-B[i]);
			}
			return difference;
			}
		
		else if (a==b && a!=0) {
			for (int i=0; i<a; i++) {
				difference += Math.abs(A[i]-B[i]);
			}
		}
	return 0;
	}
	
	public static void main (String[] args) {
		int [] A = {};
		int[] B = {};
		System.out.print(abstand(A, B));
		
	}
}
