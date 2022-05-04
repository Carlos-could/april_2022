package de.lubowiecki.lambda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;
import java.util.List;

public class BuildInFuncInterfaceTest {
	
	public static void main(String[] args) {
		
		System.out.println("---- CONSUMER ----");
		
		// void accept(T t);
		Consumer<Integer> cons1 = i -> System.out.println(i * 10);
		// System.out.println(cons1.accept(100)); // Error: accept liefert void zurück
		System.out.println();
		//System.out.print(); // Error: print verlangt immer einen Wert
		
		Consumer<String> cons2 = s -> System.out.println(s.toUpperCase());
		List<String> namen = Arrays.asList("Peter", "Natasha", "Carol", "Bruce");
		namen.forEach(cons2);
		
		System.out.println();
		List<Integer> zahlen = Arrays.asList(1,3,7,9,22,15,8,5);
		zahlen.forEach(cons1);
		
		System.out.println();
		// andThen verbindet 2 Consumer zu einem neuen
		Consumer<Integer> cons1ext = cons1.andThen(i -> System.out.println("-----"));
		zahlen.forEach(cons1ext);
		
		
		System.out.println();
		Consumer<Number> cons3 = n -> System.out.println(n.doubleValue() * 10);
		zahlen.forEach(cons3);
		
		
		System.out.println();
		Consumer<Object> cons4 = o -> System.out.println(o.hashCode());
		zahlen.forEach(cons4);
		
		
		System.out.println();
		List<Double> dZahlen = Arrays.asList(1.0,3.0,7.0,9.0,22.0,15.0,8.0,5.0);
		dZahlen.forEach(cons3);
		
		System.out.println();
		dZahlen.forEach(cons4);
		
		System.out.println("---- FUNCTION ----");
		
		Function<Integer, Double> f1 = i -> i.doubleValue();
		Double d = f1.apply(123); // Wandelt Integer in Double
		
		final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yy");
		
		Function<String, LocalDate> f2 = s -> LocalDate.parse(s, FORMATTER);
		LocalDate ld = f2.apply("25.10.00");
		System.out.println(ld);
		
		System.out.println();
		// andThen verbindet zwei Funktionen zu einer neuen, linke Seite als erstes
		Function<String, String> f3 = f2.andThen(date -> date.plusDays(30).format(FORMATTER));
		System.out.println(f3.apply("25.10.00"));
		
		// compose erzeugt einen neue Funktion, rechte Seite wird als erstes ausgeführt
		Function<LocalDate, LocalDate> f4 = f2.compose(date -> date.format(FORMATTER));
		
		System.out.println();
		dZahlen = Arrays.asList(1.0,3.0,7.0,9.0,22.0,15.0,8.0,5.0);
		dZahlen.stream()
			.map(db -> db.intValue()) // Wechsel von Double auf Integer
			.map(i -> i * 10) // Funktion mulipliziert Integer mit 10
			.sorted()
			.forEach(i -> System.out.print(i + ", "));
		
		System.out.println();
		System.out.println("---- BI_FUNCTION ----");
		
		// R apply(T t, U u);
		BiFunction<Integer, Integer, Integer> bif = (a, b) -> a * b;
		BiFunction<Integer, Integer, Double> bif2 = (a, b) -> a.doubleValue() * b.doubleValue();
		
		System.out.println(bif.apply(10, 15));
		System.out.println(bif2.apply(10, 15));
		
		System.out.println("---- SUPPLIER ----");
		
		// T get();
		Supplier<Integer> diceW6 = () -> (int) Math.ceil(Math.random() * 6);
		Supplier<Integer> diceW10 = () -> (int) Math.ceil(Math.random() * 10);
		
//		for(int i = 0; i < 1000; i++) {
//			System.out.println(diceW10.get());
//		}
		
		System.out.println();
		
		// Zufallszahlen als Stream
		//Stream.generate(diceW6).limit(10_000_000).forEach(System.out::println);
		
		
		System.out.println("---- PREDICATE ----");
		
		IntPredicate p1 = i -> i > 10; // IntPredicate, ein Predicate für primitive Zahlen
		Predicate<Integer> p2 = i -> i < 10; //Predicate für Integer Objekte
		
		IntPredicate p3 = i -> i < 50;
		
		List<Integer> iZahlen = Arrays.asList(1,25,99,120, 17,18,29,61,5);
		
		ToIntFunction<Integer> iuo = i -> i;
		
		// and verbindet zwei predicates
		iZahlen.stream() // Stream von Integer
			.mapToInt(iuo) // Stream von int
			.filter(p1.and(p3)) // zahl muss > 10 and < 50 sein
			//.forEach(z -> System.out.println(z)); // Ausgabe
			.forEach(System.out::println); // Ausgabe: Methoden-Referenz
	}
}
