package datastructures;

import java.util.Stack;

public class InfixToPostFixConversion {
	private static final int ASCII_VALUE_OF_ROOT = 94;
	private static final int ASCII_VALUE_OF_DIVIDE = 47;
	private static final int ASCII_VALUE_OF_MULTIPLY = 42;
	private static final int ASCII_VALUE_OF_ADDITION = 43;
	private static final int ASCII_VALUE_OF_SUBSTRACT = 45;

	public static int preceed(int operator) {
		switch (operator) {
		case ASCII_VALUE_OF_DIVIDE:
			return 7;
		case ASCII_VALUE_OF_MULTIPLY:
			return 6;
		case ASCII_VALUE_OF_ADDITION:
			return 5;
		case ASCII_VALUE_OF_SUBSTRACT:
			return 4;
		case ASCII_VALUE_OF_ROOT:
			return 10;
		default:
			return 4;
		}

	}

	public static void main(String[] args) {
//		String expression = "A+B*C";
//		String expression = "A+[(B+C)+(D+E)*F]/G";
		String expression = "*+56-78";

		expression+=")";
		char[] charArray = expression.toCharArray();
		Stack<String> stackOfChar = new Stack<String>();
		String postFix = "";
		stackOfChar.push("(");
		for (int i = 0; i < charArray.length; i++) {
			char value = charArray[i];
			switch (value) {
			case '+':
			case '-':
			case '/':
			case '*':
				while (preceed((int) stackOfChar.get(stackOfChar.size() - 1)
						.charAt(0)) >= preceed((int) value)) {
					postFix = postFix + stackOfChar.pop();
				}
				stackOfChar.push(Character.toString(value));
				break;
			case '(':
			case '[':
				stackOfChar.push(Character.toString('('));
				break;
			case ')':
			case ']':
				String temp = stackOfChar.pop();
				while (!temp.equals("(")) {
					postFix = postFix + temp;
					temp = stackOfChar.pop();
				}
				break;
			default:
				postFix = postFix + value;
				break;
			}
		}
		System.out.println(postFix);
	}
}
