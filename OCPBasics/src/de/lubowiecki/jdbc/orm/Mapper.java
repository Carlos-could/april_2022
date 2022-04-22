package de.lubowiecki.jdbc.orm;

import java.sql.ResultSet;
import java.util.List;

public interface Mapper<T> {

	// CRUD: Create, Read, Update, Delete
	void insert(T t) throws Exception;
	
	void update(T t) throws Exception;
	
	void delete(T t) throws Exception;
	
	void delete(int id) throws Exception;
	
	List<T> findAll() throws Exception;
	
	T findById(int id) throws Exception;
	
	T create(ResultSet rs) throws Exception;
	
}
