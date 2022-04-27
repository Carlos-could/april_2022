package de.lubowiecki.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DataStreamTest {

	public static void main(String[] args) {
		
		File f = new File("io/zahlen.txt");
		
		int i = 127;
		
		try(DataOutputStream out = new DataOutputStream(new FileOutputStream(f))) {
			out.writeDouble(i);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		try(DataInputStream in = new DataInputStream(new FileInputStream(f))) {
			Double d = in.readDouble();
			System.out.println(++d);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
