import java.util.Scanner;

public class Ex_49 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		System.out.println("Geben Sie eine Zahl ein");
		int a = scanner.nextInt();
		if (a%2 == 0) {
			System.out.println("Even"); 	}
		else {
			System.out.println("Odd");	}
			}
}
