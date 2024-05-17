package FS20;

import java.util.*;

public class School {
	List<String> names = new ArrayList<String>();
	Map<House, Integer> house = new HashMap<>();
	List<Student> registeredStudents = new ArrayList<>();	// Aendern Sie nicht die Signaturen der bestehenden Methoden.
    // Sie duerfen weitere Methoden, Felder, und Konstruktoren zu der Klasse hinzufuegen.
	
	public House createHouse(String name) {
		// TODO: Implementieren Sie die Methode
		if (names.contains(name) || name == null) {
			throw new IllegalArgumentException();
		}
		House current = new House(name);
		this.house.put(current, current.points);
		names.add(name);
		current.school = this;
		return current;
	}
	
	public House winner() {
		// TODO: Implementieren Sie die Methode
		int max = 0;
		House winner = new House("a");
		for (House current : house.keySet()) {
			if (current.points>=max) {
				max = current.points;
				winner = current;
			}
		}
			if (house.isEmpty()) {
				throw new IllegalArgumentException();
			}
		return winner;
	}
	
	public int points() {
		// TODO: Implementieren Sie die Methode
		int sum = 0;
		for (House current : house.keySet()) {
			int poinz = current.points;
			sum+=poinz;
		}
		return sum;
	}
}
