
public class LongestAscendingSubsequence {
	
	public static int[] A = {1, 4, 7, 2, 4, 8, 5, 10, 4, 6, 2};
	public static int[] lastbefore;
	public static int last;
	
	public static void main(String[] args) {
		int longestlength = las(A);
		System.out.println(longestlength);
		System.out.println();
		System.out.print("{");
		for(int i=0; i<longestlength; i++) {
			System.out.print(last + ", ");
			last = lastbefore[last];
		}
		System.out.println("}");
	}
	
	public static int las(int[] A) {
		int n = A.length;
		int length = 1;
		int[] dp = new int[n];
		//assuming the values in A <= 100
		lastbefore = new int[100];
		dp[0]=A[0];
		for(int i=1; i<n; i++) {
			if(A[i]<dp[0]) {
				dp[0]=A[i];
			}
			else if(dp[length-1]<=A[i]) {
				lastbefore[A[i]] = dp[length-1];
				last = A[i];
				dp[length] = A[i];
				length++;
			}
			else {
				int index = findIndex(A[i], dp, 0, length-1);
				dp[index]=Math.min(dp[index], A[i]);
			}
		}
		return length;
	}
	
	public static int findIndex(int a, int[] dp, int left, int right) {
		int middle = (left+right)/2;
		if(left<right) {
			middle = (left+right)/2;
			
			if(a == dp[middle]) {
				return middle;
			}
			
			else if(a<dp[middle]) {
				return findIndex(a, dp, middle+1, right);
			}
			
			else {
				return findIndex(a, dp, left, middle-1);
			}
		}
		else {
			return left;
		}
	}
}
