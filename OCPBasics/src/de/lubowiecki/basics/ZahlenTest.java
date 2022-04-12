package de.lubowiecki.basics;

public class ZahlenTest {
	
	public static void main(String[] args) {
		
		byte b = 10;
		short s = 10 + 1;
		long l = 1_000_000_000_000L;
		float f = 10.0F;
		
		int i1 = 0b00110110; // binär
		i1 = 0101;
		i1 = 0xabcdef;
		
		System.out.println(i1);
		System.out.println(Integer.toHexString(i1) + 1);
		
	}
}
