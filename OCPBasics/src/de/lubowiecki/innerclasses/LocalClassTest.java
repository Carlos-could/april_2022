package de.lubowiecki.innerclasses;

public class LocalClassTest {
	
	public static void main(String[] args) {
		
		int i = 10;
		
		class MeinTest {
			public String content;
			
			public MeinTest() {
			}
			
			public MeinTest(String content) {
				this.content = content + i;
			}

			public String getContent() {
				return content;
			}

			public void setContent(String content) {
				this.content = content;
			}
		}
		
		MeinTest mt = new MeinTest("bla bla bla");
	}
	
	public static Content machWas(final int k) {
		
		int i = 10;
		final int j = 10;
		
		class MeinTest implements Content {
			public String content;
			
			public MeinTest() {
			}
			
			public MeinTest(String content) {
				//this.content = content + i; // Error, da i nicht mehr effektiv-final ist
				this.content = content + j;
				this.content = content + k;
			}

			public String getContent() {
				return content;
			}

			public void setContent(String content) {
				this.content = content;
			}
		}
		
		MeinTest mt = new MeinTest("bla bla bla");
		MeinTest mt1 = new MeinTest();
		MeinTest mt2 = new MeinTest("...");
		MeinTest mt3 = new MeinTest("-----");
		i++;
		//j++; // Error, finale Variable darf nicht geändert werden
		//k++; // Error, finale Variable darf nicht geändert werden
		
		return mt;
	}
	
	interface Content {
		
		void setContent(String s);
		
		String getContent();
		
	}
}
