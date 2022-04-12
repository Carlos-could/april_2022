package de.lubowiecki.basics;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import de.lubowiecki.basics.enums.Wochentag;

// importiert nur den statischen Inhalt der Klasse/Enums etc 
import static de.lubowiecki.basics.enums.Wochentag.*;

public class Playground {
	
	public static void main(String[] args) {
		
		// Instanz
		Counter c1 = new Counter();
		c1.up();
		
		// Instanz
		Counter c2 = new Counter();
		c2.up();
		
		System.out.println(c1.getCount());
		System.out.println(c2.getCount());
		
		System.out.println();
		
		//StaticCounter c3 = new StaticCounter();
		//c3.up(); // Conter enthält eine statische Eigenschaft
		StaticCounter.up(); // Zugriff über die Klasse
		
//		StaticCounter c4 = new StaticCounter();
//		c4.up();
		StaticCounter.up();
		
//		System.out.println(c3.getCount());
//		System.out.println(c4.getCount());
		System.out.println(StaticCounter.getCount());
		
		System.out.println();
		
		// Statt ArrayList als Refernztyp verwendet man besser den Interface-Typ
		List<String> list = new ArrayList<>();
		list = new LinkedList<>(); // ... so kann man die Referenz auch mit jeder anderen List-Art verknüpfen
		
		final boolean x; // Runtime-Konstante
		x = true;
		
		final boolean y = true; // Kompiletime-Konstante
		
		while(x) { // Kompiler kann bei einer Runtime-Konstante den Zustand zur Kompile-Zeit nicht ermitteln
		}
		
		System.out.println("x: " + x); // String-Verkettung zur Laufzeit
		System.out.println("y: " + y); // String-Verkettung zur Kompilezeit
	}
	
	private static void machWas(Wochentag tag) {
		String x = "Hallo";
	}

}
