package de.lubowiecki.streams;

import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamToArrayTest {

	public static void main(String[] args) {
		
		
		Stream<String> str = Stream.of("A", "CH", "B", "GK", "A", "BC");
		
		IntStream ints = IntStream.of(5,7,9,22,11,8,6);
		
		Object[] arr1 = str.filter(s -> s.length() == 1).toArray();
		
		for(Object o : arr1) {
			System.out.println(o);
		}
		
		System.out.println();
		
		str = Stream.of("A", "CH", "B", "GK", "A", "BC");
		
		// Eine Funktion die ein Int als Länge nimmt und ein Array in passender Größe erzeugt
		IntFunction<String[]> fn1 = l -> new String[l]; // Erzeugt ein Array mit passender Größe und passenden Typ
		String[] arr2 = str.filter(s -> s.length() == 1).toArray(fn1);
		
		//String[] arr2 = str.filter(s -> s.length() == 1).toArray(String[]::new); // Methoden-Referenz auf den Konstruktor
		for(String s : arr2) {
			System.out.println(s);
		}
		
		
		
	}

}
