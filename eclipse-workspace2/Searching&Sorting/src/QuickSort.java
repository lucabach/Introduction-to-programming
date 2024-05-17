
public class QuickSort {

	/* 1:chose pivot element (mostly done randomly)
	 * 2: pivot element to the back of the array
	 * 3: initialize leftpointer and rightpointer. leftpointer searches for elements bigger than the pivot,
	 * while rightpointer searches for elements smaller. when two are found, swap them. Do this until leftpointer>rightpointer.
	 * 4: swap the pivot with the last element found by leftpointer. Now the pivot is in its correct spot.
	 * 5: Call the algorithm recursively on the two halfes (left and right of the pivot).
	*/
	
	
	static int[] a = {1,10, 5, 8, 9, 11, 44, 18, 1, 3, 2, 39};
	
	
	public static void main(String[] args) {
		quickSort(a, 0, a.length-1);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	 /* public static void quickSort(int[] A , int left , int right){
		    
		    if (left < right){
		      int pi = partition(A,left,right);
		      quickSort(A,left, pi - 1);
		      quickSort(A, pi + 1 , right );
		    }
	  }
		  
		  public static int partition(int[] A , int left, int right){
		    int pivot = A[right];
		    int i = (left - 1);
		    
		    for(int j = left; j < right; j++){
		      if(A[j] <= pivot){
		        i++;
		        int temp = A[i];
		        A[i] = A[j];
		        A[j] = temp;
		        
		      }
		    }
		      int temp = A[i + 1];
		      A[i + 1] = A[right];
		      A[right] = temp;
		      
		      return i + 1;
		      
		    }
		    */
	
	public static void quickSort(int[] A, int left, int right) {
		if(left<right) {												//base case to avoid infinite loop
			int p = partition(A, left, right);							//insert the pivot at its right place
			quickSort(A, left, p-1);									//sort part left and right of pivot recursively
			quickSort(A, p+1, right);
		}
	}
	
	
	public static int partition(int[] A, int left, int right) {
		int pivot = A[right];											//choose pivot as rightmost element
		int i = left-1;													//important i-1
				
		for(int j=left; j<right; j++) {									//sort
			if(A[j]<=pivot) {
				i++;
				int temp=A[i];
				A[i]= A[j];
				A[j]=temp;
			}
		}
		int temp = A[i+1];												//swap first element bigger than pivot with the pivot (put it at its right place).
		A[i+1]= pivot;
		A[right]=temp;
	    return i+1;															//return index of pivot
   }
	
}
