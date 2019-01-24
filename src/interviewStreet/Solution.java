package interviewStreet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public void findStringSimilarityForEachString(String[] inputStringArr,
			int[] sumArr) {

		for (int i = 0; i < inputStringArr.length; i++) {

			sumArr[i] = findStrSimilarityRank(inputStringArr[i]);
		}
	}

	public int findStrSimilarityRank(String inputStr) {
		int len = inputStr.length();
		int count = 0;
		int sum = 0;
		for (int i = 1; i < len; i++) {
			count = 0;
			for (int j = i; j < len; j++) {
				if (inputStr.charAt(j - i) == inputStr.charAt(j)) {
					count++;
				} else {
					break;
				}
			}
			sum = sum + count;
		}

		return sum + len;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		int num = Integer.parseInt(s);
		String[] inputStrings = new String[num];
		for (int i = 0; i < num; i++) {
			inputStrings[i] = in.readLine();
		}

		int[] similaritySumArr = new int[num];
		Solution strSimObj = new Solution();

		strSimObj.findStringSimilarityForEachString(inputStrings,
				similaritySumArr);

		for (int i = 0; i < similaritySumArr.length; i++) {

			System.out.println(similaritySumArr[i]);
		}

	}
}