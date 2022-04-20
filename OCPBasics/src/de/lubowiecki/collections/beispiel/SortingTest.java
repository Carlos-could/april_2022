package de.lubowiecki.collections.beispiel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortingTest {
	
	private Person[] persons = new Person[10];
	
	private Scanner scanner = new Scanner(System.in);
	
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	
	public static final Comparator<Person> FNAME_COMPARATOR = (p1, p2) -> {
		
		if(p1 == null)
			return -1;
		
		if(p2 == null)
			return 1;
		
		if(p1 == null & p2 == null)
			return 0;
			
		return p1.getFirstName().compareTo(p2.getFirstName());
	};
	
	public static final Comparator<Person> LNAME_COMPARATOR = (p1, p2) -> {
		
		if(p1 == null)
			return -1;
		
		if(p2 == null)
			return 1;
		
		if(p1 == null & p2 == null)
			return 0;
			
		return p1.getLastName().compareTo(p2.getLastName());
	};
	
	private int id;

	public static void main(String[] args) {
		
		new SortingTest().init();
	}

	private void init() {
		
		System.out.println("START");
		
		app: while(true) {
			
			switch(getInput("Option").toLowerCase()) {
				
				case "add": 
					Person p = createPerson();
					persons[p.getId() - 1] = p;
					break;
				
				case "show": 
					showPersons();
					break;
					
				
				case "sort": 
					// Arrays.sort(persons); // Comparable ist in Person nicht implementiert
					Arrays.sort(persons, LNAME_COMPARATOR);
					break;
					
				case "exit": 
					break app;	

				default:
					System.out.println("Falsche Eingabe...");
			}
		}
		
		System.out.println("ENDE");
	}
	
	private void showPersons() {
		for(Person p : persons) {
			if(p == null)
				continue;
			
			System.out.println(createOutput(p));
		}
	}
	
	private String createOutput(Person p) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n").append("ID: ").append(p.getId())
			.append("\n").append("Vorname: ").append(p.getFirstName())
			.append("\n").append("Nachname: ").append(p.getLastName())
			.append("\n").append("Geburtsdatum: ").append(p.getBirthDate().format(FORMATTER))
			.append("\n");
		
		return sb.toString();
	}
	
	private String getInput(String label) {
		System.out.print("\n" + label + ": ");
		return scanner.nextLine();
	}
	
	private Person createPerson() {
		Person p = new Person();
		p.setId(++id);
		p.setFirstName(getInput("Vorname"));
		p.setLastName(getInput("Nachname"));
		p.setBirthDate(createBirthDate());
		return p;
	}
	
	private LocalDate createBirthDate() {
		// TODO: Validierung
		return LocalDate.parse(getInput("Geburtsdatum"), FORMATTER);
	}
	
	
}
