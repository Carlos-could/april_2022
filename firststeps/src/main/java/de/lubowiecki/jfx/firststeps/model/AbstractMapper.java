package de.lubowiecki.jfx.firststeps.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractMapper<T extends AbstractEntity> implements Mapper<T> {	

	public final String TABLE;
	
	public AbstractMapper(String table) {
		TABLE = table;
	}

	@Override
	public List<T> findAll() throws Exception {
		
		try(Connection dbh = DbUtils.getConnection(); Statement stmt = dbh.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLE);
			
			List<T> list = new ArrayList<>();
			while(rs.next()) {
				list.add(create(rs));
			}
			
			return list;
		}
	}
	
	@Override
	public Optional<T> findById(int id) throws Exception {
		try(Connection dbh = DbUtils.getConnection(); Statement stmt = dbh.createStatement()) {
			stmt.execute("SELECT * FROM " + TABLE + " WHERE id = " +id);
			ResultSet rs = stmt.getResultSet();
			
			if(rs.next()) {
				return Optional.of(create(rs));
			}
			
			return Optional.empty();
		}
	}
	
	@Override
	public void delete(T t) throws Exception {
		delete(t.getId());
	}
	
	@Override
	public void delete(int id) throws Exception {
		try(Connection dbh = DbUtils.getConnection(); Statement stmt = dbh.createStatement()) {
			//stmt.executeUpdate("DELETE FROM " + TABLE + " WHERE id = " + id);
			stmt.execute("DELETE FROM " + TABLE + " WHERE id = " + id);
			//return stmt.getUpdateCount() > 0;
		}
	}
}
