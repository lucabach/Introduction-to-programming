/**
 * Eine Person mit diversen Eigenschaften, inkl. Alter, Gewichts, Grösse, Geschlecht und einigen
 * spezielleren Körper-Eigenschaften.
 */
public class Person {
    
	public int alter;
	public double gewicht;
	public double groesse;
	public boolean istMaennlich;
	public double schulterBreite;
	public double brustTiefe;
	public double brustBreite;
    /**
     * Erstellt eine neue Person mit den gegebenen Werten für die Eigenschaften.
     */
    Person(int alter, double gewicht, double groesse, boolean istMaennlich,
            double schulterBreite, double brustTiefe, double brustBreite) {
        // TODO
    	this.alter = alter;
    	this.gewicht = gewicht;
    	this.groesse = groesse;
    	this.istMaennlich= istMaennlich;
    	this.schulterBreite = schulterBreite;
    	this.brustTiefe=brustTiefe;
    	this.brustBreite = brustBreite;
    }
    
    String beschreibung() {
        // TODO
    	String gender = "f";
    	if (istMaennlich) {
    		gender = "m";
    	}
        return "Person: (" +gender+ ", " +alter+ " Jahre," +groesse+ " cm," + gewicht + " kg)" ;
    }
    
    double bodyMassIndex() {
        // TODO
    	double g = groesse/100;
    	double g2 = g*g;
    	double bmi = gewicht/g2;
        return bmi;
    }
}
