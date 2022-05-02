package de.lubowiecki.designpatterns;

import java.time.LocalDate;

public class BuilderTest {
	
	public static void main(String[] args) {
		
		Person p1 = new Person("Peter", "Parker", LocalDate.of(1982, 10, 5));
		
		Person.Builder builder = new Person.Builder();
		
		Person p2 = builder.setFirstName("Peter").build();
		
		Person p3 = builder.setLastName("Hansen")
							.setBirthDate(LocalDate.now())
							.setFirstName("Hans")
							.build();
		
		Person p4 = builder.setFirstName("Peter").build();
		
	}
}

class Person {
	
	private final String firstName;
	
	private final String lastName;
	
	private final LocalDate birthDate;
	
	public Person(String firstName, String lastName, LocalDate birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public static class Builder {
		
		private String firstName = "Unbekannt";
		
		private String lastName = "Unbekannt";
		
		private LocalDate birthDate;

		public Builder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder setBirthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
			return this;
		}
		
		public Person build() {
			return new Person(firstName, lastName, birthDate);
		}
	}
}
