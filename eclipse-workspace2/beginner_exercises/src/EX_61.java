
public class EX_61 {

	public static void main(String[] args) {
			int A[] = {3,5,11,11,13,17,19,23,29,31};
			int k_l = 6;
			int k_r = 18;
					
	      int start = 0;
	      int r = 9;
	      int l = 0;
	      int end = 0;
	      while (l < r-1) {
	        int m = l + (r-l)/2;
	        if (A[m] == k_l) {
	          start = m;
	          break;
	        } else if (A[m] < k_l) {
	          l = m;
	        } else {
	          r = m;
	        }
	      }
	      if (A[start] != k_l){
	        start = l;
	        while(A[start] < k_l){
	          start++;
	        }
	      }
	     
	      r = 9;
	      l = start;
	      end = 0;
	      while (l < r-1) {
	        int m = l + (r-l)/2;
	        if (A[m] == k_r) {
	          end = m;
	          break;
	        } else if (A[m] < k_r) {
	          l = m;
	        } else {
	          r = m;
	        }
	      }
	      if (A[end] != k_r){
	        end = l;
	        while(A[end] > k_r){
		          end--;
		        }while(end < 10-1 && A[end+1] <= k_r){
			          end++;
		        }
	      }
	      System.out.println(start );
	      System.out.println(end );

	      

	}

}
