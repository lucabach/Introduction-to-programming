package HS18;
import java.util.*;

public class Blocks {

    public static int largestBlock(String string) {
    	int n = string.charAt(0);
    	int[][] DP = new int[n][n];
    	int i=0;
    	int j=0;
    	int k=1;
    	while (k<string.length()) {
    		while(i<n) {
    			i++;
    			while (j<n) {
    			DP[i][j]=string.charAt(k);
    			j++;
    			k++;
    			}
            }
    	}
    	int count1 = 1;
    	int count2 = 1;
    	for (int a=0; a<n;a++) {
    		for(int b=0; b<n;b++) {
    			int number1 = Integer.MAX_VALUE;
    			if (DP[a][b]==DP[a+1][b+1] && number1 != DP[a][b]) {
    				count2++;
    			}
    			if (DP[a][b]==DP[a+1][b+1] && count1>=count2) {
    				count1++;
    				number1 = DP[a][b];	
    			}
    		}
    	}
    	return Math.max((int)Math.sqrt(count1), (int)Math.sqrt(count2));
    }
    
    static int[][] large(String string){
       	int n = string.charAt(0);
    	int[][] DP = new int[n][n];
    	int i=0;
    	int j=0;
    	int k=1;
    	while (k<string.length()) {
    		while(i<n) {
    			i++;
    			while (j<n) {
    			DP[i][j]=string.charAt(k);
    			j++;
    			k++;
    			}
            }
    	}
    	return DP;
    }
    
    public static void main(String[]args) {
    	String s = "7\n" +
                "1 2 3 1 2 2 2\n" + 
                "4 5 6 2 2 2 2\n" + 
                "8 8 7 6 2 2 2\n" + 
                "8 8 9 2 3 0 9\n" + 
                "7 8 9 2 4 9 5\n" + 
                "4 5 6 2 2 3 2\n" + 
                "9 9 9 9 0 3 1";
    int[][]large= large(s);
    int n = s.length();
    for (int a =0; a<n;a++) {
		for(int b=0; b<n;b++) {
			System.out.println(large[a][b] + " ");
		}
    }
    }
}
