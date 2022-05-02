package de.lubowiecki.innerclasses;

public class BoxContainerTest {

	public static void main(String[] args) {
		BoxContainer container = new BoxContainer();
		
		container.add("Ganz viel Kohle");
		container.add("Den ersten GameBoy");
		
		String s = container.get(1);
		System.out.println(s);
		
		// BoxContainer.Box b = new BoxContainer().new Box();

	}

}
