package de.lubowiecki.basics;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

// JavaBean
public class Person implements Serializable {
	
	private static final long serialVersionUID = 4286897717937802708L;

	private int id;
	
	private String firstname;
	
	private String lastname;
	
	private LocalDate birthdate;
	
	public Person() {
	}
	
	public Person(int id, String firstname, String lastname, LocalDate birthdate) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public int hashCode() {
		System.out.println("HASHCODE");
		return Objects.hash(birthdate, firstname, id, lastname);
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("EQUALS");
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Person other = (Person) obj;
		return Objects.equals(birthdate, other.birthdate) && Objects.equals(firstname, other.firstname)
				&& id == other.id && Objects.equals(lastname, other.lastname);
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", birthdate=" + birthdate
				+ "]";
	}
}
