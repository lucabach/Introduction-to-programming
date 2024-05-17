import java.util.*;

public class Ex_69 {
	public static void main (String[] args) {
		Scanner scanner = new Scanner (System.in);
		String a = scanner.next();
		if (a.length() % 2 == 1) {
			System.out.println("odd bitch"); }
		else {
		
			System.out.println(a.substring(0, a.length()/2));
		}
		}
	}

