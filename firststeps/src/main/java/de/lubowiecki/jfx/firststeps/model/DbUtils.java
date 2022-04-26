package de.lubowiecki.jfx.firststeps.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
	
	private DbUtils() {
	}
	
	public static Connection getConnection() throws SQLException {
		// TODO: Config auslagern
		return DriverManager.getConnection("jdbc:sqlite:firststeps.db");
	}
}
