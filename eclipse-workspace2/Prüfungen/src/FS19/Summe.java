package FS19;

public class Summe {

	public static Pair ohne7(int summe) {
		for (int i = 0; i<summe; i++) {
			int x = i;
			int y = summe - i;
			Pair pair = new Pair(x, y);
			boolean noSieben = true;
			int j = x;
			int k = y;
			while (j > 0) {
				if (j%7 != 0) {
					j = j/10;
				}
				else {
					noSieben = false;
					break;
				}
			}
			while (k != 0){
				if (k%7 != 0) {
					k = k/10;
				}
				else {
					noSieben = false;
					break;
					}
			}
		if (noSieben) {
			return pair;
		}
		}
		return null;
	}
	
	public static void main (String[] args) {
		int summe = 1234;
		System.out.println(summe);
		Pair summanden = new Pair (0,0);
		summanden = ohne7(summe);
		System.out.println(summanden);
	}
}

