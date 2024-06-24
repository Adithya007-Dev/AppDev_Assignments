package com.example.sample;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Before
    public void setUp() throws Exception {
        System.out.println("Before testing");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("After Testing");
    }

    @org.junit.Test
    public void add() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(0, calculator.add(-2, 2));
        assertEquals(-5, calculator.add(-2, -3));
    }

    @org.junit.Test
    public void subtract() {
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(-4, calculator.subtract(-2, 2));
        assertEquals(1, calculator.subtract(-2, -3));
    }

    @org.junit.Test
    public void multiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(-4, calculator.multiply(-2, 2));
        assertEquals(6, calculator.multiply(-2, -3));
    }

    @org.junit.Test
    public void divide() {
        assertEquals(2, calculator.divide(6, 3));
        assertEquals(-1, calculator.divide(-2, 2));
        assertEquals(2, calculator.divide(-4, -2));

    }
}
