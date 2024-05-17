package HS17;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math.*;

public class Primfaktoren {
	
	/**
	 * Gibt eine Liste der Primfaktoren von n zurück, geordnet vom
	 * kleinsten zum grössten. Der erste Faktor ist immer 1, falls n
	 * positiv ist, und -1 andernfalls. Danach folgen die "üblichen"
	 * Primfaktoren. Falls n = 0 wird eine leere Liste zurückgegeben.
	 */
	
	public static List<Integer> primfaktoren(int n) {
		List <Integer> list = new ArrayList <Integer>();
		if (n>0) {
			list.add(1);
			boolean isPrime = true;
			int i = 2;
			while (i<n) {
			while (n%i == 0) {
					for (int j=2; j<=i; j++) {
						if (i%j==0 && i!=j) {
							isPrime = false;
						}		
					}
				if (isPrime) {
				list.add(i);
				n /= i;
				}
			}
			i++;
		}
			return list;
		}
		else if (n<0) {
			list.add(-1);
		
		boolean isPrime = true;
		int i = 2;
		while (i < (-n) ) {
		while (n%i == 0) {
				for (int j=2; j<=i; j++) {
					if (i%j==0 && i!=j) {
						isPrime = false;
					}		
				}
			if (isPrime) {
			list.add(i);
			n /= i;
			}
		}
		i++;
		}
		return list;
	}
		else {
			return list;
	}
	}
	
	public static void main (String [] args) {
		List<Integer> list = primfaktoren(-100);
		System.out.println(list);
	}
}