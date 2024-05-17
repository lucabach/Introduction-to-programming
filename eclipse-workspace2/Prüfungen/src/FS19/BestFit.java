package FS19;

import java.util.List;
import java.util.*;


public class BestFit {
	
	public static List<Integer> bestFit(Set<Integer> werte, int durchschnitt) {
		List <Integer> bestFit = new ArrayList <Integer>();
		String[] strings = werte.toArray(new String[werte.size()]);
		int[] sizes = new int[werte.size()];
		for (int i =0; i<werte.size(); i++) {
			sizes [i] = Integer.parseInt(strings[i]);
		}
		for (int i = 0; i<sizes.length; i++) {
			if (sizes[i]==durchschnitt) {
				bestFit.add(sizes[i]);
				return bestFit;
			}
			for (int j=1; j<sizes.length; j++) {
				if ((sizes[i]>durchschnitt && sizes[j]< durchschnitt) || (sizes[i]<durchschnitt && sizes[j]>durchschnitt)) {
					int k = 2;
					int sum1 = i;
					int sum2 = j;
					while (k<100) {
						if ((i+j)/k == durchschnitt && (i+j) % k == 0) {
							for (int z = 1; z<k; z++) {
								bestFit.add(sum1);
							}
							if (!bestFit.isEmpty()) {
								bestFit.add(sum2);
								return bestFit;
							}
						}
						k++;
						i+= sum1;
					}
					i = sum1;
					j = sum2;
					
					int l = 2;
					while (l<100) {
						if ((i+j)/l == durchschnitt && (i+j) % k == 0) {
							for (int y = 1; y<l; y++) {
								bestFit.add(sum2);
							}
							if (!bestFit.isEmpty()) {
								bestFit.add(sum1);
								return bestFit;
							}
						}
					j+= sum2;
					l++;
					}
				}
			}
		}
		return null;
		
}
}

