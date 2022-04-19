package de.lubowiecki.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		
		List<Integer> zahlen = new ArrayList<>();
		
		zahlen.add(5);
		zahlen.add(7);
		zahlen.add(3);
		zahlen.add(0,2); // nicht effizient
		
		zahlen = new LinkedList<>(zahlen); // Wechsel von ArrayList auf LinkedList
		zahlen.add(0,2); // besser :-)
		zahlen.add(3,5); 
		zahlen.add(1,9); 
		
		System.out.println(zahlen.get(3)); // nicht effizient
		
		zahlen = new ArrayList<>(zahlen); // Wechsel von LinkedList auf ArrayList
		
		
		System.out.println(zahlen.remove(5)); // entfernt und liefert den wert am index 5
		System.out.println(zahlen.remove(new Integer(5))); // entfernt das Element 5 aus der Liste
		
		System.out.println();
		for(int i : zahlen) {
			System.out.println(i);
		}
		
		System.out.println();
		Iterator<Integer> itr = zahlen.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println();
		for(int i = 0; i < zahlen.size(); i++) {
			System.out.println(zahlen.get(i));
		}
		
		System.out.println();
		zahlen.forEach(z -> System.out.println(z));

	}

}
