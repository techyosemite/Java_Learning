package string_programs;

/*
 * 1. Reverse using stringbuffer
 * 2. Reverse using recursion logic
 * 3. Reverse using iteration logic
 */
public class ReverseString {

	public static void reverse(String str) {
		if (str == null)
			return;

		String[] wordArray = str.split(" ");
		for (int i = wordArray.length - 1; i >= 0; i--) {
			System.out.print(wordArray[i] + " ");
		}
		for (int i = str.length() - 1; i >=0; i--) {
			str.charAt(i);
		}

	}

	//Reverse using stringbuffer
	public static void reverseUsingStringBufferLoop(String str) {
		if (str == null)
			return;

		char[] chrArray = str.toCharArray();
		StringBuffer finalStrBuffer = new StringBuffer();
		StringBuffer strBuffer = new StringBuffer();

		for (int i = chrArray.length - 1; i >= 0; i--) {
			if (chrArray[i] == ' ' || i == 0) {
				if (i == 0)
					strBuffer.append(chrArray[i]);
				finalStrBuffer = finalStrBuffer.append(strBuffer.reverse());
				finalStrBuffer.append(' ');
				strBuffer.delete(0, strBuffer.length());
				continue;
			}
			strBuffer.append(chrArray[i]);
		}

		System.out.println(finalStrBuffer);
	}

	private static int startPosition, endPosition, isReversed = 0;

	//Using recursion logic
	public static String reverseString(String str) {

		if (str == null)
			return null;

		char[] arr = str.toCharArray();
		startPosition = 0;
		endPosition = arr.length - 1;
		reverseCharArray(arr);
		return new String(arr);
	}

	
	public static void reverseCharArray(char[] arr) {
		if (startPosition > endPosition){
			isReversed = 1;
			return;
		}
		if(isReversed == 0){
		char temp = arr[startPosition];
		arr[startPosition] = arr[endPosition];
		arr[endPosition] = temp;
		startPosition++;
		endPosition--;
		}

	}

	//Using iteration logic
	public static String reverseMe(String reverseMe) {

		char[] charArray = reverseMe.toCharArray();

		int endIndex = charArray.length-2;

		int startIndex = 0;

		while (startIndex < endIndex) {

			char temp = charArray[startIndex];

			charArray[startIndex] = charArray[endIndex];

			charArray[endIndex] = temp;

			startIndex++;

			endIndex--;

		}

		return String.valueOf(charArray);

	}
	
	public static void main(String[] args) {

		// reverse("the quick brown fox");

//		reverseUsingStringBufferLoop("the quick brown fox");
//		System.out.println(reverseString("Karan Kumar Ratra"));
		System.out.println(reverseMe("Karan Kumar Ratra~"));
	}
}
