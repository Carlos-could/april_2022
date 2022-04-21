package de.lubowiecki.generics.orm;

import java.util.List;

// ORM: Objekt-Relationales-Mapping 
// d.h. Objekte sollen in relationale Datenbanken abgelegt werden
// Daten aus Datenbanken sollen als Objekte geholt werden

// ORM-Pattern
// 1. ActiveRecord
// 2. DataMapper

// Nicht ORM-Pattern
// 3. TableDataGateway


public abstract class AbstractMapper<T extends AbstractEntity> { // DataMapper-Pattern
	
	// CRUD: Create, Read, Update, Delete
	
	public abstract void insert(T t);
	
	public abstract void update(T t);
	
	public abstract void delete(T t);
	
	public abstract List<T> findAll();
	
	public T findById(int id) {
		//String sql = "SELECT * FROM " + TABLE + " WHERE id = " + id;
		// TODO: Methode implementieren
		return null;
	}

}
