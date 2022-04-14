package de.lubowiecki.basics;

public class InterfaceTest {
	
	public static void main(String[] args) {
		KonkreteKlasse kk = new KonkreteKlasse();
		kk.machDas();
		//kk.machDies(); // nicht verfügbar
		//KonkreteKlasse.machDies();
		Machbar.machDies();
		System.out.println(kk.DEFAULT_NUM);
	}
}

interface Machbar {
	
	// wird vererbt
	int DEFAULT_NUM = 100; // per default public static final
	
	default void machDas() {
		System.out.println(getClass().getSimpleName());
	}
	
	// Wird nicht vererbt
	static void machDies() {
		System.out.println("Dies");
	}
	
}

interface NochBesserMachbar {
	
	default void machDas() {
		System.out.println(getClass().getSimpleName());
	}
	
}

class KonkreteKlasse implements Machbar, NochBesserMachbar {

	@Override
	public void machDas() {
		System.out.println(getClass().getSimpleName());
	}
}