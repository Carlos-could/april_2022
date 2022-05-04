package de.lubowiecki.lambda;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MethodenReferenzenTest {
	
	private static MethodenReferenzenTest mt = new MethodenReferenzenTest();
	private static Random rand = new Random();

	public static void main(String[] args) {
		
		//Stream.of(1,2,3,4,5,6,7,8,9,10);
		
		IntStream.rangeClosed(1, 100)
			.mapToDouble(i -> i) // IntToDoubleFunction, i wird mit primitiv widening zu double
			//.forEach(d -> System.out.println(d)); // DoubleConsumer
			//.forEach(System.out::println); // Methoden-Referenz, void println(double d)
			//.forEach(MethodenReferenzenTest::gibAusStatic); // statische Methode
			.forEach(mt::gibAusInstanz); // instanz Methode
		
		// Methoden-Referenz: statt selbst die Methode eines FunctionalInterfaces zu implementieren,
		// wird auf eine bereits vorhonadene Methode mit gleicher Signatur verwiesen
		
		System.out.println();
		
		IntStream.generate(MethodenReferenzenTest::gibZufallszahl)
			.forEach(mt::gibAusInstanz);
	}
	
	public static void gibAusStatic(double d) {
		System.out.println("###" + d + "###");
	}
	
	public void gibAusInstanz(double d) {
		System.out.println("###" + d + "###");
	}
	
	public static int gibZufallszahl() {
		return rand.nextInt(100) + 1;
	}

}
