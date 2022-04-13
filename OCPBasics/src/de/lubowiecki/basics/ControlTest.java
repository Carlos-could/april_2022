package de.lubowiecki.basics;

public class ControlTest {
	
	public static void main(String[] args) {
		
		byte b = 120;
		
		switch(b) {
			case 10: 
			case 20: 
			case 50: 
			//case 150: 
		}
		
		// Compile-Time-Konstanten
		final byte v1 = 10;
		final byte v2 = 20;
		
		// Runtime-Time-Konstanten, im Switch als Case nicht erlaubt
		final byte v3;
		v3 = 30;
		
		switch(b) {
			case v1: 
			case v2: 
			//case v3:
		}
		
		int v = 7;
					// WENN1 ? DANN 1            : // SONST1
							// WENN2 ? DANN 2 : SONST1
		boolean b2 = v > 5 ? (v < 8 ? true : false) : false;
		
		machWas(v > 5 ? true : false);
		
		int i = 10;
		
		if(i > 10)
		if(i > 20)
		if(i > 30);
			//System.out.println(i); // gilt als 2. Anweisung... ist nur bei einem if mit {...} erelaubt
		else
			System.out.println(i);
		else
			System.out.println(i);
		
		
		if(i < 10)
			System.out.println();
			//System.out.println(); // gilt als 2. Anweisung... ist nur bei einem if mit {...} erelaubt
		else {
			
		}
		
		// Loops
		
		int[] arr = {1,2,3,4,5,6};
		
		int j;
//		for(j : arr) { // j muss im loop deklariert werden!
//			System.out.println(j);
//		}
		
		int k = 0;
		for(; k < arr.length; k++) {
			System.out.println(arr[k]);
		}
		
		System.out.println("----------------");
		
		int x = Integer.MAX_VALUE - 10_000;
		for(;;System.out.println(++x)) {
			if(x == 1000) break;
		} // Endlos
		
		//for(;;) {} // Endlos-Nichts
		
		final boolean b3;
		b3 = true; // ist eine Runtime-Konstante d.h. Kopiler kennt den Wert hinter der Variable nicht
		
		while(b3) { // b3 ist nicht final
		}
		
		System.out.println("ENDE");
		
	}
	
	public static void machWas(boolean b) {
		
	}

}
