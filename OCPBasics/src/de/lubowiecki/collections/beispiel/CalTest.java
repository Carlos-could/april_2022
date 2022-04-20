package de.lubowiecki.collections.beispiel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CalTest {

	public static void main(String[] args) {
		
		TreeMap<LocalDate, Set<Item>> cal = new TreeMap<>();
		LocalDate.of(2022, 3, 15);
		
		LocalDate d = LocalDate.of(2022, 3, 15);
		cal.put(d, new TreeSet<>());
		cal.get(d).add(new Item(LocalTime.of(17, 15), "Essen mit Peter und Carol"));
		cal.get(d).add(new Item(LocalTime.of(14, 25), "Golfen mit Bruce"));
		
		d = LocalDate.of(2022, 4, 10);
		cal.put(d, new TreeSet<>());
		cal.get(d).add(new Item(LocalTime.of(8, 30), "Vortrag über Generics bei der GFN"));
		cal.get(d).add(new Item(LocalTime.of(10, 30), "Vortrag über Streams bei der GFN"));
		cal.get(d).add(new Item(LocalTime.of(7, 30), "Zähne putzen"));
		
		d = LocalDate.of(2022, 4, 11);
		cal.put(d, new TreeSet<>());
		cal.get(d).add(new Item(LocalTime.of(17, 15), "Essen mit Natasha"));
		
		d = LocalDate.of(2022, 4, 12);
		cal.put(d, new TreeSet<>());
		cal.get(d).add(new Item(LocalTime.of(17, 15), "Essen mit Natasha"));
		
		d = LocalDate.of(2022, 4, 15);
		cal.put(d, new TreeSet<>());
		cal.get(d).add(new Item(LocalTime.of(17, 15), "Essen mit Natasha"));
		
		d = LocalDate.of(2022, 4, 22);
		cal.put(d, new TreeSet<>());
		cal.get(d).add(new Item(LocalTime.of(17, 15), "Essen mit Natasha"));
		
		d = LocalDate.of(2022, 4, 25);
		cal.put(d, new TreeSet<>());
		cal.get(d).add(new Item(LocalTime.of(17, 15), "Essen mit Natasha"));
		
		d = LocalDate.of(2023, 1, 1);
		cal.put(d, new TreeSet<>());
		cal.get(d).add(new Item(LocalTime.of(8, 5), "Essen mit Peter"));
		
		
		//System.out.println(cal);
		
		for(Entry<LocalDate, Set<Item>> e : cal.entrySet()) {
			System.out.println(e.getKey());
			e.getValue().forEach(i -> System.out.println(i.getTime() + ", " + i.getTitle() + "\n" + i.getDescription()));
		}
		
		System.out.println("-----");
		
		System.out.println("Termine in dieser Woche:");
		
		Map<LocalDate, Set<Item>> thisWeek = cal.subMap(LocalDate.now(), LocalDate.now().plusDays(7));
		
		for(Entry<LocalDate, Set<Item>> e : thisWeek.entrySet()) {
			System.out.println(e.getKey());
			e.getValue().forEach(i -> System.out.println(i.getTime() + ", " + i.getTitle() + "\n" + i.getDescription()));
		}
		
		System.out.println("-----");
		
		System.out.println("Termine der vergangenen Woche:");
		
		Map<LocalDate, Set<Item>> lastWeek = cal.subMap(LocalDate.now().minusDays(7), LocalDate.now());
		
		for(Entry<LocalDate, Set<Item>> e : lastWeek.entrySet()) {
			System.out.println(e.getKey());
			e.getValue().forEach(i -> System.out.println(i.getTime() + ", " + i.getTitle() + "\n" + i.getDescription()));
		}
		
		System.out.println("-----");
		
		System.out.println("Termine der der Zukunft:");
		
		Map<LocalDate, Set<Item>> future = cal.tailMap(LocalDate.now());
		
		for(Entry<LocalDate, Set<Item>> e : future.entrySet()) {
			System.out.println(e.getKey());
			e.getValue().forEach(i -> System.out.println(i.getTime() + ", " + i.getTitle() + "\n" + i.getDescription()));
		}
	}

}
