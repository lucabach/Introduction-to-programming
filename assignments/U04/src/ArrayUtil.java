
public class ArrayUtil {
	
	public static void main(String[] args) {
		int[] x = new int[] {0, 9, 90, -1, 4, 5, 6, -2, 1};
		int[] neu = zeroInsert(x, 0);
		for(int i=0; i<neu.length; i++) {
			System.out.println(neu[i]);
		}
		System.out.println();
		System.out.println(tenFollows(x, 0));
	}
	
	public static int[] zeroInsert(int[] x, int i) {
		// TODO: Vervollstaendigen Sie den Code wie in der Aufgabenbeschreibung beschrieben
		int n = x.length;
		if(i == n-1) {
			return x;
		}
		else {
			if((x[i] >0 && x[i+1]<0) || (x[i]<0 && x[i]>0)) {
				n+=1;
				int index = 0;
				int[]xnew = new int[n];
				for(int j=0; j<n; j++) {
					if(j==i+1) {
						xnew[j]=0;
					}
					else {
						xnew[j] = x[index];
						index++;
					}
				}
				i+=1;
				return zeroInsert(xnew, i);
			}
			else {
				i+=1;
				return zeroInsert(x, i);
			}
		}
	}
	
	public static boolean tenFollows(int[] x, int index) {
		// TODO: Vervollstaendigen Sie den Code wie in der Aufgabenbeschreibung beschrieben
		for(int i=index; i<x.length-1; i++) {
			if(x[i+1] == 10*x[i]) {
				return true;
			}
		}
		return false;
	}
}
