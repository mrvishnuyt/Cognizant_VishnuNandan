package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator c = new Calculator();
        int result = c.add(2, 3);
        assertEquals(5, result); // test should pass
    }

    @Test
    public void testSubtract() {
        Calculator c = new Calculator();
        int result = c.subtract(10, 4);
        assertEquals(6, result); // test should pass
    }
}
