package de.lubowiecki.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapTest {

	public static void main(String[] args) {
		
		//Map<String, Integer> einwohnerZahlen = new HashMap<>();
		//Map<String, Integer> einwohnerZahlen = new LinkedHashMap<>(); // behält die Einfügereihenfolge bei
		Map<String, Integer> einwohnerZahlen = new TreeMap<>(); // immer nach Schlüssel sortiert
		einwohnerZahlen.put("Hamburg", 1_900_000); // keine add-Methode
		einwohnerZahlen.put("Berlin", 3_800_000);
		einwohnerZahlen.put("München", 1_600_000);
		einwohnerZahlen.put("Kiel", 400_000);
		
		System.out.println();
		
		for(int i : einwohnerZahlen.values()) {
			System.out.println(i);
		}
		
		System.out.println();
		
		for(String s : einwohnerZahlen.keySet()) {
			System.out.println(s);
		}
		
		System.out.println();
		
		for(String s : einwohnerZahlen.keySet()) {
			System.out.println(s + ": " + einwohnerZahlen.get(s));
		}
		
		System.out.println();
		
		for(Entry<String, Integer> e : einwohnerZahlen.entrySet()) {
			System.out.println(e.getKey() + ": " + e.getValue());
		}
		
		System.out.println();
		
		System.out.println(einwohnerZahlen);
		
		System.out.println(einwohnerZahlen.get("Hamburg"));

		einwohnerZahlen.put("Berlin", 3_500_000);
		System.out.println(einwohnerZahlen);
		
	}

}
