package de.lubowiecki.generics;

import java.util.ArrayList;
import java.util.List;

public class GenerischeVererbung {
	
	public static void main(String[] args) {
		
		Parkhaus<PKW> p1 = new Parkhaus<>(10);
		p1.einparken(new PKW());
		p1.einparken(new PKW());
		p1.einparken(new PKW());
		p1.einparken(new PKW());
		p1.show();
		
		LuxusParakhaus<LKW> p2 = new LuxusParakhaus<>(100);
		p2.einparken(null);
		
		LuxusPkwParkhaus p3 = new LuxusPkwParkhaus(100);
		p3.einparken(null);
		
	}

}

class PKW {
}

class LKW {
}

class Parkhaus<E> {
	
	private final List<E> parkplaetze;
	private final int SIZE;
	
	public Parkhaus(int groeße) {
		SIZE = groeße;
		parkplaetze = new ArrayList<>(SIZE);
	}
	
	public void einparken(E e) {
		if(parkplaetze.size() < SIZE) {
			parkplaetze.add(e);
			System.out.println("eingeparkt...");
		}
		else {
			System.out.println("Kein Platz mehr");
		}
	}
	
	public void show() {
		for(E e : parkplaetze) {
			System.out.println(e);
		}
	}
}

// Generischer Typ für Parkhaus wird von LuxusParakhaus weitergegeben (LuxusParakhaus<LKW> p2 = new LuxusParakhaus<>(100))
class LuxusParakhaus<E> extends Parkhaus<E> { // LuxusParakhaus<E> Deklaration des Platzhalters, Parkhaus<E> Verwendung des Platzhalters

	public LuxusParakhaus(int groeße) {
		super(groeße);
	}
}

//Generischer Typ für Parkhaus wird auf PKW fixiert
class LuxusPkwParkhaus extends Parkhaus<PKW> {

	public LuxusPkwParkhaus(int groeße) {
		super(groeße);
	}
	
}

// Generischer Typ für Parkhaus wird auf LKW fixiert
class LuxusLkwParkhaus extends Parkhaus<LKW> {

	public LuxusLkwParkhaus(int groeße) {
		super(groeße);
	}	
}
