package string_programs;

import java.util.HashMap;
import java.util.Map;

public class StringName {

	public static void ifStrCanBeMadeFromAnotherString(String str1, String str2) {

		if (str1 == null || str2 == null)
			return;

		char[] charArr1 = str1.toCharArray();

		char[] charArr2 = str2.toCharArray();

		Map<Character, Integer> m1 = new HashMap<Character, Integer>();

		Map<Character, Integer> m2 = new HashMap<Character, Integer>();

		for (int i = 0; i < charArr1.length; i++) {
			if (m1.containsKey(charArr1[i])) {
				m1.put(charArr1[i], m1.get(charArr1[i]) + 1);
			} else {
				m1.put(charArr1[i], 1);
			}
		}

		for (int i = 0; i < charArr2.length; i++) {
			if (m2.containsKey(charArr2[i])) {
				m2.put(charArr2[i], m2.get(charArr2[i]) + 1);
			} else {
				m2.put(charArr2[i], 1);
			}
		}

		boolean flag = true;

		if (charArr1.length < charArr2.length) {
			for (int i = 0; i < charArr1.length; i++) {
				if (!m2.containsKey(charArr1[i])) {
					flag = false;
					break;
				} else {
					if (m1.get(charArr1[i]) != m2.get(charArr1[i])) {
						flag = false;
						break;
					}
				}
			}

		} else {
			for (int i = 0; i < charArr2.length; i++) {
				if (!m1.containsKey(charArr2[i])) {
					flag = false;
					break;
				} else {
					if (m1.get(charArr2[i]) != m2.get(charArr2[i])) {
						flag = false;
						break;
					}
				}
			}
		}
		if (flag == true) {
			System.out.println(str1 + " can be made from " + str2);
		} else {
			System.out.println(str1 + " can't be made from " + str2);
		}

	}

	public static void main(String[] args) {

		ifStrCanBeMadeFromAnotherString("KKARAN", "RAKddfdfddfdfKNA");

	}

}
