package de.lubowiecki.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Stream;

public class FilesTest {

	public static void main(String[] args) {
		
		Path p = Paths.get("io", "f1.txt");
		
//		Files.exists(p); // existiert: true, nicht da: false, keine Rechte auch: false
//		!Files.exists(p); // existiert: false, nicht da: true, keine Rechte auch: true
//		Files.notExists(p); // existiert: false, nicht da: true, keine Rechte auch: false
		try {
			if(Files.notExists(p)) {
				Files.createFile(p);
			}
			
			p = p.subpath(0, 1).resolve("test");
			if(Files.notExists(p)) {
				Files.createDirectory(p);
			}
			
			Path p1 = Paths.get("io", "test");
			Path p2 = Paths.get("io", "test", "xyz", "abc", "..", "..");
			
			System.out.println(Files.isSameFile(p1, p2));
			
			p1 = Paths.get("io", "test.txt");
			p2 = Paths.get("io", "test_copy.txt");
			Files.copy(p1, p2, StandardCopyOption.REPLACE_EXISTING);
			
			p2 = Paths.get("io", "test", "test.txt");
			//Files.move(p1, p2, StandardCopyOption.REPLACE_EXISTING);
			
			p1 = Paths.get("io", "test_copy.txt");
			Files.deleteIfExists(p1);
			
			p1 = Paths.get("io", "test.txt");
//			try(BufferedReader r = Files.newBufferedReader(p1)) {
//				String line;
//				while((line = r.readLine()) != null) {
//					System.out.println(line);
//				}
//			}
			
			{
				// Alle Zeilen liegen im Speicher
//				List<String> lines = Files.readAllLines(p1);
//				lines.removeIf(l -> l.isEmpty());
//				lines.forEach(System.out::println);
			}
			
			// Zeilen werden nacheinander verarbeitet
			Stream<String> lines = Files.lines(p1);
			lines.forEach(System.out::println);
			
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
