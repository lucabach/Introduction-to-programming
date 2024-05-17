import java.util.Scanner;

public class Ex_54 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		System.out.println("Erste Zahl");
		int a = scanner.nextInt();
		System.out.println("Zweite Zahl");
		int b = scanner.nextInt();
		System.out.println("Dritte Zahl");
		int c = scanner.nextInt();
		
		if (a%10 == b%10 || a %10 == c%10 || b%10 == c%10) {
			System.out.println("True"); }
		else {
			System.out.println("False");
		}
	}
}


