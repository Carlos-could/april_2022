package de.lubowiecki.innerclasses;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BoxContainer {
	
	private static final Logger LOGGER = Logger.getLogger(BoxContainer.class.getSimpleName());

	private List<Box> boxes = new ArrayList<>();
	
	private class Box {
		
		private final LocalDateTime createdAt;
		
		private final String content;
		
		public Box(String content) {
			this.content = content;
			this.createdAt = LocalDateTime.now();
			LOGGER.info("eigelagert am " + createdAt);
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public String getContent() {
			return content;
		}
	}
	
	public void add(String content) {
		boxes.add(new Box(content));
	}
	
	
	public String get(int index) {
		Box b = boxes.get(index);
		LOGGER.info("eigelagert am " + b.getCreatedAt());
		LOGGER.info("geöffnet am " + LocalDateTime.now());
		return b.getContent();
	}
}
