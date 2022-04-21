package de.lubowiecki.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenereicTest2 {
	
	public static void main(String[] args) {
		
		// Seit Java 9, ist eine Liste mit NICHT veränderbarer Größe
		List<Integer> ints1 = List.of(1,5,7,22,19,18,2,7);
		//ints1.add(100); // Exception
		System.out.println(ints1);
		
		// Bis Java 8
		List<Integer> ints2 = new ArrayList<>(Arrays.asList(1,5,7,22,19,18,2,7));
		ints2.add(100);
		System.out.println(ints2);
		
		// Arrays.asList ist eine Liste mit NICHT veränderbarer Größe
		List<Integer> ints3 = Arrays.asList(1,5,7,22,19,18,2,7);
		// ints3.add(100); // Exception
		System.out.println(ints3);
		
		// Seit Java 10
		var x = new ArrayList<>(); // der Kompiler setzt den Objekt-Typ als Referenz-Typ für x ein
		// Nutzung unterschidlicher Typen für Referenz und Objekt ist mit var nicht möglich
		List<Integer> y = new ArrayList<>();
		
		Object[] arr = ints2.toArray();
		// Größe des Arrays (new Integer[0]) spielt keine Rolle, es wird lediglich der Typ ermittelt
		Integer[] iArr = ints2.toArray(new Integer[0]);
		
		Integer[] sorted = sort(new Integer[] {1,2,5,9,22,18});
		String[] sortedStr = sort(new String[] {"A", "Z", "X"});
		String str = sort("Hallo");
	}
	
	public static <T> T sort(T t) {
		//Arrays.sort(t); // Es ist nicht sicher, dass es ein Array ist
		return t;
	}

}
