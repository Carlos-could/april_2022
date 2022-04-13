package de.lubowiecki.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		
		//ArrayList<String> namen = new ArrayList<>();
		//List<String> namen = new ArrayList<String>();
		List<String> namen = new ArrayList<>(); // Start-Größe: 10 
		
		// FixedSizeList
		namen = Arrays.asList("Peter", "Bruce", "Natasha", "Carol", "Tony", "Steve");
		
		// Erzeugt eine veränderbare Liste mit Inhalt der FixedSizeList
		namen = new ArrayList<>(namen);
		
		namen = new ArrayList<>(Arrays.asList("Peter", "Bruce", "Natasha", "Carol", "Tony", "bruce", "#", "123"));
		namen.add("Steve");
		
		//namen = new ArrayList<>(1000); // Start-Größe: 1000 
		
		System.out.println(namen);
		
		//namen.sort(null);
		Collections.sort(namen);
		
		System.out.println(namen);
		
		
		// SAM - Single Abstract Method
		// Predicate: boolean test(T t) // T ist String da ArrayList mit String parametrisiert ist (Generischer Typ)
		// (n) ist die Parameterklammer der test-Methode
		// -> n.startsWith("b") || n.startsWith("1") || n.startsWith("#") ist der Body der test-Methode
		namen.removeIf((n) -> n.startsWith("b") || n.startsWith("1") || n.startsWith("#"));
		
		// Consumer: void accept(T t)
		namen.forEach(n -> System.out.println(n.toUpperCase()));
		
		System.out.println();
		
		for(String n : namen) {
			System.out.println(n.toUpperCase());
		}

		System.out.println();
		
		System.out.println(Collections.binarySearch(namen, "Natasha")); // 2
		
		// Position laut der Ordnung, negiert + -1
		System.out.println(Collections.binarySearch(namen, "Hans")); // -3
		
		System.out.println(Collections.binarySearch(namen, "Anna")); // -1
		
		List l = new ArrayList(); // RawType = Object
		l.add(1); // Autoboxing von int zu Integer, und komplex Widening von Integer auf Object
		l.add("Hallo"); // komplex Widening von String auf Object
		
		// Geordnet - Listen sind durch den Index geordnet
		// Sortiert
		
	}

}
