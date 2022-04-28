package de.lubowiecki.io;

import java.io.File;
import java.io.PrintWriter;

public class PrintTest {

	public static void main(String[] args) {
		
		File f = new File("io/print.txt");
		
		try(PrintWriter writer = new PrintWriter(f)) {
			
			writer.printf("Das ist das Haus von %s %n", "Nikigraus");
			writer.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
