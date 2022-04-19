package de.lubowiecki.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetTest2 {

	public static void main(String[] args) {
		
		
		List<String> list = Arrays.asList("Peter", "Bruce", "Natasha", "Carol", "Tony");
		
		Set<String> namen1 = new HashSet<>(list); // nicht sortiert, nicht geordnet
		System.out.println(namen1);
		
		namen1 = new LinkedHashSet<>(list); // Linked = Einfügereihenfolge, geordnet
		System.out.println(namen1);
		
		namen1 = new TreeSet<>(list); // Tree = immer sortiert
		System.out.println(namen1);
		
		TreeSet<String> sortedNames = new TreeSet<>(list);
		
		Set<String> head = sortedNames.headSet("Natasha");
		System.out.println(head);
		// add auf head erlaubt nur Elemente kleiner als Natasha
		
		Set<String> tail = sortedNames.tailSet("Natasha");
		System.out.println(tail);
		// add auf tail erlaubt nur Elemente größer/gleich als Natasha
		
		Set<String> sub = sortedNames.subSet("Hans", "Steve");
		System.out.println(sub);
		//sub.add("Gunnar"); // ist kleiner als Hans d.h. nicht erlaubt
		sub.add("Karl"); // passt zwischen Hans und Steve
		System.out.println(sub);
		
		System.out.println("sortedNames:");
		System.out.println(sortedNames);
		
		
		System.out.println(sortedNames.floor("Gunnar")); // Liefert nächstkleineres Element
		System.out.println(sortedNames.ceiling("Gunnar")); // Liefert nächstgrößeres Element
		
	}
}
