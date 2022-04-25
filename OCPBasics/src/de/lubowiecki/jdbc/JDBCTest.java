package de.lubowiecki.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		
		try(Connection dbh = connect(); Statement stmt = dbh.createStatement(
				ResultSet.TYPE_FORWARD_ONLY,
				ResultSet.CONCUR_READ_ONLY)) {
			
			// CRUD
			
			
			// CREATE
//			int count = stmt.executeUpdate("INSERT INTO users (firstname, lastname) VALUES('Steve', 'Rogers')");
//			
//			if(count > 0) {
//				System.out.println("Gespeichert...");
//			}
			
			// READ (find)
			ResultSet rs = stmt.executeQuery("SELECT * FROM users");
			
			//rs.absolute(2); // bewegt den Zeiger auf eine bestimmte Zeile
			//rs.relative(2); // bewegt den Zeiger auf um 2 zeilen weiter (ausgehend von aktueller Position)
			//rs.deleteRow(); // Löscht eine Zeile aus dem ResultSet
			
			// funktioniert nur wenn das Statement CONCUR_UPDATABLE ist
			//rs.updateString("firstname", "Hans"); // Änderung des vornamens an der aktuellen Position
			
			// ResultSetMetaData - Struktur der Tabelle ermitteln
//			ResultSetMetaData rsmd = rs.getMetaData();
//			int count = rsmd.getColumnCount();
//			for(int i = 1; i <= count; i++) {
//				System.out.println(rsmd.getColumnName(i));
//				//System.out.println(rsmd.getColumnLabel(i));
//				System.out.println(rsmd.getColumnTypeName(i));
//			}
			
			
//			while(rs.next()) {
//				System.out.print("\n" + rs.getInt("id") + ": ");
//				System.out.print(rs.getString("firstname") + " " + rs.getString("lastname"));
//				System.out.println();
//			}
			
			// READ (findById)
//			ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id = 3"); // {id, firstname, lastname}
//			
//			if(rs.next()) {
//				System.out.print("\n" + rs.getInt("id") + ": ");
//				System.out.print(rs.getString("firstname") + " " + rs.getString("lastname"));
//				System.out.println();
//			}
			
			// UPDATE
//			int count = stmt.executeUpdate("UPDATE users SET lastname = 'Wayne' WHERE id = 2");
//			
//			if(count > 0) {
//				System.out.println("Geändert...");
//			}
			
			// DELETE
//			int count = stmt.executeUpdate("DELETE FROM users WHERE id = 1");
//			
//			if(count > 0) {
//				System.out.println("Gelöscht...");
//			}
			
			
			Savepoint s1 = null;
			
			try {
				dbh.setAutoCommit(false); // Anweisungen werden erst bei einem commit zusammen übertragen
				stmt.executeUpdate("UPDATE users SET firstname = 'Nick' WHERE id = 2");
				s1 = dbh.setSavepoint(); // Sicherungspunkt für das rollback
				stmt.executeUpdate("UPDATE users SET last_name = 'Nickolsen' WHERE id = 5");
				// verursacht eine Anweisung ein Problem, wird keine ausgeführt
				dbh.commit();
			}
			catch(SQLException e) {
				//dbh.rollback(); // entfernt ALLE Anweisungen aus der Befehls-Queue
				
				if(s1 != null) {
					dbh.rollback(s1); // Anweisungen die nach dem Savepoint kommen werden aus der Befehls-Queue entfernen
					dbh.commit();
				}
			}
			
			// stmt.close();
			// dbh.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static Connection connect() throws SQLException {
		
		return DriverManager.getConnection("jdbc:sqlite:firststeps.db");
		
	}
}
