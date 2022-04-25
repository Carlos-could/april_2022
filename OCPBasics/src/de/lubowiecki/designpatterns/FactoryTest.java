package de.lubowiecki.designpatterns;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;

public class FactoryTest {

	public static void main(String[] args) {
		
		LocalDate ld = LocalDate.now();
		Stream.of(1,2,5,22,19,18);
		
		Optional<String> opt = Optional.empty();
		opt.ifPresent(System.out::println);
		
		System.out.println(opt.orElse("Leer"));
		

	}

}
