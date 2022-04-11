package de.lubowiecki.basics;

public class StaticCounter {
	
	private static int count;

	public static int getCount() {
		return count;
	}

	public static void up() {
		count++;
	}
}
