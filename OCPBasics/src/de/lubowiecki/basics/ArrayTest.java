package de.lubowiecki.basics;

public class ArrayTest {

	public static void main(String[] args) {
		
		int[] iArr = null;
		System.out.println(iArr.length);
		
		iArr = new int[]{10,20,30};
		// iArr = {10,20,30}; // geht nur, wenn var gleich deklariert und initialisiert wird
		int[] iArr2 = {10,20,30};
		iArr = new int[10]; // leeres Array mit 10 positionen
		
		int[] iArr3[];
		
		
		//int iArr4[], iArr5, iArr6;
		//int[] iArr4, iArr5, iArr6;
		int[] iArr4, iArr5[], iArr6;
		
		int[] iArr7 = new int[10];
		int[][] iArr8 = new int[10][];
		int[][] iArr9 = new int[10][10];
		
		// lokale Variablen müssen vor der Verwendung initialisiert werden
		int[] iArr10; // Wird, wenn nicht verwendet aus dem Kompilat entfernt

		//System.out.println(iArr10); //Error: iArr10 ist nicht initialisiert
		
		//10 = 15;
		
	}

}
