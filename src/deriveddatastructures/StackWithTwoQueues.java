package deriveddatastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StackWithTwoQueues {

	java.util.Stack<Object> st1, st2;

	public StackWithTwoQueues() {
		st1 = new java.util.Stack<Object>();
		st2 = new java.util.Stack<Object>();
	}

	public static void splitString(String str ){
		
		
		if(str == null) 
			 return ;
			
		char SPACE = ' ';
		char [] chArray = str.toCharArray();

			List<String> strList = new ArrayList<String>();

			int startIndex = -1;

			int length = str.length() -1 ;
			
			for(int i = 0 ; i< chArray.length ; i++) {
				
				
				if(chArray[i] == SPACE && startIndex ==-1){
					
					continue;
					
				}else if(chArray[i] !=SPACE && startIndex == -1){
					
					startIndex =i;
					
				}else if ((chArray[i] == SPACE || i == length ) && startIndex != -1 ){

					String word = str.substring(startIndex,i+1 );
					strList.add(word.trim());
				
					startIndex = -1;
				} 
				
		}

			for(String str1 : strList){
				System.out.println(str1);
			}
		
	}
	
	
	
	public void put(Object obj) {

		if (!st1.isEmpty()) {
			int s = st2.size();
				while (!st2.isEmpty()) {
					st1.push(st2.pop());
				}
			st2.push(obj);
			for (int i = 0; i < s; i++) {
				st2.push(st1.pop());
			}
		} else {
			st1.push(obj);
		}
	}

	public Object get() {
		if (!st1.isEmpty()) {
			Object obj = st1.pop();
			if (!st2.isEmpty())
				st1.push(st2.pop());
			return obj;
		}
		return null;
	}

	public static void main(String[] args) {

		StackWithTwoQueues st = new StackWithTwoQueues();
		st.put("1");
		st.put("2");
		st.put("3");
		st.put("4");
		st.put("5");
		st.put("6");
		st.put("7");
		st.put("8");


//		System.out.println(st.get());
//		System.out.println(st.get());
//		System.out.println(st.get());
//		System.out.println(st.get());
//		System.out.println(st.get());
//		System.out.println(st.get());
//		System.out.println(st.get());
//		System.out.println(st.get());


		java.util.Stack<String> st0 = new java.util.Stack<String>();
		java.util.Queue<String> q = new LinkedList<String>();
		q.add("1");
		q.add("2");
		//System.out.println(q.peek());
		
		splitString("World             is             a             better         place");
	}

}
