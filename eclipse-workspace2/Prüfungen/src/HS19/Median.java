package HS19;

import java.util.*;

public class Median {
	public static double median(Scanner scanner) {
		if (!scanner.hasNextInt()) {
			return 0;
		}
		List<Double> numbers = new ArrayList<Double>();
		while (scanner.hasNextDouble()) {
			numbers.add(scanner.nextDouble());
		}
		double [] sorted = new double[numbers.size()];
		for (int i = 0; i<numbers.size(); i++) {
			sorted [i] = numbers.get(i);
		}
		for (int i = 0; i<numbers.size(); i++) {
			for (int j = 0; j<numbers.size()-1; j++) {
				if (sorted[j]>sorted[j+1]) {
					double temp = sorted[j];
					sorted[j]=sorted[j+1];
					sorted[j+1] = temp;
					}
			}
		}
		int mid = sorted.length / 2;
		if (sorted.length % 2 == 0) {
			return (sorted[mid]+sorted[mid-1])/2;
		}
		else {
			return sorted[mid];
		}
	}
	
	public static void main (String [] args) {
		
	double [] sorted = {8,7,6,5,4};
		for (int i = 0; i<sorted.length-1; i++) {
			for (int j = 0; j<sorted.length-1; j++) {
				if (sorted[j]>sorted[j+1]) {
					double temp = sorted[j];
					sorted[j]=sorted[j+1];
					sorted[j+1] = temp;
					}
				}
		}
		for(int i = 0; i<sorted.length; i++) {
			
		
		System.out.println(sorted[i]);
		}
	}
}
