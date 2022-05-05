package de.lubowiecki.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceTest {
	
	public static void main(String[] args) {
		
		// Reduce reduziert einen Stream auf einen Wert gleichen Typs
		
		IntStream ints = IntStream.of(5,7,8,9,10,22);
		
		// IntBinaryOperator: zwei int parameter, return auch ein int
		int sum = ints.reduce(0, (a, b) -> a + b);
		System.out.println(sum);
		
		
		ints = IntStream.of(5,7,8,9,10,22);
		OptionalInt optSum = ints.reduce((a, b) -> a + b); // bei einem Element wird dieses als Startwert verwendet
		System.out.println(optSum);
		
		optSum.ifPresent(System.out::println); // Inhalt von OptionalInt wird ausgegeben 
		
		System.out.println();
		
		Stream<String> str = Stream.of("B", "G", "H", "K", "A");
		String s = str.reduce("#", (a, b) -> a + ", " + b);
		System.out.println(s);
		
		str = Stream.of("B", "G", "H", "K", "A");
		Optional<String> sOpt = str.reduce((a, b) -> a + ", " + b);
		System.out.println(sOpt);
		
		// Collect
		
		str = Stream.of("B", "G", "H", "K", "A");
		
		// 1: Erzeugung der Datenstruktur
		// 2: Einfügen von Werten
		// 3: Zusammenführen von Teil-Mengen bei paralleler Verarbeitung (leider nicht optional)
		StringBuilder sb = str.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		System.out.println(sb);
		
		System.out.println();
		str = Stream.of("B", "G", "H", "K", "A");
		
		ArrayList<String> list = str.collect(ArrayList::new, List::add, List::addAll);
		System.out.println(list);
		
		System.out.println();
		str = Stream.of("B", "G", "H", "K", "A");
		List<String> list2 = str.collect(Collectors.toList()); // toSet, toMap etc.
		System.out.println(list2);
		
		
		System.out.println();
		str = Stream.of("B", "G", "H", "K", "A");
		//System.out.println(str.min(String.CASE_INSENSITIVE_ORDER));
		System.out.println(str.max(String.CASE_INSENSITIVE_ORDER));
		
		System.out.println();
		Stream<Integer> zahlen = Stream.of(100, 105, 92, 88, 1, 3, 1005, 127);
		
		Predicate<Integer> p1 = z -> z >= 100; // Zahl ist größer als 100
		//System.out.println("Größer/gleich als 100: " + zahlen.allMatch(p1)); // Alle Zahlen sind größer/gleich als 100
		//System.out.println("Mind. eine Zahl ist größer/gleich als 100: " + zahlen.anyMatch(p1));
		System.out.println("Keine Zahl ist größer/gleich als 100: " + zahlen.parallel().noneMatch(p1));
		
	}
	

}
