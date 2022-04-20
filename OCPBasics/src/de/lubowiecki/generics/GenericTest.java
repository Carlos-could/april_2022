package de.lubowiecki.generics;

import de.lubowiecki.basics.Person;

public class GenericTest {

	public static void main(String[] args) {
		
		StringBox b1 = new StringBox(); // Nicht generisch
		b1.setContent("Hallo Welt");
		String s = b1.getContent();
		
		ObjectBox b2 = new ObjectBox();
		b2.setContent(1000); // Autoboxing von int auf Integer + Widening von Integer auf Object
		s = (String) b2.getContent(); // ClassCastException... UNSICHER!!!!
		Object o = b2.getContent(); // Indentität von o ist unbekannt
		
		GenericBox<String> b3 = new GenericBox<>();
		b3.setContent("Hallo"); // Nimmt String (den generischen Typ) entgegen
		s = b3.getContent(); // Liefert String (den generischen Typ) zurück
		
		GenericBox<Integer> b4 = new GenericBox<>();
		b4.setContent(1000); // Nimmt Integer (den generischen Typ) entgegen
		Integer i = b4.getContent();
		
		GenericBox<Person> b5 = new GenericBox<>();
		b5.setContent(new Person()); // Nimmt Person (den generischen Typ) entgegen
		Person p = b5.getContent();
		

	}
}

class StringBox {
	
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}

class ObjectBox {
	
	private Object content;

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
}

class GenericBox<T> { // <T> Deklaration der Platzhalters
	
	private T content; // T Verwendung des Platzhalters
	
	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}
}
