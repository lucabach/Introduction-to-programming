import java.util.Scanner;

public class Ex_37 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner (System.in);
		System.out.println("Geben Sie einen Satz ein:");
		String a = scanner.next();
		
		for (int i=0; i<= a.length(); i++) {
			for (int j=a.length(); j>=0; j--) {
				char b = a.charAt(i);
				char c = a.charAt(j);
				char temp = b;
				b = c;
				c = temp;
			
				System.out.print(b);
				
			}
			
		}

	}

}
