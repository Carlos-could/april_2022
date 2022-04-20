package de.lubowiecki.collections.beispiel;

import java.time.LocalTime;

public class Item implements Comparable<Item> {
	
	private LocalTime time;
	
	private String title;
	
	private String description;
	
	private boolean done;
	
	public Item() {
	}
	
	public Item(LocalTime time, String title, String description, boolean done) {
		this.time = time;
		this.title = title;
		this.description = description;
		this.done = done;
	}
	
	public Item(LocalTime time, String title) {
		this(time, title, "", false);
	}
	
	public Item(String title, String description, boolean done) {
		this(LocalTime.now(), title, description, done);
	}
	
	public Item(String title, String description) {
		this(title, description, true);
	}
	
	public Item(String title) {
		this(title, "");
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public int compareTo(Item other) {
		return this.time.compareTo(other.time);
	}
}
