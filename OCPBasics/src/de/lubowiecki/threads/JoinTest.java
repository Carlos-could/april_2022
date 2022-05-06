package de.lubowiecki.threads;

import java.util.Random;

public class JoinTest {

	public static void main(String[] args) {
		
		Random rand = new Random();
		
		
		System.out.println("Start");
		
		Runnable r = () -> {
			System.out.println(Thread.currentThread().getName() + ": tut seinen Job");
			try {
				Thread.sleep((rand.nextInt(5) + 1) * 1000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ": hat seinen Job beendet");
		};
		
		
		Thread t1 = new Thread(r, "Peter");
		Thread t2 = new Thread(r, "Carol");
		Thread t3 = new Thread(r, "Bruce");
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			// Der aktuelle Thread wartet auf daen Thread auf dem join aufgerufen wird
			t1.join(); // main-Thread wartet darauf, dass t1 seine Aufgabe beendet hat
			t2.join(); // main-Thread wartet darauf, dass t2 seine Aufgabe beendet hat
			t3.join(); // main-Thread wartet darauf, dass t3 seine Aufgabe beendet hat
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		
		System.out.println("Ende");
	}

}
