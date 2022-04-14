package de.lubowiecki.basics;

public class VererbungTest {
	
	public static void main(String[] args) {
		
		Child c = new Child();
		c.doSomething();
		System.out.println(c.num);
		c.doSomethingElse();
		
		System.out.println();
		
		// Referenztyp     // Objekttyp
		Parent p = new Child();
		p.doSomething(); // Instanz-Methoden werden IMMER auf dem Objekttyp ausgeführt 
		System.out.println(p.num); // Eigenschaften werden über den Referenztyp abgefragt
		p.doSomethingElse(); // statische Methoden werden über den Referenztyp ausgeführt
		//p.doNothing(); // Nicht sichtbar über Parant
		
		Object o = new Parent();
		o = new Child();
		o = new String();
		o.hashCode(); // Über o sind nur Methoden und Eigenschaften von Object nutzbar
		
	}

}


class Parent {
	
	int num = 100;
	
	void doSomething() {
		System.out.println("Parent: " + num);
	}
	
	static void doSomethingElse() {
		System.out.println("Parent");
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}

class Child extends Parent {
	
	int num = 200;
	
	@Override
	void doSomething() {
		System.out.println("Child: " + (num + super.num));
	}
	
	void doNothing() {
		System.out.println("Child: " + (num + super.num));
	}
	
	static void doSomethingElse() {
		System.out.println("Child");
	}
	
}