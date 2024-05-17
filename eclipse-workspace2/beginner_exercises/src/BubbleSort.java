import java.util.Arrays;

public class BubbleSort {
	public static void main (String [] args) {

	int [] a = {10, 10, 9, 7, 5, 7, 9, 3, 2, 9};
	int temp = 0;
	for (int i = 0; i<= a.length - 1; i++) {
		for (int j = i+1; j<= a.length -1; j++) {
		if (a[i] > a[j]) {
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
			}
		}
	}
	System.out.println(Arrays.toString(a));
	}
}
