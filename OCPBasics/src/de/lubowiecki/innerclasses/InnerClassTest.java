package de.lubowiecki.innerclasses;

public class InnerClassTest {
	
	public static void main(String[] args) {
		
		InnerClassTest.RealInner.RealRealInner inner = new InnerClassTest().new RealInner().new RealRealInner();
		
	}
	
	class RealInner {
		
		class RealRealInner {
			
		}
		
	}

}
