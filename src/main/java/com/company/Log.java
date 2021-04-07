package com.company;

public class Log {
    public Ln ln;

    Log(Ln ln) {
        this.ln = ln;
    }
    public double compute(double x, int a) {
        return ln.compute(x) / ln.compute(a);
    }
}
