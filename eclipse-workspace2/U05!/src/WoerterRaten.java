import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class WoerterRaten {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("woerter.txt"));
        String[] woerter = liesWoerter(scanner);
        scanner.close();
        
        rateSpiel(woerter);
    }
    
    /**
     * Liest die Wörter von dem gegebenen Scanner ein und gibt sie als Array zurück.
     */
    static String[] liesWoerter(Scanner scanner) {
        String[] woerter = new String[scanner.nextInt()];
        for(int i = 0; i < woerter.length; i++) {
            woerter[i] = scanner.next();
        }
        return woerter;
    }
    
    /**
     * Führt das Rate-Spiel einmal durch.
     */
    static void rateSpiel(String[] woerter) {
    	Scanner scanner = new Scanner(System.in);
    	String tipp = "";
    	String wort = zufallsWort(woerter);
    	while(!tipp.equals(wort)) {
    	System.out.println("Tipp?");
    	tipp = scanner.next();
    	System.out.println(hinweis(wort, tipp));
    	}
    }
    
    /**
     * Wählt zufällig ein Wort aus dem "woerter"-Array aus und gibt es zurück.
     */
    static String zufallsWort(String[] woerter) {
    	Random random = new Random();
    	int n = woerter.length;
    	int index = random.nextInt(n);
        return woerter[index];
    }
    
    /**
     * Vergleicht das gegebene "wort" und die "tipp"-Zeichenkette und gibt einen Hinweis zurück.
     * Folgende Hinweise sind möglich: "ist", "beginnt mit", "endet mit", "beginnt mit und endet
     * mit", "enthält" oder "enthält nicht".
     */
    static String hinweis(String wort, String tipp) {
    	if (wort.equals(tipp)) {
    		return "Das Wort ist " +wort+ "!";
    	}
    	else if(wort.contains(tipp)) {
    		if(wort.startsWith(tipp)) {
    			return "Das Wort startet mit " +tipp;
    		}
    		if(wort.endsWith(tipp)) {
    			return "Das Wort endet mit " +tipp;
    		}
    		else {
    			return "Das Wort enthält " +tipp;
    		}
    	}
    	else {
        return "Das Wort enthält nicht " +tipp;
    	}
    }
    
}