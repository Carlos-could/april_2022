package de.lubowiecki.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		
		Set<Integer> zahlen = new HashSet<>();
		zahlen.add(5);
		zahlen.add(1);
		System.out.println(zahlen.add(3));
		zahlen.add(9);
		zahlen.add(22);
		zahlen.add(null);
		
		//System.exit(0);
		
		System.out.println(zahlen);
		
		zahlen.remove(9); // Element mit Wert 9 wird aus der Menge entfernt
		System.out.println(zahlen.add(3));
		
		System.out.println(zahlen);
		
		System.out.println();
		for(int i : zahlen) {
			System.out.println(i);
		}
		
		System.out.println();
		Iterator<Integer> itr = zahlen.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		// Geht nicht beim Set
//		for(int i = 0; i < zahlen.size(); i++) {
//			System.out.println(zahlen.get(i)); // Set hat keine get-Methode
//		}
		
		System.out.println();
		zahlen.forEach(z -> System.out.println(z));
		
		System.out.println("-----------");
		
		Set<Car> cars = new HashSet<>();
		cars.add(new Car("HH:AB123"));
		cars.add(new Car("HH:ZX220"));
		cars.add(new Car("HH:AB123"));
		
		System.out.println(cars);
		
	}

}

// Car ist NICHT sortierbar
class Car { // ist nicht Comparable, d.h. implementiert das Interface Comparable nicht
	
	private String registration;
	
	public Car(String registration) {
		this.registration = registration;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	@Override
	public String toString() {
		return "Car [registration=" + registration + ", hashCode=" + hashCode() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(registration);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(registration, other.registration);
	}
}
