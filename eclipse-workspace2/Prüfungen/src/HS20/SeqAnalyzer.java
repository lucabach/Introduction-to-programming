package HS20;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class SeqAnalyzer {
	List<Integer>numbers = new ArrayList<>();
	Map<Integer, SeqNumber> allS = new HashMap<>();
	List<SeqNumber> numberz = new ArrayList<>();
	List<Integer> minDist;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner inputSequence = new Scanner("1 3 2 9 2 45");
		SeqAnalyzer analyzer = new SeqAnalyzer(inputSequence);

		List<SeqNumber> seqNumbers = analyzer.getNumbers();
		
		for (SeqNumber seqNumber : seqNumbers) {
			System.out.println(seqNumber);
		}
	}

	public SeqAnalyzer(Scanner scanner) {
		int i = 0;
		while (scanner.hasNextInt()) {
			int current = scanner.nextInt();
				if (!numbers.contains(current)) {
						numbers.add(current);
						Set<Integer>positions = new HashSet<>();
						positions.add(i);
						SeqNumber cur = new SeqNumber (current,positions);
						numberz.add(cur);
						allS.put(current, cur);
						i++;
				}
				else {
					SeqNumber cur = getSeqNumber(current);
					cur.positions.add(i);
					i++;
				}
				}
		
	}
	
	public List<SeqNumber> getNumbers() {
		
		return this.numberz;
	}
	
	public SeqNumber getSeqNumber(int a) {
		for(int n: allS.keySet()) {
			if (n == a) {
			SeqNumber z = this.allS.get(n);
			return z;
			}
		}
		return null;
	}
	
	public int getMinDistance(SeqNumber s) {
		Set <Integer> distances = s.positions;
		String [] dist = new String[distances.size()];
		distances.toArray(dist);
		int[]di = new int[dist.length];
		for (int i = 0; i<dist.length; i++) {
			di[i]=Integer.parseInt(dist[i]);
		}
		int minDistance = Integer.MAX_VALUE;
		for (int i = 0; i<dist.length; i++) {
			for (int j = i+1; j<dist.length; j++) {
			if (Math.abs(di[j]-di[i]) < minDistance)	{
				minDistance = di[j]-di[i];
			}
			}
		}
		minDist.add(minDistance);
		return minDistance;
	}
		
	

	public List<SeqNumber> getRanking(int number) {
		// TODO
		List<SeqNumber> getRanking = new ArrayList<>();
		if(numberz.size()<number) {
			throw new IllegalArgumentException();
		}
		Map <SeqNumber, Integer> minDistances = new HashMap<>();
		for (SeqNumber q : numberz) {
			if (q.positions.size()==0) {
				minDistances.put(q, Integer.MIN_VALUE);
			}
			else {
				int mindistance = getMinDistance(q);
				minDistances.put(q, mindistance);
			}		
		}
		String[] arr = new String[minDist.size()];
		minDist.toArray(arr);
		try {
		int[] ar = new int[minDist.size()];
		for (int i = 0; i<minDist.size(); i++) {
			ar[i]=Integer.parseInt(arr[i]);
		}
		Arrays.sort(ar);
		for(int i=ar.length-1; i>=0; i++) {
			int a = ar[i];
			for (SeqNumber q: minDistances.keySet()) {
				if (a == minDistances.get(q)&&(!getRanking.contains(q))) {
					getRanking.add(q);
				}
			}
		}
		}
		catch (ArrayStoreException e) {
			System.out.println("Dummy");
		}
		List<SeqNumber> limited = new ArrayList<>();
		for (int i = 0; i<number; i++) {
			limited.add(getRanking.get(i));
		}
		return limited;
	}
}
