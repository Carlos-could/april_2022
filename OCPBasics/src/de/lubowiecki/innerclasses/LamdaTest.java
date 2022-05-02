package de.lubowiecki.innerclasses;

public class LamdaTest {

	public static void main(String[] args) {
		
		Machbar m1 = () -> System.out.println("...");
		m1.machWas();
		
		
		Machbar m2 = new Machbar() {
			@Override
			public void machWas() {
				System.out.println("###");
				
			}
		};
		
		m2.machWas();
	

	
		//Fahrbar f1 = () -> System.out.println("..."); // Error. Lambdas benötigen eine einzige abstrakte Methode
		
		Fahrbar f2 = new Fahrbar() {
			
			@Override
			public void vorwärts() {
				System.out.println("VOR");
				
			}
			
			@Override
			public void rückwärts() {
				System.out.println("ZURÜCK");
			}
		};
		
		f2.vorwärts();
		f2.rückwärts();
		
		Fahrbar f3 = new Fahrbar() {
			
			@Override
			public void vorwärts() {
				System.out.println("FORWORD");
				
			}
			
			@Override
			public void rückwärts() {
				System.out.println("BACK");
			}
		};
		
		f3.vorwärts();
		f3.rückwärts();
		
		
		AbstractFahrzeug af1 = new AbstractFahrzeug() {

			@Override
			public void vorwärts() {
				System.out.println("fährt langsam vorwärts.");
				
			}
			
			@Override
			public void einsteigen(int personen) {
				System.out.printf("Es steigen wahrscheinlich %d Personen ein.\n", personen);
			}
			
		};
		
		af1.einsteigen(10);
		af1.vorwärts();
		af1.rückwärts();
	}
	
}


// SAM
interface Machbar {
	void machWas();
}

// Kein SAM
interface Fahrbar {
	
	void vorwärts();
	
	void rückwärts();
}

abstract class AbstractFahrzeug implements Fahrbar {
	
	@Override
	public void rückwärts() {
		System.out.println("ganz langsam rückwärts fahren");
	}
	
	public void einsteigen(int personen) {
		System.out.printf("Es steigen %d Personen ein.\n", personen);
	}
}
