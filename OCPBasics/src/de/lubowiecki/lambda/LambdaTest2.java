package de.lubowiecki.lambda;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaTest2 {

	private static int staticCount = 1;
	
	private int instanceCount = 1;
	
	
	public static void main(String[] args) {
		
		// boolean test(T t);
		//Predicate<Integer> minCount = (Integer i) -> i > staticCount;
		//Predicate<Integer> minCount = (i) -> i > staticCount;
		
		Predicate<Integer> minCount = i -> i > staticCount;
		staticCount++;
		
		System.out.println(minCount.test(5));
		
		Consumer<String> strCons = s -> System.out.println(s);
		strCons.accept("Hallo Lambda");
		
		new LambdaTest2().init();

	}
	
	public void init() {
		
		int localCount = 1;
		
		Predicate<Integer>  minCount = i -> i > instanceCount; // this in Lambdas gehört zu der umgebenden Klasse und nicht zum Lambda
		instanceCount++;
		
		//minCount = i -> i > localCount; // Error: lokale Variable ist nicht final oder effektiv-final
		localCount++;

	}

}
