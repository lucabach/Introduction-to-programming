import java.util.Arrays;

public class Ex_113 {

	public static void main(String[] args) {
	int [] a = {2, 4, 6, 8};
	int [] b = {1, 3, 5, 7};
	int [] c = new int [a.length + b.length];
	
	for (int i=0; i <= a.length-1; i++) {
		for (int j = 0; j <= b.length-1; j++) {
			if (b[j] <= b[i]) {
			c[i] = b[j];
			}
		}
	}
	System.out.println(c);
}
}
	

