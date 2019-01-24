package datastructures;

import java.util.Stack;


class BNode{
	
	
	char data ;
	
	BNode left;
	
	BNode right;
	
	BNode(char data){
		this.data = data;
	}
	
}

public class PrefixtoPostfix {

	public static  String postfixExpr = "";
	
	public static void postOrderTraversal(BNode root){
		if(root == null)
			return;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		postfixExpr+=root.data;
	}

	public static void main(String[] args) {

		String expression = "*+56-78";
				
		String  reverseExpression = new StringBuffer(expression).reverse().toString();
		
		char[] charArray = reverseExpression.toCharArray();
		
		Stack<BNode> tempStack = new Stack<BNode>();
		
		for (int i = 0; i < charArray.length; i++) {
			char value = charArray[i];
			switch (value) {
			case '+':
			case '-':
			case '/':
			case '*':
				 BNode tempNode = new BNode(value);
				 tempNode.left = tempStack.pop();
				 tempNode.right = tempStack.pop();
				 tempStack.push(tempNode);
				 break;
			default:
				BNode operatorNode = new BNode(value);
				tempStack.push(operatorNode);
				break;
			}
			
								
		}
		BNode root = tempStack.pop();
		postOrderTraversal(root);
		System.out.println(postfixExpr);


	}
}
