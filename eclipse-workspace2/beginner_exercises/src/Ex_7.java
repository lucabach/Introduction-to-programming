import java.util.Scanner;
public class Ex_7 {
	
	public static void main (String[] args) {
		
		Scanner scanner = new Scanner (System.in);
		System.out.println("Number");
		int x = scanner.nextInt();
		for (int i=1; i<=10; i++) {
			int result = i * x;
			System.out.println(+x+ "x " +i+ " = " +result);
		}
		
	}

}
