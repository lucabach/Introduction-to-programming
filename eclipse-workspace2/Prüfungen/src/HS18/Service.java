package HS18;

import java.util.*;
import java.util.Scanner;

public class Service {
	List<Student> students;

	public Service(Scanner scanner) {
		students = new ArrayList<>();

		while (scanner.hasNextInt()) {
			int id = scanner.nextInt();
			double grade_1 = scanner.nextDouble();
			double grade_2 = scanner.nextDouble();
			double grade_3 = scanner.nextDouble();

			students.add(new Student(id, grade_1, grade_2, grade_3));
		}
	}

	public List<Integer> critical(double bound1, double bound2) {
		List<Integer> critical = new ArrayList<>();

		for (Student s : students) {
			if (s.grade_1 <= bound1 && s.grade_2 + s.grade_3 < bound2)
				critical.add(s.id);
		}

		return critical;
	}
	
	public List<Integer> top(int limit) {
		// Sort by best students
		Collections.sort(students);
		Collections.reverse(students);

		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < limit; i++) {
			if (i >= students.size())
				break;
			result.add(students.get(i).id);
		}

		return result;
	}
}

class Student implements Comparable<Student> {
	int id;
	double grade_1, grade_2, grade_3;
	double sum;

	public Student(int id, double grade_1, double grade_2, double grade_3) {
		this.id = id;
		this.grade_1 = grade_1;
		this.grade_2 = grade_2;
		this.grade_3 = grade_3;

		this.sum = grade_1 + grade_2 + grade_3;
	}

	@Override
	public int compareTo(Student o) {
		if (this.sum > o.sum)
			return 1;
		else if (this.sum < o.sum)
			return -1;
		else
			return 0;
	}
}





