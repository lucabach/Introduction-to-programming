import java.util.Scanner;

public class Ex_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner (System.in);
		System.out.println("number one");
		int a = scanner.nextInt();
		System.out.println("number two");
		int b = scanner.nextInt();
		System.out.println("number three");
		int c = scanner.nextInt();
		int d = (a+b+c)/3;
		
		System.out.println(d);	
	}

}
