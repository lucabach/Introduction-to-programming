package FS20;

public class Student {
	String firstName;
	String lastName;
	House house;
	// Aendern Sie nicht die Signaturen der bestehenden Methoden und Konstruktoren.
    // Sie duerfen weitere Methoden, Felder, und Konstruktoren zu der Klasse hinzufuegen.
	
	public Student(String firstName, String lastName) {
		// TODO: Implementieren Sie die Methode
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String firstName() {
		// TODO: Implementieren Sie die Methode
		return this.firstName;
	}
	
	public String lastName() {
		// TODO: Implementieren Sie die Methode
		return this.lastName;
	}
	
	public void givePoints(int points) {
		// TODO: Implementieren Sie die Methode
		if (!(this.house.school.registeredStudents.contains(this))) {
			return;
		}
		if (points >= 0) {
			this.house.points += points;
		}
		else if ((this.house.points+= points) < 0) {
			this.house.points = 0;
		}
		else {
			this.house.points+= points;
		}
	}
}
