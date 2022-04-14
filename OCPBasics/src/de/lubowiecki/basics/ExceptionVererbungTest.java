package de.lubowiecki.basics;

import java.io.IOException;

public class ExceptionVererbungTest {
	
	public static void main(String[] args) {
		
		Auto suv = new SUV();
		
		try {
			suv.start();
			suv.gibGas();
			suv.gibGas();
			suv.gibGas();
			suv.gibGas();
			suv.gibGas();
			suv.gibGas();
			suv.gibGas();
			suv.gibGas();
			suv.gibGas();
			suv.gibGas();
		} 
		catch (SpritNichtDaException e) {
			System.out.println("Du musst tanken...");
		}
		catch (AutoIstNichtGestartetException e) {
			System.out.println("Das Auto ist noch aus!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}

class Auto {
	
	private int tank = 100;
	
	private boolean gestartet;
	
	void gibGas() throws SpritNichtDaException, AutoIstNichtGestartetException {
		
		if(gestartet) {
			if((tank -= 20) > 0) {
				System.out.println("Super");
			}
			else {
				throw new SpritNichtDaException();
			}
		}
		else {
			throw new AutoIstNichtGestartetException();
		}
	}
	
	void start() {
		gestartet = true;
	}
	
	
}

class SUV extends Auto {
	
	void start() { //throws IOException {
		System.out.println("Steige in den SUV ein und starte...");
		super.start();
	}
	
}

class SpritNichtDaException extends Exception {	
}

class AutoIstNichtGestartetException extends Exception {
}
