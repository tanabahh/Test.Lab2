package com.company;

public class Function {
    public Sin sin;
    public Cot cot;
    public Cos cos;
    public Ln ln;
    public Log log;
    public Sec sec;

    Function(Log log, Sin sin, Cot cot, Cos cos, Ln ln, Sec sec){
        this.log = log;
        this.sin = sin;
        this.cot = cot;
        this.cos = cos;
        this.ln = ln;
        this.sec = sec;
    }

    public double compute(double x) {
        if (x <= 0) {
            return  ((((Math.pow(sec.compute(x), 3)) / cot.compute(x)) + sin.compute(x)) + ((Math.pow(cos.compute(x), 3)) + sin.compute(x)));
        } else return (((((log.compute(x, 10) - log.compute(x, 5)) + log.compute(x, 2)) - (ln.compute(x) * log.compute(x, 3))) / log.compute(x, 2)) * ln.compute(x));
    }
}
