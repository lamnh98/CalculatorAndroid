/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.nhom8.nhom8calculator;

import com.example.nhom8.nhom8calculator.InfixToPostfix;

import java.util.Queue;
import java.util.Stack;

public class Calculator {

    public static String executeCalculate(String bieuthuc) throws ArithmeticException, Exception {
        Queue<String> postFix = null;
        String[] E = null;
        String result = null;

        E = InfixToPostfix.tachChuoi(bieuthuc);
        postFix = InfixToPostfix.postfix(E);
        result = Calculator.valueMath(postFix);
        System.out.println(result);

        return result;
    }

    private static String valueMath(Queue<String> elementMath) {
        BasicOperator basicOperator = new BasicOperator();
        HighOperator highOperator = new HighOperator();
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
                            num = basicOperator.add(num2, num1);
                            break;
                        case '-':
                            num = basicOperator.sub(num2, num1);
                            break;
                        case '*':
                            num = basicOperator.mult(num2, num1);
                            break;
                        case '÷':
                            num = basicOperator.div(num2, num1);
                            break;
                        case '^':
                            num = highOperator.pow(num1, num2);
                            break;
                        case 'Ö':
                            num = highOperator.pow(num2, (double) 1 / num1);
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
                            num = highOperator.giaithua(number);
                        } else if (test == 'o') {
                            num = highOperator.log(number);
                        } else {
                            num = highOperator.ln(number);
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
                            num = highOperator.sin(rad);
                            break;
                        case 'c':
                            num = highOperator.cos(rad);
                            break;
                        case 't':
                            num = highOperator.tan(rad);
                            break;
                        case '√':
                            num = highOperator.sqrt(num1);
                            break;
                        case '%':
                            num = num1 / 100;
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
}
