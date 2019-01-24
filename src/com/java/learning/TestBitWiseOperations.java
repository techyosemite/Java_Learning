package com.java.learning;

class TestNumChange{
	int m =10;//0x000A
	int n=9;//0x1010
	int i = 1023;
	
	void hexadecimalOperations(){
		System.out.println(Integer.toString(10, 16));
		System.out.println(Integer.toString(9, 16));
		System.out.println(Integer.parseInt("A", 16));
	}
	void binaryOperations(){
		// Parse and format to binary
		i = Integer.parseInt("1111111111", 2); // 1023
		String s = Integer.toString(i, 2);     // 1111111111
		System.out.println(s);
	}
	void octalOperations(){
		// Parse and format to octal
		i = Integer.parseInt("1777", 8);       // 1023
		String s = Integer.toString(i, 8);     // 1777
		System.out.println(s);
	}
	
	void decimalOperations(){
		// Parse and format to decimal
		i = Integer.parseInt("1023");          // 1023
		String s = Integer.toString(i);        // 1023
		System.out.println(s);

	}
}

class TestLogicalOps{
	
	 int bitmask = 0x000F;
     int val = 0x2223;
     void logicalOpertaion(){
     // prints "2"
     System.out.println(val & bitmask);
     }
     
     void rightSignedShift(){
    	int  i = Integer.parseInt("1010", 2);
    	 System.out.println(i >> 2);
    	 System.out.println(i >>> 2);

//    	 System.out.println(i);
     }
}

class TestBitsChangeFromitojLocation{
	
	int m =10;//0x000A
	int n=9;//0x1010
	
	int mask = 0xffff;
	
	public void replace(int n, int m, int i,int j){
		System.out.println(mask & m);
	}
	
	
	 public static void swap(int a, int b, int start, int end){
	    System.out.println(" a : " + a);
	    System.out.println(" b : " + b);
	    int maskA = 0xFFFFFFFF;
	    int maskB = 0xFFFFFFFF;
	  //  System.out.println(Integer.toHexString(maskB));
	    maskB <<= 31-end;
	    maskB >>>=31-end;
	  //  System.out.println(Integer.toHexString(maskB));
	    maskB >>>=start;
	    maskB <<=start;
	  //  System.out.println(Integer.toHexString(maskB));
	    maskA = ~maskB;
	  //  System.out.println(Integer.toHexString(maskA));
	    a = a & maskB;
	  //  System.out.println(a);
	    b |=a;
	    System.out.println("a: "+a);
	    System.out.println("b: "+b);


	  }

	
}
public class TestBitWiseOperations {
	 public static void main(String[] args) {
//		 TestNumChange obj = new TestNumChange();
//		 obj.hexadecimalOperations();
		 
//		 TestBitsChangeFromitojLocation obj1  = new TestBitsChangeFromitojLocation();
//		 obj1.replace(10, 9, 3, 5);
//		 TestBitsChangeFromitojLocation.swap(9, 6, 1, 2);
		 TestLogicalOps obj3  = new TestLogicalOps();
		 obj3.rightSignedShift();
	    }

}
