package com.company;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.mockito.Mockito.mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionTest {
    private static double del = 0.01;
    private Sin sin = new Sin();

    @ParameterizedTest
    @CsvSource({
            "0, 0.0",
            "1.5707963267948966, 1.0",
            "3.141592653589793, 0.0",
            "-1.5707963267948966, -1.0"
    })
    public void boundarySin(double actual, double expected) {
        assertEquals(expected, sin.compute(actual), del);
    }

    @ParameterizedTest
    @CsvSource({
            "0.866025404436138, 1.0471975511965976",
            "0.7071067811865476, 0.7853981633974483",
            "0.5, 0.5235987755982988"
    })
    public void firstQuarterSin(double expected, double actual) {
        assertEquals(expected, sin.compute(actual), del);
    }

    @ParameterizedTest
    @CsvSource({
            "0.866030779294889, 2.0943951023931953",
            "0.7071316948099425, 2.356194490192345",
            "0.5, 2.6179938779914944"
    })
    public void secondQuarterSin(double expected, double actual) {
        assertEquals(expected, sin.compute(actual), del);
    }

    @ParameterizedTest
    @CsvSource({
            "-0.8208533149668267, 4.1887902047863905",
            "-0.6876621507642533, 3.9269908169872414",
            "-0.5, 3.665191429188092"
    })
    public void thirdQuarterSin(double expected, double actual){
        assertEquals(expected, sin.compute(actual), del);
    }

    @ParameterizedTest
    @CsvSource({
            "-0.866025404436138, -1.0471975511965976",
            "-0.7071067812020143, -0.7853981633974483",
            "-0.5, -0.5235987755982988"
    })
    public void forthQuarterSin(double expected, double actual){
        assertEquals(expected, sin.compute(actual), del);
    }

    @Test
    public void cosStubs() {
        double actual = -0.283;
        double expected = 0.0;

        Cot cot = mock(Cot.class);
        Log log = mock(Log.class);
        Sec sec = mock(Sec.class);

        Cos cos = new Cos(sin);
        Ln ln = new Ln();

        Mockito.when(cot.compute(actual)).thenReturn(-3.43872802765767);
        Mockito.when(sec.compute(actual)).thenReturn(1.04142578503181);

        Function function = new Function(log, sin, cot, cos, ln, sec);

        assertEquals(expected, function.compute(actual), del);

        actual = -0.56;
        expected = -1.485;

        Mockito.when(cot.compute(actual)).thenReturn(-1.59502470947035);
        Mockito.when(sec.compute(actual)).thenReturn(1.18028205082632);

        assertEquals(expected, function.compute(actual), del);

        actual = -3.424;
        expected = -0.25;

        Mockito.when(cot.compute(actual)).thenReturn(-13.44634424386);
        Mockito.when(sec.compute(actual)).thenReturn(-1.041246512455);

        assertEquals(expected, function.compute(actual), del);

        actual = -2.69;
        expected = -2.267;

        Mockito.when(cot.compute(actual)).thenReturn(2.0617669651372);
        Mockito.when(sec.compute(actual)).thenReturn(-1.11141587219);

        assertEquals(expected, function.compute(actual), del);
    }

    @Test
    public void cotStubs() {
        double actual = -0.283;
        double expected = 0.0;

        Log log = mock(Log.class);
        Sec sec = mock(Sec.class);

        Cos cos = new Cos(sin);
        Ln ln = new Ln();
        Cot cot = new Cot(sin, cos);

        Mockito.when(sec.compute(actual)).thenReturn(1.04142578503181);

        Function function = new Function(log, sin, cot, cos, ln, sec);

        assertEquals(expected, function.compute(actual), del);

        actual = -0.56;
        expected = -1.485;

        Mockito.when(sec.compute(actual)).thenReturn(1.18028205082632);

        assertEquals(expected, function.compute(actual), del);

        actual = -3.424;
        expected = -0.01;

        Mockito.when(sec.compute(actual)).thenReturn(-1.041246512455);

        assertEquals(expected, function.compute(actual), del);

        actual = -2.69;
        expected = -2.267;

        Mockito.when(sec.compute(actual)).thenReturn(-1.11141587219);

        assertEquals(expected, function.compute(actual), del);
    }

    @Test
    public void secStubs() {
        double actual = -0.283;
        double expected = 0.0;

        Log log = mock(Log.class);

        Cos cos = new Cos(sin);
        Sec sec = new Sec(cos);
        Ln ln = new Ln();
        Cot cot = new Cot(sin, cos);

        Function function = new Function(log, sin, cot, cos, ln, sec);

        assertEquals(expected, function.compute(actual), del);

        actual = -0.56;
        expected = -1.485;

        assertEquals(expected, function.compute(actual), del);

        actual = -3.424;
        expected = -0.01;

        assertEquals(expected, function.compute(actual), del);

        actual = -2.69;
        expected = -2.267;

        assertEquals(expected, function.compute(actual), del);
    }

    @Test
    public void lnConditionsEquality() {
        Ln ln = new Ln();
        assertEquals(1.60943791, ln.compute(5), del);
        assertEquals(0.693147181, ln.compute(2), del);
    }

    @Test
    public void logStubs() {
        double actual = 0.35;
        double expected = -1.608;

        Cot cot = mock(Cot.class);
        Sec sec = mock(Sec.class);
        Cos cos = mock(Cos.class);

        Ln ln = new Ln();
        Log log = new Log(ln);

        Function function = new Function(log, sin, cot, cos, ln, sec);

        assertEquals(expected, function.compute(actual), del);

        actual = 1.2;
        expected = 0.13777;

        assertEquals(expected, function.compute(actual), del);

        actual = 0.216;
        expected = -2.81;

        assertEquals(expected, function.compute(actual), del);
    }
}