import java.util.Arrays;

public class Ex_A9 {

	public static void main(String[] args) {
	int index = 5;
	int value = 69;
	int [] a = {1, 2, 3, 4, 5, 6, 7};
	int [] b = new int [a.length +1];
	for (int i = 0; i<= a.length-1; i++) {
		b[i] =  a[i];
	}
	for (int j = b.length -1; j>= 0; j--) {
		if (b[j] >= b[index])
		b[j+1] = b[j];
	}
	b [index] = value;
	System.out.println(Arrays.toString(b));
	

}	}
