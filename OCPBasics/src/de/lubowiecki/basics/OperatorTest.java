package de.lubowiecki.basics;

public class OperatorTest {
	
	public static void main(String[] args) {
		
		int i = 10;
		i++;
		++i;
		
		i = ++i;
		
		i = 10;
		i = i++;
		System.out.println(i); // postfix wird nach der zuweisung nicht mehr ausgeführt
		
		int a = 1;
		int b = 2;
		
				//2 + 3 + 3 + 4
		int c = ++a + ++a + a++ + a++;
		
		System.out.println(c);
		
		System.out.println();
		
		int z = 8 & 11;
		
		// 00000100
		// 00000111
		// 00000100
		
		System.out.println(z);
		
	}

}
