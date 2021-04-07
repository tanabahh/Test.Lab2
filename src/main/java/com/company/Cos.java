package com.company;

public class Cos {
    public Sin sin;

    Cos(Sin sin) {
        this.sin = sin;
    }

    public double compute(double x) {
        return 1 - 2* sin.compute(x/2)*sin.compute(x/2);
    }
}
