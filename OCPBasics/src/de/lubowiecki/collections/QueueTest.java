package de.lubowiecki.collections;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		
		Queue<String> namen = new LinkedList<>();
		//Queue<String> namen = new ArrayDeque<>();
		namen.add("Peter");
		namen.add("Carol");
		namen.add("Bruce");
		
		// gleich wie add, wirft aber keine Exception, wenn Hinzufügen nicht möglich ist
		namen.offer("Tony"); 
		namen.add("Natasha");
		
		// Verarbeitung als eine List
		namen.forEach(n -> System.out.println(n));
		System.out.println(namen); // Es wurde nichts entfernt, daher noch voll
		
		System.out.println();
		
		// FIFO (First In First Out)
		while(!namen.isEmpty()) {
			//System.out.println(namen.element()); // Zeigt das Element, das als nächstes dran wäre
			System.out.println(namen.poll()); // poll entfernt das Element am Anfang der Warte-Schlange
			// namen.remove(); // Wirft eine Exception, wenn die Queue leer ist
		}
		System.out.println(namen); // Leer
		
		// Stack ist ein LIFO (Last In First Out)
		
		
		Queue<String> namen1 = new LinkedList<>();
		Deque<String> namen2 = new LinkedList<>();
		
		// Queue: Hinzufügen und entfernen nur jeweils auf einer seite
		namen1.add(null); 
		
		// Deque: Hinzufügen und entfernen auf beiden seite
		namen2.add(null); namen2.addFirst(null); namen2.addLast(null);
		
		System.out.println();
		
		//PriorityQueue ist eine Klasse
		Queue<String> letters = new PriorityQueue<>(String.CASE_INSENSITIVE_ORDER); // verwendet den Comparator
		//Queue<String> letters = new PriorityQueue<>(); // verwendet natural-order
		letters.offer("x");
		letters.offer("A");
		letters.offer("X");
		letters.offer("b");
		letters.offer("B");
		letters.offer("W");
		
		while(!letters.isEmpty()) {
			System.out.println(letters.poll()); // poll: entfernt das kleinstes Element (gem. Sortierung)
		}
		
		System.out.println();
		
		Deque<String> letters2 = new ArrayDeque<>();
		letters2.push("x"); // push: packt ein Element oben auf den Stack
		letters2.push("A");
		letters2.push("X");
		letters2.push("b");
		letters2.push("B");
		letters2.push("W");
		
		while(!letters2.isEmpty()) {
			System.out.println(letters2.pop()); // pop: entfernt ein Element vom Stack
			//System.out.println(letters2.pollLast()); // pop: entfernt ein Element vom Stack
		}
		
		System.out.println();
		
		letters2 = new ArrayDeque<>();
		letters2.offerLast("x"); // push: packt ein Element oben auf den Stack
		letters2.offerLast("A");
		letters2.offerLast("X");
		letters2.offerLast("b");
		letters2.offerLast("B");
		letters2.offerLast("W");
		
		while(!letters2.isEmpty()) {
			System.out.println(letters2.pollLast()); // pop: entfernt ein Element vom Stack
		}
		
		// A
		letters2.offerLast("A");
		
		// AB
		letters2.offerLast("B");
		
		// CAB
		letters2.offerFirst("C");
		
	}

}
