package com.company;

public class Ln {

    public double compute(double x){

        double currentResult = 0;
        double prevResult;
        int power = 1;

        currentResult += 1.0 / power * Math.pow((x - 1) / (x + 1), power);

        do {
            prevResult = currentResult;
            power += 2;
            currentResult = prevResult + 1.0 / power * Math.pow((x - 1) / (x + 1), power);
        } while (Math.abs(2 * (prevResult - currentResult)) > 0.01);


        return currentResult * 2;
    }
}
