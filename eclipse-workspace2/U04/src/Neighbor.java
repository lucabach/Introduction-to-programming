
public class Neighbor {

	public static void main(String[] args) {
		
		int[] test1 = new int[] {1, 4, 5, 7, 9, 10};
		int[] result1 = neighbor(test1, 5);
		if (result1 != null && result1.length == 3 && result1[0] == 5 && result1[1] == 4 && result1[2] == 7) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		
		int[] test2 = new int[] {1, 4, 5, 6, 9, 10};
		int[] result2 = neighbor(test2, 5);
		if (result2 != null && result2.length == 3 && result2[0] == 5 && ((result2[1] == 4 && result2[2] == 6) || (result2[1] == 6 && result2[2] == 4))) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		
		int[] test3 = new int[] {1, 4, 5, 6, 9, 10};
		int[] result3 = neighbor(test3, 10);
		if (result3 != null && result3.length == 3 && result3[0] == 10 && result3[1] == 9 && result3[2] == 6) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}	
	}
	
	public static int[] neighbor(int[] sequence, int key) {
		// TODO: Schreiben Sie hier Ihre Loesung
		
			int[] copy = new int[sequence.length];
			for(int i=0; i<sequence.length; i++) {
				copy[i] = sequence[i];
			}
			int[] res = new int[3];
			int k=0;
			while(k<3) {
				int n = sequence.length;
				int [] difference = new int[n];
				for(int i=0; i<n; i++) {
					difference[i]= key-copy[i];
				}
				int min1 = Integer.MAX_VALUE;
				int min1index = 0;
			for(int i=0; i<n; i++) {
				if(Math.abs(difference[i])<min1) {
					min1 = difference[i];
					min1index = i;
				}
				}
			res[k]=copy[min1index];
			k++;
			for(int i=0; i<n; i++) {
				if(difference[i]==min1) {
					copy[i]=Integer.MAX_VALUE;
				}
			}
			}
			return res;
	}
}
