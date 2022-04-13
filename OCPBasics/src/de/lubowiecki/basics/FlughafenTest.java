package de.lubowiecki.basics;

import java.util.ArrayList;
import java.util.List;

public class FlughafenTest {
	
	public static void main(String[] args) {
		
		Flughafen f = new Flughafen();
		AirBus123 ab = new AirBus123();
		Chestner c = new Chestner();
		f.landen(ab);
		f.landen(c);
		
	}

}

class Flughafen {
	
	private List<Flugzeug> flugzeuge = new ArrayList<>();
	
	public void landen(Flugzeug flugzeug) {
		flugzeug.informationenAustauschen();
		flugzeug.inPositionBringen(1000, 2000, "S");
		flugzeug.landen();
		flugzeuge.add(flugzeug);
		System.out.println("Fertig");
	}
	
	
}

interface Flugzeug {
	
	void informationenAustauschen();
	void inPositionBringen(int x, int y, String richtung);
	void landen();
	
}


class AirBus123 implements Flugzeug {
	
	private static final String TYPE = "AirBus123";

	public void informationenAustauschen() {
		System.out.println(TYPE + ": Bla bla bla");
		
	}

	public void landen() {
		System.out.println(TYPE + ": Fahrwerk ausfahren... abbremsen... landen");
		
	}

	public void inPositionBringen(int x, int y, String richtung) {
		
		// %f float/double, %s string, %d ganzzahlen, %n zeilenumbruch, %b boolean
		System.out.printf("%s: An position x: %d, y: %d begeben. \n", TYPE, x, y); // Sofortige Ausgabe
		System.out.println(TYPE + ": In richtung " + richtung + " ausrichten.");
		
		//String s = String.format("An position x: %d, y: %d begeben. \n", x, y); // Produziert einen String
	}
	
}

class Chestner implements Flugzeug {
	
	private static final String TYPE = "Chestner";

	@Override
	public void informationenAustauschen() {
		System.out.println(TYPE + ": Mayday Mayday...");
		
	}

	@Override
	public void inPositionBringen(int x, int y, String richtung) {
		System.out.printf("%s: An position x: %d, y: %d begeben. \n", TYPE, x, y); // Sofortige Ausgabe
		System.out.println(TYPE + ": In richtung " + richtung + " ausrichten.");
	}

	@Override
	public void landen() {
		System.out.println(TYPE + ": Fahrwerk ausfahren... Blödsinn... ist immer ausgefahren");
		
	}
	
}