package de.lubowiecki.basics;

public class Pointer {
	
	private int x;
	private int y;
	
	public Pointer setX(int x) {
		this.x = x;
		return this;
	}
	
	// Objekt-Chaining
	public Pointer setY(int y) {
		this.y = y;
		return this;
	}

	@Override
	public String toString() {
		return "Pointer [x=" + x + ", y=" + y + "]";
	}
}
