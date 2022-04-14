package de.lubowiecki.basics;

public class FunctionalTest {

	public static void main(String[] args) {
		
		
		MathOperation add = (x, y) -> x + y;
		System.out.println(add.use(10, 15));
		
		MathOperation multi = (x, y) -> x * y;
		System.out.println(multi.use(10, 15));
		
	}

}

@FunctionalInterface
interface MathOperation {
	
	int use(int a, int b);
	
	// Alle Instanz-Methoden von Object sind für das FunctionalInterface neutral
	int hashCode();
	
	@Override
	String toString();
	
	@Override
	boolean equals(Object obj);
	
}