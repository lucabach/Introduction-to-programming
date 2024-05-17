import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class BmiChecker {
    
    public static void main(String[] args){
        File file = new File("body.dat.txt");
        List<Person> persons = null;
        try {
        Scanner scanner = new Scanner(file);
        persons = readPersons(scanner);
        scanner.close();
    	} catch (FileNotFoundException e) { 
    		System.out.println("No file found!");
    		System.exit(-1);
    		}
        
        printUnhealthy(persons, System.out);
    }
    
    /**
     * Reads the person data from the given Scanner and returns it as a list.
     */
    private static LinkedPersonList oldReadPersons(Scanner scanner) {
        LinkedPersonList persons = new LinkedPersonList();
        while(scanner.hasNextLine()) {
        	Person nextPerson = new Person(scanner.nextLine());
        	persons.addLast(nextPerson);
        }
        return persons;
    }
    
    /**
     * Reads the person data from the given Scanner and returns it as a list.
     */
    private static List<Person> readPersons(Scanner scanner) {
        List<Person> persons = new ArrayList<>();
        int row = 1;
        while(scanner.hasNextLine()) {
            try {
                persons.add(new Person(scanner.nextLine()));
            } catch(IllegalPersonFormatException e) {
                System.out.println("Error: illegal person data in row " + row + ": " +
                        e.getMessage());
            }
            row++;
        }
        return persons;
    }
    
    /**
     * Finds all persons that are of abnormal weight and prints their corresponding weight category.
     */
    static void printUnhealthy(List<Person> persons, PrintStream ausgabe) {
        for (Person person : persons) {
            String category = weightCategory(person);
            if(!category.equals("normal")) {
            	ausgabe.println(person + " is " + category + "!");
            }   
        }
    }
    
    /**
     * Returns the weight category of the given person as a String. Possible categories are "obese",
     * "overweight", "normal", and "underweight".
     */
    static String weightCategory(Person person) {
    	
        if(person.bodyMassIndex() >= 30) {
        	return "obese";
        }
        
        if(person.bodyMassIndex() >= 25) {
        	return "overweight";
        }
        
        if(person.bodyMassIndex() < 18.5) {
        	return "underweight";
        }
            
        return "normal";
    }
}
