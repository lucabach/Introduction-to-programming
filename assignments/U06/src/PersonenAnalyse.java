import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

/* 
 * Author: Maximiliana Muster
 * für Einführung in die Programmierung
 * 
 * Analysiert einen Datensatz von Personen-Eigenschaften. Findet "ungesunde" Personen und teilt
 * alle Personen in Trainingspartner-Paare ein.
 */
public class PersonenAnalyse {
    
    public static void main(String[] args) throws FileNotFoundException {
    	Scanner scanner = new Scanner(new File ("body.dat.txt"));
    	Person[] person = liesPersonen(scanner);
    	scanner.close();
    	
    	PrintStream ungesundAusgabe = new PrintStream(new File("ungesund.txt"));
    	druckeUngesunde(person, ungesundAusgabe);
    	ungesundAusgabe.close();
    }

    /**
     * Liest die Personen-Daten von dem gegebenen Scanner ein und gibt sie als Person[] zurück.
     */
    static Person[] liesPersonen(Scanner scanner) {
        // TODO
    	int n = scanner.nextInt();
    	Person[] person = new Person[n];
    	for(int i=0; i<n; i++) {
        double schulterBreite = scanner.nextDouble();
        double brustTiefe = scanner.nextDouble();
        double brustBreite = scanner.nextDouble();
        int alter = scanner.nextInt();
        double gewicht = scanner.nextDouble();
        double grösse = scanner.nextDouble();
        int gender = scanner.nextInt();
        boolean istMaennlich = true;
        if(gender == 0) {
        	istMaennlich = false;
        }
        person[i] = new Person(alter, gewicht, grösse, istMaennlich, schulterBreite, brustTiefe, brustBreite);
    	}
    	return person;
    }
    
    /**
     * Findet alle Personen, die nicht normalgewichtig sind und gibt deren Beschreibungen, sowie die
     * entsprechende Gewichts-Klassen aus.
     */
    static void druckeUngesunde(Person[] personen, PrintStream ausgabe) {
        // TODO
    	String[] gewichtsklasse = new String[personen.length];
    	for (int i=0; i<personen.length; i++) {
    		Person current = personen[i];
    		if(current.bodyMassIndex()<18.5) {
    			gewichtsklasse[i] = "untergewichtig";
    		}
    		else if (current.bodyMassIndex()<25) {
    			gewichtsklasse[i] = "normalgewichtig";
    		}
    		else if(current.bodyMassIndex()<30) {
    			gewichtsklasse[i] = "übergewichtig";
    		}
    		else {
    			gewichtsklasse[i] = "fettleibig";
    		}
    		if (!gewichtsklasse[i].equals("normalgewichtig")) {
    			ausgabe.println(personen[i].beschreibung()+ " ist " + gewichtsklasse[i]);
    		}
    	}
    }

    /**
     * Gibt die Partner-Qualität von zwei Trainingspartner p1 und p2 zurück. Wert liegt zwischen 0
     * (schlechtester Wert) und 1 (bester Wert).
     */
    static double partnerQualitaet(Person p1, Person p2) {
        // TODO
        return 0;
    }
}