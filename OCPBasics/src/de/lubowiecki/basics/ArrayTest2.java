package de.lubowiecki.basics;

public class ArrayTest2 {

	public static void main(String[] args) {
		
		//int[] arr = new int[-10];
		
		int[] arr = new int[10];
		arr[0] = 100;
		
		try {
			Object oArr = arr;
			String[] sArr = (String[]) oArr;
			System.out.println(sArr);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
		
		Integer[] iArr = new Integer[10];
		iArr[0] = 100;
		
		try {
			Object[] oArr = iArr; // Widening von Integer zu Object
			oArr[1] = "Hallo Welt"; // Exception: ArrayStore
			
			//String[] sArr = (String[]) oArr; // Exception: ClassCast
			//sArr[1] = "Hallo Welt";
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
