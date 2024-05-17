package FS20;
import java.util.*;

public class House {
	String name;
	List<Student> house;
	int points;
	School school;
	// Aendern Sie nicht die Signaturen der bestehenden Methoden.
	// Sie duerfen weitere Methoden, Felder, und Konstruktoren zu der Klasse hinzufuegen.
	
	House (String name){
		this.name = name;
		this.points = 0;
		this.house = new ArrayList<Student>();
	}
	
	public String name() {
		// TODO: Implementieren Sie die Methode
		return this.name;
	}
	
	public int points() {
		// TODO: Implementieren Sie die Methode
		return this.points;
	}
	
	public void assign(Student student) {
		// TODO: Implementieren Sie die Methode
		if (student == null || school.registeredStudents.contains(student)) {
			throw new IllegalArgumentException();
		}
		else {
		house.add(student);
		this.school.registeredStudents.add(student);
		student.house = this;
		}
	}
}