package de.lubowiecki.jfx.firststeps.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductMapper extends AbstractMapper<Product> {

	public ProductMapper() throws SQLException {
		super("products");
		createTable();
	}

	public void createTable() throws SQLException {
		
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE + " ("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "name TEXT NOT NULL,"
				+ "description TEXT NULL, "
				+ "amount INTEGER NOT NULL"
				+ ")";
		
		try(Connection dbh = DbUtils.getConnection(); Statement stmt = dbh.createStatement()) {
			stmt.execute(sql);
		}
	}
	
	@Override
	public void insert(Product t) throws Exception {
		
		String sql = "INSERT INTO " + TABLE + " (name, description, amount) VALUES(?, ?, ?)";
		
		try(Connection dbh = DbUtils.getConnection(); PreparedStatement stmt = dbh.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, t.getName());
			stmt.setString(2, t.getDescription());
			stmt.setInt(3, t.getAmount());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys(); // Leiefert die atutomatisch vergebenen Keys (autoincrement) 
			if(rs.next()) {
				t.setId(rs.getInt(1));
			}
		}
	}

	@Override
	public void update(Product t) throws Exception {
		throw new UnsupportedOperationException("ist noch nicht implementiert...");
	}

	@Override
	public Product create(ResultSet rs) throws Exception {
		Product p = new Product();
		p.setId(rs.getInt("id"));
		p.setName(rs.getString("name"));
		p.setDescription(rs.getString("description"));
		p.setAmount(rs.getInt("amount"));
		return p;
	}

}
