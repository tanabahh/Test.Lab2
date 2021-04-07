package com.company;

public class Sin {

    public double compute(double x) {
        int steps = 7;
        double taylor = 0;
        for (int i = 1; i <= steps; i++){
            taylor = taylor + Math.pow(-1, i - 1) * (Math.pow(x, 2 * i - 1) / factorial(2 * i - 1));
        }
        return taylor;
    }

    private static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
