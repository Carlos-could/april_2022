package de.lubowiecki.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SerializeTest {

	public static void main(String[] args) {
		
		/*
		Flughafen hh = new Flughafen("Hamburg");
		Flughafen hb = new Flughafen("Bremen");
		Flughafen ki = new Flughafen("Kiel");
		
		Flugzeug f1 = new Flugzeug("BOEING 757", 182);
		Flugzeug f2 = new Flugzeug("Airbus A319", 150);
		Flugzeug f3 = new Flugzeug("Airbus A330", 275);
		Flugzeug f4 = new Flugzeug("Airbus A320", 175);
		Flugzeug f5 = new Flugzeug("Cessna 162 Skycatcher", 4);
		
		hh.addFlugzeug(f1);
		hh.addFlugzeug(f2);
		hb.addFlugzeug(f3);
		ki.addFlugzeug(f4);
		ki.addFlugzeug(f5);
		
		Set<Flughafen> republik = new HashSet<>();
		republik.add(hh);
		republik.add(hb);
		republik.add(ki);
		*/
		
		File f = new File("io/republik.ser");
		
		// Serialisierung
//		try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)))) {
//			
//			oos.writeObject(republik);
//			
//		} 
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// Deserialisierung
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)))) {

			Set<Flughafen> republik = (Set<Flughafen>) ois.readObject();
			
			for(Flughafen h : republik) {
				System.out.println(h.getName());
				
				for(Flugzeug fl : h.getFlugzeuge()) {
					System.out.println("\t" + fl.getName() + ": " + fl.getCountPassagiere());
				}
			}
			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Flughafen implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private final String name;
	
	private List<Flugzeug> flugzeuge;
	
	public Flughafen(String name) {
		this.name = name;
		flugzeuge = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}

	public List<Flugzeug> getFlugzeuge() {
		return flugzeuge;
	}

	public void addFlugzeug(Flugzeug flugzeug) {
		this.flugzeuge.add(flugzeug);
	}
}

class Flugzeug implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String name;
	
	private int countPassagiere;
	
	public Flugzeug(String name, int countPassagiere) {
		this.name = name;
		this.countPassagiere = countPassagiere;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCountPassagiere() {
		return countPassagiere;
	}

	public void setCountPassagiere(int countPassagiere) {
		this.countPassagiere = countPassagiere;
	}
}
