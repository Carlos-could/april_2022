package de.lubowiecki.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Aufgabe8 {
	
	public static void main(String[] args) {
		
		CollectionToolBox<String> ctb1 = new CollectionToolBox<>();
		Collection<String> namen = new ArrayList<>(Arrays.asList("B", "G", "A", "Z"));
		List<String> sorted1 = ctb1.toSortedList(namen);
		System.out.println(sorted1);
		
		System.out.println();
		
		sorted1 = ctb1.toSortedList(namen, String.CASE_INSENSITIVE_ORDER.reversed());
		System.out.println(sorted1);
		
		System.out.println();
		
		CollectionToolBox<Integer> ctb2 = new CollectionToolBox<>();
		Collection<Integer> zahlen = new ArrayList<>(Arrays.asList(7,15,1,8));
		List<Integer> sorted2 = ctb2.toSortedList(zahlen);
		System.out.println(sorted2);
		
		System.out.println();
		
		namen = new ArrayList<>(Arrays.asList("B", "G", "A", "Z"));
		sorted1 = CollectionToolBox.staticToSortedList(namen);
		System.out.println(sorted1);
		
		System.out.println();
		
		sorted1 = CollectionToolBox.staticToSortedList(namen, String.CASE_INSENSITIVE_ORDER.reversed());
		System.out.println(sorted1);
	}
}

class CollectionToolBox<T extends Comparable> {
	
	public List<T> toSortedList(Collection<T> c) {
		List<T> list = new ArrayList<>(c); 
		Collections.sort(list);
		return list;
	}
	
	public List<T> toSortedList(Collection<T> c, Comparator<T> comp) {
		List<T> list = new ArrayList<>(c); 
		Collections.sort(list, comp);
		return list;
	}
	
	public static <T extends Comparable> List<T> staticToSortedList(Collection<T> c) {
		List<T> list = new ArrayList<>(c); 
		Collections.sort(list);
		return list;
	}
	
	public static <T> List<T> staticToSortedList(Collection<T> c, Comparator<T> comp) {
		List<T> list = new ArrayList<>(c); 
		Collections.sort(list, comp);
		return list;
	}
}
