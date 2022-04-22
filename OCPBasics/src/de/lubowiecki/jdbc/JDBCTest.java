package de.lubowiecki.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		
		try(Connection dbh = connect(); Statement stmt = dbh.createStatement()) {
			
			// CRUD
			
			
			// CREATE
//			int count = stmt.executeUpdate("INSERT INTO users (firstname, lastname) VALUES('Steve', 'Rogers')");
//			
//			if(count > 0) {
//				System.out.println("Gespeichert...");
//			}
			
			// READ (find)
//			ResultSet rs = stmt.executeQuery("SELECT * FROM users");
//			
//			while(rs.next()) {
//				System.out.print("\n" + rs.getInt("id") + ": ");
//				System.out.print(rs.getString("firstname") + " " + rs.getString("lastname"));
//				System.out.println();
//			}
			
			// READ (findById)
			ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id = 3");
			
			if(rs.next()) {
				System.out.print("\n" + rs.getInt("id") + ": ");
				System.out.print(rs.getString("firstname") + " " + rs.getString("lastname"));
				System.out.println();
			}
			
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
