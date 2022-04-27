package de.lubowiecki.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class BufferedZeug {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		StringBuilder sb = new StringBuilder(100_000);
//		try(Reader in = new FileReader("io/test.txt")) {
//			int b;
//			while((b = in.read()) != -1) {
//				sb.append((char)b);
//			}
//		} 
//		catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try(BufferedReader in = new BufferedReader(new FileReader("io/test.txt"))) {
			String line;
			while((line = in.readLine()) != null) {
				sb.append(line);
				//sb.append("\n");
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start + "ms");
		
		
		

	}

}
