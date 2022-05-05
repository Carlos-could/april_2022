package de.lubowiecki.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class StatefulOpsTest {

	public static void main(String[] args) {

		Stream.Builder<Zeug> zeugBuilder = Stream.builder();
		
		Stream<Zeug> zeugSammlung = zeugBuilder.add(new Zeug("Hammer"))
												.add(new Zeug("Zange"))
												.add(new Zeug("Tasse"))
												.add(new Zeug("Flasche"))
												.add(new Zeug("Zange"))
												.add(new Zeug("Tisch"))
												.add(new Zeug("Laptop"))
												.add(new Zeug("Hammer")).build();
		
		Comparator<Zeug> comp = (a, b) -> CompareToBuilder.reflectionCompare(a, b);
		
		zeugSammlung.distinct()
					.sorted(comp.reversed())
					.forEach(System.out::println);
		
		System.out.println("-----------");
		
		Arrays.asList(2,7,9,8,22,1,6,18,17,22).stream()
						.skip(2) // überspringt n element
						.peek(i -> System.out.println(i + "#"))
						.limit(5) // beschränkt die Anzahl der Elemente
						.sorted() // Werte werden aufgestaut, bis alle bekannt sind
						.forEach(i -> System.out.println(i + "@"));
		
		
	}
}

class Zeug implements Comparable<Zeug> {
	
	private final String name;

	public Zeug(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	
	
	@Override
	public String toString() {
		//return "Zeug [name=" + name + "]";
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

	@Override
	public int hashCode() {
		//return name.hashCode();
		// Bezieht alle Eigenschaften in die Berechnung des HashCodes
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	@Override
	public boolean equals(Object other) {
		
//		if(this == other)
//			return true;
//		
//		if(other == null)
//			return false;
//		
//		if(!(other instanceof Zeug))
//			return false;
//		
//		Zeug otherZeug = (Zeug) other;
//		
//		if(this.name.equals(otherZeug.name))
//			return true;
//		
//		return false;
		
		// Vergleich auf Basis aller Eigenschaften
		return EqualsBuilder.reflectionEquals(this, other);
	}

	@Override
	public int compareTo(Zeug other) {
		return CompareToBuilder.reflectionCompare(this, other);
	}
}
