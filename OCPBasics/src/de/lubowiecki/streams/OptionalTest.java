package de.lubowiecki.streams;

import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {
		
		Optional<String> opt = Optional.empty();
		//opt = Optional.of("Voll");
		
		//System.out.println(opt.get()); // Wenn leer gibt es eine Exception
		System.out.println(opt.orElse("Leer"));
		
		opt.ifPresent(System.out::println);
		
	}

}
