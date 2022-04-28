package de.lubowiecki.nio;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.Iterator;
import java.util.Map;

public class AttributeTest {

	public static void main(String[] args) {
		
		Path p1 = Paths.get("io", "test.txt");
		
		try {
			// Auf allen Betriebssystemen verfügbar
			BasicFileAttributeView basicView = Files.getFileAttributeView(p1, BasicFileAttributeView.class);
			BasicFileAttributes attrs = basicView.readAttributes();
			System.out.println(attrs.size());
			System.out.println(attrs.isDirectory());
			System.out.println(attrs.isRegularFile());
			System.out.println(attrs.creationTime());
			System.out.println(attrs.lastModifiedTime());
			System.out.println(attrs.lastAccessTime());
			
			// Nur unter DOS und Windows verfügbar
//			DosFileAttributeView dosView = Files.getFileAttributeView(p1, DosFileAttributeView.class);
//			DosFileAttributes dAttrs = dosView.readAttributes();
//			System.out.println(dAttrs.isSystem());
			
			// Nur unter Unix verfügbar
			PosixFileAttributeView posixView = Files.getFileAttributeView(p1, PosixFileAttributeView.class);
			PosixFileAttributes pAttrs = posixView.readAttributes();
			System.out.println(pAttrs.owner());
			
			FileStore store = Files.getFileStore(p1);
			System.out.println(store.getTotalSpace());
			System.out.println(store.getUnallocatedSpace());
			
			System.out.println();
			
			Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
			
			for (FileStore fileStore : stores) {
				System.out.println(fileStore);
				System.out.println(fileStore.getTotalSpace());
				System.out.println(fileStore.getUnallocatedSpace());
				System.out.println(fileStore.getUsableSpace());
			}
			
			
			BasicFileAttributes attr = Files.readAttributes(p1, BasicFileAttributes.class);
			System.out.println(attr.creationTime());
			
			System.out.println();
			
			Map<String, Object> map = Files.readAttributes(p1, "unix:*");
			System.out.println(map);
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
