
public class Calculations {
	
	public static void main(String[] args) {
		int a = 2741;
		System.out.println(checksum(a));
	}
	
	public static int checksum(int x) {
		// TODO: Vervollstaendigen Sie den Code wie in der Aufgabenbeschreibung beschrieben
		if(x/10 == 0) {
			return x;
		}
		int y = x%10;
		return y + checksum(x/10);
	}
	
	public static boolean magic7(int a, int b) {
		// TODO: Vervollstaendigen Sie den Code wie in der Aufgabenbeschreibung beschrieben
		if(a==7 || b ==7 || a-b == 7 || b-a == 7 || a+b ==7) {
			return true;
		}
		return false;
	}
	
	public static boolean fast12(int z) {
		// TODO: Vervollstaendigen Sie den Code wie in der Aufgabenbeschreibung beschrieben
		if(z%12 == 0 || z%12==1 || z % 12 == 2 || z%12 == 11 || z%12 == 10) {
			return true;
		}
		return false;
	}
}
