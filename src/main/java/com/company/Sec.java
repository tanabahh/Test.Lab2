package com.company;

public class Sec {
    public Cos cos;

    Sec(Cos cos) {
        this.cos = cos;
    }

    public double compute(double x) {
        return 1 / cos.compute(x);
    }
}
