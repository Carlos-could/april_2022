package de.lubowiecki.innerclasses;

import static de.lubowiecki.innerclasses.Outer2.Inner2;

public class InnerClassTest2 {

	public static void main(String[] args) {
		
		// Für die Erzeugung eines Inner1-Objektes wird ein Outer1-Objekt verlangt
		
		Outer1.Inner1 in1 = new Outer1().new Inner1();
		
		Outer1 out1 = new Outer1();
		Outer1.Inner1 in1_1 = out1.new Inner1();
		
		// Für die Erzeugung eines Inner2-Objektes wird KEIN Outer2-Objekt verlangt
		Outer2.Inner2 in2 = new Outer2.Inner2();
		
		// Nur mit einem statischen Import möglich
		Inner2 in2_2 = new Inner2();

	}
}

class Outer1 {
	
	// Outer1 darf Eigenschaften und Methoden von Inner1 NICHT direkt benutzen
	
	class Inner1 {
		
		//static int x; // Member-Inner-Klassen dürfen keine statischen Eigenschaften haben
		// Inner1 darf Statische- und Instanz-Eigenschaften und Methoden direkt von Outer1 verwenden
	}
}

class Outer2 {
	
	// Outer2 darf Eigenschaften und Methoden von Inner2 NICHT direkt benutzen
	
	static class Inner2 {
		// Inner2 darf nur das statische Inventar von Outer2 direkt verwenden
	}
}
