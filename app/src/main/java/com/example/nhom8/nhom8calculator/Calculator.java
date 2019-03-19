package com.example.nhom8.nhom8calculator;


import com.example.nhom8.nhom8calculator.InfixToPostfix;

import java.util.Queue;
import java.util.Stack;

public class Calculator {

    public static String valueMath(Queue<String> elementMath) {

        char c;
        char test = ' ';
        Stack<String> stack = new Stack<String>();

        while (!elementMath.isEmpty()) {

            String temp = elementMath.poll();
            c = temp.charAt(0);

            if (c == 'l') { //kiem tra ki tu tiep theo sau l(log hay ln)
                test = temp.charAt(1);
            }

            if (!InfixToPostfix.isOperator(c)) // Khong phai toan tu thi bo vao stack
                stack.push(temp);
            else {
                if (c == '+' || c == '-' || c == '*' || c == '÷' || c == '^') { // Kiểm toán tử 2 số hạng
                    double num = 0f;
                    double num1 = Double.parseDouble(stack.pop());
                    double num2 = Double.parseDouble(stack.pop());
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
                        case '÷':
                            if (num1 == 0)
                                throw new ArithmeticException("Khong the chia cho 0");
                            else
                                num = num2 / num1;
                            break;
                        case '^':
                            num = Math.pow(num2, num1);
                            break;
                        case 'Ö':
                            num = Math.pow(num2, (double) 1 / num1);
                            break;

                        default:
                            break;
                    }

                    stack.push(Double.toString(num));
                } else if (c == '!' || c == 'l') {
                    double num = 0f;
                    double number = Double.parseDouble(stack.pop());
                    if (number >= 0) {
                        if (c == '!') {
                            num = GiaiThua(number);
                        } else if (test == 'o') {
                            num = Math.log10(number);
                        } else {
                            num = Math.log(number);
                        }
                        stack.push(Double.toString(num));

                    } else {
                        stack.push("NaN");
                        break;
                    }

                } else {    // Toán tử 1 số hạng
                    double num = 0f;
                    double num1 = Double.parseDouble(stack.pop());
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
                        case '√':
                            num = Math.sqrt(num1);
                            break;
                        case '%':
                            num = num1 / 100;
                            break;
                        case 'l':
                            num = Math.log(num1);
                            break;
                        default:
                            break;
                    }
                    stack.push(Double.toString(num));
                }
            }
        }

        // Tra ve ket qua
        double result = Double.parseDouble(stack.pop());
        long temple = Math.round(result);
        if (result == temple)
            return Long.toString(temple);
        else
            return Double.toString(result);
    }

    public static double GiaiThua(double a) {
        if (a > 0) {
            return a * GiaiThua(a - 1);
        } else
            return 1;
    }
}
