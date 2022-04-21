package de.lubowiecki.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class WildCardTest {

	//private ? x; // so nicht
	private Predicate<?> y; // muss platzhalter für unbekannte Typen von generischen Klassen sein
	
	
	public static void main(String[] args) {
		
		// Error: Generischer Typ muss auf beiden Seiten gleich sein
		//List<Number> zahlen = new ArrayList<Integer>();
		
		System.out.println();
		
		// Generischere Typ von Rechts ist jetzt flexibel 
		List<? extends Number> zahlen2 = new ArrayList<Integer>();
		zahlen2 = new ArrayList<Double>();
		//zahlen2 = new ArrayList<String>();
		
		// Collections mit WildCard sind nicht erweiterbar... es kann kein add verwendet werden
		
		System.out.println();
		
		// zahlen3 nutzt den RawTyp daher kein Cast
		List zahlen3 = new ArrayList<Integer>();
		zahlen3.add(123);
		zahlen3.add("Hallo");
		System.out.println(zahlen3);
		
	}
	
	// ? ist für den Inhalt der Collection
	// Wildcard kann bei Klassendeklarationen nicht benutzt werden
	public static double sum(Collection<? extends Number> c) {
		
		double sum = 0;
		for(Number v : c) {
			sum += v.doubleValue();
		}
		return sum;
	}
	
	// T ist steht hier für Collection und kann für Inhalt der Collection nicht benutzt werden
	public static <T> double newSum(Collection<? extends Number> c) {
		
		double sum = 0;
		for(Number v : c) {
			sum += v.doubleValue();
		}
		return sum;
	}

}
