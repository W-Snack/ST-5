package org.example;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    @org.junit.jupiter.api.Test
    public void testConstructorSetsArgCorrectly() {
        Sqrt sqrt = new Sqrt(25.0);
        assertEquals(25.0, sqrt.arg);
    }
    @org.junit.jupiter.api.Test
    public void testAverageWithZeros() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(0.0, sqrt.average(0, 0));
    }
    @org.junit.jupiter.api.Test
    public void testAveragePositiveNumbers() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(2.0, sqrt.average(1, 3));
    }
    @org.junit.jupiter.api.Test
    public void testAverageWithNegative() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(0.0, sqrt.average(-2, 2));
    }
    @org.junit.jupiter.api.Test
    public void testGoodWhenExact() {
        Sqrt sqrt = new Sqrt(4);
        assertTrue(sqrt.good(2.0, 4.0));
    }
    @org.junit.jupiter.api.Test
    public void testGoodWithinDelta() {
        Sqrt sqrt = new Sqrt(2);
        assertTrue(sqrt.good(1.41421356, 2.0));
    }
    @org.junit.jupiter.api.Test
    public void testGoodFailsWhenOutsideDelta() {
        Sqrt sqrt = new Sqrt(10);
        assertFalse(sqrt.good(3.0, 10.0));
    }
    @org.junit.jupiter.api.Test
    public void testImproveCalculation() {
        Sqrt sqrt = new Sqrt(8);
        assertEquals(3.0, sqrt.improve(2.0, 8.0), 0.0001);
    }
    @org.junit.jupiter.api.Test
    public void testImproveStableValue() {
        Sqrt sqrt = new Sqrt(9);
        assertEquals(3.0, sqrt.improve(3.0, 9.0), 0.0001);
    }
    @org.junit.jupiter.api.Test
    public void testIterImmediateReturn() {
        Sqrt sqrt = new Sqrt(4);
        assertEquals(2.0, sqrt.iter(2.0, 4.0), 0.0001);
    }
    @org.junit.jupiter.api.Test
    public void testIterConverges() {
        Sqrt sqrt = new Sqrt(2);
        double result = sqrt.iter(1.0, 2.0);
        assertEquals(Math.sqrt(2), result, 0.0001);
    }
    @org.junit.jupiter.api.Test
    public void testCalcForPerfectSquare() {
        Sqrt sqrt = new Sqrt(16.0);
        assertEquals(4.0, sqrt.calc(), 0.0001);
    }
    @org.junit.jupiter.api.Test
    public void testCalcForNonPerfectSquare() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2), sqrt.calc(), 0.0001);
    }
    @org.junit.jupiter.api.Test
    public void testCalcForZero() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(0.0, sqrt.calc(), 0.00000001);
    }

    @org.junit.jupiter.api.Test
    public void testCalcForOne() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(1.0, sqrt.calc(), 0.0001);
    }

    @org.junit.jupiter.api.Test
    public void testIterWithZeroGuessAndZeroX() {
        Sqrt sqrt = new Sqrt(0);
        double result = sqrt.iter(0.0, 0.0);
        assertEquals(0.0, result, 0.00000001);
    }

    @org.junit.jupiter.api.Test
    public void testImproveWithZeroGuess() {
        Sqrt sqrt = new Sqrt(0);
        double result = sqrt.improve(0.0, 4.0);
        assertTrue(Double.isInfinite(result));
    }

    @org.junit.jupiter.api.Test
    public void testGoodWithInfinity() {
        Sqrt sqrt = new Sqrt(4.0);
        assertFalse(sqrt.good(Double.POSITIVE_INFINITY, 4.0));
    }

    @org.junit.jupiter.api.Test
    public void testGoodWithNaN() {
        Sqrt sqrt = new Sqrt(4.0);
        assertFalse(sqrt.good(Double.NaN, 4.0));
    }

    @Test
    public void testCalcForVeryLargeNumber() {
        double value = 1e18;
        Sqrt sqrt = new Sqrt(value);
        double expected = Math.sqrt(value);
        assertEquals(expected, sqrt.calc(), 0.0001);
    }
}
