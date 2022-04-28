package de.lubowiecki.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

	public static void main(String[] args) {
		
		Path p = FileSystems.getDefault().getPath("io", "abc.txt");
		
		p = Paths.get("io", "abc.txt");
		
		// relativ
		System.out.println(p);
		
		// absolut
		System.out.println(p.toAbsolutePath());
		
		Path d1 = Paths.get("io", "abc", "cde");
		Path d2 = Paths.get("xyz");
		
		System.out.println(d1.relativize(d2)); // zeigt den relativen wegg von d1 zu d2
		System.out.println(d2.resolve(d1)); // verbindet pfade
		
		// Jede Manipulation auf Path produziert ein neues Path Objekt. Path ist immutable
		p = d2.resolve(d1);
		
		p = Paths.get("io", "abc", "cde", "print.txt");
		
		System.out.println(p.getName(0)); // Liefert den Teil des Pfades an Indexposition. Index beginnt bei 0
		System.out.println(p.getName(3));
		System.out.println(p.getFileName()); // liefert den letzten Teil des Pfades
		
		// absoluter Pfad (Unter Win/Dos ist es der Laufwerkbuchstabe
		p = Paths.get("/", "abc", "cde", "print.txt");
		System.out.println(p);
		System.out.println(p.getName(0)); // Root ist nicht enthalten
		System.out.println(p.getRoot()); // Liefert den Root (Unter Win/Dos ist es der Laufwerkbuchstabe)
		
		d1 = Paths.get("io", "abc", "cde");
		d2 = Paths.get("../../xyz");
		
		p = d1.resolve(d2);
		System.out.println(p);
		System.out.println(p.normalize());
		
		d1 = Paths.get("io", "abc", "cde");
		d2 = Paths.get("xyz.txt");
		p = d1.resolveSibling(d2);
		System.out.println(p);
		
		File f = p.toFile(); // NIO zu IO
		Path p2 = f.toPath(); // IO zu NIO
		
		d1 = Paths.get("io", "test.txt");
		
		try {
			d1 = d1.toRealPath(); // prüft, ob die Datei / Verzeichnis wirklich da ist
			System.out.println(d1);
		} catch (IOException e) {
			// NoSuchFileException
			e.printStackTrace();
		}
		
	}
}
