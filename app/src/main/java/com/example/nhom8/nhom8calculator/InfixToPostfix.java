package com.example.nhom8.nhom8calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InfixToPostfix {

    public InfixToPostfix() {

    }

    public static boolean isOperator(char c) { // kiem tra xem co phai toan tu
        char operator[] = {'+', '-', '*', '÷', ')', '(', '^', 's', 'c', 't', 'l', '!', '√', 'Ö', '%'};
        Arrays.sort(operator);
        if (Arrays.binarySearch(operator, c) > -1)
            return true;
        else
            return false;

    }

    public static int priority(char c) { // thiet lap thu tu uu tien
        if (c == '+' || c == '-')
            return 1;
        else if (c == '*' || c == '÷')
            return 2;
        else if (c == 's' || c == 'c' || c == 't' || c == 'l' || c == '^' || c == '√' || c == '!')
            return 3;
        else
            return 0;
    }

    public static String[] tachChuoi(String bieuthuc) {
        String[] elementMath = null;
        String s1 = "";
        char test = ' '; // bien kiem tra ki tu sau l(log hay ln)

        for (int i = 0; i < bieuthuc.length(); i++) {

            char c = bieuthuc.charAt(i);// lấy kí tự thứ i của chuỗi
            if (c == 'l') {
                test = bieuthuc.charAt(i + 1); // lay bien tiep theo sau ki tu l
            }
            if (c >= '0' && c <= '9') {// Kiểm tra có phải là số hạng
                int start = i;
                int end = start;
                String number;

                for (; i < bieuthuc.length(); i++)
                    if (((bieuthuc.charAt(i) < '0' || bieuthuc.charAt(i) > '9') && bieuthuc.charAt(i) != '.')) {
                        end = i;
                        break;
                    }

                if (i == bieuthuc.length())    // Nếu i chạy đến cuối chuỗi thì gán i = độ dài chuỗi
                    end = bieuthuc.length();
                else
                    i--;    // Giảm i do vòng lặp for sẽ tăng i+=1
                // Tách số
                number = bieuthuc.substring(start, end);
                s1 = s1 + " " + number;
            } else if (c == 'π' || c == 'ε') {

                if (c == 'π')
                    s1 = s1 + " " + Math.PI;
                else
                    s1 = s1 + " " + Math.E;

            } else {
                // TODO Chen xu ly ln , log , sin , cos
                if (c == 's' || c == 'c' || c == 't' || (c == 'l' && test == 'o')) { // kiem tra sin, cos, tan , log
                    String tam = null;
                    tam = bieuthuc.substring(i, i + 3); // lay 3 ki tu ke tiep
                    s1 = s1 + " " + tam;
                    i += 2;
                } else if (c == 'l' && test == 'n') { //kiem tra ln
                    String tam = null;
                    tam = bieuthuc.substring(i, i + 2); // lay  ki 2 tu ke tiep
                    s1 = s1 + " " + tam;
                    i += 1;
                } else {
                    s1 = s1 + " " + c;
                }
            }

            s1 = s1.trim(); // Xóa dấu ' ' nếu có ở đầu và cuối chuỗi
            elementMath = s1.split(" "); // Tách s1 thành mảng các phần tử
        }
        return elementMath;
    }

    public static Queue<String> postfix(String[] elementMath) {

        Stack<String> stack = new Stack<String>();
        Queue<String> queue = new LinkedList<String>(); // Luu postFix

        for (int i = 0; i < elementMath.length; i++) { // duyet cac phan tu
            char c = elementMath[i].charAt(0); // c la ky tu dau tien cua moi phan tu

            if (!isOperator(c)) // neu c la number
                // s1 = s1 + " " + elementMath[i]; // xuat elem vao s1
                queue.add(elementMath[i]);
            else { // c la toan tu
                if (c == '(')
                    stack.push(elementMath[i]); // c la "(" -> day phan tu vao Stack
                else {
                    if (c == ')') { // c la ")"
                        char c1; // duyet lai cac phan tu trong Stack
                        do {
                            c1 = stack.peek().charAt(0); // c1 la ky tu dau tien cua phan tu
                            if (c1 != '(')
                                queue.add(stack.peek()); // trong khi c1 != "("
                            stack.pop();
                        } while (c1 != '(');
                    } else {
                        while (!stack.isEmpty() && priority(stack.peek().charAt(0)) >= priority(c)) {
                            // Stack khong rong va trong khi phan tu trong Stack
                            // co do uu tien >= phan tu hien tai
                            queue.add(stack.peek()); // xuat phan tu trong Stack ra s1
                            stack.pop();
                        }
                        stack.push(elementMath[i]); // dua phan tu hien tai vao Stack
                    }
                }
            }
        }

        while (!stack.isEmpty()) { // Neu Stack con phan tu thi day het vao s1
            queue.add(stack.peek());
            stack.pop();
        }
        return queue;
    }

}
