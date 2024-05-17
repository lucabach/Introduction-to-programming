import java.util.Scanner;
/*
 * Author: 
 * 
 * 
 * Dieses Programm gibt die Binaerdarstellung einer positive Zahl aus, ohne Arrays oder String-
 * Operationen.
 */
public class Binaer {

	public static void main(String[] args) {
		// TODO 

		System.out.println("Zahl eingeben: ");
		Scanner scanner = new Scanner(System.in);
		int z = scanner.nextInt();
		int stellen = 0;
		
		while(Math.pow(2, stellen)<z) {
			stellen++;
		}
		
		stellen--;
		
		for(int i=stellen; i>=0; i--) {
			if(z>= Math.pow(2, i)) {
				System.out.print("1");
				z-=Math.pow(2, i);
			}
			else {
				System.out.print("0");
			}
		}
			scanner.close();
		}
}
