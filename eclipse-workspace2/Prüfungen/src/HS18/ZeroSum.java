package HS18;

import java.util.Scanner;
import java.util.*;

public class ZeroSum {

    public static Pair zeroSum(Scanner scanner) {
        List<Integer> numbers = new ArrayList<Integer>();
        while (scanner.hasNextInt()) {
        	int a = scanner.nextInt();
        	numbers.add(a);
        }
        for (int i = 0; i<numbers.size(); i++) {
        	for (int j = 0; j<numbers.size(); j++) {
        		int x = numbers.get(i);
        		int y = numbers.get(j);
        		if (x+y == 0) {
        			Pair zeroSum = new Pair(i, j);
        			return zeroSum;
        		}
        	}
        }
        return null;
    }
}

class Pair {
    int i, j;
    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
