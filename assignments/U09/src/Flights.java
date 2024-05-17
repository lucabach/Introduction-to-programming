import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Flights {

	public static void main(String[] args) throws FileNotFoundException {
		calculateMiles(new File("flights.txt"), new File("miles.txt"));
	}

	/**
	 * Liest eine Datei 'input' mit Flügen von Personen ein, berechnet die Anzahl Meilen pro Person
	 * und schreibt das Resultat in eine Datei 'output'.
	 * 
	 * Verändern Sie <b>nicht</b> die Signatur dieser Methode.
	 */
	public static void calculateMiles(File input, File output) throws FileNotFoundException {
		// TODO
		Scanner scanner = new Scanner(input);
		PrintStream printstream = new PrintStream(output);
		while(scanner.hasNext()) {
			String name = scanner.nextLine();
			String flightNumber = scanner.next();
			int points = 0;
			while(!flightNumber.equals(".")) {
				String date = scanner.next();
				String category = scanner.next();
				int distance = 125;
				if(scanner.hasNextInt()) {
					distance = scanner.nextInt();
				}
				int factor = 1;
				if(category.equals("BUSINESS")) {
					factor=2;
				}
				else if(category.equals("FIRST")) {
					factor=3;
				}
					points+=distance*factor;
					flightNumber = scanner.next();
				}
			scanner.nextLine();
			    printstream.println(name + ": " +points);
		}
		scanner.close();
		printstream.close();
	}

}
