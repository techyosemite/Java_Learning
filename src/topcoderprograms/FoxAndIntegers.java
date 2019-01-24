package topcoderprograms;

import java.awt.print.Printable;
import java.text.*;

public class FoxAndIntegers {
	
	public int[] findABC(int [] arrayObj){
		int []resultArray = new int[3];
		if ((arrayObj[0] + arrayObj[2]) % 2 != 0 || (arrayObj[1] + arrayObj[3])%2 !=0 ){
			System.out.println("result is no innteger...");
			return resultArray ;
		}
		
		int a,b,c;

		 a = (arrayObj[0] + arrayObj[2])/2;
		 b = (arrayObj[1] + arrayObj[3])/2;
		 c = arrayObj[3] - b;
		
		 if (a-b == arrayObj[0] && b-c == arrayObj[1] && a+b == arrayObj[2] && b+c == arrayObj[3])
		 {
			 resultArray[0] = a;
			 resultArray[1] = b;
			 resultArray[2] = c;
		 }
		 
		return resultArray;
		
	}
	
	public static void main(String[] args) {
		FoxAndIntegers obj = new FoxAndIntegers();
		int []testArr = new int[4];
		int [] resultArray = new int[3];
		testArr[0] = -24;testArr[1] = -5 ; testArr[2] = -4 ; testArr[3] = 25;
//		testArr[0] = 0;testArr[1] = 0 ; testArr[2] = 5 ; testArr[3] = 5;

		resultArray = obj.findABC(testArr);
		for (int i : resultArray) {
			System.out.println(i);
		}
	}

}
