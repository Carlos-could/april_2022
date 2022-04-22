package de.lubowiecki.jdbc.orm;

import java.util.Scanner;

public class UserManagementApp {

	public static void main(String[] args) {
		
		UserMapper mapper = new UserMapper();
		
		try {
			// findAll
			//mapper.findAll().forEach(u -> System.out.println(u.getId() + ", " + u.getFirstname() + " " + u.getLastname()));
			
			// findById
//			User u = mapper.findById(3);
//			System.out.println(u.getId() + ", " + u.getFirstname() + " " + u.getLastname());
			
			// delete
			//mapper.delete(4);
			
			// insert
			Scanner scanner = new Scanner(System.in);
			User u = new User();
			System.out.print("Vorname: ");
			u.setFirstname(scanner.nextLine());
			System.out.print("Nachname: ");
			u.setLastname(scanner.nextLine());
			mapper.insert(u);
			
		}
		catch(Exception e) {
			System.out.println("Problem beim Lesen aus der DB.");
		}
	}
}
