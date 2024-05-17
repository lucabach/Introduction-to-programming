import java.util.*;

public class SubsetSum {

	static List<Integer> subset = new ArrayList<Integer>();
	static boolean[][] dp;
	
	public static void main(String[] ags) {
		int[] a = new int [] {1, 4, 7, 8, 3};
		int k = 24;
		boolean bool = subsetsum(a, k);
		System.out.println();
		System.out.println(bool);
		System.out.println();
		if(bool) {
			System.out.print("{ ");
			for(int i=0; i<subset.size(); i++) {
				System.out.print(subset.get(i) + " ");
			}
			System.out.print("}");
		}
	}
	
	public static boolean subsetsum(int[] a, int k) {
		int m = a.length;
		boolean[][] dp = new boolean[m+1][k+1];
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=k; j++) {
				if(i ==0) {
					if(j==0) {
						dp[i][j]=true;
					}
					else {
						dp[i][j] = false;
					}
				}
				else if(j==0) {
						dp[i][j]=true;
				}
				else {
					try {
					dp[i][j] = dp[i-1][j] || dp[i-1][j-a[i-1]];
					}
					catch(Exception e) {
						dp[i][j] = false;
					}
				}
				}
			}
		if(dp[m][k]) {
		int i=m;
		int j=k;
		while(j>0 && i>0) {
				if(dp[i-1][j]) {
					subset.add(a[i-2]);
					i--;
				}
				else {
					subset.add(a[i-1]);
					j-=a[i-1];
					i--;
				}
		}
		}
					
		/*for(int i=0; i<=m; i++) {
			for(int j=0; j<=k; j++) {
				System.out.print(dp[i][j]+ " ");
			}
			System.out.println();
		}*/
		return dp[m][k];
		}
}
