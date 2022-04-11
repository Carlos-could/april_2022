package de.lubowiecki.basics;

public class WideningTest {
	
	public static void main(String[] args) {
		
		int i = 10;
		double d = i; // primitiv widening 
		i = (int) d; // narrowing, nicht automatisch möglich. Cast nötig
		
		Integer i2 = 10; // Autoboxing von int zu Integer
		i = i2; // Auto-Unboxing
		
		//Double d2 = 10; // Autoboxing int zu Integer, Widening von Integer zu Double, nicht möglich
		
		Number n1 = 10.0;
		
		byte b1 = 10;
		byte b2 = 15;
		//byte sum = b1 + b2; // Mathematische Operationen haben als Erg. mind. ein int
		
		float f = b1 + b2; // + führt zu int, danach widening zu float
		
		//b1 = b1 + 1; // Mathematische Operationen haben als Erg. mind. ein int
		b1 += 1; // b1 = (byte)(b1 + 1)
		b1++; // b1 = (byte)(b1 + 1)
		
		b1 = (byte) 1000;
		
		double sumD = b1 + 100.0; // b1 wird vor dem rechnen zu double erweitert
		
		// byte < short < int < long < float < double
		// char < int
		
		float f1 = 'c';
		System.out.println(f1);
		
		
	}

}
