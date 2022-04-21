package de.lubowiecki.generics;

public class GenericCalculator<T extends Number> {
	
	public static void main(String[] args) {
		
		GenericCalculator<Byte> bc = new GenericCalculator<>();
		System.out.println(bc.add((byte)5, (byte)7));
		
		GenericCalculator<Long> lc = new GenericCalculator<>();
		System.out.println(lc.add(5L, 7L));
	}
	
	public double add(T a, T b) {
		// a und b sind nicht vom Typ Object sondern Number
		return a.doubleValue() + b.doubleValue();
	}
}
