package string_programs;

public class StringEquals {
	 public static void main(String[] args) {
		
		 String s1 = new String("KARAN");
		 String s3 = new String("KARAN");
		 System.out.println(s1.hashCode() + "---" + s3.hashCode());
		 String s2 = "KARAN";
		 System.out.println(s1.equals(s3));
		 if(s1 == s3)
			 System.out.println("true11");
		 else
			 System.out.println("false...");
	}

}
