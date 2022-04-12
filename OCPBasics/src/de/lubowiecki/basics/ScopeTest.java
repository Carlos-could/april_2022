package de.lubowiecki.basics;

import java.util.Scanner;

public class ScopeTest {
	
	private int i = 10; // Instanz-Scope
	private static String s = "Hallo Scope"; // Klassen-Scope
	
	public static void main(String[] args) {
		
		//lokale Variable
		int x = 15; // ist da, solange die Methode ausgeführt wird
		
		
	}
	
	public void machWas() {
		
		//lokale Variable
		int x = 15; // ist da, solange die Methode ausgeführt wird
		int i = 17; // localer Scope überlagert den Instanz-Scope
		
		
		if(true) { // neuer Scope
			// int i = 19; // Error: da i der Methode sichtbar ist, kann es nicht redeklariert werden
			int z = 22; // Wird am Ende von if entfernt
		}
		
		int z = 35; // z aus dem if ist nicht mehr da, und kann redeklariert werden
		
		{ // neuer Scope
			int a = 40;
		} // hier ist a out of scope
		
		Scanner scanner = new Scanner(System.in);
		
		String s = scanner.nextLine();
		
		switch(s.toLowerCase()) {
		
			case "a":
				String output = "A";
				break;
				
			case "b": 
				break;
				
			case "c":
				output = "C";  
				break;
		
		}
		
		Person p = new Person(); // Referenz p verweist auf ein Objekt auf dem Heap
		p = null; // Referenz wurde gelöst d.h. Objekt auf dem Heap stet für GC zur Verfügung
		
		
	}
	

}
