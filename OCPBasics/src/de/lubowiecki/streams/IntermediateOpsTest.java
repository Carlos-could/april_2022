package de.lubowiecki.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermediateOpsTest {
	
	public static void main(String[] args) {
		
		List<Integer> zahlen = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		Predicate<Integer> p1 = i -> i < 5;
		Predicate<Integer> p2 = i -> i > 8;
		
		zahlen.stream()
//			.filter(i -> {
//				System.out.println(i);
//				boolean b = i > 5;
//				System.out.println(b);
//				return b;
//			}) // Lazy
//			.filter(i -> i < 5)
//			.filter(i -> i > 8)
			.filter(p1.or(p2)) // es werden nur werte weitergegeben, die true liefern
			//.count(); // eine terminierende OP
			.forEach(System.out::println); // eine terminierende OP
		
		//System.out.println("Anzahl: " + count);
		
		System.out.println("----------");
		
		zahlen.stream()
			.map(i -> i + "") // Beschreibt eine Transformation in einen anderen komplexen Typ, Integer zu String
//			.mapToInt(i -> i) // Beschreibt eine Transformation in primitiv int, auto-unboxing
//			.mapToDouble(i -> i) // Beschreibt eine Transformation in primitiv double, auto-unboxing danach primitiv widening
//			.mapToLong(i -> i) // Beschreibt eine Transformation in primitiv long, auto-unboxing danach primitiv widening
			.forEach(s -> System.out.printf("Die Ausgabe ist %s \n", s));
		
		System.out.println("----------");
		
		// peek zeigt das aktuelle Element, wird nur für das debuging benutzt
		zahlen.stream()
			.peek(i -> {
				System.out.println(i + "#");
			}) // peek kann den aktuellen Zustand anzeigen ihn aber nicht verändern
			.filter(i -> i > 3)
			.peek(i -> {
				System.out.println(i + "@");
			})
			.filter(i -> i > 6)
			.peek(i -> {
				System.out.println(i + "§");
			})
			.forEach(i -> System.out.println(i + "FE"));
		
		System.out.println("----------");
		
		Stream.of("Peter", "Steve", "Natasha", "Carol", "Bruce")
			.flatMap(n -> Arrays.stream(n.split(""))) // Zerlegt die Elemente in Streams und bringt sie auf einer Ebene zusammen
			.forEach(System.out::println);
		
		System.out.println("----------");
		
		List<List<Integer>> zahlenReihen = new ArrayList<>();
		zahlenReihen.add(Arrays.asList(1,1,7,5));
		zahlenReihen.add(Arrays.asList(9,2,8,9));
		zahlenReihen.add(Arrays.asList(3,3,1,7));
		zahlenReihen.add(Arrays.asList(8,8,8,1));
		
		zahlenReihen.stream()
			.flatMap(l -> l.stream())
			.forEach(i -> System.out.print(i + ","));
		
		System.out.println();
		System.out.println("ENDE");
		
	}
}
