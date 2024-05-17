import java.util.Scanner;
/*
 * Author: 
 * 
 * 
 * Dieses Programm berechnet die Reihe 1/1^2 + 1/2^2 + ... + 1/N^2
 */
public class Reihe {

	public static void main(String[] args) {
		// TODO 
		Scanner scanner = new Scanner(System.in);
		System.out.println("n eingeben: ");
		int n = scanner.nextInt();
		double sum = 0;
		for(int i=1; i<=n; i++) {
			sum += 1/ Math.pow(i, 2);
		}
		scanner.close();
		System.out.println("sum 1/n^2 = " +sum);
	}
	
	

}
