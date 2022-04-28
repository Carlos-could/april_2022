package de.lubowiecki.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;

public class LukeFileWalker {

	public static void main(String[] args) {
		
		
		Path p1 = Paths.get(".");
		
		try {
			Files.walk(p1)
				//.filter(p -> p.toString().endsWith(".java"))
				.forEach(p -> System.out.println(p));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		// find
		System.out.println();
		
		try {
			
			BiPredicate<Path, BasicFileAttributes> bp = (p, a) -> a.size() > 10_000;
			
			Files.find(p1, Integer.MAX_VALUE, bp)
				.forEach(p -> System.out.println(p));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		

	}
}
