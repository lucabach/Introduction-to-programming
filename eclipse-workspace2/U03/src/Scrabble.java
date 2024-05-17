import java.util.Scanner;
/*
 * Author: 
 * 
 * 
 * Dieses Programm gibt den eingegebenen Namen als in einem Quadrat angeordnete Scrabble-Steine aus.
 */
public class Scrabble {

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Name eingeben:");
    	String name = scanner.next();
		drawNameSquare(name);
		scanner.close();
	}
	
    public static void drawNameSquare(String name) {
		// TODO: Implementieren Sie die Methode   
    	
    	int n = name.length();
    	System.out.print("+");
    	for(int i=0; i<n; i++) {
    		System.out.print("---+");
    	}
    	System.out.println();
    	System.out.print("| ");
    	
       	for(int i=0; i<n; i++) {
    		System.out.print(name.charAt(i) + " | ");
    	}
       	
       	System.out.println();
       	System.out.print("+");
    	int space = n-2;
    	
    	
    	for(int i=0; i<n-2; i++) {
    		
    		if (i==0) {
    			for(int i1=0; i1<n; i1++) {
    			System.out.print("---+");
    			}
    			System.out.println();
    		}
    		System.out.print("| " + name.charAt(i+1) + " | ");
    		
    		for(int j=0; j<space*4 -2; j++) {
    			System.out.print(" ");
    		}
    		
    		System.out.print("| " + name.charAt(n-2-i) + " | ");
    		System.out.println();
    		
    		if(i!= n-3) {
    		System.out.print("+---+");
    		
    		
    		for(int j=0; j<space*4 -1; j++) {
    			System.out.print(" ");
    		}
    		
    		
    		System.out.print("+---+");
    		System.out.println();
    		}
    		
    		if (i==n-3) {
    			System.out.print("+");
    			for(int i1=0; i1<n; i1++) {
    			System.out.print("---+");
    			}
    			System.out.println();
    		}
    	}
    	
    	System.out.print("| ");
    	
    	for(int i=n-1; i>=0; i--) {
    		System.out.print(name.charAt(i) + " | ");
    	}
    	System.out.println();
    	System.out.print("+");
    	
    	for(int i=0; i<n; i++) {
    		System.out.print("---+");
    	}
    	
    }

}
