package string_programs;

public class AnagramsString {
	
	public static boolean isAnagram(String str1, String str2){
		
		if(str1.length() != str2.length())
			return false;
		
		
		int [] arr = new int[256];
		
		for(int i = 0 ; i< str1.length() ; i++){
			int charIndex = (int)str1.charAt(i);
			arr[charIndex] += 1;
		}
		
		for(int i = 0 ; i < str2.length() ; i++){
			int charIndex = (int)str1.charAt(i);
			if(arr[charIndex] <= 0 )
				return false;
			arr[charIndex]-=1;
		}
		return true;
		
	}
	public static void main(String[] args) {
		

		System.out.println(isAnagram("CINEMA","ICEMAN"));
		int [][]arr = {{1,2,3},{4,5,6}};
		System.out.println(arr[0].length);
	}

}
