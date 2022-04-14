package de.lubowiecki.basics;

import java.io.IOException;

public class ExceptionTest {

	public static void main(String[] args) {
		
		
		try {
			new ExceptionTest().init();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void init() throws Exception {
		
		machWas();
		
		
//		try {
//			machWasGanzAnderes();
//		}
//		catch(IOException e) { // IOException kann nicht behandelt werden, wenn sie gar nicht auftuchen kann
//			// IOException ist immer checked
//			e.printStackTrace();
//		}
		
		try {
			machWasGanzAnderes();
		}
		catch(Exception e) { // Exception kann auch eine RuntimeException sein
			e.printStackTrace();
		}
		
		
		try {
			machWasAnderes();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	void machWas() throws Exception { // throws kann verwendet werden, auch wenn die Methode keine Exception werfen kann
		System.out.println("Hallo");
	}
	
	void machWasAnderes() throws IOException { // throws kann verwendet werden, auch wenn die Methode keine IOException wirft
		System.out.println("Hallo");
	}
	
	void machWasGanzAnderes() {
		System.out.println("Hallo");
	}

}
