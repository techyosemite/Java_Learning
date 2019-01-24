package careercup;

import java.util.Stack;

public class ValidateJsonUsingStack {

	
	public static boolean validateJson(String str){
		
		Stack<Character> st = new Stack<Character>();
		
		//Validating extra comma in json string is left out
//		String[] splitStr = str.split(",");
//		for(String s : splitStr){
//			if(s == null || s.isEmpty())
//				return false;
//		}
//			
		
		char[] charArray = str.toCharArray();
		
		for(char c : charArray){
			
			switch(c){
			
			case '{' :
					st.push(c);
					break;
				
				
			case '}' :
					if(st.isEmpty())
						return false;
					
					char topElement = st.pop();
					if(topElement != '{')
						return false;
				
					break;
					
			case '\"' :
				  if(st.isEmpty())
					  return false;
				  
				  char last = st.peek();
				  if(last == '\"')
					  st.pop();
				  else
					  st.push(c);
				  break;
			}
			
		}
		
		return st.isEmpty();
		
		
	}
	public static void main(String[] args) {
		
		String str = "{"
				+ "\"key1\"" +":" + "\"value1\"" + ","
				+ "\"key2\"" +":" + "\"value2\"" + ","
				+ "}" ;
		
		
		System.out.println(str);
		
		System.out.println("Is the Json String valid :: " + validateJson(str));
	}
}
