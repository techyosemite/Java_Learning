package string_programs;

public class StringPool {
	
	public static void main(String[] args) {
		
		String s ="Karan";
		
		System.out.println(s.hashCode());
		
		String p = "Karan";
		String k = "New Test String";
		
		String x = new String("Karan");
		
		if(x == s){
			System.out.println("All strings are kept in string pool");
		}else{
			System.out.println("String literal and new strings are kept separately!!");
		}
		
		String s1 = "SachinTendulkar";
		
		System.out.println(s1.substring(6));
		System.out.println(s1.substring(0,6));

	}

}
