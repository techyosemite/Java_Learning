package officeprograms;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public int findSum(int[] arr) {

		int[] sumArr = new int[arr.length];

		Arrays.fill(sumArr, 1);

		for(int i = 0 ; i < arr.length ; i ++){
			if(i+1 < arr.length && arr[i+1] > arr[i]){
				sumArr[i+1] = sumArr[i] + 1;
			}
		}
		for(int i = arr.length -1 ; i>=0; i--){
				if(i-1>=0 && arr[i-1] > arr[i] && (sumArr[i]+1 > sumArr[i-1])){
					sumArr[i-1] = sumArr[i]+ 1;
				}
		}	
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + sumArr[i];
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(

		System.in));

		String s = bufferRead.readLine();

		int num = Integer.parseInt(s);
		int[] arr = new int[num];

		for (int i = 0; i < num; i++) {

			arr[i] = Integer.parseInt(bufferRead.readLine());

		}

		Solution can = new Solution();

		int sumValue = can.findSum(arr);
		
		System.out.println(sumValue);

	}

}
