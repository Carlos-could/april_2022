package de.lubowiecki.basics;

public class OverloadingTest {
	
	public static void main(String[] args) {
		new OverloadingTest().init();
	}
	
	void init() {
		machWas(10);
		
		// 1. passende Methode: int
		// 2. primitiv Widening zu double
		// 3. Autoboxing zu Integer
		// 4. Autoboxing zu Integer und Objekt-Widening zum Parent d.h. Number
		// 5. VarArgs immer als letzte Option
	}
	
	void machWas(byte b) {
		System.out.println("byte");
	}
	
	void machWas(Byte b) {
		System.out.println("Byte");
	}
	
//	void machWas(int b) {
//		System.out.println("int");
//	}
	
//	void machWas(Integer b) {
//		System.out.println("Integer");
//	}
	
//	void machWas(double b) {
//		System.out.println("double");
//	}
	
	void machWas(Double b) {
		System.out.println("Double");
	}
	
//	void machWas(Number b) {
//		System.out.println("Number");
//	}
	
	void machWas(int... b) {
		System.out.println("int VarArg");
	}

}
