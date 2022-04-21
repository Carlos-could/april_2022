package de.lubowiecki.generics.orm;

// VO - ValueObject
// DTO - Data Transfer Object
public class User extends AbstractEntity {
	
	private String firstName;
	
	private String lastName;
	
	public User() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
