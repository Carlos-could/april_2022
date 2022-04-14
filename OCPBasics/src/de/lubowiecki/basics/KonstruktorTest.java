package de.lubowiecki.basics;

public class KonstruktorTest {

	public static void main(String[] args) {
		
		SuperHero sh = new SuperHero();

		// Anonyme Klasse
		SuperKraft sk = new SuperKraft() { // Instanz einer annonymen Klasse die von SuperKraft erbt

			@Override
			public void nutzeKraft1() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void nutzeKraft2() {
				// TODO Auto-generated method stub
				
			}
		};
		
		Hero h = new Hero() {
			
			@Override
			public void nutzeKraft1() {
				System.out.println("....");
			}
			
		};
		
		
		// Ein Lambda ist nicht möglich da SuperKraft kein FunctionalInterface ist
		//SuperKraft sk2 = () -> System.out.println("Gogo Gageto...");
		//sk2.nutzeKraft1();
		
	}
}

class Hero implements SuperKraft { // Hero IS-A Object, Hero IS-A SuperKraft
	
	public Hero() {
		this(10);
	}
	
	public Hero(int i) {
		//super(); // ruft den Konstruktor von Object auf
	}

	@Override
	public void nutzeKraft1() {
		
	}
	
	@Override
	public void nutzeKraft2() {
		
	}
	
}

class SuperHero extends Hero { // SuperHero IS-A Hero, SuperHero IS-A Object, SuperHero IS-A SuperKraft 
	
	public SuperHero() {
		super(); // (kann super oder this sein) wenn vorhanden muss es die erste Zeile sein
	}
	
}

// FunctionalInterface muss ein SAM sein (Single Abstract Method) 
//@FunctionalInterface
interface SuperKraft {
	
	// int i;
	
	void nutzeKraft1();
	void nutzeKraft2();
	
}
