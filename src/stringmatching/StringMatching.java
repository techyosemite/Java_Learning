package stringmatching;

public class StringMatching {
	
	public static void main(String[] args) {
		
//		String str1= "KAAAARAKARANNKRANKARANKARAN";
//		String str2="KARAN";
		
		String str1= "000010001010001";
		String str2="0001";
		
		int n = str1.length();
		int m = str2.length();
		int count = 0;
		System.out.println("Length1::" + n);
		System.out.println("Length2::" + m);
		
		for(int i=0;i<=n-m;i++){
			System.out.println(i);
			System.out.println(i + "---" + str1.substring(i, i+m));
			
			if(str1.substring(i, i+m).equals(str2)){
				System.out.println("String matched..." + ++count);
			}
		}
		System.out.println("\nString Contained::" + count);
	}
	
	

}
