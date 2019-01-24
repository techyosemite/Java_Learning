package string_programs;


public class InPlaceStringConversion {

	public static void inPlaceStringReverse(String str){
		
		int i,j;
		i = 0;
		j = str.length() - 1;
		
		char []chr = str.toCharArray();
		
		while(i!=j){
			char c = chr[i];
			chr[i] = chr[j];
			chr[j] = c;
			i++;
			j--;
		}
		for(char c:chr){
			System.out.print(c);
		}
		
	}
	
	public static void main(String[] args) {
		inPlaceStringReverse("KARAN RATRA");
	}

}
