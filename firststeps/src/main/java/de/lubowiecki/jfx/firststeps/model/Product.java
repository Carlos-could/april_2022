package de.lubowiecki.jfx.firststeps.model;

public class Product extends AbstractEntity {
	
	private String name;
	
	private String description;
	
	private int amount;

	public Product() {
	}
	
	public Product(String name, String description, int amount) {
		this.name = name;
		this.description = description;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
