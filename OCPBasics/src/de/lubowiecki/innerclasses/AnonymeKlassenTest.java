package de.lubowiecki.innerclasses;

public class AnonymeKlassenTest {
	
	public static void main(String[] args) {
		
		// Anonyme Klasse erbt hier von Object
		// überschreibt die toString Methode
		// Wird instanziert und über eine Referenz für Objekt verfügbar gemacht
		Object o1 = new Object() {
			
			@Override
			public String toString() {
				return "Moin Moin";
			}
		};
		
		System.out.println(o1); // toString wird automatisch verwendet
		
		Object o2 = new Object() {
			
			@Override
			public String toString() {
				return "Tach auch!";
			}
		};
		
		System.out.println(o2);
		
		
		
		Object o3 = bauMalEinObjekt(Region.MÜNCHEN);
		System.out.println(o3);
		
		Object o4 = bauMalEinObjekt(Region.HAMBURG);
		System.out.println(o4);
		
	}
	
	// Factory
	static Object bauMalEinObjekt(Region r) {
		
		switch(r) {
		
			case HAMBURG: {
				Object o = new Object() {
					
					@Override
					public String toString() {
						return "Moin Moin!";
					}
					
					// ist nach außen über einen Referenz von Object nicht sichtbar
					public String machWas() {
						return "Moin Moin!";
					}
				};
				return o;
			}
			
			case MÜNCHEN: {
				Object o = new Object() {
					
					@Override
					public String toString() {
						return "Grüß Gott!";
					}
				};
				return o;
			}
			
			case NIEDERSACHSEN: {
				Object o = new Object() {
					
					@Override
					public String toString() {
						return "Tach auch!";
					}
				};
				return o;
			}
			
			default: {
				Object o = new Object() {
					
					@Override
					public String toString() {
						return "Guten Tag!";
					}
				};
				return o;
			}
		}
		
		
	}
	
	enum Region {
		HAMBURG, MÜNCHEN, NIEDERSACHSEN;
	}
}
