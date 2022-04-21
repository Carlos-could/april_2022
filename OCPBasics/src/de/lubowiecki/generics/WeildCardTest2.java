package de.lubowiecki.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class WeildCardTest2 {

	public static void main(String[] args) {
		
		List<Double> zahlen = new ArrayList<>(Arrays.asList(1.0,2.0,3.0,4.0,5.0));
		machWas(zahlen); // Number oder niedriger ist erlaubt
		
		List<Object> zahlen2 = new ArrayList<>(Arrays.asList(1.0,2.0,3.0,4.0,5.0));
		//List<Object> zahlen2 = new ArrayList<>(Arrays.asList("A", "B", "C"));
		machWasAnderes(zahlen2); // Number oder höher ist möglich
		
		Consumer<Double> cons1 = d -> System.out.println(d);
		Consumer<Object> cons2 = o -> System.out.println(o);
		Consumer<Number> cons3 = n -> System.out.println(n);
		zahlen.forEach(cons3); // Foreach verwendet LOWER-Bound auf dem generischen Typ der Collection 

	}
	
	// UPPER-Bound (Number und Kindklassen sind erlaubt)
	public static void machWas(List<? extends Number> zahlen) {
		//zahlen.forEach(System.out::println); // Consumer als Methoden-Referenz
		zahlen.forEach(z -> System.out.println(z)); // Über z sind die Eigenschaften von Number nutzbar
	}
	
	// LOWER-Bound (Number und ihre Elternklassen sind erlaubt)
	public static void machWasAnderes(List<? super Number> zahlen) {
		zahlen.forEach(z -> System.out.println(z)); // Über z sind die Eigenschaften von Number NICHT nutzbar
	}

}
