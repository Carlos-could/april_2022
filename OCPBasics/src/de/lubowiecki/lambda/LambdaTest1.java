package de.lubowiecki.lambda;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LambdaTest1 {
	
	public static void main(String[] args) {
		
		Machbar m = () -> System.out.println("...");
		
		Machbar m2 = () -> String.format("Mein Name ist %s", "Peter"); // Erg. von format wird ignoriert
		
		Machbar2 m3 = () -> String.format("Mein Name ist %s", "Peter");
		Supplier<String> sup1 = () -> String.format("Mein Name ist %s", "Peter");
		
		Machbar3 m31 = x -> String.format("Mein Name ist %s", "Peter");
		Function<String, String> f1 = x -> String.format("Mein Name ist %s", "Peter");
		UnaryOperator<String> uo1 = x -> String.format("Mein Name ist %s", "Peter");
		
		m.machWas();
		
		m2.machWas();
		
		m3.machWas();
		
		takeMachbar(m);
		
		
		// Alle 4 machen genau das gleiche
		takeMachbar(() -> System.out.println("............."));
		
		
		Machbar m4 = () -> System.out.println(".............");
		takeMachbar(m4);
		
		Machbar m5 = new Machbar() {
			
			@Override
			public void machWas() {
				System.out.println(".............");
			}
		};
		
		takeMachbar(m5);
		
		takeMachbar(System.out::println);
		
	}
	
	public static void takeMachbar(Machbar m) {
		m.machWas();
	}
	
}

@FunctionalInterface
interface Machbar {
	
	void machWas();
	
	// static oder default Methoden können noch dazukommen
	// Methoden von Object sind ebenfalls als abstrakte-Methoden erlaubt
	
	@Override
	String toString(); // Verletzt nicht das SAM
	
}

@FunctionalInterface
interface Machbar2 {
	
	String machWas();
	
}

@FunctionalInterface
interface Machbar3 {
	
	String machWas(String s);
	
}

class Zeug implements Machbar3 {

	@Override
	public String machWas(String x) {
		// TODO Auto-generated method stub
		return null;
	}
}


