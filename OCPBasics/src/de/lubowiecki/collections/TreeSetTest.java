package de.lubowiecki.collections;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
	
	public static void main(String[] args) {
		
		TreeSet<Integer> ints = new TreeSet<>();
		ints.add(25);
		ints.add(3);
		ints.add(17);
		ints.add(1892);
		
		// Integer hat eine natürliche Reihenfolge (Comparable-Interface wird implemetiert)
		System.out.println(ints);
		
		TreeSet<String> str = new TreeSet<>();
		str.add("A");
		str.add("Z");
		str.add("f");
		str.add("F");
		
		// String hat eine natürliche Reihenfolge (Comparable-Interface wird implemetiert)
		System.out.println(str);
		
		
		TreeSet<LocalDate> dates = new TreeSet<>();
		dates.add(LocalDate.now());
		dates.add(LocalDate.of(2015, 7, 1));
		dates.add(LocalDate.of(2025, 4, 17));
		dates.add(LocalDate.of(2012, 3, 8));
		
		// LocalDate hat eine natürliche Reihenfolge (Comparable-Interface wird implemetiert)
		System.out.println(dates);
		
		
		TreeSet<SuperHero> heros = new TreeSet<>();
		heros.add(new SuperHero(10, "Ironman"));
		heros.add(new SuperHero(15, "Cap. Marvel"));
		heros.add(new SuperHero(7, "Cap. America"));
		
		System.out.println(heros);
		
		// Sortierung nach NR
		// Sortierung nicht nach Comparabel von SuperHero, sondern nach dem Comparator
		// Comparator hat eine Methode compare die wie compareTo des Comparable arbeitet
		
		// Externes Objekt zum Vergleichen von SuperHeros
		Comparator<SuperHero> comp = (a, b) -> a.getNr() - b.getNr();
		TreeSet<SuperHero> heros2 = new TreeSet<>(comp);
		heros2 = new TreeSet<>(comp.reversed());
		
		heros2.add(new SuperHero(10, "Ironman"));
		heros2.add(new SuperHero(3, "Spiderman"));
		heros2.add(new SuperHero(30, "Hulk"));
		
		System.out.println(heros2);
		
		// Comparable = eine Möglichkeit der Sortierung (natürliche Reihenfolge)
		// Comparable wird von der zu vergleichenden Klasse implementiert
		
		// Comparator = jeder Comparator beschreibt eine Reihenfolge
		// Comparator ist ein externes Vergleichsobjekt
		// Man kann viele Comparatoren für eine Klasse schreiben
		
		
		SuperHero hero = new SuperHero(10, "Ironman");
		
		if(hero instanceof Comparable) {
			System.out.println("ist vergleichbar");
		}
		
		
	}
}

// Immutable
class SuperHero implements Comparable<SuperHero> {
	
	private final int nr;
	
	private final String name;

	public SuperHero(int nr, String name) {
		this.nr = nr;
		this.name = name;
	}

	public String getName() {
		return name;
	}

//	@Override
//	public int compareTo(SuperHero other) {
//		return this.nr - other.nr;
//	}
	
	public int getNr() {
		return nr;
	}

	@Override
	public int compareTo(SuperHero other) {
		return this.name.compareTo(other.name);
	}

	@Override
	public String toString() {
		return "SuperHero [nr=" + nr + ", name=" + name + "]";
	}
}
