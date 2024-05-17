import java.util.Scanner;

public class Ex_55 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		System.out.println("Sekunden");
		int a = scanner.nextInt();
		int b = a/3600;
		if (b!=0) {
		int c = b/60; 	}
		else {
		int c = a/60;	}
		if (c != 0) {
		int d = b%60; }
		else {
		int d = 0; }
		
		System.out.println("" +b+ ":" +c+ ":" +d);
		}
	}

