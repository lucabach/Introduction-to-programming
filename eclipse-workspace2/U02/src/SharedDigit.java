
public class SharedDigit {
	public static void main(String[] args) {
		// Aendern Sie die Werte um verschiedene Ausfuehrungen zu testen.
		int a = 12;
		int b = 43;
		
		// TODO: Vervollstaendigen Sie den Code wie in der Aufgabenbeschreibung beschrieben
		String first = Integer.toString(a);
		String second = Integer.toString(b);
		char s = 'o';
		
		if(first.charAt(0) == second.charAt(0) || first.charAt(0) == second.charAt(1)) {
			s = first.charAt(0);
		}
		
		else if(first.charAt(1) == second.charAt(0) || first.charAt(1) == second.charAt(1)) {
			s = first.charAt(1);
		}
		
		int r = 0;
		if(s == 'o') {
			r = -1;
		}
		else {
			r = Character.getNumericValue(s);
		}
		
		// Der finale Wert von r wird ausgegeben
		System.out.println("a: " + a + ", b: " + b + " --> r: " + r);
	}
}
