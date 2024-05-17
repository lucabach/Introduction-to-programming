import java.util.Scanner;

public class Ex_44 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Geben Sie eine Zahl von 1 bis 10 ein:");
		int a = scanner.nextInt();
		if (a<1 || a>10) {
			System.out.println("Keine gültige Zahl");
		}
		
		else if (a>0 && a<11) {
		
		int b = a*11;
		int c = a*111;
		int result = a+b+c;
		
		System.out.println(+a+ " + " +b+ " + " +c+ " = " +result);
	}
}
}
