package de.lubowiecki.streams;

import java.util.Arrays;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) throws IOException {
		
		Stream<Integer> st1 = Stream.empty();
		st1 = Stream.of(1,5,7,9,20);
		Stream<Integer> st2 = Stream.of(1,5,7,9,20);
		Stream<Integer> st3 = Stream.concat(st1, st2); // verbindet 2 Streams zu einem neuen
		
		System.out.println();
		// UnaryOperator: T apply(T t);
		st1 = Stream.iterate(1, i -> i + 2).limit(50); // Wert von davor wird als Basis für den nächsten Wert verwendet
		st1.forEach(System.out::println);
		
		
		Random rand = new Random();
		
		System.out.println();
		// Supplier: T get ();
		st1 = Stream.generate(() -> rand.nextInt(1000) + 1).limit(50); // jeder Wert wird für sich generiert
		st1.forEach(System.out::println);
		//st1.forEach(System.out::println); // Exception: Stream ist bereits verarbeitet
		
		
		System.out.println();
		List<String> namen = Arrays.asList("Peter", "Carol", "Bruce", "Steve", "Natasha");
		namen.stream() // Stream von Strings
			.forEach(System.out::println);
		
		System.out.println();
		"Das ist ein Haus von Nikigraus".chars().forEach(c -> System.out.println((char) c));
		
		System.out.println();
		Arrays.stream("Das ist ein Haus von Nikigraus".split(" ")).forEach(System.out::println);
		
		System.out.println();
		Path p = Paths.get("io/test.txt");
		Files.lines(p) // Liefert ein Stream von Strings
			.skip(100)
			.limit(10)
			.forEach(System.out::println);
		
		// Komplexe Streams: Stream<T>
		// Primitive Streams: IntStream, LongStream, DoubleStream
		
		System.out.println();
		//IntStream.range(10, 1000).forEach(System.out::println);
		IntStream.rangeClosed(10, 1000).forEach(System.out::println); // Endwert inclusive
	}
}
