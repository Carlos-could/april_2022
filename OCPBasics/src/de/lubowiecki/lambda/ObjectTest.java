package de.lubowiecki.lambda;

import java.util.ArrayList;
import java.util.List;

public class ObjectTest {
	
	public static void main(String[] args) {
		
		List<Stadt> sammlung = new ArrayList<>();
		sammlung.add(new Stadt("Hamburg", 1_900_000));
		sammlung.add(new Stadt("Kiel", 400_000));
		sammlung.add(new Stadt("Flensburg", 500_000));
		sammlung.add(new Stadt("München", 1_600_000));
		
		// Aufruf von statischen Methoden einer (fremden) Klasse, deren Signatur passt 
		// Aufruf von Instanz-Methoden auf einem Objekt einer (fremden) Klasse, deren Signatur passt 
		
		// Aufruf von Instanz-Methoden auf einem Objekt des Elementes, dass gerade verarbeitet wird
		// Rückgabetyp mus passen
		
		sammlung.stream()
			// void accept(Stadt s)
			.forEach(Stadt::ausgabe); // Hier können auch Instanz-Methoden von Stadt aufgerufen werden
			//.forEach(s -> s.ausgabe()); // Stadt::ausgabe entspricht s -> s.ausgabe()
		
		
	}
	

}

class Stadt {
	
	private final String name;
	private final int einwohner;
	
	public Stadt(String name, int einwohner) {
		this.name = name;
		this.einwohner = einwohner;
	}
	
	public String getName() {
		return name;
	}
	public int getEinwohner() {
		return einwohner;
	}
	
	@Override
	public String toString() {
		return "Stadt [name=" + name + ", einwohner=" + einwohner + "]";
	}

	public void ausgabe() {
		System.out.println(this);
	}
}