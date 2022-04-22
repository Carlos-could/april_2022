package de.lubowiecki.jdbc.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserMapper extends AbstractMapper<User> {

	public UserMapper() {
		super("users");
	}

	@Override
	public void insert(User t) throws Exception {
		
		String sql = "INSERT INTO " + TABLE + " (firstname, lastname) VALUES(?, ?)";
		
		try(Connection dbh = DbUtils.getConnection(); PreparedStatement stmt = dbh.prepareStatement(sql)) {
			stmt.setString(1, t.getFirstname());
			stmt.setString(2, t.getLastname());
			stmt.execute();
		}
	}

	@Override
	public void update(User t) throws Exception {
		// TODO Auto-generated method stub
		
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
