package de.lubowiecki.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;

public class FileTest {

	public static void main(String[] args) {
		
		File f1 = new File("io");
		File f2 = new File(f1, "test.txt");
		// Erzeugt keine Verzeichnisse/Dateien auf FileSystem
		try {
			if(!f1.exists()) {
				f1.mkdir(); // Erzeugt ein Verzeichnis
				//f1.mkdirs(); // Erzeugt mehrere verschachtelte Verzeichnisse
			}
			
			if(!f2.exists()) {
				f2.createNewFile();// Erzeugt eine neue Datei
			}
			
			System.out.println("f1");
			System.out.println(f1.isDirectory());
			System.out.println(f1.isFile());
			
			System.out.println("f2");
			System.out.println(f2.isDirectory());
			System.out.println(f2.isFile());
			
			System.out.println("\nCUR");
			File cur = new File("."); // . aktuelles Verzeichnis
			
			for(String s : cur.list()) {
				System.out.println(s);
			}
			
			// Ausgabe in eine Datei
//			OutputStream out = new FileOutputStream(f2);
//			if(out != null)
//				out.close();
			
			// Schreiben von Bytes
			try(OutputStream out = new FileOutputStream(f2)) {
				out.write("Das ist das Haus von Nikigraus.".getBytes());
				// out.close() // wird automatisch am Ende des Blocks verwendet
			}
			
			// Lesen von Bytes
			try(InputStream in = new FileInputStream(f2)) {
				
				int b;
				while((b = in.read()) != -1) {
					System.out.print((char)b);
				}
				
				System.out.println();
				// in.close() // wird automatisch am Ende des Blocks verwendet
			}
			
			
			// Schreiben von Strings
			try(Writer out = new FileWriter(f2)) {
				out.write("Das ist das Haus von Nikigraus.");
			}
			
			// Lesen von Strings
			CharBuffer chars = CharBuffer.allocate(100);
			try(Reader in = new FileReader(f2)) {
				in.read(chars);
				System.out.println(chars.flip().toString());
			}
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
