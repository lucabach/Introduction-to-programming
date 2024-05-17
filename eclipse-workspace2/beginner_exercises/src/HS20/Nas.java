package HS20;
import java.util.*;

public class Nas {
	
	public static void main (String[] args) {
		Set<Integer> nas = new HashSet<>();
		nas.add(2);
		nas.add(3);
		nas.add(4);
		Integer[]nasone = new Integer[nas.size()];
		int j = 0;
		for (int n : nas) {
			nasone[j++]=n;
			System.out.println(nasone[j-1]);
		}
		
	}

	
	
}
