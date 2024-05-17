
public class HeapSort {
	
	//the code is faulty/not complete, but the algorithm works as follows:
	//represent the array as a tree. Now Convert it into a max heap.
	//Now the biggest element in the array is at the bottom, so switch it with the last
	//and remove it from the heap. WIth the remaining nodes, build again a max heap 
	//and repeat the same procedure over and over.
	
	static int[] a = {1,10, 5, 8, 9, 11, 44, 18, 1, 3, 2, 39};
	
	public static void main(String[] args) {
		int[] sorted = sort(a);
		for(int i=0; i<a.length; i++) {
			System.out.print(sorted[i] + " ");
		}
	}
	
	public static int[] sort(int[] a) {
		int n = a.length;
		buildMaxHeap(a);
		return a;
	}
	
	public static void buildMaxHeap(int[] a) {
		int n = a.length;
		for(int i = Math.floorDiv(n, 2); i>0; i++) {
			heapify(a, i);
		}
	}
	
	public static void heapify(int[] a, int i) {
		
		int n = a.length;
		int left = 2*i;
		int right = 2*i +1;
		int max = 0;
		
		if(left<n && a[left]>a[i]) {
			max = left;
		}
		if(right<n && a[right]>a[max]) {
			max = right;
		}
		
		if(max!=i) {
			int temp = a[i];
			a[i] = a[max];
			a[max] = temp;
		}
	}
}
