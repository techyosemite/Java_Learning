package careercup;

import java.util.Stack;

public class PostFixExpressionParser {

	/*
	 * http://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/
	 */
	
	
	
	public static int evaluate (String expression){
	
		Stack<String> st = new Stack<String>();
		
		char [] chArray = expression.toCharArray();
		
		Double db = new Double(25.2);
		for(int i=0; i < chArray.length; i++){
			
			if(chArray[i] == '+' || chArray[i] == '-' || chArray[i] == '*' || chArray[i] == '/'){
				
				String a = st.pop();
				String b = st.pop();
				
				switch(chArray[i]){
					
					case '+' : 
								int sum = Integer.parseInt(new String(""+a+"")) + Integer.parseInt(new String(""+ b +""));
						    break;
					case '-' :
								int minus = Integer.parseInt(new String(""+b+"")) - Integer.parseInt(new String(""+ a +""));
							break;
					case '*' :
							int mul = Integer.parseInt(new String(""+b+"")) * Integer.parseInt(new String(""+ a +""));
							break;
					case '/' : 	
							Double divide = new Double(b) / new Double(a);
							st.push(divide.toString());
							break;
						
				}
				
			}else{
				st.push(chArray[i]);
			}
		}
		
		
		return 0;
	}
	
	
	public static void main(String[] args) {
	
		String expression = "2 3 1 * + 9 -";
		
		
	}
}
