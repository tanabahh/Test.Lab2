package com.company;

public class Cot {
    public Sin sin;
    public Cos cos;

    public Cot(Sin sin, Cos cos) {
        this.sin = sin;
        this.cos = cos;
    }

    public double compute (double x) {
        return cos.compute(x) / sin.compute(x);
    }
}
