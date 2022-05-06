package de.lubowiecki.threads;

public class JoinTest2 {

	public static void main(String[] args) {
		
		System.out.println("START");
		
		TrainThread t1 = new TrainThread("Peter", Thread.currentThread()); // wartet bis main fertig ist
		TrainThread t2 = new TrainThread("Bruce", t1); // wartet bis t1 fertig ist
		TrainThread t3 = new TrainThread("Tony", t2); // wartet bis t2 fertig ist
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("END");

	}

}

class TrainThread extends Thread {
	
	private Thread other;
	
	// other ist der Thread auf den gewartet werden soll
	public TrainThread(String name, Thread other) {
		super(name);
		this.other = other;
	}

	@Override
	public void run() {
		
		try {
			other.join(); // wartet bis other mit seiner run-Methode fertig ist
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < 100; i++) {
			System.out.println(getName() + ": " + i);
		}
	}
	
}
