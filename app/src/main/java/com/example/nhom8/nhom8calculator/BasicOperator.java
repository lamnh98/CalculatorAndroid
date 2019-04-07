package com.example.nhom8.nhom8calculator;

public class BasicOperator implements IBasicOperator{
    @Override
    public double add(double op1, double op2) {
        return op1 + op2;
    }

    @Override
    public double mult(double op1, double op2) {
        return op1 * op2;
    }

    @Override
    public double div(double op1, double op2) {
        if(op2 != 0)
            return op1 / op2;
        else
            throw new ArithmeticException("Không thể chia cho 0");
    }

    @Override
    public double sub(double op1, double op2) {
        return op1 - op2;
    }
}
