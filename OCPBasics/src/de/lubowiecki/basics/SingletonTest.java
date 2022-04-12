package de.lubowiecki.basics;

public class SingletonTest {
	
	public static void main(String[] args) {
		
		LazySingleton s1 = LazySingleton.getInstance();
		// s1 = new LazySingleton(); // Konstruktor ist privat
		
		LazySingleton s2 = LazySingleton.getInstance();
		
		System.out.println(s1.getCount());
		System.out.println(s2.getCount());
		System.out.println(s1.getCount());
		System.out.println(s2.getCount());
		
	}
}

class EagerSingleton {
	
	// instance wird gleicht initialisiert
	private static EagerSingleton instance = new EagerSingleton();
	
	private int count;
	
	private EagerSingleton() {
	}
	
	public static EagerSingleton getInstance() {
		return instance;
	}

	public int getCount() {
		return ++count;
	}
	
}

class LazySingleton {
	
	// instance wird beim ersten Aufruf von getInstance initialisiert
	private static LazySingleton instance;
	
	private int count;
	
	private LazySingleton() {
	}
	
	public static LazySingleton getInstance() {
		
		if(instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}

	public int getCount() {
		return ++count;
	}
}