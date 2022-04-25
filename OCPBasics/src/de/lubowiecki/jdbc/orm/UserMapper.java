package de.lubowiecki.jdbc.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class UserMapper extends AbstractMapper<User> {

	public UserMapper() {
		super("users");
	}

	@Override
	public void insert(User t) throws Exception {
		
		String sql = "INSERT INTO " + TABLE + " (firstname, lastname) VALUES(?, ?)";
		
		try(Connection dbh = DbUtils.getConnection(); PreparedStatement stmt = dbh.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, t.getFirstname());
			stmt.setString(2, t.getLastname());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys(); // Leiefert die atutomatisch vergebenen Keys (autoincrement) 
			if(rs.next()) {
				t.setId(rs.getInt(1));
			}	
		}
	}

	@Override
	public void update(User t) throws Exception {
		
		String sql = "UPDATE " + TABLE + " SET firstname = ?, lastname = ? WHERE id = ?";
		
		try(Connection dbh = DbUtils.getConnection(); PreparedStatement stmt = dbh.prepareStatement(sql)) {
			stmt.setString(1, t.getFirstname());
			stmt.setString(2, t.getLastname());
			stmt.setInt(3, t.getId());
			stmt.execute();
		}
		
	}
	
	@Override
	public User create(ResultSet rs) throws Exception {
		User u = new User();
		u.setId(rs.getInt("id"));
		u.setFirstname(rs.getString("firstname"));
		u.setLastname(rs.getString("lastname"));
		return u;
	}
}
