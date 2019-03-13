package com.example.nhom8.nhom8calculator;


import com.example.nhom8.nhom8calculator.InfixToPostfix;
import java.util.Queue;
import java.util.Stack;

public class Calculator {

	public static String valueMath(Queue<String> elementMath) {

		char c;
		Stack<String> stack = new Stack<String>();

		while (!elementMath.isEmpty()) {

			String temp = elementMath.poll();
			c = temp.charAt(0);

			if (!InfixToPostfix.isOperator(c)) // Khong phai toan tu thi bo vao stack
				stack.push(temp);
			else {
				if (c != 's' && c != 'c' && c != 't') {
					double num = 0f;
					double num1 = Float.parseFloat(stack.pop());
					double num2 = Float.parseFloat(stack.pop());
					switch (c) {
					case '+':
						num = num2 + num1;
						break;
					case '-':
						num = num2 - num1;
						break;
					case '*':
						num = num2 * num1;
						break;
					case '/':
						num = num2 / num1;
						break;
					case '^':
						num = Math.pow(num2, num1);
						break;
					default:
						break;
					}

					stack.push(Double.toString(num));
				} else {
					double num = 0f;
					double num1 = Float.parseFloat(stack.pop());
					double rad = Math.toRadians(num1);
					switch (c) {
					
					case 's':
						num = Math.sin(rad);
						break;
					case 'c':
						num = Math.cos(rad);
						break;
					case 't':
						num = Math.tan(rad);
						break;
					default:
						break;
					}
					stack.push(Double.toString(num));
				}
			}
		}
		// Tra ve ket qua
		return stack.pop();
	}
}
