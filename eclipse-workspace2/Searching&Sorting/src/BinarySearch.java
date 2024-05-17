public class BinarySearch {

	static int[] a = {1,3, 5, 8, 9, 11, 14, 18, 23, 29, 34, 39};
	
	public static void main(String[] args) {
		int index = search(a, 12);
		System.out.println(index);
	}
	
	public static int search(int[]a, int x) {
		int left = 0;
		int right= a.length -1;
		while(left<=right) {
			int mid = ((left+right)/2);
			if(a[mid]==x) {
				return mid;
			}
			else if(a[mid]<x) {
				left+=mid-1;
			}
			else {
				right-= mid-1;
			}
		}
		return -1;
		}
	
}
