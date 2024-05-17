import java.util.Scanner;
/*
 * Author: 
 * 
 * 
 * Dieses Programm berechnet den GGT von zwei ganzen Zahlen.
 */
public class GGT {

	public static void main(String[] args) {
		// TODO 
		Scanner scanner = new Scanner(System.in);
		System.out.println("erste Zahl eingeben:");
		int a = scanner.nextInt();
		System.out.println("zweite Zahl eingeben:");
		int b = scanner.nextInt();
		int g = ggt(a, b);
		System.out.println("Der ggT der eingegebenen Zahlen ist " +g);
		scanner.close();
	}
	
	
	public static int ggt(int x, int y) {
		if(x>=y && x%y==0) {
			return y;
		}
		else {
			return ggt(y, x%y);
		}
	}

}
