package org.example;

import junit.framework.TestCase;

public class SqrtTest extends TestCase {
    public void testConstructorSetsArgCorrectly() {
        Sqrt sqrt = new Sqrt(25.0);
        assertEquals(25.0, sqrt.arg);
    }

    public void testAverageWithZeros() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(0.0, sqrt.average(0, 0));
    }

    public void testAveragePositiveNumbers() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(2.0, sqrt.average(1, 3));
    }

    public void testAverageWithNegative() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(0.0, sqrt.average(-2, 2));
    }

    public void testGoodWhenExact() {
        Sqrt sqrt = new Sqrt(4);
        assertTrue(sqrt.good(2.0, 4.0));
    }

    public void testGoodWithinDelta() {
        Sqrt sqrt = new Sqrt(2);
        assertTrue(sqrt.good(1.41421356, 2.0));
    }

    public void testGoodFailsWhenOutsideDelta() {
        Sqrt sqrt = new Sqrt(10);
        assertFalse(sqrt.good(3.0, 10.0));
    }

    public void testImproveCalculation() {
        Sqrt sqrt = new Sqrt(8);
        assertEquals(3.0, sqrt.improve(2.0, 8.0), 0.0001);
    }

    public void testImproveStableValue() {
        Sqrt sqrt = new Sqrt(9);
        assertEquals(3.0, sqrt.improve(3.0, 9.0), 0.0001);
    }

    public void testIterImmediateReturn() {
        Sqrt sqrt = new Sqrt(4);
        assertEquals(2.0, sqrt.iter(2.0, 4.0), 0.0001);
    }

    public void testIterConverges() {
        Sqrt sqrt = new Sqrt(2);
        double result = sqrt.iter(1.0, 2.0);
        assertEquals(Math.sqrt(2), result, 0.0001);
    }

    public void testCalcForPerfectSquare() {
        Sqrt sqrt = new Sqrt(16.0);
        assertEquals(4.0, sqrt.calc(), 0.0001);
    }

    public void testCalcForNonPerfectSquare() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2), sqrt.calc(), 0.0001);
    }

    public void testCalcForZero() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(0.0, sqrt.calc(), 0.00000001);
    }

    public void testCalcForOne() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(1.0, sqrt.calc(), 0.0001);
    }
}
