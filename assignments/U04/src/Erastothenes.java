import java.util.*;

public class Erastothenes {
	
	static List<Integer> primenumbers = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("Gaben Sie eine beliebige Zahl ein:");
		int limit = scanner.nextInt();
		sieb(limit);
		scanner.close();
		System.out.println("Anzahl Primzahlen von 1 bis " +limit+ ": " +primenumbers.size());
		System.out.println();
		System.out.println("Primzahlen: ");
		for(int i=0; i<primenumbers.size(); i++) {
			System.out.print(primenumbers.get(i)+ ", ");
		}
	}
	
	public static void sieb(int limit) {
		int[] numbers = new int[limit+1];
		for(int i=0; i<=limit; i++) {
			numbers[i] = i;
		}
		for(int i=2; i<=limit; i++) {
			int current = numbers[i];
			if(current!=0) {
				primenumbers.add(current);
				for(int i1=current; i1<=limit; i1+=current) {
					numbers[i1] = 0;
				}
			}
		}
	}
	
}
