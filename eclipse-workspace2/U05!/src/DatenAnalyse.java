import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import gui.Window; // dieser Import wird benoetigt, falls das Histogramm in einem Fenster gezeichnet wird und die Window-Klasse verwendet wird

public class DatenAnalyse {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("groessen.txt"));
        int[] groessen = liesGroessen(scanner);
        scanner.close();
        
        einfacheAnalyse(groessen);

        int histMin = 140; //  Wir nehmen an, dass alle Groessen >= 1.40m sind
        int histMax = 200; //  Wir nehmen an, dass alle Groessen < 2.00m sind
        histogrammAnalyse(groessen, histMin, histMax);
    }
    
    /**
     * Liest die Körpergrössen von dem gegebenen Scanner ein und gibt sie als Array zurück.
     */
    static int[] liesGroessen(Scanner scanner) {
    	int[] groessen = new int[scanner.nextInt()];
    	for(int i=0; i<groessen.length; i++) {
    		groessen[i] = scanner.nextInt();
    	}
        return groessen;
    }
    
    /**
     * Macht eine einfache Datenanalyse: Gibt die Anzahl Daten, das Minimum, das Maximum und den
     * Durchschnitt der Körpergrössen aus.
     */
    static void einfacheAnalyse(int[] groessen) {
    	int min = Integer.MAX_VALUE;
    	int max = Integer.MIN_VALUE;
    	int sum = 0;
    	for(int i=0; i<groessen.length; i++) {
    		min = Math.min(min, groessen[i]);
    		max = Math.max(max, groessen[i]);
    		sum += groessen[i];
    	}
    	int durchschnitt = sum/groessen.length;
    	System.out.println("min: " +min);
    	System.out.println("max: " +max);
    	System.out.println("durchschnitt: " +durchschnitt);
    	System.out.println();
    }
    
    /**
     * Erstellt ein Histogramm der Körpergrössen und gibt es aus. Zuerst wird der Benutzer nach der
     * Anzahl Histogramm-Klassen gefragt.
     */
    static void histogrammAnalyse(int[] groessen, int histMin, int histMax) {
    	int dif = histMax-histMin;
    	int klassen = dif;
    	int abstand = 1;
    	if(dif%4 == 0) {
    		klassen = dif/4;
    		abstand = 4;
    	}
    	else if(dif%3 == 0) {
    		klassen = dif/3;
    		abstand = 3;
    	}
    	else if(dif%2 == 0) {
    		klassen = dif/2;
    		abstand = 2;
    	}
    	int currentmin = histMin;
    	int[] histogramm = erstelleHistogramm(groessen, histMin, histMax, klassen);
    	for(int i=0; i<histogramm.length; i++) {
    		int currentmax = currentmin+abstand;
    		System.out.print("[" + currentmin + ", " + currentmax + ") ");
    		for(int j=0; j<histogramm[i]; j++) {
    			System.out.print("| ");
    		}
    	System.out.println();
    	currentmin+=abstand;
    	}
    }
    
    /**
     * Erstellt von den Körpergrössen in dem "groessen"-Array ein Histogramm mit den gegebenen
     * Grössen Minimum, Maximum und Anzahl Klassen.
     * 
     * @return das Histogramm, als Array. Jedes Element entspricht einer Klasse im Histogramm und
     *         enthält die Anzahl Körpergrössen in dieser Klasse.
     */
    static int[] erstelleHistogramm(int[] groessen, int histMin, int histMax, int klassen) {
    	int[] histprimal = new int[histMax-histMin];
        for(int i=0; i<groessen.length; i++) {
        	int current = groessen[i];
        	int index = (current- histMin);
        	histprimal[index]+=1;
        }
        int abstand = (histMax-histMin) / klassen;
        int[] hist = new int[klassen];
        int j = 0;
        int sum = 0;
        for(int i=0; i<histprimal.length; i++) {
        	sum+= histprimal[i];
        	if(i%abstand==0 && i!=0) {
        		hist[j]=sum;
        		sum=0;
        		j++;
        	}
        }
        return hist;
    }
    
    /**
     * Gibt die Klassenbreite in einem Histogramm mit den gegebenen Grössen Minimum, Maximum und
     * Anzahl Klassen zurück. Falls sich die gesamte Breite des Histogramms nicht restlos auf die
     * Klassen aufteilen lässt, wird die Klassenbreite aufgerundet. Das heisst, dass das Histogramm
     * "histMax" überschreiten kann.
     */
    static int klassenBreite(int histMin, int histMax, int klassen) {
        return 0;
    }
}