package com.example.nhom8.nhom8calculator;

public class HighOperator implements IHighOperator {
    @Override
    public double sin(double num) {
        return Math.sin(num);
    }

    @Override
    public double cos(double num) {
        return Math.cos(num);
    }

    @Override
    public double tan(double num) {
        return Math.tan(num);
    }

    @Override
    public double log(double num) {
        return Math.log10(num);
    }
    @Override
    public double ln(double num) {
        return Math.log(num);
    }

    @Override
    public double giaithua(double num) {
        return GiaiThua(num);
    }

    @Override
    public double sqrt(double num) {
        return Math.sqrt(num);
    }

    @Override
    public double pow(double num1, double num2) {
        return Math.pow(num2,num1);
    }
    private static double GiaiThua(double a) {
        if (a > 0) {
            return a * GiaiThua(a - 1);
        } else
            return 1;
    }
}
