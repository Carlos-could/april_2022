package de.lubowiecki.basics;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class StringTest {
	
	public static void main(String[] args) {
		
		String s = "Hallo Welt";
		s = s + "...";
		System.out.println(s);
		String s2 = "Hallo Welt"; // Referenz auf Wert im Pool
		s2 = new String("Hallo Welt"); // Landet nicht im Pool
		
		Integer i1 = 150;
		Integer i2 = 150;
		System.out.println(i1 == i2); // ist es das gleiche Objekt?
		System.out.println(i1.equals(i2)); // ist es der gleiche Wert?
		// Byte-Literal-Pool: -128 bis 127
		
		String s3 = new String("Moin"); // Nicht im Pool
		String s4 = "Moin"; // Im Pool
		
		System.out.println(s3 == s4); // false
		System.out.println(s3.equals(s4)); // true
		System.out.println(s3.hashCode() + " " + s4.hashCode());
		
		System.out.println();
		
		Person a = new Person(1, "Peter", "Parker", LocalDate.of(1979, 10, 5));
		Person b = new Person(1, "Peter", "Parker", LocalDate.of(1979, 10, 5));
		Person c = new Person(2, "Bruce", "Banner", LocalDate.of(1975, 1, 1));
		
		System.out.println(a == b); // false
		System.out.println(a.equals(b)); // true
		System.out.println(a.hashCode() + " " + b.hashCode()); // true
		
		System.out.println();
		
		Set<Person> menge = new HashSet<>();
		System.out.println();
		menge.add(a);
		
		System.out.println();
		menge.add(b);
		
		System.out.println();
		menge.add(c);
		
		System.out.println(menge);
		
	}

}
