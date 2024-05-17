package HS20;

public class Square {
	
    public static void main(String[] args) {
    	int[][] t = { 
    			{0, 3, 5, 7, 2}, 
    			{2, 7, 4, 3, 0}, 
    			{4, 4, 6, 1, 4}, 
    			{7, 7, 4, 3, 3}, 
    			{0, 3, 5, 7, 2} 
    		};

    	System.out.println(checkProperty(t));
    }

    static boolean checkProperty(int[][] x) {
    	int n = x.length;
    	int a = n;
    	int b = 0;
    	for (int i = 0; i<n; i++) {
    		while (b<n-i) {
    		if (x[a-1-i][b+i]!=x[i][b+i]) {
    			return false;
    		}
    		b++;
    		}
    	}
    	return true;
    }

}
    

