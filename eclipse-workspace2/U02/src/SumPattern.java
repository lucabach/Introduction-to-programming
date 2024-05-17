
public class SumPattern {
	public static void main(String[] args) {
		// Aendern Sie die Werte um verschiedene Ausfuehrungen zu testen.
		int a = 10;
		int b = 4;
		int c = 7;
		
		if (b+c== a) {
			System.out.println("Moeglich: " +b+ " + " +c+  " = " +a);
		}
		
		else if (a+c== b) {
			System.out.println("Moeglich: " +a+ " + " +c+  " = " +b);
		}
		
		else if (a+b== c) {
			System.out.println("Moeglich: " +a+ " + " +b+  " = " +c);
		}
		
		else {
			System.out.println("Unmoeglich");
		}
	}
}
