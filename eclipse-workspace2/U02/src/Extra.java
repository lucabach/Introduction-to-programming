
public class Extra {

	public static void main(String[] args) {
		
		int aufgabe=2;
		
		
		if(aufgabe == 1) {
		for(int i=0; i<8; i++) {
			if(i%2 == 0) {
				System.out.println("**..**..**..");
			}
			else {
				System.out.println("..**..**..**");
			}
		}
		}
		
		else if(aufgabe == 2) {
			for(int i=1; i<=9; i++) {
				for(int j=1; j<=9; j++) {
					System.out.print(".");
				}
				System.out.println();
			}
		}
	}
}
