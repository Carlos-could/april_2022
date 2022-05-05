package de.lubowiecki.streams;

import java.util.DoubleSummaryStatistics;
import java.util.Random;
import java.util.List;
import java.util.Map;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class TerminalOpsTest {
	
	public static void main(String[] args) {
		
		DoubleStream str1 = DoubleStream.of(10.5, 20.7, 1, 8, 17.22, 9.678);
		System.out.println(str1.sum());
		//System.out.println(str1.min());
		//System.out.println(str1.max());
		//System.out.println(str1.average());
		
		System.out.println();
		
		// Gibt es nur für primitivs (int, double, long)
		str1 = DoubleStream.of(10.5, 20.7, 1, 8, 17.22, 9.678);
		DoubleSummaryStatistics stats = str1.summaryStatistics();
		System.out.println(stats.getSum());
		System.out.println(stats.getAverage());
		System.out.println(stats.getMax());
		System.out.println(stats.getMin());
		System.out.println(stats.getCount());
		
		System.out.println();
		
		String[] fNames = {"Peter", "Bruce", "Natasha", "Carol", "Steve", "Tony"};
		String[] lNames = {"Parker", "Banner", "Romanov", "Danvers", "Rogers", "Stark"};
		
		Random rand = new Random();
		IntSupplier w6 = () -> rand.nextInt(6) + 1;
		
		
		Stream<Person> personen = Stream.generate(() -> new Person(fNames[w6.getAsInt() - 1], lNames[w6.getAsInt() - 1]));
		
		//personen.limit(100).forEach(System.out::println);
		
		Map<String, List<Person>> map = personen.limit(100).collect(Collectors.groupingBy(Person::getLastName));
		System.out.println(map.get("Stark"));
		
		System.out.println();
		personen = Stream.generate(() -> new Person(fNames[w6.getAsInt() - 1], lNames[w6.getAsInt() - 1]));
		
		Predicate<Person> pred = p -> p.getFirstName().startsWith("B");
		Map<Boolean, List<Person>> map2 = personen.limit(100).collect(Collectors.partitioningBy(pred));
		System.out.println(map2.get(true));
		
		System.out.println();
		
		Stream<String> str2 = Stream.of("A", "B", "C", "D");
		String s = str2.collect(Collectors.joining(", ", ">> ", " <<"));
		System.out.println(s);
		
	}
}

class Person {
	
	private final String firstName;
	private final String lastName;
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
