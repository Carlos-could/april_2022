package de.lubowiecki.basics;

public class ControlTest2 {
	
	static int y; // Klassen und Instanz-Variablen bekommen default-Werte

	public static void main(String[] args) {
		
		int y; // lokale Variablen bekommen keine default-Werte
		y = 5;
		
		while(y < 10) {
			System.out.println(y);
			break;
		}
		
		int x = 0;
		
//		do {
//			x++;
//			int z = 15; // Außerhalb der {} nicht sichtbar
//		}
//		while(x == z); //Kompilererror
		
		System.out.println("--------");
		
		for(int i = 10; i > 5; i--) {
			if(i == 7) break;
			System.out.println(i);
		}
		
		System.out.println("ENDE");

	}

}
