package de.lubowiecki.basics;

public class StringBuilderTest {
	
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder(); // Länge: 16
		System.out.println(sb.capacity());
		
		sb.append("0123456789abcdef0123").append("ABC"); // Neue Länge = Alte Länge * 2 + 2;
		System.out.println(sb.capacity()); // Länge: 34
		
		System.out.println();
		
		sb = new StringBuilder("abc"); // Länge: 3 + 16, Initial-Länge + 16
		System.out.println(sb.capacity());
		
		System.out.println();
		
		sb = new StringBuilder(1000); // Länge: 1000
		System.out.println(sb.capacity());
		sb.append("ABC");
		sb.trimToSize(); // Länge: 3
		
	}
}
