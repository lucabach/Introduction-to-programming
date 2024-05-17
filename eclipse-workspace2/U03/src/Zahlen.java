import java.util.Scanner;
/*
 * Author: 
 * 
 * 
 * Dieses Programm liest einen String ein, der eine Siebensegmentanzeige kodiert, und gibt die kodierte Zahl als Integer aus.
 */
public class Zahlen {

	public static void main(String[] args) {
		// TODO 
		Scanner scanner = new Scanner(System.in);
		System.out.println("String eingeben: ");
		String s = scanner.next();
		int n = 999;
		
		if(s.contains("c")) {
			if(s.contains("b")) {
				if(s.contains("a")) {
					n=7;
					if(s.contains("g")) {
						if(s.contains("d")) {
								if(s.contains("f")) {
									if(s.contains("e")) {
										n=8;
										System.out.println("Das ist die " +n+ " auf dem seven digit display");
										return;
									}
									n=9;
									System.out.println("Das ist die " +n+ " auf dem seven digit display");
									return;
								}
								n=3;
								System.out.println("Das ist die " +n+ " auf dem seven digit display");
								return;
						}
					}
				}
				if(s.contains("f")) {
					if(s.contains("g")) {
						n=4;
						System.out.println("Das ist die " +n+ " auf dem seven digit display");
						return;
					}
					else {
						n=0;
						System.out.println("Das ist die " +n+ " auf dem seven digit display");
						return;
					}
				}
			}
			if(s.contains("d")) {
				if(s.contains("g")){
					if(s.contains("f")) {
						if(s.contains("a")){
							if(s.contains("e")) {
								n=6;
								System.out.println("Das ist die " +n+ " auf dem seven digit display");
								return;
							}
							n=5;
							System.out.println("Das ist die " +n+ " auf dem seven digit display");
							return;
						}
					}
				}
			}
			n=1;
			System.out.println("Das ist die " +n+ " auf dem seven digit display");
			return;
		}
		else {
			n=2;
			System.out.println("Das ist die " +n+ " auf dem seven digit display");
		}
		
		
		
		
	}
}
		
							
				
						

