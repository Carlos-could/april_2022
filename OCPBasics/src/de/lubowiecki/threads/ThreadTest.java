package de.lubowiecki.threads;

public class ThreadTest {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName() + ": START");
		
		// void run();
		Runnable r = () -> {
			
			String name = Thread.currentThread().getName();
			
			for(int i = 0; i < 1000; i++) {
				if(Thread.interrupted()) {
					System.out.println(name + ": Wurde abgebrochen...");
					break;
				}	
					
				// Thread.currentThread(): der aktuelle Thread wird ermittelt
				System.out.println(name + ": " + i);
				
				try {
					Thread.sleep(1000); // Der Thread, der diese Zeile ausführt pausiert für 1 Sekunde
				} 
				catch (InterruptedException e) {
					System.out.println(name + ": Jetzt ist der Thread wach...");
					Thread.currentThread().interrupt(); // setzt interrupted auf true
				}
			}
		};
		
		
		// r.run(); // Starten die Aufgabe sequentiel im main-Thread
		
		// Thread wird als Container für eine Aufgabe verwendet
		Thread t = new Thread(r);
		//t.setPriority(10);
		t.setPriority(Thread.MAX_PRIORITY);
		t.start();
		
		new Thread(r).start(); // Wird parallel ausgeführt
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		
		//new Thread(r).run(); // Startet die Aufgabe sequentiel im main-Thread
		new Thread(r).start(); // Startet die run-Methode (Aufgabe) parallel in einem eigenen Thread
		
		try {
			Thread.sleep(5000); // main-Thread wartet 5 Sekunden
			t.interrupt();
			//t.stop(); // lieber nicht mehr benutzen, weil es zu ungültigen Objekt-Zuständen führen kann
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Hier ist die Aufgabe ein Teil des Threads und braucht nicht übergeben werden 
//		new MyThread().start();
//		new MyThread().start();
//		new MyThread().start();
//		new MyThread().start();
//		new MyThread().start();
		
		System.out.println(Thread.currentThread().getName() + ": ENDE");

		// Programm endet erst, wenn alle Threads fertig sind
		
		
		Object o = new Object();
		// Diese Methoden werden für Synchronisierung verwendet
//		o.notify();
//		o.wait();
		
	}

}

class MyThread extends Thread {
	
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			// getName: direkte Verwendung von Thread-Methoden möglich
			System.out.println(getName() + ": " + i);
		}
	}
	
}
