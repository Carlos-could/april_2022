package de.lubowiecki.collections;

public class Overview {
	
	// List: arbeitet mit einem Index, behält Einfügereihenfolge bei
	// Set: keine Duplikate, null 1x erlaubt
	// Queue: Warteschlangen - Elemente werden nur an Enden hinzugefügt/entfernt
	// Map: Schlüssel-Wert-Paare, Duplikate überschreeiben vorhandene Werte, null darf 1x als Schlüssel benutzt werden
	
	// Hash: Schnelle, Hash-basierte Struktur. hashCode und equals müssen richtig eingebaut sein
	// Linked: behält Einfügereihenfolge bei
	// Tree: immer sortiert, Elemente müssen Comparable sein, oder ein Comparator muss vorgegeben werden
	// Navigable: Methoden zum ermitteln von Teilbereichen, größer, kleiner etc.
	// Array: Nutzt intern ein Array
	
	// LinkedList
	// LinkedHashSet
	// TreeSet
	// LinkedHashMap
	
	// Hashbar: Beim Eifügen eines Elementes wird geprüft, ob bereits ein Objekt mit gleichem HashCode enthalten ist
	// Ist das der Fall, wird das Objekt mit dem enthaltenen Objekt per equals verglichen
	// Ist das nicht der Fall, kann das Objekt direkt eingefügt werden
	// Ergibt HashCode-Vergleich true und equals true, dann ist es ein Duplikat
	
}
